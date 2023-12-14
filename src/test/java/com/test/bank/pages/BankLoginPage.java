package com.test.bank.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class BankLoginPage {

    public BankLoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//strong")
    WebElement header;
    @FindBy(xpath = "//button[.='Customer Login'] ")
    WebElement customerLoginButton;

    @FindBy(xpath = "//button[.='Bank Manager Login']")
    WebElement managerLoginButton;

    @FindBy(xpath = "//button[.='Home']")
    WebElement homeButton;

    public String headerFromLoginPage(){
        return BrowserUtils.getText(header);
    }
    public void clickCustomerLogin(){
        customerLoginButton.click();
    }
    public void clickManagerLogin(){
        managerLoginButton.click();
    }
    public void clickHomeButton(){
        homeButton.click();
    }

}
