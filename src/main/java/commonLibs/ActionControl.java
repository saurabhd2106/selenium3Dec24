package commonLibs;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ActionControl {

    public void click(WebElement element){

        element.click();
    }


    public void clear(WebElement element){

        element.clear();
    }

    public void writeText(WebElement element, String text){
        element.sendKeys(text);
    }
    
    public void selectValueFromDropdown(WebElement element, String visibleText){

        Select dropdown = new Select(element);

        dropdown.selectByVisibleText(visibleText);

    }
}
