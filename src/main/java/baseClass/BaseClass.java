package baseClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BaseClass {

    public static Properties propertysetUp() throws FileNotFoundException {

        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream("config/config.properties");
        try {
            properties.load(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties;
//        String username = properties.getProperty("baseURL");
//        System.out.println("url is " +username);
    }

    public static WebDriver driversetUp() throws FileNotFoundException {
        Properties properties = propertysetUp();
        String url = properties.getProperty("baseURL");
//        System.out.println("url is " + url);

        ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");


        System.setProperty("webdriver.chrome.driver", "./src/resources/chromedriver.exe");

        // Instantiate a ChromeDriver class.
        WebDriver driver = new ChromeDriver(option);

//        // Launch Website
//        driver.get(url);
//
//        //Maximize the browser
//        driver.manage().window().maximize();

        return driver;

//        String username = properties.getProperty("baseURL");
//        System.out.println("url is " +username);
    }


}
