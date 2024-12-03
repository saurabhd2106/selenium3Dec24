package testcases;

import org.testng.annotations.Test;

public class AddArticleTest extends BaseTest{

    @Test(enabled = false)
    public void verifyAddArticle() throws Exception{

        cmnDriver.navigateToUrl("http://localhost:3000");
        
        // 2. Login to the application

        String useremail = "test@abc.com";
        String password = "testpassword";

        loginpage.loginToApplication(useremail, password);

        // 3. Click on Add article

        // 4. Write steps to add the article

        // 5. Verify the add article is succesful

        // 6. Close Browser

    }
    
}
