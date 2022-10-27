package com.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Set;

public class BrowserUtils {

    /*
    This method accepts a Webdriver, expectedInURL as String, expectedInTitle as string switches to the expectedInURL and
    asserts that expectedInTitle contains actualTitle
    */
    public static void switchWindowAndVerify(WebDriver driver, String expectedInURL, String expectedInTitle){
        Set<String> allWindowHandles = driver.getWindowHandles();
        for (String each : allWindowHandles) {
            driver.switchTo().window(each);
            // System.out.println("Current URL: " + driver.getCurrentUrl());
            if (driver.getCurrentUrl().contains(expectedInURL)){
                break;
            }
        }
        String actualTitle = driver.getTitle();
        Assert.assertTrue (actualTitle.contains(expectedInTitle));
    }

    /* This method accepts a String "expectedTitle" and Asserts if it is true
    */

    public static void verifyTitle(WebDriver driver, String expectedTitle){
        Assert.assertEquals(driver.getTitle(), expectedTitle, "Title verified");
    }

    /* this method makes the browser wait for given seconds before triggering the next action
    */
    public static void sleep(long second){
        long millis=second*1000;
               try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Wait for " + second + " seconds and continue");
    }

    /* This method automatically logs in with 2 different overloaded versions
    version 1: login_crm()
     */

    /*
    Creating a utility method for ExplicitWait so we dont have to repeat the lines
     */
    public static void waitForInvisibility(WebElement webElement){
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOf(webElement));
    }

}


/*

1. Create a new class called BrowserUtils
2. Create a method to make Task1 logic re-usable
3. when method is called, it should switch window and verify title

 */