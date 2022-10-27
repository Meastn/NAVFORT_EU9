package com.tests;

import com.github.javafaker.Faker;
import com.pages.Dashboard_Page;
import com.pages.LogIn_Page;
import com.pages.QuickLaunchpad_Page;
import com.utilities.BrowserUtils;
import com.utilities.ConfigurationReader;
import com.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogoutTest {
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

    public String case1s = ("USER      : DRIVER " + "\nTEST CASE 1           : LOGOUT LANDS TO LOG IN PAGE TEST\nRESULT   : SUCCESS");
    public String case1f = ("USER      : DRIVER " + "\nTEST CASE 1           : LOGOUT LANDS TO LOG IN PAGE TEST\nRESULT   : FAIL");
    public String case2s = ("USER      : SALES MANAGER " + "\nTEST CASE 2    : LOGOUT LANDS TO LOG IN PAGE TEST\nRESULT   : SUCCESS");
    public String case2f = ("USER      : SALES MANAGER " + "\nTEST CASE 2    : LOGOUT LANDS TO LOG IN PAGE TEST\nRESULT   : FAIL");
    public String case3s = ("USER      : STORE MANAGER " + "\nTEST CASE 3    : LOGOUT LANDS TO LOG IN PAGE TEST\nRESULT   : SUCCESS");
    public String case3f = ("USER      : STORE MANAGER " + "\nTEST CASE 3    : LOGOUT LANDS TO LOG IN PAGE TEST\nRESULT   : FAIL");


    @BeforeMethod
    public void setup() {
        Driver.getDriver().get(logInPageUrl);
        logInPage = new LogIn_Page();
    }

    @Test(priority = 1)
    public void driver_logout_landingpage_test() {
        quickLaunchpad_page = new QuickLaunchpad_Page();
        logInPage.usernameInputBox.sendKeys(driver_username);
        logInPage.password_InputBox.sendKeys(driver_password);
        logInPage.logIn_Button.click();
        BrowserUtils.sleep(2);
        quickLaunchpad_page.displayDropdown.click();
        quickLaunchpad_page.selectLogout.click();

        if (logInPage.loginPageHeader.isDisplayed()) {
            System.out.println(case1s);
        } else {
            System.out.println(case1f);
        }
    }

    @Test(priority = 2)
    public void salesmanager_logout_landingpage_test() {
        dashboard_page = new Dashboard_Page();
        logInPage.usernameInputBox.sendKeys(salesManager_username);
        logInPage.password_InputBox.sendKeys(salesManager_password);
        logInPage.logIn_Button.click();
        BrowserUtils.sleep(8);

        dashboard_page.displayDropdown.click();
        dashboard_page.selectLogout.click();

        if (logInPage.loginPageHeader.isDisplayed()) {
            System.out.println(case2s);
        } else {
            System.out.println(case2f);
        }
    }

    @Test(priority = 3)
    public void storemanager_logout_landingpage_test() {
        dashboard_page = new Dashboard_Page();
        logInPage.usernameInputBox.sendKeys(storeManager_username);
        logInPage.password_InputBox.sendKeys(storeManager_password);
        logInPage.logIn_Button.click();
        BrowserUtils.sleep(8);
        dashboard_page.displayDropdown.click();
        dashboard_page.selectLogout.click();

        if (logInPage.loginPageHeader.isDisplayed()) {
            System.out.println(case3s);
        } else {
            System.out.println(case3f);
        }
    }


    @Test(priority = 4)
    public void logout_driver_with_tab_close_test() {
        logInPage.usernameInputBox.sendKeys(driver_username);
        logInPage.password_InputBox.sendKeys(driver_password);
        logInPage.logIn_Button.click();
        //BrowserUtils.sleep(2);
        Driver.closeDriver();
        Driver.getDriver().get(logInPageUrl);
        quickLaunchpad_page = new QuickLaunchpad_Page();
        String case4s = ("\nTEST CASE 1 : CLOSING TABS QUITS THE APPLICATION" + "\nTESTED URL  :" +" Quick Launchpad" + "\nUSER        : DRIVER " + "\nRESULT      : SUCCESS");
        String case4f = ("\nTEST CASE 1 : CLOSING TABS QUITS THE APPLICATION" + "\nTESTED URL  :" +" Quick Launchpad" + "\nUSER        : DRIVER " + "\nRESULT      : FAIL");
        String currentURL = Driver.getDriver().getCurrentUrl();
        if (currentURL.contains(ConfigurationReader.getProperty("logIn_pageUrl"))) {
            System.out.println(case4s);
        } else {
            System.out.println(case4f);
        }
    }
    @Test(priority = 5)
    public void logout_salesmanager_with_tab_close_test() {
        dashboard_page = new Dashboard_Page();
        logInPage.usernameInputBox.sendKeys(salesManager_username);
        logInPage.password_InputBox.sendKeys(salesManager_password);
        logInPage.logIn_Button.click();
        //BrowserUtils.sleep(2);
        Driver.closeDriver();
        Driver.getDriver().get(logInPageUrl);
        dashboard_page = new Dashboard_Page();
        String case4s = ("\nTEST CASE 2 : CLOSING TABS QUITS THE APPLICATION" + "\nTESTED URL  :" +" Dashboard" + "\nUSER        : SALES MANAGER " + "\nRESULT      : SUCCESS");
        String case4f = ("\nTEST CASE 2 : CLOSING TABS QUITS THE APPLICATION" + "\nTESTED URL  :" +" Dashboard" + "\nUSER        : SALES MANAGER " + "\nRESULT      : FAIL");
        String currentURL = Driver.getDriver().getCurrentUrl();
        if (currentURL.contains(ConfigurationReader.getProperty("logIn_pageUrl"))) {
            System.out.println(case4s);
        } else {
            System.out.println(case4f);
        }
    }

    @Test(priority = 6)
    public void logout_storemanager_with_tab_close_test() {
        dashboard_page = new Dashboard_Page();
        logInPage.usernameInputBox.sendKeys(storeManager_username);
        logInPage.password_InputBox.sendKeys(storeManager_password);
        logInPage.logIn_Button.click();
        //BrowserUtils.sleep(2);
        Driver.closeDriver();
        Driver.getDriver().get(logInPageUrl);
        dashboard_page = new Dashboard_Page();
        String case4s = ("\nTEST CASE 3 : CLOSING TABS QUITS THE APPLICATION" + "\nTESTED URL  :" +" Dashboard" + "\nUSER        : STORE MANAGER " + "\nRESULT      : SUCCESS");
        String case4f = ("\nTEST CASE 3 : CLOSING TABS QUITS THE APPLICATION" + "\nTESTED URL  :" +" Dashboard" + "\nUSER        : STORE MANAGER " + "\nRESULT      : FAIL");
        String currentURL = Driver.getDriver().getCurrentUrl();
        if (currentURL.contains(ConfigurationReader.getProperty("logIn_pageUrl"))) {
            System.out.println(case4s);
        } else {
            System.out.println(case4f);
        }

    }



    @AfterMethod
    public void ending() {
        Driver.closeDriver();
    }
}

/*
User Story :
As a user I should be able to log out

Acceptance Criteria:
1- (+) User can log out by using log out button inside profile info and ends up in login page.  (+) User should land on "Login" page after logs out  (+)

2- (+) The user can not go to the home page again by clicking the step back button after successfully logged out.

3- (+) The user must be logged out if the user close the tab (if there are multiple open tabs in the app, close all of them)

4- (+) The user must be logged out if the user is away from keyboard for 3 minutes (AFK)
(if the user does not do any  mouse or keyboard action for 3 minutes)
 */