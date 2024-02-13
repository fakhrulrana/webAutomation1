package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

public class CartPage {

    WebDriver driver;

    By cartButton= By.cssSelector("a.btn");
    By viewCartBtn= By.xpath("//*[@id=\"cartur\"]");
    By getQuantity=By.xpath("//*[@id=\"product-1\"]/td[4]/button");

    By viewProduct=By.xpath("/html/body/div[5]/div/div[2]/div/div[1]/div/div/h4/a");
    By checkOutBtn= By.xpath("/html/body/div[6]/div/div[2]/button");

    By getCheckoutText= By.xpath("/html/body/div[10]/h2");

    By phoneCategoryPath = By.xpath("/html/body/div[5]/div/div[1]/div/a[2]");
    By laptopCategoryPath = By.xpath("/html/body/div[5]/div/div[1]/div/a[3]");
    By monitorCategoryPath = By.xpath("/html/body/div[5]/div/div[1]/div/a[4]");
    By viewAllPhonePath = By.xpath("//*[@id='tbodyid']/div");

    By namePath = By.xpath("//*[@id=\"name\"]");
    By countryPath = By.xpath("//*[@id=\"country\"]");
    By cityPath = By.xpath("//*[@id=\"city\"]");

    By creditCardPath = By.xpath("//*[@id=\"card\"]");
    By monthPath = By.xpath("//*[@id=\"month\"]");
    By yearPath = By.xpath("//*[@id=\"year\"]");

    By purchaseBtnPath = By.xpath("/html/body/div[3]/div/div/div[3]/button[2]");

    By okBtn= By.xpath("/html/body/div[10]/div[7]/div/button");

    By dashboard=By.xpath("/html/body/div[10]");

    public void viewAndCountPhonesCategory(WebDriver driver) {
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
    }
    public void viewProduct(WebDriver driver)
    {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(viewProduct).click();
    }
    public void clickOnCartButton(WebDriver driver)
    {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.findElement(cartButton).click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        Alert alertDialog = driver.switchTo().alert();

// Get the alert text
        String successTxt = alertDialog.getText();

// Click the OK button on the alert.
        alertDialog.accept();
    }

    public void clickOnViewCartButton(WebDriver driver)
    {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(viewCartBtn).click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public String clickOnCheckOut(WebDriver driver,String fullName,String city,String country,String creditCard, String month,String year)
    {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(checkOutBtn).click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(namePath).sendKeys(fullName);
        driver.findElement(countryPath).sendKeys(country);
        driver.findElement(cityPath).sendKeys(city);
        driver.findElement(creditCardPath).sendKeys(creditCard);
        driver.findElement(monthPath).sendKeys(month);
        driver.findElement(yearPath).sendKeys(year);

        driver.findElement(purchaseBtnPath).click();

        String textChkOut=driver.findElement(getCheckoutText).getText();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement element = driver.findElement(dashboard);

        File source = ((TakesScreenshot)element).getScreenshotAs(OutputType.FILE);
        try {
            FileHandler.copy(source, new File("./screenshots/purchasePhone.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("check out text " + textChkOut);

        driver.findElement(okBtn).click();
        return textChkOut;
    }

}
