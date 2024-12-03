package testcases;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Amazontest {

    @Test
    public void verifySearchProduct() {

        ChromeDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        driver.get("https://amazon.com");

        WebElement selectElement = driver.findElement(By.id("searchDropdownBox"));

        Select dropdown = new Select(selectElement);

        dropdown.selectByVisibleText("Electronics");

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Apple Watch");

        driver.findElement(By.id("nav-search-submit-button")).click();

        List<WebElement> allProducts = driver.findElements(By.xpath("//div[@data-component-type=\"s-search-result\"]"));

        int numberOfProducts = allProducts.size();


        System.out.println(allProducts.size());

        Assert.assertTrue(numberOfProducts >= 16);

        // Get the first product

        String productDetails = allProducts.get(0).getText();

        System.out.println(productDetails);

        // Get me the 7th product

        String nthProductDetails = allProducts.get(6).getText();

        System.out.println(nthProductDetails);

        // Get all products

        for( WebElement product : allProducts) {

            System.out.println(product.getText());

            System.out.println("----------------------------------------------");

        }



    }

}
