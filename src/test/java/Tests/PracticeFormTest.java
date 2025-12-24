package Tests;

import Base.BaseTest;
import Pages.HomePage;
import Pages.PracticeFormPage;
import Pages.Sidebar;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class PracticeFormTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        homePage = new HomePage();
        sidebar = new Sidebar();
        practiceFormPage = new PracticeFormPage();
    }

    @Test
    public void userCanImportDataFromExcel() {
        homePage.clickOnCardName("Forms");
        sidebar.clickOnSidebarButton("Practice Form");

        String firstName = excelReader.getStringData("TestData", 1, 0);
        String lastName = excelReader.getStringData("TestData", 1, 1);
        String email = excelReader.getStringData("TestData", 1, 2);
        String number = excelReader.getStringData("TestData", 1, 3);
        String address = excelReader.getStringData("TestData", 1, 4);

        practiceFormPage.inputFirstName(firstName);
        practiceFormPage.inputLastName(lastName);
        practiceFormPage.inputEmail(email);
        practiceFormPage.inputNumber(String.valueOf(number));
        practiceFormPage.inputAddress(address);

        Assert.assertTrue(practiceFormPage.firstNameField.getAttribute("value").contains("Jane"));
        Assert.assertTrue(practiceFormPage.isValidEmail(email));
        Assert.assertEquals(practiceFormPage.numberField.getAttribute("value").length(), 10);
    }

    @Test
    public void userCanChooseRadioButton() {
        homePage.clickOnCardName("Forms");
        sidebar.clickOnSidebarButton("Practice Form");
        String gender = excelReader.getStringData("TestData",1,5);
        practiceFormPage.pickGender(gender);

        Assert.assertTrue(driver.findElement(By.id("gender-radio-2")).isSelected());
    }

    @Test
    public void userCanPickDateOfBirth() {
        homePage.clickOnCardName("Forms");
        sidebar.clickOnSidebarButton("Practice Form");

        String month = excelReader.getStringData("TestData", 1, 6);
        String year = excelReader.getStringData("TestData", 1, 7);
        String day = excelReader.getStringData("TestData", 1, 8);

        practiceFormPage.clickOnDateField();
        practiceFormPage.clickOnMonthDropdown();
        practiceFormPage.pickMonth(month);
        practiceFormPage.clickOnYearDropdown();
        practiceFormPage.pickYear(String.valueOf(year));
        practiceFormPage.pickDay(String.valueOf(day));

        Assert.assertEquals(practiceFormPage.dateField.getAttribute("value"), "30 Apr 1990");
    }

    @Test
    public void userCanAddSubjects() {
        homePage.clickOnCardName("Forms");
        sidebar.clickOnSidebarButton("Practice Form");

        String subject1 = excelReader.getStringData("TestData", 1, 9);
        String subject2 = excelReader.getStringData("TestData", 1, 10);
        String subject3 = excelReader.getStringData("TestData", 1, 11);

        practiceFormPage.addSubject1(subject1);
        practiceFormPage.addSubject2(subject2);
        practiceFormPage.addSubject3(subject3);

        List<WebElement> addedSubjects = driver.findElements(By.cssSelector(".subjects-auto-complete__multi-value__label"));
        List<String>subjectsText = new ArrayList<>();
        for (int i = 0; i < addedSubjects.size(); i++) {
            subjectsText.add(addedSubjects.get(i).getText());
        }
        Assert.assertTrue(subjectsText.contains("Computer Science"));
        Assert.assertTrue(subjectsText.contains("English"));
        Assert.assertTrue(subjectsText.contains("Arts"));

    }

    @Test
    public void userCanCheckHobbies() {
        homePage.clickOnCardName("Forms");
        sidebar.clickOnSidebarButton("Practice Form");
        practiceFormPage.checkHobby("Music");

        Assert.assertTrue(driver.findElement(By.id("hobbies-checkbox-3")).isSelected());
    }

    @Test
    public void userCanAddandSubmitAllDataFromExcel() {
        homePage.clickOnCardName("Forms");
        sidebar.clickOnSidebarButton("Practice Form");

        String firstName = excelReader.getStringData("TestData", 1, 0);
        String lastName = excelReader.getStringData("TestData", 1, 1);
        String email = excelReader.getStringData("TestData", 1, 2);
        String number = excelReader.getStringData("TestData", 1, 3);
        String address = excelReader.getStringData("TestData", 1, 4);
        String gender = excelReader.getStringData("TestData",1,5);
        String month = excelReader.getStringData("TestData", 1, 6);
        String year = excelReader.getStringData("TestData", 1, 7);
        String day = excelReader.getStringData("TestData", 1, 8);
        String subject1 = excelReader.getStringData("TestData", 1, 9);
        String subject2 = excelReader.getStringData("TestData", 1, 10);
        String subject3 = excelReader.getStringData("TestData", 1, 11);
        String hobby = excelReader.getStringData("TestData", 1, 12);

        practiceFormPage.inputFirstName(firstName);
        practiceFormPage.inputLastName(lastName);
        practiceFormPage.inputEmail(email);
        practiceFormPage.pickGender(gender);
        practiceFormPage.inputNumber(String.valueOf(number));
        practiceFormPage.clickOnDateField();
        practiceFormPage.clickOnMonthDropdown();
        practiceFormPage.pickMonth(month);
        practiceFormPage.clickOnYearDropdown();
        practiceFormPage.pickYear(String.valueOf(year));
        practiceFormPage.pickDay(String.valueOf(day));
        practiceFormPage.addSubject1(subject1);
        practiceFormPage.addSubject2(subject2);
        practiceFormPage.addSubject3(subject3);
        practiceFormPage.checkHobby(hobby);
        practiceFormPage.inputAddress(address);

        practiceFormPage.clickOnSubmitButton();

        Assert.assertTrue(practiceFormPage.firstNameField.getAttribute("value").contains("Jane"));
        Assert.assertTrue(practiceFormPage.isValidEmail(email));
        Assert.assertTrue(driver.findElement(By.id("gender-radio-2")).isSelected());
        Assert.assertEquals(practiceFormPage.numberField.getAttribute("value").length(), 10);
        Assert.assertEquals(practiceFormPage.dateField.getAttribute("value"), "30 Apr 1990");
        List<WebElement> addedSubjects = driver.findElements(By.cssSelector(".subjects-auto-complete__multi-value__label"));
        List<String>subjectsText = new ArrayList<>();
        for (int i = 0; i < addedSubjects.size(); i++) {
            subjectsText.add(addedSubjects.get(i).getText());
        }
        Assert.assertTrue(subjectsText.contains("Computer Science"));
        Assert.assertTrue(subjectsText.contains("English"));
        Assert.assertTrue(subjectsText.contains("Arts"));
        Assert.assertTrue(driver.findElement(By.id("hobbies-checkbox-3")).isSelected());

        Assert.assertTrue(practiceFormPage.submittedForm.isDisplayed());
        Assert.assertTrue(practiceFormPage.message.isDisplayed());
        Assert.assertEquals(practiceFormPage.message.getText(), "Thanks for submitting the form");

    }

}
