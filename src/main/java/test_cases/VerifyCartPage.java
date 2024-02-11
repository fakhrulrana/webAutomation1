package test_cases;

import baseClass.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.CartPage;

import java.io.FileNotFoundException;
import java.util.Properties;

public class VerifyCartPage {

    WebDriver driver = (WebDriver) BaseClass.driversetUp();

    public VerifyCartPage() throws FileNotFoundException {
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
        crt.viewProduct(driver);
//        driver.findElement(By.xpath("/html/body/section[2]/div/div/div[2]/div[1]/div[2]/div/div[2]/ul/li/a")).click();
    }

    @Test(priority = 2)

    public void addToCart() {
        CartPage crt = new CartPage();
        crt.clickOnCartButton(driver);
    }

    @Test(priority = 3)

    public void verifyTheCart() {
        CartPage crt = new CartPage();
        String quantity = crt.clickOnViewCartButton(driver);

        /* here used quantity as assertion for test purpose*/
        Assert.assertEquals(quantity, quantity);
    }

    @AfterTest

    public void terminateBrowser() {
        driver.close();
    }
}
