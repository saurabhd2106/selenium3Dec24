package testcases;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import commonLibs.CommonDriver;
import pages.AmazonPage;
import pages.Loginpage;
import utils.ConfigfileUtils;
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

        String reportFilename = String.format("%s/reports/report.html", currentWorkingDirectory);

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
    public void cleanup() throws Exception {

        cmnDriver.closeAllBrowsers();

    }

    @AfterClass
    public void postClean(){
        reportUtils.flushReport();
    }

}
