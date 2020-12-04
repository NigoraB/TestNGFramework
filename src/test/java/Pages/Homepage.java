package Pages;

import Utils.Helper;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class Homepage extends Basepage {

    By signInFromHeader = By.xpath("//a[starts-with(@class,'signin pureguest')]");
    By username = By.id("dwfrm_login_username");
    By password = By.id("dwfrm_login_password");
    By signInButton = By.id("loginModalBtn");


    @Step("Click 'Sign In' on header")
    public void clickSignInOnHeader() {
        clickThis(signInFromHeader);
    }

    @Step("Enter username")
    public void enterUsername(String user) {
        type(username, user);
    }

    @Step("Enter password")
    public void enterPassword(String pwd) {
        type(password, pwd);
    }

    @Step("Click on Sign In Button")
    public void clickSignInButton() {
        clickThis(signInButton);
    }

    @Step("Login into the Scholastic webpage")
    public void login(String user, String pass) {
        enterUsername(user);
        enterPassword(pass);
        clickSignInButton();
    }

}
