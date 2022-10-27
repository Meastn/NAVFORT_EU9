package com.tests;

import com.github.javafaker.Faker;
import com.pages.LogIn_Page;
import com.pages.QuickLaunchpad_Page;
import com.utilities.BrowserUtils;
import com.utilities.ConfigurationReader;
import com.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RememberMe_Test {

    LogIn_Page logInPage;
    QuickLaunchpad_Page quickLaunchpad_page;
    String logInPageUrl= ConfigurationReader.getProperty("logIn_pageUrl");
    String driver_username = ConfigurationReader.getProperty("driver_username");
    String driver_password = ConfigurationReader.getProperty("driver_password");
    Faker faker = new Faker();

    @BeforeMethod
    public void setup() {
        Driver.getDriver().get(logInPageUrl);
        logInPage = new LogIn_Page();
    }
    @Test(priority = 1)
    public void valid_driver_rememberMe_test() {
        // correct username, correct password, no logout
        quickLaunchpad_page = new QuickLaunchpad_Page();
        logInPage.usernameInputBox.sendKeys(driver_username);
        logInPage.password_InputBox.sendKeys(driver_password);
        logInPage.rememberMeCheckBox.click();
        logInPage.logIn_Button.click();
        BrowserUtils.sleep(5);

        Driver.closeDriver();
    }

    @Test(priority = 2)
    public void existing_credentials_test(){
        // correct username, correct password no logout remember me test
        String actualUsernameInput = logInPage.usernameInputBox.getAttribute("value");
        String expectedUsernameInput = driver_username;
        String actualPasswordInput = logInPage.password_InputBox.getAttribute("value");
        String expectedPasswordInput = driver_password;
        try {
            Assert.assertTrue(actualUsernameInput.equals(expectedUsernameInput));
        } catch (AssertionError n){
            System.out.println("TEST CASE 1   : RETRIEVE USERNAME AFTER REMEMBER ME CHOSEN \nCONDITION     : USER DO NOT LOGS OUT \nRESULT        : FAIL");
        }

        try {
            Assert.assertTrue(actualPasswordInput.equals(expectedPasswordInput));
        } catch (AssertionError n){
            System.out.println("TEST CASE 2   : RETRIEVE PASSWORD AFTER REMEMBER ME CHOSEN \nCONDITION     : USER DO NOT LOGS OUT \nRESULT        : FAIL");
        }
        Driver.closeDriver();

    }
    @Test (priority = 3)
    public void valid_driver_rememberMe_after_logout_test() {
        // correct username, correct password, no logout
        quickLaunchpad_page = new QuickLaunchpad_Page();
        logInPage.usernameInputBox.sendKeys(driver_username);
        logInPage.password_InputBox.sendKeys(driver_password);
        logInPage.rememberMeCheckBox.click();
        logInPage.logIn_Button.click();
        BrowserUtils.sleep(5);
        quickLaunchpad_page.displayDropdown.click();
        quickLaunchpad_page.selectLogout.click();
        Driver.closeDriver();
    }

    @Test(priority = 4)
    public void existing_credentials_after_logout_test(){
        // correct username, correct password no logout remember me test
        String actualUsernameInput = logInPage.usernameInputBox.getAttribute("value");
        String expectedUsernameInput = driver_username;
        String actualPasswordInput = logInPage.password_InputBox.getAttribute("value");
        String expectedPasswordInput = driver_password;
        try {
            Assert.assertTrue(actualUsernameInput.equals(expectedUsernameInput));
        } catch (AssertionError n){
            System.out.println("TEST CASE 3   : RETRIEVE USERNAME AFTER REMEMBER ME CHOSEN \nCONDITION     : USER LOGGED OUT \nRESULT        : FAIL");
        }

        try {
            Assert.assertTrue(actualPasswordInput.equals(expectedPasswordInput));
        } catch (AssertionError n){
            System.out.println("TEST CASE 4   : RETRIEVE PASSWORD AFTER REMEMBER ME CHOSEN \nCONDITION     : USER LOGGED OUT \nRESULT        : FAIL");
        }
        Driver.closeDriver();

    }


}
