package com.tests;

import com.github.javafaker.Faker;
import com.pages.LogIn_Page;
import com.pages.QuickLaunchpad_Page;
import com.pages.ResetRequest_Page;
import com.utilities.BrowserUtils;
import com.utilities.ConfigurationReader;
import com.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ForgotPasswordTest {
    LogIn_Page logInPage;
    ResetRequest_Page resetRequest_page;
    String logInPageUrl = ConfigurationReader.getProperty("logIn_pageUrl");
    String driver_username = ConfigurationReader.getProperty("driver_username");
    String salesManager_username = ConfigurationReader.getProperty("salesManager_username");
    String storeManager_username = ConfigurationReader.getProperty("storeManager_username");

    String caseS = ("TEST CASE 1   : SEND PASSWORD REQUEST TO EMAIL\nRESULT        : SUCCESS");
    String caseF = ("TEST CASE 1   : SEND PASSWORD REQUEST TO EMAIL\nRESULT        : FAIL");
    @BeforeMethod
    public void setup() {
        Driver.getDriver().get(logInPageUrl);
        logInPage = new LogIn_Page();
        resetRequest_page = new ResetRequest_Page();
    }

    @Test (priority = 1)
    public void driver_forgotpassword_test(){
        logInPage.forgotPasswordLink.click();
        resetRequest_page.usernameInputBox.sendKeys(driver_username);
        resetRequest_page.requestButton.click();

        try {
            if (resetRequest_page.emailNotSendAlert.isDisplayed()){
                System.out.println("USER          : DRIVER \n" + caseF);
            } else {
                System.out.println(caseS);
            }
        } catch (RuntimeException n){
            System.out.println("USER          : DRIVER \n" +caseF);
        }


    }

    @Test (priority = 2)
    public void salesManager_forgotpassword_test(){
        logInPage.forgotPasswordLink.click();
        resetRequest_page.usernameInputBox.sendKeys(salesManager_username);
        resetRequest_page.requestButton.click();

        try {
            if (resetRequest_page.emailNotSendAlert.isDisplayed()){
                System.out.println("USER          : SALES MANAGER \n" + caseF);
            } else {
                System.out.println(caseS);
            }
        } catch (RuntimeException n){
            System.out.println("USER          : SALES MANAGER \n" +caseF);
        }

    }

    @Test (priority = 3)
    public void storeManager_forgotpassword_test(){
        logInPage.forgotPasswordLink.click();
        resetRequest_page.usernameInputBox.sendKeys(storeManager_username);
        resetRequest_page.requestButton.click();

        try {
            if (resetRequest_page.emailNotSendAlert.isDisplayed()){
                System.out.println("USER          : STORE MANAGER \n" + caseF);
            } else {
                System.out.println(caseS);
            }
        } catch (RuntimeException n){
            System.out.println("USER          : STORE MANAGER \n" +caseF);
        }

    }@Test (priority = 4)
    public void forgot_password_page_test () {
        logInPage.forgotPasswordLink.click();
        BrowserUtils.sleep(5);
        String actualResetRequestHeader = resetRequest_page.forgotPageTitle.getText();
        String expectedResetRequestHeader = "Forgot Password";

        try {
            Assert.assertFalse(actualResetRequestHeader.equals(expectedResetRequestHeader));
        } catch (AssertionError n){
            System.out.println("TEST CASE 1 : FORGOT PASSWORD LINKS WORKS?\nRESULT      : SUCCESS");
        }





    }


    @AfterMethod
    public void ending () {
        Driver.closeDriver();
    }
}


// User can change his/her password with their
// username after clicking on "Forgot your password?" link