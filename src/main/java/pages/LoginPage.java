package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;
    By loginBtn = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a");
    By loginUserName = By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[2]");
    By passWordFld = By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[3]");
    By loginSubmitBtn = By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/button");
    By checkUserName = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a/b");


    public void clickOnLoginButton(WebDriver driver) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(loginBtn).click();
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
