package steps;

import aquality.selenium.core.logging.Logger;
import lombok.experimental.UtilityClass;
import pages.ProjectPage;

@UtilityClass
public class ProjectPageSteps {
    private static final ProjectPage PROJECT_PAGE = new ProjectPage();

    public static void goToTestPage(String testId) {
        Logger.getInstance().info("Step: go to test page");
        PROJECT_PAGE.goToTestPage(testId);
    }
}
