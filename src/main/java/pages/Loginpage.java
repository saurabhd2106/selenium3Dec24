package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Loginpage extends Basepage{

    @FindBy(linkText = "Sign in")
    private WebElement siginLink;

    @FindBy(xpath = "//input[@type='email']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@type='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement signinButton;

    @FindBy(xpath = "//a[contains(@href, 'profile')]")
    private WebElement userProfile;

    public Loginpage(WebDriver driver){

        PageFactory.initElements(driver, this);


    }

    public void loginToApplication(String username, String password){

        control.click(siginLink);

        control.writeText(emailField, username);

        control.writeText(passwordField, password);

        control.click(signinButton);
        

    }

    public String getUserprofileName(){

        return userProfile.getText();
         

    }
    
}
