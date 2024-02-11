package test_cases;

import baseClass.BaseClass;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;

import java.io.FileNotFoundException;
import java.util.Properties;

public class ViewLandingPage {


    WebDriver driver = (WebDriver) BaseClass.driversetUp();

    public ViewLandingPage() throws FileNotFoundException {
    }

    @BeforeTest
    public void setup() throws FileNotFoundException {

        Properties properties = BaseClass.propertysetUp();
        String url = properties.getProperty("baseURL");
        driver.get(url);
        //Maximize the browser
        driver.manage().window().maximize();

    }

    @Test(priority = 1)
    public void viewLandingPage() {

        String title = new HomePage().getTitle(driver);
        Assert.assertEquals(title, "STORE");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterTest
    public void terminateBrowser() {
        driver.close();
    }
}

