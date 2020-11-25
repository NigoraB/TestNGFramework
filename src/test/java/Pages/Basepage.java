package Pages;

import Driver.Web;
import Utils.Helper;
import com.google.common.base.Function;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class Basepage {

    public WebElement findElementUsingFluentWait(final By locator) {
        Wait fWait = new FluentWait(Web.getDriver())
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoAlertPresentException.class)
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .withMessage("Element is found after 30 seconds of fluent wait");

        WebElement element = (WebElement) fWait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(locator);
            }
        });
        return element;
    }

    public void clickThis(By locator) {
        findElementUsingFluentWait(locator).click();
    }

    public void type(By locator, String data) {
        findElementUsingFluentWait(locator).sendKeys(data);
    }

    public boolean isElementDisplayed(By locator) {
        return findElementUsingFluentWait(locator).isDisplayed();
    }








}
