package com.tests;

import com.pages.Dashboard_Page;
import com.pages.LogIn_Page;
import com.pages.QuickLaunchpad_Page;
import com.utilities.BrowserUtils;
import com.utilities.ConfigurationReader;
import com.utilities.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class QuitAfter3Minutes {
    LogIn_Page logInPage;
    QuickLaunchpad_Page quickLaunchpad_page;
    Dashboard_Page dashboard_page;
    String logInPageUrl = ConfigurationReader.getProperty("logIn_pageUrl");
    String driver_username = ConfigurationReader.getProperty("driver_username");
    String driver_password = ConfigurationReader.getProperty("driver_password");
    String salesManager_username = ConfigurationReader.getProperty("salesManager_username");
    String salesManager_password = ConfigurationReader.getProperty("salesManager_password");
    String storeManager_username = ConfigurationReader.getProperty("storeManager_username");
    String storeManager_password = ConfigurationReader.getProperty("storeManager_password");

    public String case1s = ("USER      : DRIVER " + "\nTEST CASE 1     : AFTER LOGOUT USER CAN NOT RETURN TO MAIN PAGE\nRESULT   : SUCCESS");
    public String case1f = ("USER      : DRIVER " + "\nTEST CASE 1     : AFTER LOGOUT USER CAN NOT RETURN TO MAIN PAGE\nRESULT   : FAIL");
    public String case2s = ("USER      : SALES MANAGER " + "\nTEST CASE 2    : AFTER LOGOUT USER CAN NOT RETURN TO MAIN PAGE\nRESULT   : SUCCESS");
    public String case2f = ("USER      : SALES MANAGER " + "\nTEST CASE 2     : AFTER LOGOUT USER CAN NOT RETURN TO MAIN PAGE\nRESULT   : FAIL");
    public String case3s = ("USER      : STORE MANAGER " + "\nTEST CASE 3     : AFTER LOGOUT USER CAN NOT RETURN TO MAIN PAGE\nRESULT   : SUCCESS");
    public String case3f = ("USER      : STORE MANAGER " + "\nTEST CASE 3     : AFTER LOGOUT USER CAN NOT RETURN TO MAIN PAGE\nRESULT   : FAIL");

    @BeforeMethod
    public void setup() {
        Driver.getDriver().get(logInPageUrl);
        logInPage = new LogIn_Page();
    }

    @Test(priority = 1)
    public void wait_driver_three_minutes_and_quit (){
        quickLaunchpad_page = new QuickLaunchpad_Page ();
        logInPage.usernameInputBox.sendKeys(driver_username);
        logInPage.password_InputBox.sendKeys(driver_password);
        logInPage.logIn_Button.click();
        BrowserUtils.sleep(180);
        String case1s = ("\nTEST CASE 1 : WAITING 3 MINUTES RETURNS TO LOGIN PAGE" + "\nTESTED PAGE  :" +" Quick Launchpad" + "\nUSER        : DRIVER " + "\nRESULT      : SUCCESS");
        String case1f = ("\nTEST CASE 1 : WAITING 3 MINUTES RETURNS TO LOGIN PAGE" + "\nTESTED PAGE  :" +" Quick Launchpad" + "\nUSER        : DRIVER " + "\nRESULT      : FAIL");
        String currentURL = Driver.getDriver().getCurrentUrl();
        if (currentURL.contains(ConfigurationReader.getProperty("logIn_pageUrl"))) {
            System.out.println(case1s);
        } else {
            System.out.println(case1f);
        }
    }

    @Test(priority = 1)
    public void wait_salesManager_three_minutes_and_quit (){
        dashboard_page = new Dashboard_Page();
        logInPage.usernameInputBox.sendKeys(salesManager_username);
        logInPage.password_InputBox.sendKeys(salesManager_password);
        logInPage.logIn_Button.click();
        BrowserUtils.sleep(180);
        String case2s = ("\nTEST CASE 2 : WAITING 3 MINUTES RETURNS TO LOGIN PAGE" + "\nTESTED PAGE  :" +" Dashboard" + "\nUSER        : SALES MANAGER " + "\nRESULT      : SUCCESS");
        String case2f = ("\nTEST CASE 2 : WAITING 3 MINUTES RETURNS TO LOGIN PAGE" + "\nTESTED PAGE  :" +" Dashboard" + "\nUSER        : SALES MANAGER " + "\nRESULT      : FAIL");
        String currentURL = Driver.getDriver().getCurrentUrl();
        if (currentURL.contains(ConfigurationReader.getProperty("logIn_pageUrl"))) {
            System.out.println(case2s);
        } else {
            System.out.println(case2f);
        }
    }

    @Test(priority = 1)
    public void wait_storeManager_three_minutes_and_quit (){
        dashboard_page = new Dashboard_Page();
        logInPage.usernameInputBox.sendKeys(salesManager_username);
        logInPage.password_InputBox.sendKeys(salesManager_password);
        logInPage.logIn_Button.click();
        BrowserUtils.sleep(180);
        String case3s = ("\nTEST CASE 3 : WAITING 3 MINUTES RETURNS TO LOGIN PAGE" + "\nTESTED PAGE  :" +" Dashboard" + "\nUSER        : STORE MANAGER " + "\nRESULT      : SUCCESS");
        String case3f = ("\nTEST CASE 3 : WAITING 3 MINUTES RETURNS TO LOGIN PAGE" + "\nTESTED PAGE  :" +" Dashboard" + "\nUSER        : STORE MANAGER " + "\nRESULT      : FAIL");
        String currentURL = Driver.getDriver().getCurrentUrl();
        if (currentURL.contains(ConfigurationReader.getProperty("logIn_pageUrl"))) {
            System.out.println(case3s);
        } else {
            System.out.println(case3f);
        }
    }

    @AfterMethod
    public void ending() {
        Driver.closeDriver();
    }

}
