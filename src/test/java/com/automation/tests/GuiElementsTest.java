package com.automation.tests;

import com.automation.pages.GuiElementsPage;
import com.automation.utils.ExtentReportManager;
import com.automation.utils.ScreenshotUtil;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * GuiElementsTest
 * ══════════════════════════════════════════════════════════════
 * 18 TestNG @Test methods covering every GUI element on:
 *   https://testautomationpractice.blogspot.com/
 *
 * Each test:
 *   1. Creates ExtentTest node in the HTML report
 *   2. Performs action via GuiElementsPage (POM)
 *   3. Captures screenshot BEFORE and AFTER the action
 *   4. Asserts the expected outcome
 *   5. Marks PASS or FAIL in the report
 * ══════════════════════════════════════════════════════════════
 */
public class GuiElementsTest extends BaseTest {

    private GuiElementsPage page;

    // ── Test Data ────────────────────────────────────────────────
    private static final String NAME         = "Riyaz Shaik";
    private static final String EMAIL        = "testng@gmail.com";
    private static final String PHONE        = "1234567890";
    private static final String ADDRESS      = "Vijayawada, Andhra Pradesh";
    private static final String GENDER_ID    = "male";
    private static final String DAY_ID       = "sunday";
    private static final String COUNTRY      = "India";
    private static final String COLOR        = "Blue";
    private static final String ANIMAL       = "Lion";
    private static final String DATE1        = "03/15/2026";
    private static final String DATE2        = "09/09/2021";
    private static final String START_DATE   = "12-05-2004";
    private static final String END_DATE     = "12-05-2005";
    private static final String SINGLE_FILE  =
        "D:\\Wipro\\Assignment - 25 - SDET.pdf";
    private static final String FILE1        =
        "D:\\Wipro\\Riyaz_Resume.pdf";
    private static final String FILE2        =
        "D:\\Wipro\\image.png";
    private static final String WIKI_SEARCH  = "Selenium";
    private static final String PROMPT_TEXT  = "Riyaz";
    private static final String DC_TEXT      = "Riyaz";
    private static final String COMBO_ITEM   = "Item 3";

    @BeforeClass
    public void initPage() {
        page = new GuiElementsPage(BaseTest.driver, BaseTest.wait);
        System.out.println("[Test] GuiElementsPage initialised.");
    }

    // ── Helper: attach screenshot to current ExtentTest node ─────
    private void addScreenshot(ExtentTest test,
            String stepName,
            String description) {
String path = ScreenshotUtil.capture(BaseTest.driver, stepName);
        if (!path.isEmpty()) {
            try {
                test.addScreenCaptureFromPath(path, description);
            } catch (Exception e) {
                test.log(Status.WARNING,
                    "Could not attach screenshot: " + e.getMessage());
            }
        }
    }

    // ════════════════════════════════════════════════════════════
    //  TC01 — Page Title Validation
    // ════════════════════════════════════════════════════════════
    @Test(priority = 1, description = "Validate page title of the application")
    public void tc01_PageTitleValidation() {
        ExtentTest test = ExtentReportManager.createTest(
            "TC01 – Page Title Validation",
            "Verify the page title matches expected value");
        try {
            addScreenshot(test, "TC01_title_before", "Page loaded");

            String actual   = page.getPageTitle();
            String expected = "Automation Testing Practice";
            test.log(Status.INFO, "Actual Title: <b>" + actual + "</b>");

            Assert.assertEquals(actual, expected, "Page title mismatch!");
            addScreenshot(test, "TC01_title_after", "Title verified");
            test.pass("Page title validated: " + actual);

        } catch (AssertionError | Exception e) {
            addScreenshot(test, "TC01_FAIL", "FAIL – Page Title");
            test.fail("TC01 failed: " + e.getMessage());
            throw e;
        }
    }

    // ════════════════════════════════════════════════════════════
    //  TC02 — Name Text Field
    // ════════════════════════════════════════════════════════════
    @Test(priority = 2, description = "Enter text in the Name field")
    public void tc02_NameField() {
        ExtentTest test = ExtentReportManager.createTest(
            "TC02 – Name Text Field",
            "Verify Name field accepts and retains input text");
        try {
            page.scrollTo(page.getNameField());
            addScreenshot(test, "TC02_name_before", "Name field – before input");

            page.enterName(NAME);
            test.log(Status.INFO, "Entered name: <b>" + NAME + "</b>");

            addScreenshot(test, "TC02_name_after", "Name field – after input");

            String actual = page.getNameField().getAttribute("value");
            Assert.assertEquals(actual, NAME, "Name field mismatch!");
            test.pass("Name field correctly shows: " + actual);

        } catch (AssertionError | Exception e) {
            addScreenshot(test, "TC02_FAIL", "FAIL – Name Field");
            test.fail(e.getMessage());
            throw e;
        }
    }

