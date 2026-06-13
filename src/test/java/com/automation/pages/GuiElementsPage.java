package com.automation.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * GuiElementsPage — Page Object Model
 * ══════════════════════════════════════════════════════════════
 * All locators verified against YOUR working capstone code on:
 *   https://testautomationpractice.blogspot.com/
 *
 * Every method scrolls the element into view before acting,
 * so tests are stable regardless of page scroll position.
 * ══════════════════════════════════════════════════════════════
 */
public class GuiElementsPage {

    private final WebDriver        driver;
    private final WebDriverWait    wait;
    private final Actions          actions;
    private final JavascriptExecutor js;

    public GuiElementsPage(WebDriver driver, WebDriverWait wait) {
        this.driver  = driver;
        this.wait    = wait;
        this.actions = new Actions(driver);
        this.js      = (JavascriptExecutor) driver;
    }

    // ─── Internal helpers ────────────────────────────────────────

    /** Scrolls element to centre of viewport */
    public void scrollTo(WebElement el) {
        js.executeScript(
            "arguments[0].scrollIntoView({block:'center',inline:'nearest'});", el);
        sleep(300);
    }

    /** Scrolls page by pixel offset */
    public void scrollBy(int px) {
        js.executeScript("window.scrollBy(0," + px + ");");
        sleep(300);
    }

    /** Scrolls to top of page */
    public void scrollToTop() {
        js.executeScript("window.scrollTo(0,0);");
        sleep(300);
    }

    /** Scrolls to bottom of page */
    public void scrollToBottom() {
        js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
        sleep(300);
    }

    public void sleep(long ms) {
        try { Thread.sleep(ms); } catch (InterruptedException ignored) {}
    }

    // ════════════════════════════════════════════════════════════
    //  PAGE TITLE
    // ════════════════════════════════════════════════════════════

    public String getPageTitle() {
        return driver.getTitle();
    }

    // ════════════════════════════════════════════════════════════
    //  1.  TEXT FIELDS
    // ════════════════════════════════════════════════════════════

    public void enterName(String value) {
        WebElement el = driver.findElement(
                By.xpath("//input[@placeholder='Enter Name']"));
        scrollTo(el);
        el.clear();
        el.sendKeys(value);
    }

    public void enterEmail(String value) {
        WebElement el = driver.findElement(By.id("email"));
        scrollTo(el);
        el.clear();
        el.sendKeys(value);
    }

    public void enterPhone(String value) {
        WebElement el = driver.findElement(By.id("phone"));
        scrollTo(el);
        el.clear();
        el.sendKeys(value);
    }

    public void enterAddress(String value) {
        WebElement el = driver.findElement(By.id("textarea"));
        scrollTo(el);
        el.clear();
        el.sendKeys(value);
    }

    // ════════════════════════════════════════════════════════════
    //  2.  RADIO BUTTON
    // ════════════════════════════════════════════════════════════

    public void selectGender(String genderId) {
        // genderId = "male" or "female"
        WebElement radio = driver.findElement(By.id(genderId));
        scrollTo(radio);
        if (!radio.isSelected()) radio.click();
    }

    // ════════════════════════════════════════════════════════════
    //  3.  CHECKBOX
    // ════════════════════════════════════════════════════════════

    public void checkDay(String dayId) {
        // dayId = "sunday", "monday", etc.
        WebElement cb = driver.findElement(By.id(dayId));
        scrollTo(cb);
        if (!cb.isSelected()) cb.click();
    }

    // ════════════════════════════════════════════════════════════
    //  4.  DROPDOWNS
    // ════════════════════════════════════════════════════════════

    public void selectCountry(String country) {
        WebElement el = driver.findElement(
                By.xpath("//select[contains(@id,'country')]"));
        scrollTo(el);
        new Select(el).selectByVisibleText(country);
    }

    public void selectColor(String color) {
        WebElement el = driver.findElement(
                By.xpath("//select[contains(@id,'colors')]"));
        scrollTo(el);
        new Select(el).selectByVisibleText(color);
    }

