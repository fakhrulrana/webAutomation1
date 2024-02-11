package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    WebDriver driver;

    By home = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[1]/a/text()");

    public HomePage() {

        this.driver = driver;
    }

    public String getTitle(WebDriver driver) {
        System.out.println("Try to get ttile=== ");
        String title = driver.getTitle();
        System.out.println("title is " + driver.getTitle());
        return title;
    }

}
