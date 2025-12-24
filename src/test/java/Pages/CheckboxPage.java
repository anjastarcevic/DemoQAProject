package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v140.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class CheckboxPage extends BaseTest {


    public CheckboxPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".rct-icon.rct-icon-expand-all")
    public WebElement expandAllButton;

    @FindBy(css = ".rct-icon.rct-icon-collapse-all")
    public WebElement collapseAllButton;

    @FindBy(className = "rct-title")
    public List<WebElement> itemsList;

    @FindBy(css = "input[type='checkbox']")
    public List<WebElement> checklist;


    public void checkAllItems() {
        for(int i = 0; i < itemsList.size(); i++) {
            if(itemsList.get(i).getText().equals("Home")) {
                scrollToElement(itemsList.get(i));
                itemsList.get(i).click();
                break;
            }
        }

    }





    public void clickOnExpandAllButton() {
        expandAllButton.click();
    }

    public void clickOnCollapseAllButton() {
        collapseAllButton.click();
    }

}
