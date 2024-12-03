package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class multipleTab {

    @Test
    public void multipleTabHandling() {

        ChromeDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        driver.get("https://playwright.dev/");

        // 1. Get the window handle of the primary tab

        String primaryWindowHandle = driver.getWindowHandle();

        driver.findElement(By.xpath("//img[@alt='VS Code']//parent::a")).click();

        // 2. Get the window handle of the secondary tab

        String secWindowHandle = driver.getWindowHandles().toArray()[1].toString();

        // 3. Switch to the secondary tab

        driver.switchTo().window(secWindowHandle);

        // 4. Verify

        Assert.assertEquals(driver.getTitle(), "Visual Studio Code - Code Editing. Redefined");

        // 5. Switch back to the primary tab

        driver.close();

        driver.switchTo().window(primaryWindowHandle);

    }

}
