package steps;

import database.table.models.TestModel;
import lombok.experimental.UtilityClass;
import org.testng.asserts.SoftAssert;
import pages.TestPage;
import utils.ImageUtils;

@UtilityClass
public class TestPageSteps {
    private static final TestPage TEST_PAGE = new TestPage();
    
    SoftAssert softAssert;

    public static void checkTestRight(TestModel test, byte[] image, String logs) {
        softAssert = new SoftAssert();
        softAssert.assertTrue(TEST_PAGE.isTestInformationCorrect(test, logs), "The information from test page is different");
        softAssert.assertTrue(ImageUtils.isImageEquals(image, TEST_PAGE.getEncodedImage()));
        softAssert.assertAll();
    }
}
