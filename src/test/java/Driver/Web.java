package Driver;

import Report.ReportFactory;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class Web extends ReportFactory {

    private static WebDriver driver = null;

    @Parameters({"url", "browser"})
    @BeforeMethod
    public void initDriver(String appUrl, String clientName) {
        switch (clientName.toLowerCase()) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "./driverExecFiles/chromedriver");
                driver = new ChromeDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "./driverExecFiles/geckodriver");
                driver = new FirefoxDriver();
                break;
            case "sauce":
                // code to implement
                break;
            default:
                new Exception("Invalid client name: " + clientName);
        }
        System.setProperty("webdriver.chrome.driver", "./driverExecFiles/chromedriver");
        driver = new ChromeDriver();
        driver.get(appUrl);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void quitDriver(ITestResult iTestResult) {
        if (iTestResult.getStatus() != 1) {
            attachScreenShot();
        }
        driver.quit();
    }

    public static WebDriver getDriver() {
        return driver;
    }

    @Attachment(value="webpage screenshot", type="image/png")
    public byte[] attachScreenShot() {
        return ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.BYTES);
    }





}