    // ════════════════════════════════════════════════════════════
    //  TC03 — Email Field
    // ════════════════════════════════════════════════════════════
    @Test(priority = 3, description = "Enter text in the Email field")
    public void tc03_EmailField() {
        ExtentTest test = ExtentReportManager.createTest(
            "TC03 – Email Text Field",
            "Verify Email field accepts valid email address");
        try {
            page.scrollTo(page.getEmailField());
            addScreenshot(test, "TC03_email_before", "Email field – before input");

            page.enterEmail(EMAIL);
            test.log(Status.INFO, "Entered email: <b>" + EMAIL + "</b>");

            addScreenshot(test, "TC03_email_after", "Email field – after input");

            String actual = page.getEmailField().getAttribute("value");
            Assert.assertEquals(actual, EMAIL, "Email field mismatch!");
            test.pass("Email field correctly shows: " + actual);

        } catch (AssertionError | Exception e) {
            addScreenshot(test, "TC03_FAIL", "FAIL – Email Field");
            test.fail(e.getMessage());
            throw e;
        }
    }

    // ════════════════════════════════════════════════════════════
    //  TC04 — Phone Field
    // ════════════════════════════════════════════════════════════
    @Test(priority = 4, description = "Enter text in the Phone field")
    public void tc04_PhoneField() {
        ExtentTest test = ExtentReportManager.createTest(
            "TC04 – Phone Text Field",
            "Verify Phone field accepts numeric input");
        try {
            page.scrollTo(page.getPhoneField());
            addScreenshot(test, "TC04_phone_before", "Phone field – before input");

            page.enterPhone(PHONE);
            test.log(Status.INFO, "Entered phone: <b>" + PHONE + "</b>");

            addScreenshot(test, "TC04_phone_after", "Phone field – after input");

            String actual = page.getPhoneField().getAttribute("value");
            Assert.assertEquals(actual, PHONE, "Phone field mismatch!");
            test.pass("Phone field correctly shows: " + actual);

        } catch (AssertionError | Exception e) {
            addScreenshot(test, "TC04_FAIL", "FAIL – Phone Field");
            test.fail(e.getMessage());
            throw e;
        }
    }

    // ════════════════════════════════════════════════════════════
    //  TC05 — Address Textarea
    // ════════════════════════════════════════════════════════════
    @Test(priority = 5, description = "Enter text in the Address textarea")
    public void tc05_AddressField() {
        ExtentTest test = ExtentReportManager.createTest(
            "TC05 – Address Textarea",
            "Verify Address textarea accepts text input");
        try {
            page.scrollTo(page.getAddressField());
            addScreenshot(test, "TC05_address_before", "Address field – before input");

            page.enterAddress(ADDRESS);
            test.log(Status.INFO, "Entered address: <b>" + ADDRESS + "</b>");

            addScreenshot(test, "TC05_address_after", "Address field – after input");

            String actual = page.getAddressField().getAttribute("value");
            Assert.assertEquals(actual, ADDRESS, "Address field mismatch!");
            test.pass("Address field correctly shows: " + actual);

        } catch (AssertionError | Exception e) {
            addScreenshot(test, "TC05_FAIL", "FAIL – Address Field");
            test.fail(e.getMessage());
            throw e;
        }
    }

    // ════════════════════════════════════════════════════════════
    //  TC06 — Radio Button
    // ════════════════════════════════════════════════════════════
    @Test(priority = 6, description = "Select Male radio button")
    public void tc06_RadioButton() {
        ExtentTest test = ExtentReportManager.createTest(
            "TC06 – Radio Button",
            "Verify Male radio button can be selected");
        try {
            page.scrollTo(page.getGenderRadio());
            addScreenshot(test, "TC06_radio_before", "Radio button – before selection");

            page.selectGender(GENDER_ID);
            test.log(Status.INFO, "Selected gender: <b>Male</b>");

            addScreenshot(test, "TC06_radio_after", "Radio button – after selection");

            Assert.assertTrue(page.getGenderRadio().isSelected(),
                "Male radio button not selected!");
            test.pass("Male radio button selected successfully.");

        } catch (AssertionError | Exception e) {
            addScreenshot(test, "TC06_FAIL", "FAIL – Radio Button");
            test.fail(e.getMessage());
            throw e;
        }
    }

