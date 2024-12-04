package testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Amazontest extends BaseTest {

    @Test
    public void verifySearchProduct() throws Exception{

    
        cmnDriver.navigateToUrl("https://amazon.in");

        amazonpage.searchProduct("Apple Watch", "Electronics");
       
        int numberOfProducts = amazonpage.getProductSize();
       
        Assert.assertTrue(numberOfProducts >= 16);

        // Get the first product

        String productDetails = amazonpage.getFirstProductDetails();

        Assert.assertTrue(productDetails.toLowerCase().contains("apple watch"));

        // Get me the 7th product

        String nthProductDetails = amazonpage.getProductDetailsByIndex(6);

        Assert.assertTrue(nthProductDetails.toLowerCase().contains("apple watch"));

        // Get all products

        List<String> allProductDetails = amazonpage.allProductDetails();

        for(String productDetail : allProductDetails){
            Assert.assertTrue(productDetail.toLowerCase().contains("apple"));;
        }


    }

}
