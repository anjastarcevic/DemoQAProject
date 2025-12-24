package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class PracticeFormPage extends BaseTest {

    public PracticeFormPage() {
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @FindBy(id = "firstName")
    public WebElement firstNameField;

    @FindBy(id = "lastName")
    public WebElement lastNameField;

    @FindBy(id = "userEmail")
    public WebElement emailField;

    @FindBy(css = ".custom-control.custom-radio.custom-control-inline")
    public List<WebElement> radioButtons;

    @FindBy(id = "userNumber")
    public WebElement numberField;

    @FindBy(id = "dateOfBirthInput")
    public WebElement dateField;

    @FindBy(className = "react-datepicker__month-select")
    public WebElement monthDropdown;

    @FindBy(className = "react-datepicker__year-select")
    public WebElement yearDropdown;

    @FindBy(css = "option")
    public List<WebElement> monthOptions;

    @FindBy(css = "option")
    public List<WebElement> yearOptions;

    @FindBy(className = "react-datepicker__day")
    public List<WebElement> dayOptions;

    @FindBy(id = "currentAddress")
    public WebElement addressField;

    @FindBy(id = "subjectsInput")
    public WebElement subjectField;

    @FindBy(css = ".subjects-auto-complete__option")
    public List<WebElement> subjects;

    @FindBy(css = "label.custom-control-label")
    public List<WebElement> hobbies;

    @FindBy(id = "submit")
    public WebElement submitButton;

    @FindBy(id = "example-modal-sizes-title-lg")
    public WebElement message;

    @FindBy(className = "modal-body")
    public WebElement submittedForm;

    public void inputFirstName(String firstName) {
        firstNameField.clear();
        firstNameField.sendKeys(firstName);
    }

    public void inputLastName(String lastName) {
        lastNameField.clear();
        lastNameField.sendKeys(lastName);
    }

    public void inputEmail(String email) {
        emailField.clear();
        emailField.sendKeys(email);
    }

    public boolean isValidEmail(String email) {
        String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        return email.matches(regex);
    }

    public void inputNumber(String number) {
        numberField.clear();
        numberField.sendKeys(number);
    }

    public void inputAddress(String address) {
        addressField.clear();
        addressField.sendKeys(address);
    }

    public void clickOnDateField() {
        scrollToElement(dateField);
        dateField.click();
    }

    public void pickGender(String gender) {
        for(int i = 0; i < radioButtons.size(); i++) {
            if(radioButtons.get(i).getText().equals(gender)) {
                scrollToElement(radioButtons.get(i));
                radioButtons.get(i).click();
                break;
            }
        }
    }

    public void clickOnMonthDropdown() {
        monthDropdown.click();
    }

    public void clickOnYearDropdown() {
        yearDropdown.click();
    }

    public void pickMonth(String month) {
        for(int i = 0; i < monthOptions.size(); i++) {
            if(monthOptions.get(i).getText().equals(month)) {
                monthOptions.get(i).click();
                break;
            }
        }
    }

    public void pickYear(String year) {
        for(int i = 0; i < yearOptions.size(); i++) {
            if(yearOptions.get(i).getText().equals(year)) {
                yearOptions.get(i).click();
                break;
            }
        }
    }

    public void pickDay(String day) {
        for(int i = 0; i < dayOptions.size(); i++) {
            if(dayOptions.get(i).getText().equals(day)) {
                dayOptions.get(i).click();
                break;
            }
        }
    }

    public void addSubject1(String subject1) {
        scrollToElement(subjectField);
        subjectField.sendKeys("C");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".subjects-auto-complete__menu")));
        for(int i = 0; i < subjects.size(); i++) {
            if(subjects.get(i).getText().equals(subject1)) {
                subjects.get(i).click();
                break;
            }
        }
    }

    public void addSubject2(String subject2) {
        subjectField.sendKeys("E");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".subjects-auto-complete__menu")));
        for(int i = 0; i < subjects.size(); i++) {
            if(subjects.get(i).getText().equals(subject2)) {
                subjects.get(i).click();
                break;
            }
        }
    }

    public void addSubject3(String subject3) {
        subjectField.sendKeys("A");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".subjects-auto-complete__menu")));
        for(int i = 0; i < subjects.size(); i++) {
            if(subjects.get(i).getText().equals(subject3)) {
                subjects.get(i).click();
                break;
            }
        }
    }

    public void checkHobby(String hobby) {
        scrollToElement(driver.findElement(By.id("subjects-label")));
        for(int i = 0; i < hobbies.size(); i++) {
            if(hobbies.get(i).getText().contains(hobby)) {
                hobbies.get(i).click();
                break;
            }
        }
    }

    public void clickOnSubmitButton() {
        submitButton.click();
    }

}