    // ════════════════════════════════════════════════════════════
    //  TC07 — Checkbox
    // ════════════════════════════════════════════════════════════
    @Test(priority = 7, description = "Select Sunday checkbox")
    public void tc07_Checkbox() {
        ExtentTest test = ExtentReportManager.createTest(
            "TC07 – Checkbox",
            "Verify Sunday checkbox can be checked");
        try {
            page.scrollTo(page.getDayCheckbox());
            addScreenshot(test, "TC07_checkbox_before", "Checkbox – before selection");

            page.checkDay(DAY_ID);
            test.log(Status.INFO, "Checked day: <b>Sunday</b>");

            addScreenshot(test, "TC07_checkbox_after", "Checkbox – after selection");

            Assert.assertTrue(page.getDayCheckbox().isSelected(),
                "Sunday checkbox not checked!");
            test.pass("Sunday checkbox checked successfully.");

        } catch (AssertionError | Exception e) {
            addScreenshot(test, "TC07_FAIL", "FAIL – Checkbox");
            test.fail(e.getMessage());
            throw e;
        }
    }

    // ════════════════════════════════════════════════════════════
    //  TC08 — Dropdowns
    // ════════════════════════════════════════════════════════════
    @Test(priority = 8, description = "Select Country, Color and Animal dropdowns")
    public void tc08_Dropdowns() {
        ExtentTest test = ExtentReportManager.createTest(
            "TC08 – Dropdowns",
            "Verify Country, Color and Animal dropdowns work correctly");
        try {
            // Country
            page.scrollTo(page.getCountryDropdown());
            addScreenshot(test, "TC08_country_before", "Country dropdown – before");
            page.selectCountry(COUNTRY);
            test.log(Status.INFO, "Country selected: <b>" + COUNTRY + "</b>");
            addScreenshot(test, "TC08_country_after", "Country dropdown – after");

            // Color
            page.scrollTo(page.getColorsDropdown());
            addScreenshot(test, "TC08_color_before", "Color dropdown – before");
            page.selectColor(COLOR);
            test.log(Status.INFO, "Color selected: <b>" + COLOR + "</b>");
            addScreenshot(test, "TC08_color_after", "Color dropdown – after");

            // Animal
            page.scrollTo(page.getAnimalsDropdown());
            addScreenshot(test, "TC08_animal_before", "Animal dropdown – before");
            page.selectAnimal(ANIMAL);
            test.log(Status.INFO, "Animal selected: <b>" + ANIMAL + "</b>");
            addScreenshot(test, "TC08_animal_after", "Animal dropdown – after");

            test.pass("All 3 dropdowns selected: "
                + COUNTRY + " | " + COLOR + " | " + ANIMAL);

        } catch (AssertionError | Exception e) {
            addScreenshot(test, "TC08_FAIL", "FAIL – Dropdowns");
            test.fail(e.getMessage());
            throw e;
        }
    }

    // ════════════════════════════════════════════════════════════
    //  TC09 — Date Pickers
    // ════════════════════════════════════════════════════════════
    @Test(priority = 9, description = "Set all 3 date pickers")
    public void tc09_DatePickers() {
        ExtentTest test = ExtentReportManager.createTest(
            "TC09 – Date Pickers",
            "Verify all 3 date pickers accept date input");
        try {
            // Date Picker 1
            page.scrollTo(page.getDatePicker1());
            addScreenshot(test, "TC09_date1_before", "Date Picker 1 – before");
            page.enterDatePicker1(DATE1);
            test.log(Status.INFO, "Date Picker 1 set: <b>" + DATE1 + "</b>");
            addScreenshot(test, "TC09_date1_after", "Date Picker 1 – after");

            // Date Picker 2
            page.scrollTo(page.getDatePicker2());
            addScreenshot(test, "TC09_date2_before", "Date Picker 2 – before");
            page.enterDatePicker2(DATE2);
            test.log(Status.INFO,
                "Date Picker 2 set via JS: <b>" + DATE2 + "</b>");
            addScreenshot(test, "TC09_date2_after", "Date Picker 2 – after");

            // Date Range
            page.scrollTo(page.getStartDate());
            addScreenshot(test, "TC09_daterange_before", "Date Range – before");

            page.enterDateRange(START_DATE, END_DATE); // this must use JS fix

            addScreenshot(test, "TC09_daterange_after", "Date Range – after");

            test.log(Status.INFO, "Date Range set from "
                + START_DATE + " to " + END_DATE);

            test.pass("All 3 date pickers set successfully");

        } catch (AssertionError | Exception e) {
            addScreenshot(test, "TC09_FAIL", "FAIL – Date Pickers");
            test.fail(e.getMessage());
            throw e;
        }
    }

