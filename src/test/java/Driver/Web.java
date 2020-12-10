package Driver;

import Report.ReportFactory;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Web extends ReportFactory {

    private static WebDriver driver = null;
    private String USERNAME = "Serdar_Tests";
    private String ACCESS_KEY = "450047b9-e5c0-4df9-9157-31f8af15a049";
    private String SAUCE_URL = "https://"+USERNAME+":"+ACCESS_KEY+"@ondemand.us-west-1.saucelabs.com:443/wd/hub";

    @Parameters({"url", "browser"})
    @BeforeMethod
    public void initDriver(String appUrl, String clientName) {
        System.out.println("Client Name: " + clientName);
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
                DesiredCapabilities caps = DesiredCapabilities.chrome();
                caps.setCapability("platform", "Windows 10");
                caps.setCapability("version", "latest");
                try {
                    driver = new RemoteWebDriver(new URL(SAUCE_URL), caps);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                break;
            default:
                new Exception("Invalid client name: " + clientName);
        }
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