    public void selectAnimal(String animal) {
        WebElement el = driver.findElement(By.id("animals"));
        scrollTo(el);
        new Select(el).selectByVisibleText(animal);
    }

    // ════════════════════════════════════════════════════════════
    //  5.  DATE PICKERS
    // ════════════════════════════════════════════════════════════

    /** Date Picker 1 — standard jQuery datepicker (mm/dd/yyyy) */
    public void enterDatePicker1(String date) {
        WebElement el = driver.findElement(By.id("datepicker"));
        scrollTo(el);
        el.click();
        el.clear();
        el.sendKeys(date);
        el.sendKeys(Keys.ESCAPE);
        // Click label to close calendar popup
        driver.findElement(
            By.xpath("//label[contains(text(),'Date Picker 3')]")).click();
    }

    /** Date Picker 2 — read-only field, set via JavascriptExecutor */
    public void enterDatePicker2(String date) {
        WebElement el = driver.findElement(By.id("txtDate"));
        scrollTo(el);
        js.executeScript("arguments[0].value='" + date + "';", el);
    }

    /** Date Picker 3 — start and end date range */
    public void enterDateRange(String startDate, String endDate) {

        WebElement start = driver.findElement(By.id("start-date"));
        WebElement end   = driver.findElement(By.id("end-date"));

        JavascriptExecutor js = (JavascriptExecutor) driver;

        scrollTo(start);

        // Set start date using JS
        js.executeScript("arguments[0].value='';", start);
        js.executeScript("arguments[0].value=arguments[1];", start, startDate);

        // Set end date using JS
        js.executeScript("arguments[0].value='';", end);
        js.executeScript("arguments[0].value=arguments[1];", end, endDate);

        // Submit
        driver.findElement(By.xpath("//button[@class='submit-btn']")).click();

        System.out.println("[Page] Date range submitted.");
    }

    // ════════════════════════════════════════════════════════════
    //  6.  FILE UPLOAD
    // ════════════════════════════════════════════════════════════

    public void uploadSingleFile(String absolutePath) {
        WebElement el = driver.findElement(By.id("singleFileInput"));
        scrollTo(el);
        el.sendKeys(absolutePath);
        // Submit single file form
        driver.findElement(
            By.xpath("//form[@id='singleFileForm']/button")).click();
        System.out.println("[Page] Single file uploaded: " + absolutePath);
    }

    public void uploadMultipleFiles(String path1, String path2) {
        WebElement el = driver.findElement(By.id("multipleFilesInput"));
        scrollTo(el);
        el.sendKeys(path1 + "\n" + path2);
        // Submit multiple files form
        driver.findElement(
            By.xpath("//form[@id='multipleFilesForm']/button")).click();
        System.out.println("[Page] Multiple files uploaded.");
    }

    // ════════════════════════════════════════════════════════════
    //  7.  WIKIPEDIA SEARCH WIDGET
    // ════════════════════════════════════════════════════════════

    public void searchWikipedia(String searchTerm) {
        WebElement el = driver.findElement(
                By.id("Wikipedia1_wikipedia-search-input"));
        scrollTo(el);
        el.clear();
        el.sendKeys(searchTerm + Keys.ENTER);
    }

    // ════════════════════════════════════════════════════════════
    //  8.  DYNAMIC BUTTON (START / STOP)
    // ════════════════════════════════════════════════════════════

    public String clickDynamicButtonAndGetText() {
        // Find by class since name attribute changes after each click
        WebElement btn = driver.findElement(By.xpath("//button[@class='start']"));
        scrollTo(btn);
        String before = btn.getText();
        System.out.println("[Page] Dynamic Button current text: " + before);

        // First click: START → STOP
        btn.click();
        sleep(2000);
        btn = driver.findElement(By.xpath("//button[@class='stop']"));
        String afterFirst = btn.getText();
        System.out.println("[Page] Dynamic Button after 1st click: " + afterFirst);

        // Second click: STOP → START
        btn.click();
        sleep(2000);
        btn = driver.findElement(By.xpath("//button[@class='start']"));
        String afterSecond = btn.getText();
        System.out.println("[Page] Dynamic Button after 2nd click: " + afterSecond);

        return afterFirst; // returns "STOP" — TC12 asserts this equals "STOP"
    }

