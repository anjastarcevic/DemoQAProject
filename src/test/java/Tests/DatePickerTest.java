package Tests;

import Base.BaseTest;
import Pages.HomePage;
import Pages.Sidebar;
import Pages.DatePickerPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class DatePickerTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/");

        homePage = new HomePage();
        sidebar = new Sidebar();
        datePickerPage = new DatePickerPage();
    }

    @Test
    public void userCanSelectDate() {
        homePage.clickOnCardName("Widgets");
        sidebar.clickOnSidebarButton("Date Picker");
        datePickerPage.clickOnDateField();
        datePickerPage.clickOnMonthDropdown();
        datePickerPage.selectMonth("August");
        datePickerPage.clickOnYearDropdown();
        datePickerPage.selectYear("1992");
        datePickerPage.selectDay("2");

        Assert.assertFalse(datePickerPage.dateField.getAttribute("value").isEmpty());
        Assert.assertEquals(datePickerPage.dateField.getAttribute("value"), "08/02/1992");

    }


}
