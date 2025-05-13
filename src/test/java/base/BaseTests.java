package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;

import java.util.List;

public class BaseTest {
    private static WebDriver driver;
    protected HomePage homePage;

    public void setUp(WebDriver driver) {
        this.driver = driver;
        driver = new ChromeDriver();
        driver.manage().window().maximize(); //can be fullscreen() or setSize();

        driver.get("https://the-internet.herokuapp.com/");
        homePage = new HomePage(driver);

        driver.quit();
    }

    public static void main(String[] args) {
        BaseTest test = new BaseTest();
        test.setUp(driver);

    }
}
