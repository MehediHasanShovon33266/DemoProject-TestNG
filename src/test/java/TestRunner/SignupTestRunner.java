package TestRunner;

import Base.Setup;
import Pages.LoginPage;
import Pages.SignupPage;
import Utils.Utils;
import org.testng.annotations.Test;

public class SignupTestRunner extends Setup {
    @Test
    public void doSignup() throws InterruptedException {
        driver.get("http://automationpractice.com/");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.linkLogin.click();
        SignupPage signupPage = new SignupPage(driver);
        Utils utils = new Utils();
        String emailUserAccount = "testautouser" + utils.generateRandomNumber(1000, 99999);
        String email = emailUserAccount + "@test.com";
        String password = "asdf1234";
        String phoneMobile = "175" + utils.generateRandomNumber(1000000, 9999999);
        signupPage.doRegistration(email, password, phoneMobile);

    }
}
