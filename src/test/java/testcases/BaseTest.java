package testcases;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import commonLibs.CommonDriver;
import pages.AmazonPage;
import pages.Loginpage;

public class BaseTest {

    CommonDriver cmnDriver;

    WebDriver driver;

    Loginpage loginpage;
    AmazonPage amazonpage;

    Properties configProperty;

    @BeforeMethod
    public void setup() throws Exception {

        cmnDriver = new CommonDriver("chrome");

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

}
