package com.tests;

import com.pages.Dashboard_Page;
import com.pages.LogIn_Page;
import com.pages.QuickLaunchpad_Page;
import com.utilities.BrowserUtils;
import com.utilities.ConfigurationReader;
import com.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogoutNoReturn_Test {
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

    public String case1s = ("USER      : DRIVER " + "\nTEST CASE 4     : AFTER LOGOUT USER CAN NOT RETURN TO MAIN PAGE\nRESULT   : SUCCESS");
    public String case1f = ("USER      : DRIVER " + "\nTEST CASE 4     : AFTER LOGOUT USER CAN NOT RETURN TO MAIN PAGE\nRESULT   : FAIL");
    public String case2s = ("USER      : SALES MANAGER " + "\nTEST CASE 5    : AFTER LOGOUT USER CAN NOT RETURN TO MAIN PAGE\nRESULT   : SUCCESS");
    public String case2f = ("USER      : SALES MANAGER " + "\nTEST CASE 5     : AFTER LOGOUT USER CAN NOT RETURN TO MAIN PAGE\nRESULT   : FAIL");
    public String case3s = ("USER      : STORE MANAGER " + "\nTEST CASE 6     : AFTER LOGOUT USER CAN NOT RETURN TO MAIN PAGE\nRESULT   : SUCCESS");
    public String case3f = ("USER      : STORE MANAGER " + "\nTEST CASE 6     : AFTER LOGOUT USER CAN NOT RETURN TO MAIN PAGE\nRESULT   : FAIL");

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
        Driver.getDriver().navigate().back();
        String actualURL = Driver.getDriver().getCurrentUrl();
        String expectedURl = ConfigurationReader.getProperty("logIn_pageUrl");

        if(actualURL.equals(expectedURl)){
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

        Driver.getDriver().navigate().back();
        String actualURL = Driver.getDriver().getCurrentUrl();
        String expectedURl = ConfigurationReader.getProperty("logIn_pageUrl");

        if(actualURL.equals(expectedURl)){
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

        Driver.getDriver().navigate().back();
        String actualURL = Driver.getDriver().getCurrentUrl();
        String expectedURl = ConfigurationReader.getProperty("logIn_pageUrl");

        if(actualURL.equals(expectedURl)){
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
