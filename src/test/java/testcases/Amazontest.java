package testcases;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import utils.DataProviders;

public class Amazontest extends BaseTest {

    @Test(dataProvider = "searchProductData", dataProviderClass = DataProviders.class)
    public void verifySearchProduct(String productName, String category) throws Exception{

        reportUtils.createTestcase("TC#012310 - Search product feature in Amazon - " + productName + " " + category);

        reportUtils.addLogs("info", "Navigate to URL - " + configProperty.getProperty("amazonUrl"));
        cmnDriver.navigateToUrl(configProperty.getProperty("amazonUrl"));

        reportUtils.addLogs("info", "Searching Products");
        amazonpage.searchProduct(productName, category);
       
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
