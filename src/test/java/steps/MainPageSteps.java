package steps;

import aquality.selenium.core.logging.Logger;
import data.ProjectInfo;
import lombok.experimental.UtilityClass;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import pages.MainPage;
import utils.DriverUtils;

@UtilityClass
public class MainPageSteps {
    private static final MainPage MAIN_PAGE = new MainPage();
    private static final String closePopUpScript = "closePopUp()";

    private SoftAssert softAssert;

    public static void checkPageOpenAndVariantRight(String variant) {
        softAssert = new SoftAssert();
        softAssert.assertTrue(MAIN_PAGE.state().waitForDisplayed(), "The main page is not opened.");
        softAssert.assertEquals(MAIN_PAGE.getVariantNumber(), variant, "Variant number is not the same.");
        softAssert.assertAll();
    }

    public static void goToProjectPage(String projectName) {
        Logger.getInstance().info("Step: go to project " + projectName);
        MAIN_PAGE.clickProjectLink(projectName);
    }

    public static void clickAddAndAddNewProject(String projectName) {
        Logger.getInstance().info("Step: click add, add new project, save and close alert");
        MAIN_PAGE.state().waitForDisplayed();
        MAIN_PAGE.clickAddButton();
        DriverUtils.switchToFrame(ProjectInfo.FRAME_NAME.getText());
        MAIN_PAGE.inputProjectName(projectName);
        MAIN_PAGE.saveProjectName();
        Assert.assertTrue(MAIN_PAGE.isAlertSuccess(), "Alert saving is not successfully.");
    }

    public static void closeAlert() {
        DriverUtils.switchToParentFrame();
        DriverUtils.executeScript(closePopUpScript);
        Assert.assertTrue(MAIN_PAGE.isAlertClose(), "Alert is not close.");
    }

    public static void checkNewProjectAdded(String projectName) {
        DriverUtils.refresh();
        Assert.assertTrue(MAIN_PAGE.isProjectAdded(projectName), "Project is not added.");
    }

}
