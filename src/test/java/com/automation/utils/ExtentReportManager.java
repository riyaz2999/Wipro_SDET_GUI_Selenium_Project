package com.automation.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * ExtentReportManager
 * Singleton that manages the single ExtentReports instance
 * for the entire test run.
 *
 * Flow:
 *   1. BaseTest @BeforeSuite  → ExtentReportManager.init()
 *   2. Each @Test             → ExtentReportManager.createTest("TC01")
 *   3. BaseTest @AfterSuite   → ExtentReportManager.flush()
 *
 * Report saved to: test-output/ExtentReport.html
 */
public class ExtentReportManager {

    private static ExtentReports extent;

    // ThreadLocal so each test has its own ExtentTest node
    private static final ThreadLocal<ExtentTest> testNode = new ThreadLocal<>();

    private static final String REPORT_PATH = "test-output/ExtentReport.html";

    /** Call once before suite starts — sets up the HTML report */
    public static void init() {
        ExtentSparkReporter spark = new ExtentSparkReporter(REPORT_PATH);
        spark.config().setTheme(Theme.DARK);
        spark.config().setDocumentTitle("GUI Automation Report");
        spark.config().setReportName("testautomationpractice.blogspot.com");
        spark.config().setTimeStampFormat("dd-MMM-yyyy HH:mm:ss");

        extent = new ExtentReports();
        extent.attachReporter(spark);
        extent.setSystemInfo("Application", "testautomationpractice.blogspot.com");
        extent.setSystemInfo("Browser",     "Google Chrome");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("Tester",      "Riyaz Shaik");
    }

    /** Creates a new test node in the report for each @Test */
    public static ExtentTest createTest(String testName, String description) {
        ExtentTest test = extent.createTest(testName, description);
        testNode.set(test);
        return test;
    }

    /** Returns the current thread's ExtentTest node */
    public static ExtentTest getTest() {
        return testNode.get();
    }

    /** Writes the report file to disk — call once after all tests finish */
    public static void flush() {
        if (extent != null) {
            extent.flush();
            System.out.println("[Report] Extent HTML report saved → " + REPORT_PATH);
        }
    }
}