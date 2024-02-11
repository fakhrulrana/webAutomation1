package test_cases;

import baseClass.BaseClass;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.CartPage;

import java.io.FileNotFoundException;
import java.util.Properties;

public class ProceedToCheckout {

    WebDriver driver = (WebDriver) BaseClass.driversetUp();

    public ProceedToCheckout() throws FileNotFoundException {
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

    public void viewToCart() {
        CartPage crt = new CartPage();
        String getchkOutTxt = crt.clickOnCheckOut(driver);

        /* here used quantity as assertion for test purpose*/
        Assert.assertEquals("Checkout", getchkOutTxt);
    }

    @AfterTest

    public void terminateBrowser() {
        driver.close();
    }
}
