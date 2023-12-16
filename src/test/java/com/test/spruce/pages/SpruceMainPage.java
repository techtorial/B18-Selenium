package com.test.spruce.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SpruceMainPage {

    public SpruceMainPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//span[.='Ingredients']")
    WebElement ingredients;
    @FindBy(xpath = "//a[.='Fish & Seafood']")
    WebElement fishAndSeaFood;

    public void chooseFishSeaFood(WebDriver driver) throws InterruptedException {
        Actions actions=new Actions(driver);
        Thread.sleep(1000);
        actions.moveToElement(ingredients).perform();
        Thread.sleep(1000);
        actions.click(fishAndSeaFood).perform();
        Thread.sleep(1000);
    }
}
