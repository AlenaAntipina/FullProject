package pages;

import aquality.selenium.core.logging.Logger;
import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.*;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import utils.StringUtils;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class MainPage extends Form {
    private final ILabel variantNumber = getElementFactory().getLabel(By.xpath("//p[contains(@class,'text-muted')]/span"), "TEXT BOX - variant number");
    private final IButton buttonAdd = getElementFactory().getButton(By.xpath("//button[@data-target='#addProject']"), "BUTTON - add");
    private final ITextBox inputProjectName = getElementFactory().getTextBox(By.xpath("//input[@id='projectName']"), "Project name");
    private final IButton buttonSaveProjectName = getElementFactory().getButton(By.xpath("//button[@type='submit']"), "BUTTON - Save project name");
    private final ILabel textAlertSuccess = getElementFactory().getLabel(By.xpath("//div[contains(@class,'alert-success')]"), "TEXT BOX - alert success");
    private final ILabel textAlertUnique = getElementFactory().getLabel(By.xpath("//div[contains(@class,'modal fade in')]"), "TEXT BOX - alert close");
    private final By allProjectsLocator = By.xpath("//div[@class='list-group']/a");

    public MainPage() {
        super(By.xpath("//div[@class='panel-heading' and contains(., 'Available projects')]"), "Unique element on Main page");
    }

    public String getVariantNumber() {
        return StringUtils.cutStringFromSymbolColon(variantNumber.getText());
    }

    public void clickProjectLink(String projectName) {
        try {
            getAllProjects().stream().filter(project -> project.getText().equals(projectName)).findFirst().get().click();
        }
        catch (NoSuchElementException e) {
            Logger.getInstance().error("There is no project " + projectName);
            throw new RuntimeException(e);
        }
    }

    public void clickAddButton() {
        buttonAdd.click();
    }

    public void inputProjectName(String projectName) {
        inputProjectName.sendKeys(projectName);
    }

    public void saveProjectName() {
        buttonSaveProjectName.click();
    }

    public boolean isAlertSuccess() {
        return textAlertSuccess.state().waitForDisplayed();
    }

    public boolean isAlertClose() {
        return !textAlertUnique.state().waitForDisplayed();
    }

    public boolean isProjectAdded(String projectName) {
        return getAllProjects().stream().map(IElement::getText).collect(Collectors.toList()).contains(projectName);
    }

    public List<IElement> getAllProjects() {
        return getElementFactory().findElements(allProjectsLocator, ElementType.LABEL);
    }
}