package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import commonLibs.CommonDriver;

public class BaseTest {

    CommonDriver cmnDriver;

    WebDriver driver;


    @BeforeMethod
    public void setup() throws Exception {

    cmnDriver = new CommonDriver("chrome");

    cmnDriver.setElementDetectionTimeout(10);

    cmnDriver.setPageloadTimeout(120);

    driver = cmnDriver.getDriver();
    }

    @AfterMethod
    public void cleanup() throws Exception{

        cmnDriver.closeAllBrowsers();

    }
    
}
