package testcases;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertHandling {

    @Test
    public void AlertHandlongExample() {

        ChromeDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();

        Alert alert = driver.switchTo().alert();

        String alertMessage = alert.getText();

        try {

            Thread.sleep(3000);

        } catch (Exception e) {
            // TODO: handle exception

            e.printStackTrace();
        }

        alert.accept();

        Assert.assertEquals(alertMessage, "I am a JS Alert");

    }

}
