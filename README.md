# Selenium GUI Automation Framework

## Wipro SDET Capstone Project

Selenium WebDriver automation framework built using Java, Maven, and TestNG.
Covers full GUI automation for https://testautomationpractice.blogspot.com using Page Object Model.

---

## Project Summary

| Item           | Value                      |
| -------------- | -------------------------- |
| Total Tests    | 18                         |
| Framework      | TestNG                     |
| Design Pattern | Page Object Model          |
| Reporting      | ExtentReports (HTML)       |
| Logging        | Log4j2                     |
| Build Tool     | Maven                      |
| Screenshots    | Before and After each test |

---

## Tech Stack

| Tool               | Version | Usage                 |
| ------------------ | ------- | --------------------- |
| Java               | 11+     | Core language         |
| Selenium WebDriver | 4.x     | UI automation         |
| TestNG             | 7.x     | Test execution        |
| Maven              | 3.x     | Dependency management |
| WebDriverManager   | 5.x     | Driver setup          |
| ExtentReports      | 5.x     | Reporting             |
| Log4j2             | 2.x     | Logging               |
| Commons IO         | 2.x     | File handling         |

---

## Project Structure

```
selenium-gui-automation/
│
├── pom.xml
├── screenshots/
├── test-output/
│
└── src/
    └── test/
        ├── resources/
        │   ├── testng.xml
        │   └── log4j2.xml
        │
        └── java/com/automation/
            ├── tests/
            │   ├── BaseTest.java
            │   └── GuiElementsTest.java
            │
            ├── pages/
            │   └── GuiElementsPage.java
            │
            └── utils/
                ├── ScreenshotUtil.java
                └── ExtentReportManager.java
```

---

## Test Cases

| TC ID | Test         | Element              | Validation       |
| ----- | ------------ | -------------------- | ---------------- |
| TC01  | Title Check  | Page Title           | assertEquals     |
| TC02  | Name Field   | Input                | Value match      |
| TC03  | Email Field  | Input                | Value match      |
| TC04  | Phone Field  | Input                | Value match      |
| TC05  | Address      | Textarea             | Value match      |
| TC06  | Radio        | Gender               | isSelected       |
| TC07  | Checkbox     | Sunday               | isSelected       |
| TC08  | Dropdown     | Country/Color/Animal | Selected value   |
| TC09  | Date Picker  | Calendar             | Correct date     |
| TC10  | Upload       | File Input           | File present     |
| TC11  | Search       | Wikipedia            | Input submit     |
| TC12  | Button       | Start/Stop           | Toggle           |
| TC13  | Hover        | Mouse                | Action performed |
| TC14  | Double Click | Copy                 | Text copied      |
| TC15  | Drag Drop    | UI                   | Target updated   |
| TC16  | Slider       | Range                | Position changed |
| TC17  | Alerts       | JS Alerts            | Handled          |
| TC18  | Misc         | Links/Scroll         | Executed         |

---

## Architecture

| Layer         | Responsibility              |
| ------------- | --------------------------- |
| Test Layer    | Contains TestNG test cases  |
| Page Layer    | Stores locators and actions |
| Utility Layer | Screenshots and reporting   |
| Base Layer    | Setup and teardown          |

---

## Execution Flow

1. BaseTest запускает browser
2. URL loaded
3. TestNG executes test cases
4. Each test calls Page methods
5. Screenshots captured
6. Results logged to ExtentReport
7. Browser closed

---

## Setup

### Clone

```
git clone https://github.com/YOUR_USERNAME/selenium-gui-automation.git
```

### Import

* Open Eclipse
* Import → Maven → Existing Project
* Select folder

### Build

```
mvn clean install
```

---

## Run Tests

| Method | Command           |
| ------ | ----------------- |
| TestNG | Run testng.xml    |
| Maven  | mvn clean install |

---

## Reports

| File                          | Description      |
| ----------------------------- | ---------------- |
| test-output/ExtentReport.html | Main HTML report |
| screenshots/                  | Test screenshots |

---

## Features

* WebDriverManager auto setup
* No manual driver config
* Full GUI coverage
* Clean POM structure
* Reusable components
* Screenshot tracking
* HTML reporting

---

## Key Concepts

| Concept     | Usage                   |
| ----------- | ----------------------- |
| Locators    | id, xpath, css          |
| Actions     | hover, drag, drop       |
| Alerts      | accept, dismiss         |
| Waits       | implicit, explicit      |
| JS Executor | scroll, input           |
| TestNG      | annotations, assertions |

---
## Author

> Riyaz Shaik  
> Software Development Engineer in Test (Trainee) 
> Wipro Limited

---

## Notes

* test-output and target folders should be ignored in Git
* Screenshots generated at runtime
* Chrome required

---

## License

Educational use only
