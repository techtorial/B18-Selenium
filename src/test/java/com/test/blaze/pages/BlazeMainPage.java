package com.test.blaze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.util.List;

public class BlazeMainPage {

    public BlazeMainPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//a[@id='itemc']")
    List<WebElement> allCategories;
    @FindBy(css = "#cartur")
    WebElement cartButton;

    public void chooseCategory(String expectedCategory) throws InterruptedException {

        for(WebElement category:allCategories){
            if(BrowserUtils.getText(category).equals(expectedCategory)){
                category.click();
                break;
            }
        }
    }
    public void clickCartButton(){
        cartButton.click();
    }

}
