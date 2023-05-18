package utils;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.browser.Browser;
import lombok.experimental.UtilityClass;
import org.openqa.selenium.Cookie;

@UtilityClass
public class DriverUtils {
    private static final Browser BROWSER = AqualityServices.getBrowser();

    public static void quit() {
        BROWSER.quit();
    }

    public static void goTo(String url) {
        BROWSER.goTo(url);
    }

    public static void maximize() {
        BROWSER.maximize();
    }

    public static void refresh() {
        BROWSER.refresh();
    }

    public static void goBack() {
        BROWSER.goBack();
    }

    public static void switchToFrame(String frame) {
        BROWSER.getDriver().switchTo().frame(frame);
    }

    public static void switchToParentFrame() {
        BROWSER.getDriver().switchTo().parentFrame();
    }

    public static void executeScript(String script) {
        BROWSER.getDriver().executeScript(script);
    }

    public static String getBrowserName() {
        return BROWSER.getBrowserName().name();
    }

    public static byte[] getScreenshot() {
        return BROWSER.getScreenshot();
    }

    public static void addCookie(Cookie cookie) {
        BROWSER.getDriver().manage().addCookie(cookie);
    }
}
