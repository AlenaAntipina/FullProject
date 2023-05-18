package pages;

import aquality.selenium.core.logging.Logger;
import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.IElement;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import pages.dataforpages.Attribute;
import utils.StringUtils;

import java.util.List;
import java.util.NoSuchElementException;

public class ProjectPage extends Form {
    private final By allTestsLocator = By.xpath("//table[@class='table']//a");

    private TableTestsForm TableTests = new TableTestsForm();

    public ProjectPage() {
        super(By.xpath("//div[@class='panel-heading' and contains(.,'Total tests progress')]"), "Unique element on project page");
    }

    public TableTestsForm getTableTests() {
        return TableTests;
    }

    public void goToTestPage(String testId) {
        try {
            getAllTests().stream().filter(test -> StringUtils.cutStringFromSymbolEquals
                    (test.getAttribute(Attribute.HREF.getAttribute())).equals(testId)).findFirst().get().click();
        }
        catch (NoSuchElementException e) {
            Logger.getInstance().error("There is no test with id " + testId);
            throw new RuntimeException(e);
        }
    }

    public List<IElement> getAllTests() {
        return getElementFactory().findElements(allTestsLocator, ElementType.LABEL);
    }

    public void waitForTestLoad(String startTime) {
        getElementFactory().getLabel(getTimeLocator(startTime), "new test").state().waitForDisplayed();
    }

    private By getTimeLocator(String param) {
        return By.xpath(String.format("//table[@class='table']//td[contains(., '%s')]", param));
    }
}