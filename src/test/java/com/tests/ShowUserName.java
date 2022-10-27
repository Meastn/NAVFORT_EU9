package com.tests;

import com.pages.Dashboard_Page;
import com.pages.LogIn_Page;
import com.pages.QuickLaunchpad_Page;
import com.pages.ResetRequest_Page;
import com.utilities.ConfigurationReader;
import com.utilities.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ShowUserName {
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

    String case1s = ("USER      : DRIVER "+"\nTEST CASE 1          : USER NAME SHOWN ON PROFILE? \nRESULT        : SUCCESS");
    String case1f = ("USER      : DRIVER "+"\nTEST CASE 1          : USER NAME SHOWN ON PROFILE? \nRESULT        : FAIL");
    String case2s = ("USER      : SALES MANAGER "+"\nTEST CASE 2   : USER NAME SHOWN ON PROFILE? \nRESULT        : SUCCESS");
    String case2f = ("USER      : SALES MANAGER "+"\nTEST CASE 2   : USER NAME SHOWN ON PROFILE? \nRESULT        : FAIL");
    String case3s = ("USER      : STORE MANAGER "+"\nTEST CASE 3   : USER NAME SHOWN ON PROFILE? \nRESULT        : SUCCESS");
    String case3f = ("USER      : STORE MANAGER "+"\nTEST CASE 3   : USER NAME SHOWN ON PROFILE? \nRESULT        : FAIL");
    @BeforeMethod
    public void setup() {
        Driver.getDriver().get(logInPageUrl);
        logInPage = new LogIn_Page();
        quickLaunchpad_page = new QuickLaunchpad_Page();
        dashboard_page = new Dashboard_Page();
    }


    @Test(priority = 1)
    public void show_driver_username_test() {
        quickLaunchpad_page = new QuickLaunchpad_Page();
        logInPage.usernameInputBox.sendKeys(driver_username);
        logInPage.password_InputBox.sendKeys(driver_password);
        logInPage.logIn_Button.click();
        String actualShownUsername = quickLaunchpad_page.displayDropdown.getText();
        String expectedShownUsername = driver_username;
        try {
            if (actualShownUsername.equals(expectedShownUsername)) {
                System.out.println(case1s);
            } else {
                System.out.println(case1f);
            }
        } catch (AssertionError n){
            System.out.println(case1s);
        }


    }

    @Test(priority = 2)
    public void show_salesManager_username_test() {
        quickLaunchpad_page = new QuickLaunchpad_Page();
        logInPage.usernameInputBox.sendKeys(salesManager_username);
        logInPage.password_InputBox.sendKeys(salesManager_password);
        logInPage.logIn_Button.click();
        String actualShownUsername = quickLaunchpad_page.displayDropdown.getText();
        String expectedShownUsername = salesManager_username;
        try {
            if (actualShownUsername.equals(expectedShownUsername)) {
                System.out.println(case2s);
            } else {
                System.out.println(case2f);
            }
        } catch (AssertionError n){
            System.out.println(case2s);
        }
    }

    @Test(priority = 3)
    public void show_storeManager_username_test() {
        quickLaunchpad_page = new QuickLaunchpad_Page();
        logInPage.usernameInputBox.sendKeys(storeManager_username);
        logInPage.password_InputBox.sendKeys(storeManager_password);
        logInPage.logIn_Button.click();
        String actualShownUsername = quickLaunchpad_page.displayDropdown.getText();
        String expectedShownUsername = storeManager_username;
        try {
            if (actualShownUsername.equals(expectedShownUsername)) {
                System.out.println(case3s);
            } else {
                System.out.println(case3f);
            }
        } catch (AssertionError n){
            System.out.println(case3s);
        }
    }

    @AfterMethod
    public void ending () {
        Driver.closeDriver();
    }
}
