package pages;

import org.openqa.selenium.*;

public class LargeAndDeepDomPage {
    private WebDriver driver;
    private By table = By.id("large-table");

    public LargeAndDeepDomPage(WebDriver driver){
        this.driver = driver;
    }
    public void scrollToTable(){
        WebElement tableElement = driver.findElement(table);
        //execute JS
        String script = "arguments[0].scrollIntoView(true);";
        ((JavascriptExecutor)driver).executeScript(script, tableElement);
    }


}