    public String getDynamicButtonText() {
        return driver.findElement(
                By.xpath("//button[@name='start']")).getText();
    }

    // ════════════════════════════════════════════════════════════
    //  9.  ACTIONS — MOUSE HOVER
    // ════════════════════════════════════════════════════════════

    public void mouseHover() {
        WebElement pointMe = driver.findElement(
                By.xpath("//button[text()='Point Me']"));
        scrollTo(pointMe);
        actions.moveToElement(pointMe).perform();
        sleep(600);
    }

    // ════════════════════════════════════════════════════════════
    //  10.  ACTIONS — DOUBLE CLICK
    // ════════════════════════════════════════════════════════════

    public void setField1(String text) {
        WebElement field1 = driver.findElement(By.id("field1"));
        scrollTo(field1);
        field1.clear();
        field1.sendKeys(text);
    }

    public void doubleClickCopyButton() {
        WebElement copyBtn = driver.findElement(
                By.xpath("//button[text()='Copy Text']"));
        scrollTo(copyBtn);
        actions.doubleClick(copyBtn).perform();
        sleep(500);
    }

    public String getField1Value() {
        return driver.findElement(By.id("field1")).getAttribute("value");
    }

    public String getField2Value() {
        return driver.findElement(By.id("field2")).getAttribute("value");
    }

    // ════════════════════════════════════════════════════════════
    //  11.  ACTIONS — DRAG AND DROP
    // ════════════════════════════════════════════════════════════

