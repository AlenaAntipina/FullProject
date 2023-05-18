package tests;

import data.DataForTables;
import data.ProjectInfo;
import data.URI;
import database.table.models.TestModel;
import internet.ConfigUtils;
import org.openqa.selenium.Cookie;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import steps.*;
import utils.DriverUtils;
import utils.TimeUtils;

import java.sql.Timestamp;
import java.util.List;


public class TestVariantA extends BaseTest {
    @Test
    @Parameters({"projectName", "projectNameToCreate", "paramVariantName", "paramVariantValue"})
    public void finalTest(String projectName, String projectNameToCreate, String paramVariantName, String paramVariantValue){
        String token = APISteps.getToken(URI.TOKEN_GET.getUri(), paramVariantName, paramVariantValue);
        APISteps.checkTokenReceived(token);

        DriverUtils.goTo(ConfigUtils.getMainUrlWithCredentials());
        DriverUtils.addCookie(new Cookie(ProjectInfo.COOKIE_PARAM.getText(), token));
        DriverUtils.refresh();
        MainPageSteps.checkPageOpenAndVariantRight(paramVariantValue);

        MainPageSteps.goToProjectPage(projectName);
        List<TestModel> testsFromDB = DataBaseSteps.getTests();
        TableFormSteps.checkTestsTheSame(testsFromDB);

        DriverUtils.goBack();
        MainPageSteps.clickAddAndAddNewProject(projectNameToCreate);
        MainPageSteps.closeAlert();
        MainPageSteps.checkNewProjectAdded(projectNameToCreate);

        TestModel newTest = new TestModel(DataForTables.getNameTestForTest(),
                1, DataForTables.getMethodNameForTest(), DataBaseSteps.getProjectId(projectNameToCreate), 1,
                new Timestamp(TimeUtils.cutMilliseconds(System.currentTimeMillis())),
                new Timestamp(TimeUtils.cutMilliseconds(System.currentTimeMillis())),
                ProjectInfo.AUTHOR_NAME.getText(), DriverUtils.getBrowserName());
        byte[] image = DriverUtils.getScreenshot();
        String logs = ProjectInfo.LOGS.getText();
        MainPageSteps.goToProjectPage(projectNameToCreate);
        DataBaseSteps.addTest(newTest, image, logs);
        TableFormSteps.checkTestAddedToNewProject(newTest);

        ProjectPageSteps.goToTestPage(String.valueOf(newTest.getId()));
        TestPageSteps.checkTestRight(newTest, image, logs);
    }
}
