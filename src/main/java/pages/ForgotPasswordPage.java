package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {
    private WebDriver driver;
    private By pageTitle = By.cssSelector("#content h2");
    private By emailField = By.id("email");
    private By retrivePasswordButton = By.id("form_submit");

    public ForgotPasswordPage(WebDriver driver){
        this.driver = driver;
    }
    public void enterEmail(String email){
        driver.findElement(emailField).sendKeys(email);
    }
    public EmailSentPage clickRetrivePaaword(){
        driver.findElement(retrivePasswordButton).click();
        return new EmailSentPage(driver);
    }
    public EmailSentPage retrivePassword(String email){
        enterEmail(email);
        return clickRetrivePaaword();
    }
    public String getForgotPasswordTitle(){
        return driver.findElement(pageTitle).getText();
    }
}