    public void dragAndDrop() {
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));
        scrollTo(source);
        actions.dragAndDrop(source, target).perform();
        sleep(600);
    }

    public String getDropTargetText() {
        return driver.findElement(By.id("droppable")).getText().trim();
    }

    // ════════════════════════════════════════════════════════════
    //  12.  ACTIONS — SLIDER
    // ════════════════════════════════════════════════════════════

    public void moveSlider(int pixelOffset) {
        WebElement slider = driver.findElement(By.xpath(
            "//span[@class='ui-slider-handle ui-corner-all ui-state-default']"));
        scrollTo(slider);
        actions.dragAndDropBy(slider, pixelOffset, 0).perform();
        sleep(500);
    }

    // ════════════════════════════════════════════════════════════
    //  13.  SCROLLING COMBOBOX
    // ════════════════════════════════════════════════════════════

    public void selectComboBoxItem(String item) {
        WebElement combo = driver.findElement(By.id("comboBox"));
        scrollTo(combo);
        combo.click();
        combo.sendKeys(item);
        System.out.println("[Page] ComboBox item entered: " + item);
    }

    // ════════════════════════════════════════════════════════════
    //  14.  NEW TAB
    // ════════════════════════════════════════════════════════════

    public void clickNewTab() {
        WebElement btn = driver.findElement(
                By.xpath("//button[text()='New Tab']"));
        scrollTo(btn);
        btn.click();
    }

    // ════════════════════════════════════════════════════════════
    //  15.  POPUP WINDOW
    // ════════════════════════════════════════════════════════════

    public void clickPopupWindow() {
        WebElement btn = driver.findElement(
                By.xpath("//button[text()='Popup Windows']"));
        scrollTo(btn);
        btn.click();
    }

    // ════════════════════════════════════════════════════════════
    //  16.  ALERTS
    // ════════════════════════════════════════════════════════════

    public void clickSimpleAlert() {
        WebElement btn = driver.findElement(By.id("alertBtn"));
        scrollTo(btn);
        btn.click();
    }

    public String acceptSimpleAlert() {
        wait.until(ExpectedConditions.alertIsPresent());
        Alert a    = driver.switchTo().alert();
        String txt = a.getText();
        a.accept();
        return txt;
    }

    public void clickConfirmAlert() {
        WebElement btn = driver.findElement(By.id("confirmBtn"));
        scrollTo(btn);
        btn.click();
    }

    public String dismissConfirmAlert() {
        wait.until(ExpectedConditions.alertIsPresent());
        Alert a    = driver.switchTo().alert();
        String txt = a.getText();
        a.dismiss();
        return txt;
    }

    public String acceptConfirmAlert() {
        wait.until(ExpectedConditions.alertIsPresent());
        Alert a    = driver.switchTo().alert();
        String txt = a.getText();
        a.accept();
        return txt;
    }

    public void clickPromptAlert() {
        WebElement btn = driver.findElement(By.id("promptBtn"));
        scrollTo(btn);
        btn.click();
    }

    public String handlePromptAlert(String inputText) {
        wait.until(ExpectedConditions.alertIsPresent());
        Alert a    = driver.switchTo().alert();
        String txt = a.getText();
        a.sendKeys(inputText);
        a.accept();
        return txt;
    }

    // ════════════════════════════════════════════════════════════
    //  17.  HYPERLINK COUNT
    // ════════════════════════════════════════════════════════════

    public int getLinkCount() {
        List<WebElement> links = driver.findElements(By.tagName("a"));
        return links.size();
    }

    // ════════════════════════════════════════════════════════════
    //  GETTERS — expose elements for screenshot targeting in tests
    // ════════════════════════════════════════════════════════════

    public WebElement getNameField() {
        return driver.findElement(By.xpath("//input[@placeholder='Enter Name']"));
    }
    public WebElement getEmailField()    { return driver.findElement(By.id("email")); }
    public WebElement getPhoneField()    { return driver.findElement(By.id("phone")); }
    public WebElement getAddressField()  { return driver.findElement(By.id("textarea")); }
    public WebElement getGenderRadio()   { return driver.findElement(By.id("male")); }
    public WebElement getDayCheckbox()   { return driver.findElement(By.id("sunday")); }
    public WebElement getCountryDropdown() {
        return driver.findElement(By.xpath("//select[contains(@id,'country')]"));
    }
    public WebElement getColorsDropdown() {
        return driver.findElement(By.xpath("//select[contains(@id,'colors')]"));
    }
    public WebElement getAnimalsDropdown() { return driver.findElement(By.id("animals")); }
    public WebElement getDatePicker1()   { return driver.findElement(By.id("datepicker")); }
    public WebElement getDatePicker2()   { return driver.findElement(By.id("txtDate")); }
    public WebElement getStartDate()     { return driver.findElement(By.id("start-date")); }
    public WebElement getSingleUpload()  { return driver.findElement(By.id("singleFileInput")); }
    public WebElement getWikiSearch()    {
        return driver.findElement(By.id("Wikipedia1_wikipedia-search-input"));
    }
    public WebElement getDynamicButton() {
        return driver.findElement(By.xpath("//button[@name='start']"));
    }
    public WebElement getHoverButton()   {
        return driver.findElement(By.xpath("//button[text()='Point Me']"));
    }
    public WebElement getField1()        { return driver.findElement(By.id("field1")); }
    public WebElement getCopyButton()    {
        return driver.findElement(By.xpath("//button[text()='Copy Text']"));
    }
    public WebElement getDraggable()     { return driver.findElement(By.id("draggable")); }
    public WebElement getDroppable()     { return driver.findElement(By.id("droppable")); }
    public WebElement getSlider()        {
        return driver.findElement(By.xpath(
            "//span[@class='ui-slider-handle ui-corner-all ui-state-default']"));
    }
    public WebElement getAlertBtn()      { return driver.findElement(By.id("alertBtn")); }
    public WebElement getConfirmBtn()    { return driver.findElement(By.id("confirmBtn")); }
    public WebElement getPromptBtn()     { return driver.findElement(By.id("promptBtn")); }
    public WebElement getComboBox()      { return driver.findElement(By.id("comboBox")); }
    public WebElement getNewTabBtn()     {
        return driver.findElement(By.xpath("//button[text()='New Tab']"));
    }
    public WebElement getPopupBtn()      {
        return driver.findElement(By.xpath("//button[text()='Popup Windows']"));
    }
}