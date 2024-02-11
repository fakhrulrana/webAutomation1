package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {

    WebDriver driver;

    By signUpBtn = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a");
    By submitBtn = By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/button");
    By nameFld = By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[2]");
    By emailFld = By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[3]");

    By radioBtn = By.xpath("//*[@id=\"id_gender1\"]");
    By passWrdFld = By.xpath("//*[@id=\"password\"]");
    By firstName = By.xpath("//*[@id=\"first_name\"]");
    By lastName = By.xpath("//*[@id=\"last_name\"]");
    By cmpanyName = By.xpath("//*[@id=\"company\"]");

    By address1Fld = By.xpath("//*[@id=\"address1\"]");

    By stateFld = By.xpath("//*[@id=\"state\"]");

    By cityFld = By.xpath("//*[@id=\"city\"]");

    By zipCodeFld = By.xpath("//*[@id=\"zipcode\"]");

    By mobilNoFld = By.xpath("//*[@id=\"mobile_number\"]");

    By createAccntBtn = By.xpath("//*[@id=\"form\"]/div/div/div/div/form/button");
    By getSuccessText = By.xpath("//*[@id=\"form\"]/div/div/div/h2/b");
    By getQuantity = By.xpath("//*[@id=\"product-1\"]/td[4]/button");


    public void clickOnSignUpLogin(WebDriver driver) {
        driver.findElement(signUpBtn).click();
    }

    public void clickOnSubmit(WebDriver driver, String name, String email) {
        driver.findElement(nameFld).sendKeys(name);
        driver.findElement(emailFld).sendKeys(email);
        driver.findElement(submitBtn).click();
    }

    public void createAccountWithInfo(WebDriver driver, String fName, String lName, String passWord, String mobileNo, String address, String state, String zipCode) {
        driver.findElement(radioBtn).click();
        driver.findElement(passWrdFld).sendKeys(passWord);
        driver.findElement(firstName).sendKeys(fName);
        driver.findElement(lastName).sendKeys(lName);
        driver.findElement(address1Fld).sendKeys(address);
        driver.findElement(stateFld).sendKeys(state);
        driver.findElement(cityFld).sendKeys(state);
        driver.findElement(zipCodeFld).sendKeys(zipCode);
        driver.findElement(mobilNoFld).sendKeys(mobileNo);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        /* scroll down */

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");

        driver.findElement(createAccntBtn).click();
    }

    public String verifyAccountCreation(WebDriver driver) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String successTxt = driver.findElement(getSuccessText).getText();
        System.out.println("success message is " + successTxt);
        return successTxt;
    }

}
