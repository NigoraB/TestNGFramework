package Tests;

import Driver.Web;
import Pages.Homepage;
import Pages.Welcomepage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Login extends Web {

    @Test(description = "User can login with valid credentials")
    public void userCanLoginUsingValidCredentials() {
        /*
            1. Launch the page
            2. Click Sign In button
            3. Enter user credentials
            4. Click SIGN IN button
            5. Verify "Hi," text is displayed
            6. Close the browser
         */

        Homepage hp = new Homepage();
        Welcomepage wp = new Welcomepage();

        // 2
        hp.clickSignInOnHeader();
        // 3
        hp.enterUsername("dt@schl.com");
        hp.enterPassword("passw0rd");
        // 4
        hp.clickSignInButton();
        // 5
        Assert.assertTrue(wp.isHiDisplayed(), "Hi message is not displayed");




    }




}
