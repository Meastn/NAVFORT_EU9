package com.pages;

import com.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dashboard_Page {

    public Dashboard_Page (){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath = "//h1[@class='oro-subtitle']")
    public WebElement DashboardPageTitle;

    @FindBy (xpath = "//a[@class='dropdown-toggle']")
    public WebElement displayDropdown;



    @FindBy (xpath = "//a[@class='no-hash']")
    public WebElement selectLogout;

}
