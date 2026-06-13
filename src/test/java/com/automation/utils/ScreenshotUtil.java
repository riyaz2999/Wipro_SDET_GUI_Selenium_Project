package com.automation.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ScreenshotUtil
 * Central utility for capturing browser screenshots.
 *
 * Usage from any test:
 *   String path = ScreenshotUtil.capture(driver, "TC01_NameField");
 *
 * Screenshots saved to: screenshots/<stepName>_<timestamp>.png
 * Returned path is embedded into ExtentReport.
 */
public class ScreenshotUtil {

    private static final String SCREENSHOT_DIR = "screenshots";
    private static final SimpleDateFormat SDF =
            new SimpleDateFormat("yyyyMMdd_HHmmss_SSS");

    /**
     * Captures full-page screenshot and saves as PNG.
     *
     * @param driver   active WebDriver instance
     * @param stepName label used in the filename
     * @return absolute path of saved PNG, or empty string if failed
     */
    public static String capture(WebDriver driver, String stepName) {

        String safeName  = stepName.replaceAll("[^a-zA-Z0-9_\\-]", "_");
        String timestamp = SDF.format(new Date());
        String fileName  = safeName + "_" + timestamp + ".png";

        File dir = new File(SCREENSHOT_DIR);
        if (!dir.exists()) dir.mkdirs();

        File destFile = new File(dir, fileName);

        try {
            TakesScreenshot ts  = (TakesScreenshot) driver;
            File            src = ts.getScreenshotAs(OutputType.FILE);
            Files.copy(src.toPath(), destFile.toPath(),
                       StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Screenshot saved → " + destFile.getAbsolutePath());
            return destFile.getAbsolutePath();

        } catch (IOException e) {
            System.err.println("Screenshot failed for step '" + stepName
                               + "': " + e.getMessage());
            return "";
        }
    }

    /**
     * Scrolls element into view then captures screenshot.
     * Use when you want the element visible in the shot.
     */
    public static String captureElement(WebDriver driver,
                                        WebElement element,
                                        String stepName) {
        try {
            ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center'});", element);
            Thread.sleep(300);
        } catch (Exception ignored) {}
        return capture(driver, stepName);
    }
}