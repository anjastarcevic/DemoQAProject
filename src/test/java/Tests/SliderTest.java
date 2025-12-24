package Tests;

import Base.BaseTest;
import Pages.HomePage;
import Pages.Sidebar;
import Pages.SliderPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SliderTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/");

        homePage = new HomePage();
        sidebar = new Sidebar();
        sliderPage = new SliderPage();
    }

    @Test
    public void userCanMoveSlider() {
        homePage.clickOnCardName("Widgets");
        sidebar.clickOnSidebarButton("Slider");
        sliderPage.slide();
        String expectedValue = "74";
        String actualValue = sliderPage.slider.getAttribute("value");
        Assert.assertEquals(actualValue, expectedValue);
        Assert.assertEquals(sliderPage.sliderValueField.getAttribute("value"), expectedValue);
    }

}
