package test_cases;

import baseClass.BaseClass;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CategoryPage;
import pages.LoginPage;

import java.io.FileNotFoundException;
import java.util.Properties;

public class PurchasePhone {

    WebDriver driver = (WebDriver) BaseClass.driversetUp();
    Properties properties = BaseClass.propertysetUp();

    String userName = properties.getProperty("loginName");
    String passWord = properties.getProperty("passWord");

    String fullName = properties.getProperty("fullName");
    String city = properties.getProperty("city");
    String country = properties.getProperty("country");
    String month = properties.getProperty("month");
    String year = properties.getProperty("year");

    String creditCard = properties.getProperty("creditCard");

    public PurchasePhone() throws FileNotFoundException {
    }

    @BeforeTest
    public void setup() throws FileNotFoundException {

        Properties properties = BaseClass.propertysetUp();
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
    public void Login() {

        LoginPage lg = new LoginPage();
        lg.clickOnLoginButton(driver);
        String getText = lg.loginWithValidData(driver, userName, passWord);

    }

    @Test(priority = 2)
    public void viewPhoneCatergory() {
        CartPage crtPage = new CartPage();
        crtPage.viewAndCountPhonesCategory(driver);
    }

    @Test(priority = 3)

    public void viewProduct() {
        CartPage crt = new CartPage();
        crt.viewProduct(driver);
//        driver.findElement(By.xpath("/html/body/section[2]/div/div/div[2]/div[1]/div[2]/div/div[2]/ul/li/a")).click();
    }

    @Test(priority = 4)

    public void addToCart() {
        CartPage crt = new CartPage();
        crt.clickOnCartButton(driver);
    }

    @Test(priority = 5)

    public void viewTheCart() {
        CartPage crt = new CartPage();
        crt.clickOnViewCartButton(driver);
    }

    @Test(priority = 6)
    public void checkOutProduct() {
        CartPage crt = new CartPage();
        String successMsg=crt.clickOnCheckOut(driver,fullName,city,country,creditCard,month,year);
        Assert.assertEquals(successMsg, "Thank you for your purchase!");
    }

    @AfterTest

    public void terminateBrowser() {
        driver.close();
    }
}
