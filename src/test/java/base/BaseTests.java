package base;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import utils.WindowManager;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BaseTests {
    private WebDriver driver;
    protected HomePage homePage;

    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize(); //can be fullscreen() or setSize();
    }

    @BeforeMethod
    public void resetAppState() {
        driver.get("https://the-internet.herokuapp.com/");
        homePage = new HomePage(driver);
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    @AfterMethod
    public void recordFailure(ITestResult result){
        if(ITestResult.FAILURE == result.getStatus()){
            //cast drive into new class
            var camera = (TakesScreenshot) driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try {
                Files.move(screenshot, new File("src/main/resources/screenshots/" + result.getName() + ".png"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Screenshot taken: " + screenshot.getAbsolutePath());
        }
        else {
            System.out.println("Test has passed, screenshot not needed.");
        }

    }

    public WindowManager getWindowManager(){
        return new WindowManager(driver);
    }

}
