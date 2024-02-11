package test_cases;

import baseClass.BaseClass;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import java.io.FileNotFoundException;
import java.util.Properties;

public class VerifyLoginWithUsername {

    WebDriver driver = (WebDriver) BaseClass.driversetUp();

    Properties properties = BaseClass.propertysetUp();

    String userName = properties.getProperty("loginName");
    String passWord = properties.getProperty("passWord");

    public VerifyLoginWithUsername() throws FileNotFoundException {
    }

    @BeforeTest
    public void setup() throws FileNotFoundException {

        String url = properties.getProperty("baseURL");
        driver.get(url);
        //Maximize the browser
        driver.manage().window().maximize();

    }

    @Test(priority = 1)
    public void VerifyLoginUserName() {

        LoginPage lg = new LoginPage();
        lg.clickOnLoginButton(driver);
        String getText = lg.loginWithValidData(driver, userName, passWord);
        Assert.assertEquals(getText, "Fakhrul Islam Rana");

    }

    @AfterTest
    public void terminateBrowser() {
        driver.close();
    }
}
