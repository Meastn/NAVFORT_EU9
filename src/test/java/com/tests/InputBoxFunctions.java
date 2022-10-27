package com.tests;

import com.github.javafaker.Faker;
import com.pages.LogIn_Page;
import com.pages.QuickLaunchpad_Page;
import com.utilities.ConfigurationReader;
import com.utilities.Driver;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class InputBoxFunctions {
    LogIn_Page logInPage;
    QuickLaunchpad_Page quickLaunchpad_page;
    String logInPageUrl= ConfigurationReader.getProperty("logIn_pageUrl");
    String driver_username = ConfigurationReader.getProperty("driver_username");
    String driver_password = ConfigurationReader.getProperty("driver_password");
    Faker faker = new Faker();

    public String case1 = ("USER      : DRIVER "+"\nTEST     : EMPTY CREDENTIALS LOGIN TEST\nTEST CASE 1   : \"Please fill out this field.\" desplay test"+ "\nRESULT   : SUCCESS");

    @BeforeMethod
    public void setup() {
        Driver.getDriver().get(logInPageUrl);
        logInPage = new LogIn_Page();
    }

    @Test(priority = 1)
    public void empty_credentials_test (){
        logInPage.usernameInputBox.sendKeys(Keys.RETURN);
        boolean requiredUsername = Boolean.parseBoolean(logInPage.usernameInputBox.getAttribute("required"));
        if (requiredUsername){
            System.out.println("TEST CASE 1   : FILL OUT USERNAME FIELD WARNING"+ "\nRESULT        : SUCCESS");
        } else {
            System.out.println("TEST CASE 1   : FILL OUT USERNAME FIELD WARNING"+ "\nRESULT        : FAIL");
        }
        boolean requiredPassword = Boolean.parseBoolean(logInPage.password_InputBox.getAttribute("required"));
        if (requiredPassword){
            System.out.println("TEST CASE 2   : FILL OUT PASSWORD FIELD WARNING"+ "\nRESULT        : SUCCESS");
        } else {
            System.out.println("TEST CASE 2   : FILL OUT PASSWORD FIELD WARNING"+ "\nRESULT        : FAIL");
        }

    }

    @Test (priority = 2)
    public void switch_to_password_Input_box_test(){
        // CLICKING ENTER Key in the USERNAME Input Box will check if it switched to
        // the PASSWORD Input Box or not
        logInPage.usernameInputBox.sendKeys(Keys.ENTER);
        String actualActiveInputBox = logInPage.password_InputBox.getAttribute("name");
        String expectedActiveInputBox = Driver.getDriver().switchTo().activeElement().getAttribute("name");
        String case1a = ("USER          : DRIVER "+"\nTEST CASE 3   : SWITCH FROM USERNAME INPUT BOX TO PASSWORD INPUT BOX (RETURN KEY)"+ "\nRESULT        : SUCCESS");
        String case1b = ("USER          : DRIVER "+"\nTEST CASE 3   : SWITCH FROM USERNAME INPUT BOX TO PASSWORD INPUT BOX (RETURN KEY)"+ "\nRESULT        : FAILED");
        try {

            if (expectedActiveInputBox.equals(actualActiveInputBox)) {
                System.out.println(case1a);
            } else {
                System.out.println(case1b);
            }
        } catch (RuntimeException n){
        }
    }

    @Test (priority = 3)
    public void switch_to_username_Input_box_test(){
        // CLICKING ENTER Key in the Password Input Box will check if it switched to
        // the USERNAME Input Box or not
        logInPage.password_InputBox.sendKeys(Keys.ENTER);
        String expectedActiveInputBox = logInPage.usernameInputBox.getAttribute("name");
        String actualActiveInputBox = Driver.getDriver().switchTo().activeElement().getAttribute("name");

        String case1a = ("USER          : DRIVER "+"\nTEST CASE 4   : SWITCH FROM PASSWORD INPUT BOX TO USERNAME INPUT BOX (RETURN KEY)"+ "\nRESULT        : SUCCESS");
        String case1b = ("USER          : DRIVER "+"\nTEST CASE 4   : SWITCH FROM PASSWORD INPUT BOX TO USERNAME INPUT BOX (RETURN KEY)"+ "\nRESULT        : FAILED");
        try {

            if (expectedActiveInputBox.equals(actualActiveInputBox)) {
                System.out.println(case1a);
            } else {
                System.out.println(case1b);
            }
        } catch (RuntimeException n){
        }
        }

    @AfterMethod
    public void ending () {
        Driver.closeDriver();
    }
    }
/*
    User can use "Enter" key from their keyboard to switch to next field / btn
        (For example, click on "Username" input box and enter a username,
         hit the "Enter" button, then cursor appears on "Password" input box,
         enter a password and hit the "Enter" button again,
         "Login" button gets clicked)

 */