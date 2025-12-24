package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SliderPage extends BaseTest {

    Actions action = new Actions(driver);

    public SliderPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".range-slider.range-slider--primary")
    public WebElement slider;

    @FindBy(id = "sliderValue")
    public WebElement sliderValueField;

    public void slide() {
        scrollToElement(slider);
        action.dragAndDropBy(slider, 100, 0).perform();
    }

}
