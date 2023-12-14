package com.test.blaze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BlazeCartPage {

    public BlazeCartPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//button[.='Place Order']")
    WebElement placeOrderButton;

    public void clickPlaceOrderButton(){
        placeOrderButton.click();
    }
}
