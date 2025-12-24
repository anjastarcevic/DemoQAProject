package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends BaseTest {

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "card-body")
    public List<WebElement> elements;

    public void clickOnCardName(String cardName) {
        for(int i = 0; i < elements.size(); i++) {
            if(elements.get(i).getText().equals(cardName)) {
                scrollToElement(elements.get(i));
                elements.get(i).click();
                break;
            }
        }
    }


}
