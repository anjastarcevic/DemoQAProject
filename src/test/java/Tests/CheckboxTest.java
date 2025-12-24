package Tests;

import Base.BaseTest;
import Pages.CheckboxPage;
import Pages.HomePage;
import Pages.Sidebar;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckboxTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/");

        homePage = new HomePage();
        sidebar = new Sidebar();
        checkboxPage = new CheckboxPage();
    }

    @Test
    public void userCanExpandCollapseList() {
        homePage.clickOnCardName("Elements");
        sidebar.clickOnSidebarButton("Check Box");
        checkboxPage.clickOnExpandAllButton();
        Assert.assertTrue(checkboxPage.itemsList.getLast().getText().contains("Excel File.doc"));

        checkboxPage.clickOnCollapseAllButton();
        Assert.assertTrue(checkboxPage.itemsList.getLast().getText().contains("Home"));
    }

    @Test
    public void userCanCheckAllItems() {
        homePage.clickOnCardName("Elements");
        sidebar.clickOnSidebarButton("Check Box");
        checkboxPage.checkAllItems();
        checkboxPage.clickOnExpandAllButton();
        for(WebElement checkbox: checkboxPage.checklist) {
            Assert.assertTrue(checkbox.isSelected());
        }
    }

}
