package com.pages;

import com.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResetRequest_Page {

    public ResetRequest_Page(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath ="//input[@name='username']")
    public WebElement usernameInputBox;

    @FindBy (xpath = "//button[@class='btn extra-submit btn-uppercase btn-primary']")
    public WebElement requestButton;

    @FindBy (xpath ="//div[@class='alert alert-warn']")
    public WebElement emailNotSendAlert;

    @FindBy (xpath ="//h2[@class='title']")
    public WebElement forgotPageTitle;
}

// User can change his/her password with their
// username after clicking on "Forgot your password?" link