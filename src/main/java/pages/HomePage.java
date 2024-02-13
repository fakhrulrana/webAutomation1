package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

public class HomePage {

    WebDriver driver;

    By home = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[1]/a/text()");

    By dashboard= By.xpath("//*[@id=\"narvbarx\"]");

    public HomePage() {

        this.driver = driver;
    }

    public String getTitle(WebDriver driver) {
        System.out.println("Try to get ttile=== ");
        String title = driver.getTitle();
        System.out.println("title is " + driver.getTitle());


        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement element = driver.findElement(dashboard);

        File source = ((TakesScreenshot)element).getScreenshotAs(OutputType.FILE);
        try {
            FileHandler.copy(source, new File("./screenshots/validateLandingPage.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return title;
    }

}
