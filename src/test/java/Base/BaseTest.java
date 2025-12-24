package Base;

import Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

public class BaseTest {

    public WebDriverWait wait;
    public static WebDriver driver;
    public ExcelReader excelReader;
    public HomePage homePage;
    public Sidebar sidebar;
    public CheckboxPage checkboxPage;
    public TextboxPage textboxPage;
    public DatePickerPage datePickerPage;
    public SliderPage sliderPage;
    public PracticeFormPage practiceFormPage;


    @BeforeClass
    public void setUp() throws IOException {
        WebDriverManager.chromedriver().setup();
        excelReader = new ExcelReader("C:\\Users\\Anja\\IdeaProjects\\DemoQAProject\\src\\test\\resources\\PracticeFormData.xlsx");
    }

    @AfterClass
    public void tearDown() {
        //driver.quit();
    }

    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public boolean isValidEmail(String email) {
        String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        return email.matches(regex);
    }



}
