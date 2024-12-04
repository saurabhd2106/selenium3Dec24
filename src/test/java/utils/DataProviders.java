package utils;

import org.testng.annotations.DataProvider;

public class DataProviders {


    @DataProvider
    public String[][] searchProductData(){

        String[][] data = new String[3][2];


        data[0][0] = "Apple Watch";
        data[0][1] = "Electronics";

        data[1][0] = "Apple Watch";
        data[1][1] = "Watches";

        data[2][0] = "Apple Watch";
        data[2][1] = "Deals";

      
        return data;


    }
    
}
