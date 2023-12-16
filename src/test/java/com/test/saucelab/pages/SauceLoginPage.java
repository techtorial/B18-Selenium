package com.test.saucelab.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SauceLoginPage {

    public SauceLoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "#user-name")
    WebElement username;
    @FindBy(css = "#password")
    WebElement password;
    @FindBy(css = "#login-button")
    WebElement login;

    public void login(String name,String password) throws InterruptedException {
        username.sendKeys(name);
        Thread.sleep(1000);
        this.password.sendKeys(password);
        login.click();
    }
}
