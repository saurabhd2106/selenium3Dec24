package testcases;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Amazontest extends BaseTest {

    @Test
    public void verifySearchProduct() throws Exception{

        reportUtils.createTestcase("TC#012310 - Search product feature in Amazon");

        reportUtils.addLogs("info", "Navigate to URL - " + configProperty.getProperty("amazonUrl"));
        cmnDriver.navigateToUrl(configProperty.getProperty("amazonUrl"));

        reportUtils.addLogs("info", "Searching Products");
        amazonpage.searchProduct("Apple Watch", "Electronics");
       
        int numberOfProducts = amazonpage.getProductSize();
       
        Assert.assertTrue(numberOfProducts >= 16);

        // Get the first product

        String productDetails = amazonpage.getFirstProductDetails();

        Assert.assertTrue(productDetails.toLowerCase().contains("apple watch"));

        // Get me the 7th product

        String nthProductDetails = amazonpage.getProductDetailsByIndex(6);

     //   Assert.assertTrue(nthProductDetails.toLowerCase().contains("apple"));

        // Get all products

        List<String> allProductDetails = amazonpage.allProductDetails();

        for(String productDetail : allProductDetails){
            Assert.assertTrue(productDetail.toLowerCase().contains("apple"));;
        }


    }

}
