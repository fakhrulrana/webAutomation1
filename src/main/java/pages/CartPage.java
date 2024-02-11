package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {

    WebDriver driver;

    By cartButton= By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/span/button");
    By viewCartBtn= By.xpath("//*[@id=\"cartModal\"]/div/div/div[2]/p[2]/a/u");
    By getQuantity=By.xpath("//*[@id=\"product-1\"]/td[4]/button");

    By viewProduct=By.xpath("/html/body/section[2]/div/div/div[2]/div[1]/div[2]/div/div[2]/ul/li/a");
    By checkOutBtn= By.xpath("//*[@id=\"do_action\"]/div[1]/div/div/a");

    By getCheckoutText= By.xpath("//*[@id=\"checkoutModal\"]/div/div/div[1]/h4");



    public void viewProduct(WebDriver driver)
    {
        driver.findElement(viewProduct).click();
    }
    public void clickOnCartButton(WebDriver driver)
    {
        driver.findElement(cartButton).click();
    }

    public String clickOnViewCartButton(WebDriver driver)
    {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(viewCartBtn).click();
        String noOfCart=driver.findElement(getQuantity).getText();
        System.out.println("number of cart is " + noOfCart);
        return noOfCart;
    }

    public String clickOnCheckOut(WebDriver driver)
    {
        CartPage crt= new CartPage();
        crt.viewProduct(driver);
        crt.clickOnCartButton(driver);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(viewCartBtn).click();

        driver.findElement(checkOutBtn).click();
        String textChkOut=driver.findElement(getCheckoutText).getText();

        System.out.println("check out text " + textChkOut);
        return textChkOut;
    }

}
