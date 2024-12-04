package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ConduitappTest extends BaseTest {

  @Test
  public void verifyTitle() throws Exception {

    cmnDriver.navigateToUrl(configProperty.getProperty("baseUrl"));

    String actualTitle = cmnDriver.getTitle();

    System.out.println("Title of the page - " + actualTitle);

    Assert.assertEquals(actualTitle, "Conduit");

  }

  @Test
  public void loginToApplication() throws Exception {

    String useremail = "test@abc.com";

    String password = "testpassword";

    cmnDriver.navigateToUrl("http://localhost:3000");

    loginpage.loginToApplication(useremail, password);

    String actualUsername = loginpage.getUserprofileName();

    Assert.assertEquals(actualUsername, "saurabh");

  }

}
