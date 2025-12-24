# DemoQAProject

This is an automated testing project using **Selenium WebDriver**, **TestNG**, and **Java**. The project tests various UI elements on [DemoQA](https://demoqa.com/), including **Date Picker**, **Slider**, **Checkbox**, **Textbox**, and **Practice Form**.

---

## Technologies & Libraries

- **Java 25**
- **Selenium WebDriver 4.38.0**
- **WebDriverManager 6.3.2**
- **TestNG 7.11.0**
- **Apache POI 5.5.1** (for working with Excel files)

---

## Setup & Installation

### Prerequisites

- Java JDK installed
- Maven installed
- IDE (IntelliJ IDEA or Eclipse)
- Supported browser (e.g., Chrome)

### Install Dependencies

```bash
mvn clean install
```

---


## Project Structure

DemoQAProject
├── pom.xml
├── README.md
└── src
└── test
└── java
├── Base
│   ├── BaseTest.java
│   └── ExcelReader.java
├── Pages
│   ├── HomePage.java
│   ├── Sidebar.java
│   ├── PracticeFormPage.java
│   ├── CheckboxPage.java
│   ├── TextboxPage.java
│   ├── DatePickerPage.java
│   └── SliderPage.java
└── Tests
├── PracticeFormTest.java  (data-driven via Excel)
├── CheckboxTest.java       (hardcoded data)
├── SliderTest.java         (hardcoded data)
├── TextBoxTest.java        (hardcoded data)
└── DatePickerTest.java     (hardcoded data)


- **Base**: Contains the base test setup, WebDriver initialization, and helper methods.
- **Pages**: Page Object Model (POM) classes representing different pages and elements of the site.
- **Tests**: TestNG test classes for various functionalities of the site.

---

## Running the Tests

1. **Clone** the project or download the ZIP file.
2. Open the project in an IDE like **IntelliJ IDEA** or **Eclipse**.
3. Ensure **Maven** is configured and all dependencies in `pom.xml` are downloaded.
4. Run the tests from the `Tests` package as a **TestNG test** or using the command:


## Tested Functionalities

### 1. Practice Form (data-driven via Excel)
- Fills out the form using data from an Excel file.
- Validates form submission.

### 2. Checkbox (hardcoded data)
- Selects and deselects checkboxes.
- Validates checkbox state.

### 3. Slider (hardcoded data)
- Moves the slider to a specific value.
- Validates the slider value.

### 4. Textbox (hardcoded data)
- Enters text into input fields.
- Validates input values.

### 5. Date Picker (hardcoded data)
- Opens the date picker.
- Selects month and year.
- Chooses a specific day.

---

## Excel File Configuration

- Tests use an **Excel file** (`PracticeFormData.xlsx`) located locally at:  
  `C:\Users\Anja\Desktop\PracticeFormData.xlsx`
- The `ExcelReader` class reads data for the **Practice Form** tests.

---

## Notes

- Currently, `driver.quit()` in `BaseTest` is commented out to simplify debugging.
- Both **implicit** and **explicit waits** are used depending on the element and test.
- New tests and POM classes can be added as needed.

## Author

Anja Starčević Tomaš

