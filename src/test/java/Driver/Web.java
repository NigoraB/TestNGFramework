package Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class Web {

    private static WebDriver driver = null;

    @BeforeMethod
    public void initDriver() {
        System.setProperty("webdriver.chrome.driver", "./driverExecFiles/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://clubs3qa1.scholastic.com/home");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void quitDriver() {
        driver.quit();
    }

    public static WebDriver getDriver() {
        return driver;
    }





}
