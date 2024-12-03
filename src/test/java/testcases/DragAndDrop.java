package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class DragAndDrop {

    @Test
    public void verifyDragAndDrop() {

        ChromeDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        driver.get("https://jqueryui.com/droppable/");

        WebElement frame = driver.findElement(By.className("demo-frame"));

        driver.switchTo().frame(frame);

        WebElement source = driver.findElement(By.id("draggable"));

        WebElement target = driver.findElement(By.id("droppable"));

        Actions mouseAction = new Actions(driver);

        mouseAction.dragAndDrop(source, target).build().perform();

      

    }

}
