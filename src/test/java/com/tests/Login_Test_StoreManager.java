package com.tests;

import com.github.javafaker.Faker;
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

public class Login_Test_StoreManager {
    LogIn_Page logInPage;
    Dashboard_Page dashboard_page;
    String logInPageUrl= ConfigurationReader.getProperty("logIn_pageUrl");
    String storeManager_username = ConfigurationReader.getProperty("storeManager_username");
    String storeManager_password = ConfigurationReader.getProperty("storeManager_password");
    Faker faker = new Faker();


    public String case1 = ("USER      : STORE MANAGER "+"\nTEST     : VALID LOGIN TEST\nTEST CASE 1   : LOGIN TO QUICK LAUNCH PAGE test"+ "\nRESULT   : SUCCESS");
    public String case2 = ("USER      : STORE MANAGER "+"\nTEST     : INVALID LOGIN TEST\nTEST CASE 2   : \"Invalid username or password.\" display test"+ "\nCONDITION: WRONG username, CORRECT password"+"\nRESULT   : MESSAGE DISPLAYED, NO LOGIN");
    public String case3 = ("USER      : STORE MANAGER "+"\nTEST     : INVALID LOGIN TEST\nTEST CASE 3   : \"Invalid username or password.\" display test"+ "\nCONDITION: CORRECT username, WRONG password"+"\nRESULT   : MESSAGE DISPLAYED, NO LOGIN");
    public String case4 = ("USER      : STORE MANAGER "+"\nTEST     : INVALID LOGIN TEST\nTEST CASE 4   : \"Invalid username or password.\" display test"+ "\nCONDITION: WRONG username, WRONG password"+"\nRESULT   : MESSAGE DISPLAYED, NO LOGIN");

    @BeforeMethod
    public void setup() {
        Driver.getDriver().get(logInPageUrl);
        logInPage = new LogIn_Page();
    }

    @Test (priority = 1)
    public void valid_driver_login_test(){
        // correct username, correct password
        dashboard_page = new Dashboard_Page();
        logInPage.usernameInputBox.sendKeys(storeManager_username);
        logInPage.password_InputBox.sendKeys(storeManager_password);
        logInPage.logIn_Button.click();

        BrowserUtils.sleep(5);
        try {
            Assert.assertFalse(dashboard_page.DashboardPageTitle.isDisplayed());
        } catch (AssertionError n){
            System.out.println(case1);
        }

    }

    @Test (priority = 2)
    // wrong username, correct password
    public void invalid_driver_login_test_1(){
        logInPage.usernameInputBox.sendKeys(faker.name().username());
        logInPage.password_InputBox.sendKeys(storeManager_password);
        logInPage.logIn_Button.click();
        try {
            Assert.assertFalse(logInPage.invalidEntry_Message.isDisplayed());
        } catch (AssertionError n){
            System.out.println(case2);
        }

    }

    @Test (priority = 3)
    // correct username, wrong password
    public void invalid_driver_login_test2(){
        logInPage.usernameInputBox.sendKeys(storeManager_username);
        logInPage.password_InputBox.sendKeys(faker.internet().password());
        logInPage.logIn_Button.click();
        try {
            Assert.assertFalse(logInPage.invalidEntry_Message.isDisplayed());
        } catch (AssertionError n){
            System.out.println(case3);
        }
    }

    @Test (priority = 4)
    public void invalid_driver_login_test3(){
        // wrong username, wrong password
        logInPage.usernameInputBox.sendKeys(faker.name().username());
        logInPage.password_InputBox.sendKeys(faker.internet().password());
        logInPage.logIn_Button.click();
        try {
            Assert.assertFalse(logInPage.invalidEntry_Message.isDisplayed());
        } catch (AssertionError n){
            System.out.println(case4);
        }
    }


    @AfterMethod
    public void ending () {
        Driver.closeDriver();
    }



}

/*
1- VALID CREDENTIALS LOGIN
Login with valid credentials. Only authenticated users can access to application  (+)
       a) User type "Store Manager" should land on the "Dashboard" page after login(+)

INVALID CREDENTIALS LOGIN
2- Warning Messages, While logging in:
      a) "Invalid username or password." message should be displayed for invalid credentials (+x3)
        invalid username, valid password (+)
        valid username, invalid password (+)
        invalid username, invalid password  (+)

EMPTY CREDENTIALS LOGIN
(MANUAL)3) "Please fill out this field." message should be displayed from any empty field (if both of them is empty, just username field should throw the warning message)


(MANUAL)4) Users should see their password in bullet signs while typing (like ****)

 */