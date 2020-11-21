package Pages;

import org.openqa.selenium.By;

public class Welcomepage extends Basepage {


    By hiInHeader = By.xpath("//span[@class='user-data' and contains(text(),'Hi,')]");



    public boolean isHiDisplayed() {
        return isElementDisplayed(hiInHeader);
    }



}
