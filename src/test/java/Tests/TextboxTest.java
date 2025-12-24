package Tests;

import Base.BaseTest;
import Base.ExcelReader;
import Pages.HomePage;
import Pages.Sidebar;
import Pages.TextboxPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TextboxTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/");

        homePage = new HomePage();
        sidebar = new Sidebar();
        textboxPage = new TextboxPage();
    }

    @Test
    public void userCanAddData() {
        homePage.clickOnCardName("Elements");
        sidebar.clickOnSidebarButton("Text Box");
        String fullName = excelReader.getStringData("TextBoxData", 1,0);
        String email = excelReader.getStringData("TextBoxData", 1,1);
        String currentAddress = excelReader.getStringData("TextBoxData", 1,2);
        String permanentAddress= excelReader.getStringData("TextBoxData", 1, 3);
        textboxPage.inputFullName(fullName);
        textboxPage.inputEmail(email);
        textboxPage.inputCurrentAddress(currentAddress);
        textboxPage.inputPermanentAddress(permanentAddress);
        textboxPage.clickOnSubmitButton();
        Assert.assertTrue(textboxPage.addedData.isDisplayed());
        Assert.assertTrue(textboxPage.addedData.getText().contains(fullName));
    }

    @Test
    public void userCannotSubmitDataWithInvalidEmailFormat() {
        homePage.clickOnCardName("Elements");
        sidebar.clickOnSidebarButton("Text Box");
        String fullName = excelReader.getStringData("TextBoxData", 2,0);
        String email = excelReader.getStringData("TextBoxData", 2,1);
        String currentAddress = excelReader.getStringData("TextBoxData", 2,2);
        String permanentAddress= excelReader.getStringData("TextBoxData", 2, 3);
        textboxPage.inputFullName(fullName);
        textboxPage.inputEmail(email);
        textboxPage.inputCurrentAddress(currentAddress);
        textboxPage.inputPermanentAddress(permanentAddress);
        textboxPage.clickOnSubmitButton();
        Assert.assertFalse(textboxPage.isValidEmail(email));
        try {
            Assert.assertFalse(textboxPage.addedData.isDisplayed());
        } catch (Exception e) {
            e.printStackTrace();
        }
        Assert.assertTrue(driver.findElement(By.id("userEmail")).getAttribute("class").contains("field-error"));

      }

}
