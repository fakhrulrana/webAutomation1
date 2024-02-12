package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {

    WebDriver driver;

    By signUpBtn = By.xpath("//*[@id=\"signin2\"]");
    By submitBtn = By.xpath("/html/body/div[2]/div/div/div[3]/button[2]");
    By nameFld = By.xpath("//*[@id=\"sign-username\"]");
    By passWrdFld = By.xpath("//*[@id=\"sign-password\"]");


    public void clickOnSignUpLogin(WebDriver driver) {
        driver.findElement(signUpBtn).click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void createAccountWithInfo(WebDriver driver,  String userName, String passWord) {
        driver.findElement(nameFld).sendKeys(userName);
        driver.findElement(passWrdFld).sendKeys(passWord);
        driver.findElement(submitBtn).click();

    }

    public String verifyAccountCreation(WebDriver driver) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        Alert alertDialog = driver.switchTo().alert();

// Get the alert text
        String successTxt = alertDialog.getText();

// Click the OK button on the alert.
        alertDialog.accept();
        System.out.println("pop up success message is " + successTxt);
        return successTxt;
    }

}
