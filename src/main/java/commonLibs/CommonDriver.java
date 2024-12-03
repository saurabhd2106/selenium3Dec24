package commonLibs;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriverService;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.service.DriverService;


public class CommonDriver {

    private WebDriver driver;
    private int elementDetectionTimeout;
    private int pageloadTimeout;

    public void setElementDetectionTimeout(int timeout) {
        elementDetectionTimeout = timeout;

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));
    }

    public void setPageloadTimeout(int timeout){

        pageloadTimeout = timeout;

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageloadTimeout));
    }

    public WebDriver getDriver(){
        return driver;
    }

    public CommonDriver(String browserType) throws Exception{

        elementDetectionTimeout = 5;
        pageloadTimeout = 90;


        browserType = browserType.trim();

        if(browserType.equalsIgnoreCase("chrome")){

            driver = new ChromeDriver();

        } else if(browserType.equalsIgnoreCase("firefox")){

          
            
            FirefoxOptions options = new FirefoxOptions();
          
            options.setBinary("/snap/bin/geckodriver");
            
            driver = new FirefoxDriver(options);

        } else if (browserType.equalsIgnoreCase("edge")) {

            driver = new EdgeDriver();

        } else {

            System.out.println("No browser selected, so setting the default browser as chrome");
            driver = new ChromeDriver();
        }

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(elementDetectionTimeout));

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageloadTimeout));

    }

    public void navigateToUrl(String url) throws Exception{

        url = url.trim();

        driver.get(url);
    }

    public void closeBrowser() throws Exception {

        driver.close();
    }

    public void closeAllBrowsers() throws Exception {

        driver.quit();
    }
    
}
