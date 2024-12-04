package testcases;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import commonLibs.CommonDriver;
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

    @BeforeClass
    public void preSetup() throws Exception{

        currentWorkingDirectory = System.getProperty("user.dir");

        String configFilePath = String.format("%s/config/config.properties", currentWorkingDirectory);


        configProperty = ConfigfileUtils.readConfig(configFilePath);

        String executionStartTime = DateTimeUtils.getCurrentDateAndTime();

        String reportFilename = String.format("%s/reports/report-%s.html", currentWorkingDirectory, executionStartTime);

        reportUtils = new ReportUtils(reportFilename);
    }

    @BeforeMethod
    public void setup() throws Exception {

        cmnDriver = new CommonDriver(configProperty.getProperty("browserType"));

        cmnDriver.setElementDetectionTimeout(10);

        cmnDriver.setPageloadTimeout(120);

        driver = cmnDriver.getDriver();

        loginpage = new Loginpage(driver);
        amazonpage = new AmazonPage(driver);


    }

    @AfterMethod
    public void cleanup(ITestResult result) throws Exception {

        if(result.getStatus() == ITestResult.SUCCESS){
            reportUtils.addLogs("Info", "All test steps executed successfully!");
        } else if(result.getStatus() == ITestResult.FAILURE){

            reportUtils.addLogs("fail", "One or more step failed");

            reportUtils.addLogs("fail", result.getThrowable().toString());

        }

        cmnDriver.closeAllBrowsers();

    }

    @AfterClass
    public void postClean(){
        reportUtils.flushReport();
    }

}