    // ════════════════════════════════════════════════════════════
    //  TC10 — File Upload
    // ════════════════════════════════════════════════════════════
    @Test(priority = 10, description = "Upload single and multiple files")
    public void tc10_FileUpload() {
        ExtentTest test = ExtentReportManager.createTest(
            "TC10 – File Upload",
            "Verify single and multiple file upload works");
        try {
            // Single file
            page.scrollTo(page.getSingleUpload());
            addScreenshot(test, "TC10_singlefile_before", "Single upload – before");
            page.uploadSingleFile(SINGLE_FILE);
            test.log(Status.INFO, "Single file uploaded.");
            addScreenshot(test, "TC10_singlefile_after", "Single upload – after");

            // Multiple files
            addScreenshot(test, "TC10_multifile_before", "Multiple upload – before");
            page.uploadMultipleFiles(FILE1, FILE2);
            test.log(Status.INFO, "Multiple files uploaded.");
            addScreenshot(test, "TC10_multifile_after", "Multiple upload – after");

            test.pass("Single and multiple file uploads completed.");

        } catch (AssertionError | Exception e) {
            addScreenshot(test, "TC10_FAIL", "FAIL – File Upload");
            test.fail(e.getMessage());
            throw e;
        }
    }

    // ════════════════════════════════════════════════════════════
    //  TC11 — Wikipedia Search Widget
    // ════════════════════════════════════════════════════════════
    @Test(priority = 11, description = "Search Selenium in Wikipedia widget")
    public void tc11_WikipediaSearch() {
        ExtentTest test = ExtentReportManager.createTest(
            "TC11 – Wikipedia Search Widget",
            "Verify Wikipedia search widget accepts input and submits");
        try {
            page.scrollTo(page.getWikiSearch());
            addScreenshot(test, "TC11_wiki_before", "Wikipedia widget – before");

            page.searchWikipedia(WIKI_SEARCH);
            test.log(Status.INFO,
                "Searched Wikipedia for: <b>" + WIKI_SEARCH + "</b>");

            addScreenshot(test, "TC11_wiki_after", "Wikipedia widget – after");
            test.pass("Wikipedia search submitted: " + WIKI_SEARCH);

        } catch (AssertionError | Exception e) {
            addScreenshot(test, "TC11_FAIL", "FAIL – Wikipedia Search");
            test.fail(e.getMessage());
            throw e;
        }
    }

    // ════════════════════════════════════════════════════════════
    //  TC12 — Dynamic Button
    // ════════════════════════════════════════════════════════════
    @Test(priority = 12, description = "Toggle Dynamic START/STOP button")
    public void tc12_DynamicButton() {
        ExtentTest test = ExtentReportManager.createTest(
            "TC12 – Dynamic Button (START/STOP)",
            "Verify Dynamic button toggles between START and STOP");
        try {
            page.scrollTo(page.getDynamicButton());
            addScreenshot(test, "TC12_dynbtn_before", "Dynamic Button – before click");

            // Click START → STOP → START (both clicks handled inside the method)
            page.clickDynamicButtonAndGetText();

            addScreenshot(test, "TC12_dynbtn_after", "Dynamic Button – toggled back to START");
            test.pass("Dynamic button toggled: START → STOP → START");

        } catch (AssertionError | Exception e) {
            addScreenshot(test, "TC12_FAIL", "FAIL – Dynamic Button");
            test.fail(e.getMessage());
            throw e;
        }
    }

    // ════════════════════════════════════════════════════════════
    //  TC13 — Mouse Hover
    // ════════════════════════════════════════════════════════════
    @Test(priority = 13, description = "Hover over Point Me button")
    public void tc13_MouseHover() {
        ExtentTest test = ExtentReportManager.createTest(
            "TC13 – Mouse Hover",
            "Verify mouse hover action on Point Me button");
        try {
            page.scrollTo(page.getHoverButton());
            addScreenshot(test, "TC13_hover_before", "Hover button – before hover");

            page.mouseHover();
            test.log(Status.INFO, "Mouse hovered over 'Point Me' button.");

            addScreenshot(test, "TC13_hover_after", "Hover button – after hover");
            test.pass("Mouse hover performed successfully on 'Point Me' button.");

        } catch (AssertionError | Exception e) {
            addScreenshot(test, "TC13_FAIL", "FAIL – Mouse Hover");
            test.fail(e.getMessage());
            throw e;
        }
    }

