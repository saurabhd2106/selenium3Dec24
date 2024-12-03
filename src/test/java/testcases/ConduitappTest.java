package testcases;

import org.openqa.selenium.By;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ConduitappTest extends BaseTest {

  @Test
  public void verifyTitle() throws Exception {

    cmnDriver.navigateToUrl("http://localhost:3000");

    String actualTitle = cmnDriver.getTitle();

    System.out.println("Title of the page - " + actualTitle);

    Assert.assertEquals(actualTitle, "Conduit");

  }

  @Test
  public void loginToApplication() throws Exception {

    String useremail = "test@abc.com";

    String password = "testpassword";

    cmnDriver.navigateToUrl("http://localhost:3000");

    driver.findElement(By.linkText("Sign in")).click();

    driver.findElement(By.xpath("//input[@type='email']")).sendKeys(useremail);

    driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);

    driver.findElement(By.xpath("//button[@type='submit']")).click();

    String actualUsername = driver.findElement(By.xpath("//a[contains(@href, 'profile')]")).getText();

    Assert.assertEquals(actualUsername, "saurabh");

  }

}
