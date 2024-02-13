package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
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

    By phoneDashboard = By.xpath("/html/body/div[5]/div/div[2]");
    By laptopDashboard = By.xpath("//*[@id=\"tbodyid\"]");
    By monitorDashboard = By.xpath("//*[@id=\"tbodyid\"]");


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
        int rowCount = driver.findElements(viewAllPhonePath).size();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement element = driver.findElement(phoneDashboard);

        File source = ((TakesScreenshot) element).getScreenshotAs(OutputType.FILE);
        try {
            FileHandler.copy(source, new File("./screenshots/phoneCountDashboard.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


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
        int rowCount = driver.findElements(viewAllPhonePath).size();
        System.out.println("number of laptop is " + rowCount);


        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement element = driver.findElement(laptopDashboard);

        File source = ((TakesScreenshot) element).getScreenshotAs(OutputType.FILE);
        try {
            FileHandler.copy(source, new File("./screenshots/laptopCountDashboard.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


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
        int rowCount = driver.findElements(viewAllPhonePath).size();


        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement element = driver.findElement(monitorDashboard);

        File source = ((TakesScreenshot) element).getScreenshotAs(OutputType.FILE);
        try {
            FileHandler.copy(source, new File("./screenshots/monitorCountDashboard.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        System.out.println("number of monitor is " + rowCount);
        return rowCount;
    }

}
