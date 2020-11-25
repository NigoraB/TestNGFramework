package ZDiscussion;

import Driver.Web;
import com.google.common.base.Function;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.internal.WebElementToJsonConverter;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Wait_Concept {
    @Test
    public void Waits() {
        System.setProperty("webdriver.chrome.driver", "./driverExecFiles/chromedriver");
        WebDriver driver = new ChromeDriver();

        /**
         * If script is not able to find the element, throws NoSuchElementException.
         * Wait doesn't allow to throw NoSuchElementException during the wait time.
         * OR
         * Wait ignores to throw NoSuchElementException during the wait time.
         *
         * Polling time/period:
         * after how many milliseconds/seconds,
         *      selenium will go back and try to check for the element.
         * Wait period: 3000ms
         * polling period: 500ms
         *
         * after every 500ms, selenium will try to find the element.
         *
         *
         */

        /**
         * Types of Wait:
         * 1. Implicit
         * 2. Explicit
         * 3. Fluent
         *
         * Implicit Wait: (like, changing the settings in the driver)
         * Wait for a certain amount of time before throwing NoSuchElementException
         *  and stop waiting as soon element is found.
         *
         *  Polling Period: 250ms
         */
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        /**
         * Explicit Wait:
         * Wait for a certain amount of time until the specified condition(s) is met.
         * As soon, the condition met, stop waiting and move ahead.
         *
         * Polling Period: 500ms
         */
        WebDriverWait eWait = new WebDriverWait(driver, 20);
        eWait.until((ExpectedConditions.titleIs("Hotels.com")));

        eWait.until(ExpectedConditions.and(
                ExpectedConditions.alertIsPresent(),
                ExpectedConditions.elementToBeClickable(By.xpath(""))
        ));

        eWait.until(ExpectedConditions.or(
                ExpectedConditions.alertIsPresent(),
                ExpectedConditions.elementToBeClickable(By.xpath(""))
        ));

        /**
         * Fluent Wait:
         *
         * Wait for a certain amount of time until the element is found or conditions(s) is met
         * When waiting period is over, throws TimeOutException
         *
         * user can define the polling period
         * user can ignore the specific exceptions during the wait period
         * user can put a custom message to display when wait if over
         *
         */
        Wait fWait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoAlertPresentException.class)
                .ignoring(NoSuchElementException.class)
                .withMessage("Element is found after 30 seconds of fluent wait");

        WebElement element = (WebElement) fWait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.xpath(""));
            }
        });


        // how to use fluent-wait object with Explicit-Wait conditions
        fWait.until(ExpectedConditions.urlContains("facebook"));

    }
}
