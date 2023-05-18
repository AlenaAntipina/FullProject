package steps;

import aquality.selenium.core.logging.Logger;
import com.google.common.collect.Ordering;
import data.StatusMap;
import database.table.models.TestModel;
import lombok.experimental.UtilityClass;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import pages.ProjectPage;
import pages.modelsUI.TestUI;
import pages.modelsUI.TestUIField;
import utils.ChangeClassUtils;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@UtilityClass
public class TableFormSteps {
    private static final ProjectPage PROJECT_PAGE = new ProjectPage();

    private SoftAssert softAssert;

    public static void checkTestsTheSame(List<TestModel> testsFromDB) {
        List<TestUI> testsFromUI = getAllTests();
        softAssert = new SoftAssert();
        softAssert.assertTrue(isTestsSortedByDate(testsFromUI), "Test are not sorted by date.");
        softAssert.assertTrue(isDbAndUiTestsSimilar(testsFromUI, testsFromDB), "Tests from database and tests from UI are not the same.");
        softAssert.assertAll();
    }

    public static void checkTestAddedToNewProject(TestModel test) {
        PROJECT_PAGE.waitForTestLoad(String.valueOf(test.getStartTime()));
        Assert.assertTrue(getAllTests().contains(ChangeClassUtils.changeTestModelToTestUI(test)), "Test is not added to project.");
    }

    public boolean isTestsSortedByDate(List<TestUI> tests) {
        return Ordering.natural().reverse()
                .isOrdered(tests.stream().map(TestUI::getLatestTestStartTime).collect(Collectors.toList()));
    }

    public boolean isDbAndUiTestsSimilar(List<TestUI> testsFromUI, List<TestModel> testsFromDB) {
        return ChangeClassUtils.changeTestModelToTestUI(testsFromDB).containsAll(testsFromUI);
    }

    public List<TestUI> getAllTests() {
        Logger.getInstance().info("Step: get all tests");
        List<TestUI> testsInTable = new ArrayList<>();
        Map<String, Integer> headings = PROJECT_PAGE.getTableTests().getHeadings();
        int len = PROJECT_PAGE.getTableTests().getRowsNumber();
        for (int i = 0; i < len; i++) {
            WebElement row = PROJECT_PAGE.getTableTests().getRow(i);
            TestUI currentTest = new TestUI();

            currentTest.setTestName(PROJECT_PAGE.getTableTests().getCell(row, headings.get(TestUIField.TEST_NAME.getField())));
            currentTest.setTestMethod(PROJECT_PAGE.getTableTests().getCell(row, headings.get(TestUIField.TEST_METHOD.getField())));

            String result = PROJECT_PAGE.getTableTests().getCell(row, headings.get(TestUIField.LATEST_TEST_RESULT.getField())).toUpperCase();
            currentTest.setLatestTestResult(StatusMap.getStatusMap().containsValue(result) ? result : null);

            currentTest.setLatestTestStartTime(Timestamp.valueOf(PROJECT_PAGE.getTableTests().getCell(row, headings.get(TestUIField.LATEST_TEST_START_TIME.getField()))));
            String textEndTime = PROJECT_PAGE.getTableTests().getCell(row, headings.get(TestUIField.LATEST_TEST_END_TIME.getField()));
            currentTest.setLatestTestEndTime(textEndTime.isEmpty() ? null : Timestamp.valueOf(textEndTime));

            testsInTable.add(currentTest);
        }
        return testsInTable;
    }
}
