package Pages;

import Driver.Web;
import org.openqa.selenium.By;

public class Basepage {

    public void clickThis(By locator) {
        Web.getDriver().findElement(locator).click();
    }

    public void type(By locator, String data) {
        Web.getDriver().findElement(locator).sendKeys(data);
    }

    public boolean isElementDisplayed(By locator) {
        return Web.getDriver().findElement(locator).isDisplayed();
    }






}
