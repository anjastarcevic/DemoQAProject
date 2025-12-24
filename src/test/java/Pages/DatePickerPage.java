package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DatePickerPage extends BaseTest {

    public DatePickerPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "datePickerMonthYearInput")
    public WebElement dateField;

    @FindBy(id = "dateAndTimePickerInput")
    public WebElement dateTimeField;

    @FindBy(className = "react-datepicker__month-select")
    public WebElement monthDropdown;

    @FindBy(css = "option")
    public List<WebElement> months;

    @FindBy(className = "react-datepicker__year-select")
    public WebElement yearDropdown;

    @FindBy(css = "option")
    public List<WebElement> years;

    @FindBy(className = "react-datepicker__day")
    public List<WebElement> days;

    public void clickOnDateField() {
        dateField.click();
    }

    public void clickOnMonthDropdown() {
        monthDropdown.click();
    }

    public void clickOnYearDropdown() {
        yearDropdown.click();
    }


    public void selectMonth(String month) {
        for(int i = 0; i < months.size(); i++) {
            if(months.get(i).getText().equals(month)) {
                months.get(i).click();
                break;
            }
        }
    }

    public void selectYear(String year) {
        for(int i = 0; i < years.size(); i++) {
            if(years.get(i).getText().equals(year)) {
                years.get(i).click();
                break;
            }
        }
    }

    public void selectDay(String day) {
        for(int i = 0; i < days.size(); i++) {
            if(days.get(i).getText().equals(day)) {
                days.get(i).click();
                break;
            }
        }
    }

}
