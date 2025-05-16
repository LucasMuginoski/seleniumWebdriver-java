package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JSAlertsPage {
    private WebDriver driver;
    private By pageTitle = By.cssSelector(".example h3");
    private By tiggerAlertButton = By.xpath("//button[text()='Click for JS Alert']");
    private By triggerConfirmButton = By.xpath("//button[text()='Click for JS Confirm']");
    private By triggerPromptButton = By.xpath("//button[text()='Click for JS Prompt']");
    private By results = By.id("result");

    public JSAlertsPage(WebDriver driver){
        this.driver = driver;
    }
    public String getPageTitle(){
        return driver.findElement(pageTitle).getText();
    }
    public void triggerAlert(){
        driver.findElement(tiggerAlertButton).click();
    }
    public void alert_clickToAccept(){
        driver.switchTo().alert().accept();
    }
    public String getResult(){
        return driver.findElement(results).getText();
    }
    public void triggerConfirm(){
        driver.findElement(triggerConfirmButton).click();
    }
    public String alert_getText(){
        return driver.switchTo().alert().getText();
    }

    public void alert_clickToDismiss(){
        driver.switchTo().alert().dismiss();
    }

    public void triggerPrompt(){
        driver.findElement(triggerPromptButton).click();
    }
    public void alert_setInput(String text){
        driver.switchTo().alert().sendKeys(text);
    }


}
