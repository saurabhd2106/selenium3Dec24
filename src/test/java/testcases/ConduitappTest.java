package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import commonLibs.CommonDriver;

public class ConduitappTest {

  @Test
  public void verifyTitle(){

    ChromeDriver driver = new ChromeDriver();

    driver.manage().window().maximize();

    driver.get("http://localhost:3000");

    String actualTitle = driver.getTitle();


    System.out.println("Title of the page - " + actualTitle);

    Assert.assertEquals(actualTitle, "Conduit");

    driver.close();


  }

  @Test
  public void loginToApplication() throws Exception{

    String useremail = "test@abc.com";

    String password = "testpassword";

    CommonDriver cmnDriver = new CommonDriver("chrome");

    cmnDriver.setElementDetectionTimeout(10);

    WebDriver driver = cmnDriver.getDriver();


    driver.get("http://localhost:3000");

    driver.findElement(By.linkText("Sign in")).click();

    

    driver.findElement(By.xpath("//input[@type='email']")).sendKeys(useremail);

    driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);

    driver.findElement(By.xpath("//button[@type='submit']")).click();


   String actualUsername = driver.findElement(By.xpath("//a[contains(@href, 'profile')]")).getText();

   Assert.assertEquals(actualUsername, "saurabh");

    //This only closes current active window
    //  driver.close();

    //This closes the whole connection
    driver.quit();


  }
    
}
