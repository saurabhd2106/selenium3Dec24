package testcases;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import commonLibs.CommonDriver;
import commonLibs.ScreenshotControl;
import pages.AmazonPage;
import pages.Loginpage;
import utils.ConfigfileUtils;
import utils.DateTimeUtils;
import utils.ReportUtils;

public class BaseTest {

    CommonDriver cmnDriver;

    WebDriver driver;

    Loginpage loginpage;
    AmazonPage amazonpage;

    Properties configProperty;

    String currentWorkingDirectory;

    ReportUtils reportUtils;

    ScreenshotControl screenshotControl;

    @BeforeClass
    public void preSetup() throws Exception {

        initialiseCurrentWorkingDirectory();

        initialiseConfigProperties();

        initialiseReporting();

    }

   

    @BeforeMethod
    public void setup() throws Exception {

        cmnDriver = new CommonDriver(configProperty.getProperty("browserType"));

        cmnDriver.setElementDetectionTimeout(10);

        cmnDriver.setPageloadTimeout(120);

        driver = cmnDriver.getDriver();

        loginpage = new Loginpage(driver);
        amazonpage = new AmazonPage(driver);
        screenshotControl = new ScreenshotControl(driver);

    }

    @AfterMethod
    public void cleanup(ITestResult result) throws Exception {

        if (result.getStatus() == ITestResult.SUCCESS) {
            reportUtils.addLogs("Info", "All test steps executed successfully!");
        } else if (result.getStatus() == ITestResult.FAILURE) {

            reportUtils.addLogs("fail", "One or more step failed");

            reportUtils.addLogs("fail", result.getThrowable().toString());

            String testcasename = result.getName();

            String currentTime = DateTimeUtils.getCurrentDateAndTime();

            String screenshotFilename = String.format("%s/screenshots/%s-%s.jpeg", currentWorkingDirectory,
                    testcasename, currentTime);

            screenshotControl.captureAndSaveScreenshot(screenshotFilename);

            reportUtils.addScreenshotToReport(screenshotFilename);

        } else if (result.getStatus() == ITestResult.SKIP) {
            reportUtils.addLogs("skip", "One ore more steps got skipped");
        }

        cmnDriver.closeAllBrowsers();

    }

    @AfterClass
    public void postClean() {
        reportUtils.flushReport();
    }

    private void initialiseReporting() throws Exception {

        String executionStartTime = DateTimeUtils.getCurrentDateAndTime();

        String reportFilename = String.format("%s/reports/report-%s.html", currentWorkingDirectory, executionStartTime);

        reportUtils = new ReportUtils(reportFilename);
    }

    private void initialiseConfigProperties() throws Exception {
        String configFilePath = String.format("%s/config/config.properties", currentWorkingDirectory);

        configProperty = ConfigfileUtils.readConfig(configFilePath);

    }

    private void initialiseCurrentWorkingDirectory() {
        currentWorkingDirectory = System.getProperty("user.dir");
    }

}
