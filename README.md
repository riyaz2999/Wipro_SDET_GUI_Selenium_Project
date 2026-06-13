# selenium-gui-automation
Selenium WebDriver GUI Automation | Wipro SDET Capstone. POM framework with 18 TestNG test cases, ExtentReports HTML report, Log4j2 logging, before/after screenshots for every test, covering all GUI elements on testautomationpractice.blogspot.com
Here's your complete README:

```markdown
# Selenium GUI Automation Framework
### Wipro SDET Capstone Project

A professional Selenium WebDriver automation framework built as part of the 
Wipro SDET (Software Development Engineer in Test) training program. 
The framework automates all interactive GUI elements on 
[testautomationpractice.blogspot.com](https://testautomationpractice.blogspot.com) 
using Java, Maven, and TestNG.

---

## Project Structure

```
selenium-gui-automation/
│
├── pom.xml                          ← Maven build + all dependencies
├── screenshots/                     ← Auto-generated PNG screenshots at runtime
│   └── TC01_title_before_*.png ...
├── test-output/
│   └── ExtentReport.html            ← Rich HTML report with embedded screenshots
│
└── src/
    └── test/
        ├── resources/
        │   ├── testng.xml           ← TestNG suite definition
        │   └── log4j2.xml           ← Logging configuration
        └── java/com/automation/
            ├── tests/
            │   ├── BaseTest.java    ← @BeforeSuite / @AfterSuite (WebDriver + Report setup)
            │   └── GuiElementsTest.java  ← 18 @Test methods with screenshots
            ├── pages/
            │   └── GuiElementsPage.java  ← Page Object Model (all locators & actions)
            └── utils/
                ├── ScreenshotUtil.java        ← Captures & saves PNG screenshots
                └── ExtentReportManager.java   ← Singleton HTML report manager
```

---

## Tech Stack

| Technology | Version | Purpose |
|---|---|---|
| Java | 11 | Programming language |
| Selenium WebDriver | 4.18.1 | Browser automation |
| TestNG | 7.9.0 | Test framework |
| Maven | 3.x | Build and dependency management |
| WebDriverManager | 5.7.0 | Auto ChromeDriver setup |
| ExtentReports | 5.1.1 | HTML test reporting |
| Log4j2 | 2.23.1 | Logging |
| Commons IO | 2.16.1 | File handling |

---

## Test Cases — 18 Total

| TC | Test Name | GUI Element | Assertion |
|---|---|---|---|
| TC01 | Page Title Validation | Browser title | Title equals expected |
| TC02 | Name Text Field | Text input | Value matches input |
| TC03 | Email Text Field | Text input | Value matches input |
| TC04 | Phone Text Field | Text input | Value matches input |
| TC05 | Address Textarea | Textarea | Value matches input |
| TC06 | Radio Button | Gender radio | isSelected() = true |
| TC07 | Checkbox | Sunday checkbox | isSelected() = true |
| TC08 | Dropdowns | Country, Color, Animal | Selected values verified |
| TC09 | Date Pickers | 3 date pickers | Dates set correctly |
| TC10 | File Upload | Single + Multiple | Files uploaded |
| TC11 | Wikipedia Search | Search widget | Input + Enter submitted |
| TC12 | Dynamic Button | START/STOP toggle | Button toggles correctly |
| TC13 | Mouse Hover | Point Me button | Hover performed |
| TC14 | Double Click | Copy Text button | Field2 = Field1 value |
| TC15 | Drag and Drop | Draggable to droppable | Target text not empty |
| TC16 | Slider | jQuery UI slider | Slider moved 100px |
| TC17 | Alert Handling | Simple, Confirm, Prompt | All 3 alerts handled |
| TC18 | Misc Features | ComboBox, Links, New Tab, Popup, Scroll | All actions completed |

---

## Framework Architecture

### Page Object Model (POM)
All web element locators and actions are centralized in `GuiElementsPage.java`.
Tests never interact with the browser directly — they call page methods only.
This makes the framework easy to maintain when locators change.

### BaseTest
Handles browser lifecycle:
- `@BeforeSuite` — launches Chrome, sets implicit wait, opens URL, initializes report
- `@AfterSuite` — closes browser, flushes ExtentReport to disk

### ExtentReportManager
Singleton class managing the HTML report:
- Creates one report instance for the entire test run
- Each `@Test` gets its own node with PASS/FAIL status
- Screenshots embedded directly inside each test node

### ScreenshotUtil
Captures full-page screenshots at any point during execution:
- Auto-creates `screenshots/` folder if not present
- Filename format: `stepName_yyyyMMdd_HHmmss_SSS.png`
- Returns absolute path for embedding into ExtentReport

---

## Prerequisites

- Java JDK 11 or higher
- Maven 3.x
- Google Chrome browser
- Eclipse IDE (or any Java IDE)
- Internet connection (WebDriverManager auto-downloads ChromeDriver)

---

## Setup and Installation

**1. Clone the repository**
```bash
git clone https://github.com/YOUR_USERNAME/selenium-gui-automation.git
```

**2. Import into Eclipse**
```
File → Import → Maven → Existing Maven Projects
→ Browse to cloned folder → Finish
```

**3. Update Maven**
```
Right-click project → Maven → Update Project → Force Update → OK
```

**4. Run Maven build**
```
Right-click project → Run As → Maven clean
Right-click project → Run As → Maven install
```

---

## How to Run Tests

**Option 1 — Run via TestNG directly (Eclipse)**
```
Right-click testng.xml → Run As → TestNG Suite
```

**Option 2 — Run via Maven**
```
Right-click project → Run As → Maven install
```

---

## Test Reports

After execution, open the HTML report:
```
test-output/ExtentReport.html
→ Right-click → Open With → Web Browser
```

Report includes:
- Pass/Fail status for all 18 tests
- System info (Browser, Environment, Tester name)
- Before and after screenshots for every test step
- Execution timestamps and duration

Screenshots are saved at:
```
screenshots/TC01_title_before_*.png
screenshots/TC02_name_after_*.png
... and so on for all 18 test cases
```

---

## Key Selenium Concepts Covered

- WebDriver setup using WebDriverManager
- Locators: By.id, By.xpath, By.tagName, By.cssSelector
- Select class for dropdowns
- Actions class: doubleClick, moveToElement, dragAndDrop, dragAndDropBy
- JavascriptExecutor: set values, scroll up/down
- Alert handling: accept, dismiss, sendKeys
- File upload via sendKeys with absolute path
- Implicit and Explicit waits (WebDriverWait + ExpectedConditions)
- TakesScreenshot interface
- Page Object Model design pattern
- TestNG annotations: @BeforeSuite, @AfterSuite, @BeforeClass, @Test
- TestNG assertions: assertEquals, assertTrue, assertFalse

---

## Author

**Sourav Singh**  
SDET Trainee — Wipro Limited  
Training Program: Software Development Engineer in Test  

---

## License

This project is developed for educational purposes as part of Wipro SDET training.
```

---

Copy this entire content, create a file named `README.md` in your project root folder, paste it in, and push to GitHub.
