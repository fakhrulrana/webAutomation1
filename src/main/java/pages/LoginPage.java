package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;
    By loginBtn = By.xpath("//*[@id=\"login2\"]");
    By loginUserName = By.xpath("//*[@id=\"loginusername\"]");
    By passWordFld = By.xpath("//*[@id=\"loginpassword\"]");
    By loginSubmitBtn = By.xpath("/html/body/div[3]/div/div/div[3]/button[2]");
    By checkUserName = By.cssSelector("#nameofuser");


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
        String textUserName = driver.findElement(checkUserName).getText();

        System.out.println("check user name text " + textUserName);
        return textUserName;
    }
}
