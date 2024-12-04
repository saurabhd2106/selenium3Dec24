package utils;

import org.testng.annotations.DataProvider;

import commonLibs.ExcelReader;

public class DataProviders {

    @DataProvider
    public String[][] searchProductData() {

        String[][] data = new String[3][2];

        data[0][0] = "Apple Watch";
        data[0][1] = "Electronics";

        data[1][0] = "Apple Watch";
        data[1][1] = "Watches";

        data[2][0] = "Apple Watch";
        data[2][1] = "Deals";

        return data;

    }

    @DataProvider
    public String[][] searchProductDataFromExcel() throws Exception{


        // 1. Open the workbook

        ExcelReader reader = new ExcelReader();

        String currentWorkingDirectory = System.getProperty("user.dir");

        String filename = String.format("%s/testdata/etestdata.xlsx", currentWorkingDirectory);

        reader.openWorkbook(filename);

        // 2. Get the sheet

        String sheetname = "TestData";

        // 3. Get the row count

        int rowCount = reader.getRowCount(sheetname);

        // 4. Get the cell count

        int cellCount = reader.getCellCountFromRow(sheetname, 0);

        // 5. Get the data

        String[][] data = new String[rowCount + 1][cellCount];

        for(int row=0; row <= rowCount; row++) {
            for(int cell=0; cell< cellCount; cell++ ) {
                
                data[row][cell] = reader.getCellData(sheetname, row, cell);
                
            }
        }



        return data;

    }


}
