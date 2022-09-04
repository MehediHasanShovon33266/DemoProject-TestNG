package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SignupPage {
    @FindBy(id = "email_create")
    WebElement txtRegEmail;
    @FindBy(id = "SubmitCreate")
    WebElement btnSignup;
    @FindBy(id = "id_gender1")
    WebElement btnGender1;
    @FindBy(id = "customer_firstname")
    WebElement customerFirstName;
    @FindBy(id = "customer_lastname")
    WebElement customerLastName;
    @FindBy(id = "passwd")
    WebElement customerPassword;
    @FindBy(id = "days")
    WebElement cbDays;
    @FindBy(id = "months")
    WebElement cbMonth;
    @FindBy(id = "years")
    WebElement cbYear;
    @FindBy(id = "address1")
    WebElement txtAddress1;
    @FindBy(id = "city")
    WebElement txtCity;
    @FindBy(id = "id_state")
    WebElement cbState;
    @FindBy(id = "postcode")
    WebElement txtPostcode;
    @FindBy(id = "phone_mobile")
    WebElement txtPhoneMobile;
    @FindBy(id = "submitAccount")
    WebElement btnRegister;

    WebDriver driver;

    public SignupPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void doRegistration(String email, String password, String phoneMobile) throws InterruptedException {
        txtRegEmail.click();
        txtRegEmail.sendKeys(email);
        btnSignup.click();
        Thread.sleep(3000);
        btnGender1.click();
        customerFirstName.sendKeys("Hasan");
        customerLastName.sendKeys("Shovon");
        customerPassword.sendKeys(password);
        Select days = new Select(cbDays);
        days.selectByValue("7");
        Select months = new Select(cbMonth);
        months.selectByValue("11");
        Select years = new Select(cbYear);
        years.selectByValue("1996");
        txtAddress1.sendKeys("1 London Road, London");
        txtCity.sendKeys("Boston");
        Select state = new Select(cbState);
        state.selectByValue("5");
        txtPostcode.sendKeys("12000");
        txtPhoneMobile.sendKeys(phoneMobile);
        btnRegister.click();
    }

}
