package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

public class Utils {

    public int generateRndmNumber()
    {
        int min = 1;
        int max = 10;
//Generate random double value from 200 to 400

        int randomNumber = (int) (Math.random()*(max-min+1)+min);

        System.out.println("Random value of type double between "+min+" to "+max+ ":" +randomNumber);
        return randomNumber;
    }

    public void captureScreenShot(WebDriver driver, String path) throws Exception {
// TODO Auto-generated method stub
        System.setProperty("webdriver.chrome.driver", "./src/resources/chromedriver.exe");
//System.setProperty("webdriver.gecko.driver", "E:\\Selenium-Softwares\\geckodriver.exe");
        driver=new ChromeDriver();
        driver.get("http://demo.automationtesting.in/Register.html");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement element = driver.findElement(By.xpath(path));

        File source = ((TakesScreenshot)element).getScreenshotAs(OutputType.FILE);
        try {
            FileHandler.copy(source, new File("./screenshots/element.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();

    }
}
