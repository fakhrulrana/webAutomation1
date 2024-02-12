package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CategoryPage {

    WebDriver driver;

    By phoneCategoryPath = By.xpath("/html/body/div[5]/div/div[1]/div/a[2]");
    By laptopCategoryPath = By.xpath("/html/body/div[5]/div/div[1]/div/a[3]");
    By monitorCategoryPath = By.xpath("/html/body/div[5]/div/div[1]/div/a[4]");
    By viewAllPhonePath = By.xpath("//*[@id='tbodyid']/div");
    By viewAllPhonePathCss = By.cssSelector("#tbodyid");
    By viewAllLaptopPath = By.xpath("/html/body/div[5]/div/div[2]/div");

    By viewAllMonitorPath = By.xpath("/html/body/div[5]/div/div[2]/div");



    public int viewAndCountPhonesCategory(WebDriver driver) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(phoneCategoryPath).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
       int rowCount= driver.findElements(viewAllPhonePath).size();
        System.out.println("number of phone is " + rowCount);
        return rowCount;
    }
    public int viewAndCountLaptopCategory(WebDriver driver) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(laptopCategoryPath).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        int rowCount= driver.findElements(viewAllPhonePath).size();
        System.out.println("number of laptop is " + rowCount);
        return rowCount;
    }

    public int viewAndCountMonitorCategory(WebDriver driver) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(monitorCategoryPath).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        int rowCount= driver.findElements(viewAllPhonePath).size();
        System.out.println("number of monitor is " + rowCount);
        return rowCount;
    }

}
