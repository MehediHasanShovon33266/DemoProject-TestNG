package TestRunner;

import Base.Setup;
import Pages.LoginPage;
import Utils.Utils;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTestRunner extends Setup {
    LoginPage loginPage;
    Utils utils;
    @Test(priority = 1)
    public void doLoginWithValidCredentials() throws IOException, ParseException {
        loginPage = new LoginPage(driver);
        utils = new Utils();
        //utils.getUserCredentials(0);
        utils.getUserCredentials(utils.getUserCount());
        driver.get("http://automationpractice.com/");
        boolean isLogoutFound = loginPage.doLoginWithValidCredentials(utils.getEmail(), utils.getPassword());
        Assert.assertEquals(isLogoutFound, true);
        loginPage.linkLogout.click();
    }
    @Test(priority = 2)
    public void doLoginWithInValidCredentials() throws IOException, ParseException {
//        driver.get("http://automationpractice.com/");
        loginPage = new LoginPage(driver);
        utils = new Utils();
        utils.getUserCredentials(1);
        String validationError = loginPage.doLoginWithInValidCredentials(utils.getEmail(), utils.getPassword());
        Assert.assertTrue(validationError.contains("failed"));
        }


    }