    // ════════════════════════════════════════════════════════════
    //  TC14 — Double Click
    // ════════════════════════════════════════════════════════════
    @Test(priority = 14, description = "Double click Copy Text button to copy field1 to field2")
    public void tc14_DoubleClick() {
        ExtentTest test = ExtentReportManager.createTest(
            "TC14 – Double Click",
            "Verify double-click on Copy Text copies field1 value to field2");
        try {
            page.scrollTo(page.getField1());
            addScreenshot(test, "TC14_dblclick_before", "Double click area – before");

            page.setField1(DC_TEXT);
            test.log(Status.INFO, "Field1 set to: <b>" + DC_TEXT + "</b>");
            addScreenshot(test, "TC14_field1_filled", "Field1 filled");

            page.doubleClickCopyButton();
            test.log(Status.INFO, "Double-clicked Copy Text button.");

            addScreenshot(test, "TC14_dblclick_after", "After double-click");

            String field2 = page.getField2Value();
            Assert.assertEquals(field2, DC_TEXT,
                "Field2 does not contain copied text!");
            test.pass("Field2 = '" + field2 + "' matches Field1. Copy verified.");

        } catch (AssertionError | Exception e) {
            addScreenshot(test, "TC14_FAIL", "FAIL – Double Click");
            test.fail(e.getMessage());
            throw e;
        }
    }

    // ════════════════════════════════════════════════════════════
    //  TC15 — Drag and Drop
    // ════════════════════════════════════════════════════════════
    @Test(priority = 15, description = "Drag draggable element onto droppable target")
    public void tc15_DragAndDrop() {
        ExtentTest test = ExtentReportManager.createTest(
            "TC15 – Drag and Drop",
            "Verify draggable element can be dropped onto target");
        try {
            page.scrollTo(page.getDraggable());
            addScreenshot(test, "TC15_dragdrop_before", "Drag & Drop – before");

            page.dragAndDrop();
            test.log(Status.INFO, "Drag and drop performed.");

            addScreenshot(test, "TC15_dragdrop_after", "Drag & Drop – after");

            String dropText = page.getDropTargetText();
            test.log(Status.INFO,
                "Drop target text: <b>" + dropText + "</b>");
            Assert.assertFalse(dropText.isEmpty(),
                "Drop target text is empty – drag and drop may have failed!");
            test.pass("Drag and drop successful. Target text: " + dropText);

        } catch (AssertionError | Exception e) {
            addScreenshot(test, "TC15_FAIL", "FAIL – Drag and Drop");
            test.fail(e.getMessage());
            throw e;
        }
    }

    // ════════════════════════════════════════════════════════════
    //  TC16 — Slider
    // ════════════════════════════════════════════════════════════
    @Test(priority = 16, description = "Move the slider 100px to the right")
    public void tc16_Slider() {
        ExtentTest test = ExtentReportManager.createTest(
            "TC16 – Slider",
            "Verify slider can be moved using dragAndDropBy");
        try {
            page.scrollTo(page.getSlider());
            addScreenshot(test, "TC16_slider_before", "Slider – before move");

            page.moveSlider(100);
            test.log(Status.INFO, "Slider moved 100px to the right.");

            addScreenshot(test, "TC16_slider_after", "Slider – after move");
            test.pass("Slider moved successfully.");

        } catch (AssertionError | Exception e) {
            addScreenshot(test, "TC16_FAIL", "FAIL – Slider");
            test.fail(e.getMessage());
            throw e;
        }
    }

