package com.pages;

import com.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogIn_Page {

    public LogIn_Page () {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy (xpath = "//input[@id='prependedInput']")
    public WebElement usernameInputBox;

    @FindBy (xpath="//input[@name='_password']")
    public WebElement password_InputBox;

    @FindBy (xpath ="//button[@name='_submit']")
    public WebElement logIn_Button;

    @FindBy (xpath="//div[.='Invalid user name or password.']")
    public WebElement invalidEntry_Message;

    @FindBy (xpath = "//a[@href='/user/reset-request']")
    public WebElement forgotPasswordLink;

    @FindBy (xpath = "//span[@class='custom-checkbox__icon']")
    public WebElement rememberMeCheckBox;

    @FindBy (xpath = "//h2[@class='title']")
    public WebElement loginPageHeader;




}


/*
User Story :
As a user, I should be able to login.

Acceptance Criteria:
1- Login with valid credentials. Only authenticated users can access to application
   (+)   a) User type "Driver" should land on the "Quick Launchpad" page after login
   (+)   b) User type "Sales Manager" should land on the "Dashboard" page after login
    (+)  c) User type "Store Manager" should land on the "Dashboard" page after login

2- Warning Messages, While logging in:
    (+)  a) "Invalid username or password." message should be displayed for invalid credentials


   (+)   b) "Please fill out this field." message should be displayed from any empty field (if both of them is empty, just username field should throw the warning message)
 -----MANUAL---
3- Users should see their password in bullet signs while typing (like ****)
-----------
----AUTOMATED----
4- "Forgot Password" menu
      (+)  a) User lands on the ‘Forgot Password’ page after clicking on the "Forgot your password?" link
     (+)  b) User can change his/her password with their username after clicking on "Forgot your password?" link

5(OK)- If "Remember me on this computer" checkbox is clicked, User can see his/her credentials already entered in the login page in their next attempt.

6 (+)- User can use "Enter" key from their keyboard to switch to next field / btn
(For example, click on "Username" input box and enter a username, hit the "Enter" button, then cursor appears on "Password" input box, enter a password and hit the "Enter" button again, "Login" button gets clicked)

7- User can see his own "username" (what he types in the username field) in the profile menu, after login

 */