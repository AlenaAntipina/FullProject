package pages;

import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.elements.interfaces.ILink;
import aquality.selenium.forms.Form;
import data.NameInTest;
import data.StatusMap;
import database.dao.ProjectDAOImpl;
import database.table.models.Project;
import database.table.models.TestModel;
import org.apache.hc.core5.http.ContentType;
import org.openqa.selenium.By;
import pages.dataforpages.Attribute;
import utils.StringUtils;

public class TestPage extends Form {
    private final ILabel logs = getElementFactory().getLabel(By.xpath("//div[contains(.,'Logs')]/parent::div[contains(@class,'panel-default')]//td"), "TEXT BOX - logs");
    private final ILink imageSrc = getElementFactory().getLink(By.xpath("//div[contains(.,'Attachments')]/parent::div[contains(@class,'panel-default')]//td/a/img"), "TEXT BOX - image src");
    private final ILabel imageContentType = getElementFactory().getLabel(By.xpath("//div[contains(.,'Attachments')]/parent::div[contains(@class,'panel-default')]//td/following::td"), "TEXT BOX - image content type");

    private final String stringNamesLocator = "//h4[contains(.,'%s')]/parent::div[@class='list-group-item']/p";
    private final String stringTimeLocator = "//div[@class='list-group-item']/p[contains(.,'%s')]";

    public TestPage() {
        super(By.xpath("//div[@class='panel-heading' and contains(.,'Attachments')]"), "Unique element on Test page info");
    }

    public boolean isTestInformationCorrect(TestModel testToCheck, String logs) {
        Project project = new ProjectDAOImpl().get(testToCheck.getProjectId());
        return testToCheck.getName().equals(getText(stringNamesLocator, NameInTest.TEST_NAME.getName()))
                & testToCheck.getMethodName().equals(getText(stringNamesLocator, NameInTest.TEST_METHOD_NAME.getName()))
                & StatusMap.getStatusMap().get(testToCheck.getStatusId()).equals(getText(stringNamesLocator, NameInTest.STATUS.getName()).toUpperCase())
                & testToCheck.getStartTime().toString().equals(StringUtils.cutStringFromSymbolColon(getText(stringTimeLocator, NameInTest.START_TIME.getName())))
                & testToCheck.getEndTime().toString().equals(StringUtils.cutStringFromSymbolColon(getText(stringTimeLocator, NameInTest.END_TIME.getName())))
                & testToCheck.getEnv().equals(getText(stringNamesLocator, NameInTest.ENVIRONMENT.getName()))
                & testToCheck.getBrowser().equals(getText(stringNamesLocator, NameInTest.BROWSER.getName()))
                & project.getName().equals(getText(stringNamesLocator, NameInTest.PROJECT_NAME.getName()))
                & logs.equals(this.logs.getText())
                & ContentType.IMAGE_JPEG.getMimeType().equals(imageContentType.getText());
    }

    public String getEncodedImage() {
        return StringUtils.cutImageString(imageSrc.getAttribute(Attribute.SRC.getAttribute()));
    }

    private String getText(String stringLocator, String param) {
        return getElementFactory().getTextBox(By.xpath(String.format(stringLocator, param)), "TEXT BOX - test name").getText();
    }
}