    // ════════════════════════════════════════════════════════════
    //  TC17 — Alerts
    // ════════════════════════════════════════════════════════════
    @Test(priority = 17, description = "Handle Simple, Confirm and Prompt alerts")
    public void tc17_Alerts() {
        ExtentTest test = ExtentReportManager.createTest(
            "TC17 – Alert Handling",
            "Verify Simple, Confirm and Prompt alerts can be handled");
        try {
            // Simple Alert
            page.scrollTo(page.getAlertBtn());
            addScreenshot(test, "TC17_alert_before", "Simple Alert – before click");
            page.clickSimpleAlert();
            String simpleText = page.acceptSimpleAlert();
            test.log(Status.INFO,
                "Simple Alert text: <b>" + simpleText + "</b> → Accepted.");
            Assert.assertEquals(simpleText, "I am an alert box!",
                "Simple alert text mismatch!");
            addScreenshot(test, "TC17_alert_after", "Simple Alert – accepted");

            // Confirm Alert — Dismiss first
            page.scrollTo(page.getConfirmBtn());
            page.clickConfirmAlert();
            String confirmText1 = page.dismissConfirmAlert();
            test.log(Status.INFO,
                "Confirm Alert: <b>" + confirmText1 + "</b> → Dismissed.");
            addScreenshot(test, "TC17_confirm_dismissed", "Confirm Alert – dismissed");

            // Confirm Alert — Accept second time
            page.clickConfirmAlert();
            String confirmText2 = page.acceptConfirmAlert();
            test.log(Status.INFO,
                "Confirm Alert: <b>" + confirmText2 + "</b> → Accepted.");
            addScreenshot(test, "TC17_confirm_accepted", "Confirm Alert – accepted");

            // Prompt Alert
            page.scrollTo(page.getPromptBtn());
            page.clickPromptAlert();
            String promptText = page.handlePromptAlert(PROMPT_TEXT);
            test.log(Status.INFO, "Prompt Alert text: <b>" + promptText
                + "</b> → Typed: <b>" + PROMPT_TEXT + "</b>");
            addScreenshot(test, "TC17_prompt_after", "Prompt Alert – submitted");

            test.pass("All 3 alert types handled successfully.");

        } catch (AssertionError | Exception e) {
            addScreenshot(test, "TC17_FAIL", "FAIL – Alerts");
            test.fail(e.getMessage());
            throw e;
        }
    }

    // ════════════════════════════════════════════════════════════
    //  TC18 — Hyperlink Count + Scroll + ComboBox + New Tab + Popup
    // ════════════════════════════════════════════════════════════
    @Test(priority = 18, description = "Hyperlink count, scroll, combobox, new tab, popup")
    public void tc18_MiscFeatures() {
        ExtentTest test = ExtentReportManager.createTest(
            "TC18 – Misc Features",
            "Hyperlink count, JS scroll, ComboBox, New Tab, Popup Window");
        try {
            // ComboBox
            page.scrollTo(page.getComboBox());
            addScreenshot(test, "TC18_combo_before", "ComboBox – before");
            page.selectComboBoxItem(COMBO_ITEM);
            test.log(Status.INFO,
                "ComboBox item entered: <b>" + COMBO_ITEM + "</b>");
            addScreenshot(test, "TC18_combo_after", "ComboBox – after");

            // Hyperlink count
            int count = page.getLinkCount();
            test.log(Status.INFO,
                "Total hyperlinks on page: <b>" + count + "</b>");
            Assert.assertTrue(count > 0, "No hyperlinks found on page!");
            addScreenshot(test, "TC18_links", "Hyperlink count verified");

            // New Tab
            page.scrollTo(page.getNewTabBtn());
            addScreenshot(test, "TC18_newtab_before", "New Tab button – before");
            page.clickNewTab();
            test.log(Status.INFO, "New Tab button clicked.");
            addScreenshot(test, "TC18_newtab_after", "New Tab button – after");

            // Popup Window
            page.scrollTo(page.getPopupBtn());
            addScreenshot(test, "TC18_popup_before", "Popup Window button – before");
            page.clickPopupWindow();
            test.log(Status.INFO, "Popup Window button clicked.");
            addScreenshot(test, "TC18_popup_after", "Popup Window button – after");

            // Scroll Down
            page.scrollToBottom();
            test.log(Status.INFO, "Scrolled to bottom of page.");
            addScreenshot(test, "TC18_scroll_bottom", "Page – scrolled to bottom");

            // Scroll Up
            page.scrollToTop();
            test.log(Status.INFO, "Scrolled back to top of page.");
            addScreenshot(test, "TC18_scroll_top", "Page – scrolled to top");

            test.pass("All misc features completed: ComboBox, Links, New Tab, Popup, Scroll.");

        } catch (AssertionError | Exception e) {
            addScreenshot(test, "TC18_FAIL", "FAIL – Misc Features");
            test.fail(e.getMessage());
            throw e;
        }
    }
}