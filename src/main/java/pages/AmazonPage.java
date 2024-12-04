package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonPage extends Basepage{

    @FindBy(id = "searchDropdownBox")
    private WebElement searchDropdown;

    @FindBy(id = "twotabsearchtextbox")
    private WebElement searchBox;

    @FindBy(id = "nav-search-submit-button")
    private WebElement searchButton;

    @FindBy(xpath = "//div[@data-component-type=\"s-search-result\"]")
    private List<WebElement> allProducts;

    public AmazonPage(WebDriver driver){

        PageFactory.initElements(driver, this);

    }

    public void searchProduct(String productName, String productCategory){

        control.selectValueFromDropdown(searchDropdown, productCategory);

        control.writeText(searchBox, productName);

        control.click(searchButton);


    }

    public int getProductSize(){

        return allProducts.size();

    }

    public String getFirstProductDetails(){
        return allProducts.get(0).getText();
    }

    public String getProductDetailsByIndex(int index){

        return allProducts.get(index).getText();
    }

    public List<String> allProductDetails(){

        List<String> allProductDetails = new ArrayList<>();

        for(WebElement element: allProducts){
           allProductDetails.add(element.getText());
        }



        return allProductDetails;

    }

}
