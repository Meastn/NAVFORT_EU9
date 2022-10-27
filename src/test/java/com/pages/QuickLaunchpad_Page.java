package com.pages;

import com.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class QuickLaunchpad_Page {

    public QuickLaunchpad_Page () {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath = "//h1[.='Quick Launchpad']")
    public WebElement quickLaunchPadPageTitle;

    @FindBy (xpath = "//a[@class='dropdown-toggle']")
    public WebElement displayDropdown;

    @FindBy (xpath = "//a[@class='no-hash']")
    public WebElement selectLogout;

}
/*
    User Story :
        As a user I should be able to log out

        Acceptance Criteria:
        1- User can log out by using log out button inside profile info and ends up in login page.

        2-User should land on "Login" page after logs out

        3- The user can not go to the home page again by clicking the step back button after successfully logged out.

        4- The user must be logged out if the user close the tab (if there are multiple open tabs in the app, close all of them)

        5- The user must be logged out if the user is away from keyboard for 3 minutes (AFK)
        (if the user does not do any  mouse or keyboard action for 3 minutes)

 */