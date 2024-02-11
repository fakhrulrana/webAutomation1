package test_cases;

import baseClass.BaseClass;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.CategoryPage;

import java.io.FileNotFoundException;
import java.util.Properties;

public class ViewCategoriesAndCount {

    WebDriver driver = (WebDriver) BaseClass.driversetUp();

    public ViewCategoriesAndCount() throws FileNotFoundException {
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

    public void viewPhoneCatergory() {
        CategoryPage catPg = new CategoryPage();
        int phoneCount= catPg.viewAndCountPhonesCategory(driver);
        System.out.println("total number of phone in category page " +phoneCount);
//        driver.findElement(By.xpath("/html/body/section[2]/div/div/div[2]/div[1]/div[2]/div/div[2]/ul/li/a")).click();
    }
    @Test(priority = 2)

    public void viewLaptopCatergory() {
        CategoryPage catPg = new CategoryPage();
        int laptopCount= catPg.viewAndCountLaptopCategory(driver);
        System.out.println("total number of Laptop in category page " +laptopCount);
//        driver.findElement(By.xpath("/html/body/section[2]/div/div/div[2]/div[1]/div[2]/div/div[2]/ul/li/a")).click();
    }

    @Test(priority = 3)

    public void viewMonitorCatergory() {
        CategoryPage catPg = new CategoryPage();
        int monitorCount= catPg.viewAndCountMonitorCategory(driver);
        System.out.println("total number of Monitor in category page " +monitorCount);
//        driver.findElement(By.xpath("/html/body/section[2]/div/div/div[2]/div[1]/div[2]/div/div[2]/ul/li/a")).click();
    }

    @AfterTest

    public void terminateBrowser() {
        driver.close();
    }
}
