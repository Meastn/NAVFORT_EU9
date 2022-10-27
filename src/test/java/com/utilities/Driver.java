package com.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Driver {

    /*
    Creating a private constructor so we are closing access to
    the object of this class from outside of class
     */

    private Driver (){}
     /*
    We make WebDriver private, because we want to close the access from outside of the class
    We make it static because we will use it in a static method
     */

    private static WebDriver driver;

    /*
     Create a reusable utility method which will return same driver instance when we call it
    SINGLETON DESIGN PATTERN
     */
    public static WebDriver getDriver(){

        if (driver== null){
            /*
            read our browserType from configuration properties.
            So that we can control which browser is opened outside of
            our code
             */
            String browserType = ConfigurationReader.getProperty("browser");
           /*
           depending on the browserType that will return
           from the configuariton.properties file switch s
           statement will determine the case and open the
           relevant browser window
            */

            switch (browserType) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;
                case "safari":
                    WebDriverManager.safaridriver().setup();
                    driver = new SafariDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;
            }
        }
        return driver;

    }

    //This method ensures that our driver value is always null after using quit() method
    public static void closeDriver(){
        if (driver != null){
            driver.quit();// terminate existing session
            driver=null; //define driver as null for our singleton design pattern
        }
    }


}
