package pages;

import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.Label;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TableTestsForm extends Form {
    private final By headings = By.xpath(".//tr//th");
    private final By row = By.xpath(".//td/parent::tr");
    private final By cell = By.xpath(".//td");

    public TableTestsForm() {
        super(By.xpath("//table[@class='table']"), "Table form");
    }

    public Map<String, Integer> getHeadings() {
        int id = 0;
        Map<String, Integer> headingsMap = new HashMap<>();
        List<Label> headings = getElementFactory().findElements(this.headings, ElementType.LABEL);
        for (Label heading : headings) {
            headingsMap.put(heading.getText(), id++);
        }
        return headingsMap;
    }

    public int getRowsNumber() {
        return super.getFormLabel().getElement().findElements(row).size();
    }

    public WebElement getRow(int index) {
        return super.getFormLabel().getElement().findElements(row).get(index);
    }

    public String getCell(WebElement element, int index) {
        return element.findElements(cell).get(index).getText();
    }

}
