package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

public class LoginPage {

    WebDriver driver;
    By loginBtn = By.xpath("//*[@id=\"login2\"]");
    By loginUserName = By.xpath("//*[@id=\"loginusername\"]");
    By passWordFld = By.xpath("//*[@id=\"loginpassword\"]");
    By loginSubmitBtn = By.xpath("/html/body/div[3]/div/div/div[3]/button[2]");
    By checkUserName = By.cssSelector("#nameofuser");

    By dashboard= By.xpath("/html/body");


    public void clickOnLoginButton(WebDriver driver) {
        driver.findElement(loginBtn).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public String loginWithValidData(WebDriver driver, String userName, String password) {
        driver.findElement(loginUserName).sendKeys(userName);
        driver.findElement(passWordFld).sendKeys(password);
        driver.findElement(loginSubmitBtn).click();

        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement element = driver.findElement(dashboard);

        File source = ((TakesScreenshot)element).getScreenshotAs(OutputType.FILE);
        try {
            FileHandler.copy(source, new File("./screenshots/VerifyLoginWithUsername.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String textUserName = driver.findElement(checkUserName).getText();

        System.out.println("check user name text " + textUserName);
        return textUserName;
    }
}
