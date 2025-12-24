package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TextboxPage extends BaseTest {

    public TextboxPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "userName")
    public WebElement fullNameField;

    @FindBy(id = "userEmail")
    public WebElement emailField;

    @FindBy(id = "currentAddress")
    public WebElement currentAddressField;

    @FindBy(id = "permanentAddress")
    public WebElement permanentAddressField;

    @FindBy(id = "submit")
    public WebElement submitButton;

    @FindBy(css = ".border.col-md-12.col-sm-12")
    public WebElement addedData;

    public void inputFullName(String fullName) {
        fullNameField.clear();
        fullNameField.sendKeys(fullName);
    }

    public void inputEmail(String email) {
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void inputCurrentAddress(String currentAddress) {
        currentAddressField.clear();
        currentAddressField.sendKeys(currentAddress);
    }

    public void inputPermanentAddress(String permanentAddress) {
        permanentAddressField.clear();
        permanentAddressField.sendKeys(permanentAddress);
    }

    public void clickOnSubmitButton() {
        scrollToElement(submitButton);
        submitButton.click();
    }

    public boolean isValidEmail(String email) {
        String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        return email.matches(regex);
    }


}
