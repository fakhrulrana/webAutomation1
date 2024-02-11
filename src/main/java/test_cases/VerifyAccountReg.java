package test_cases;

import baseClass.BaseClass;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.RegistrationPage;
import utils.Utils;

import java.io.FileNotFoundException;
import java.util.Properties;

public class VerifyAccountReg {

    WebDriver driver = (WebDriver) BaseClass.driversetUp();
    Properties properties = BaseClass.propertysetUp();
    Utils utility = new Utils();

    public VerifyAccountReg() throws FileNotFoundException {
    }

    @BeforeTest
    public void setup() throws FileNotFoundException {

        String url = properties.getProperty("baseURL");
        driver.get(url);
        //Maximize the browser
        driver.manage().window().maximize();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    @Test(priority = 1)


    public void verifyCreateAccount() {

        String email = properties.getProperty("email");
        int number = utility.generateRndmNumber();
        String generatedEmail = String.valueOf(number)+email ;

        String name = properties.getProperty("name");
        String fName = properties.getProperty("fName");
        String lName = properties.getProperty("lName");
        String passWord = properties.getProperty("passWord");
        String mobileNo = properties.getProperty("mobileNo");
        String address = properties.getProperty("address");
        String state = properties.getProperty("state");
        String zipCode = properties.getProperty("zipCode");

        RegistrationPage regPage = new RegistrationPage();

        regPage.clickOnSignUpLogin(driver);
        regPage.clickOnSubmit(driver, name, generatedEmail);
        regPage.createAccountWithInfo(driver, fName, lName, passWord, mobileNo, address, state, zipCode);

        String getText = regPage.verifyAccountCreation(driver);

        /* here used quantity as assertion for test purpose*/
        Assert.assertEquals("ACCOUNT CREATED!", getText);
    }

    @AfterTest

    public void terminateBrowser() {
        driver.close();
    }
}
