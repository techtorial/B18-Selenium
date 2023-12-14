package com.test.blaze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

public class BlazeOrderPage {

    public BlazeOrderPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(css = "#name")
    WebElement name;
    @FindBy(css = "#country")
    WebElement country;
    @FindBy(css = "#city")
    WebElement city;
    @FindBy(css = "#card")
    WebElement card;
    @FindBy(css = "#month")
    WebElement month;
    @FindBy(css = "#year")
    WebElement year;
    @FindBy(xpath = "//button[.='Purchase']")
    WebElement purchaseButton;
    @FindBy(xpath = "//h2[contains(text(),'Thank you')]")
    WebElement purchaseMessage;
    @FindBy(xpath = "//button[.='OK']")
    WebElement okButton;

    public void orderFunctionality(WebDriver driver,String name,String country,String city,String card,String month,
                                   String year,String expectedMessage,String expectedUrl) throws InterruptedException {
        this.name.sendKeys(name);
        this.country.sendKeys(country);
        Thread.sleep(1000);
        this.city.sendKeys(city);
        this.card.sendKeys(card);
        this.month.sendKeys(month);
        this.year.sendKeys(year);
        Thread.sleep(1000);
        purchaseButton.click();
        Assert.assertEquals(BrowserUtils.getText(purchaseMessage),expectedMessage);
        Thread.sleep(1000);
        okButton.click();
        Assert.assertEquals(driver.getCurrentUrl(),expectedUrl);
    }
}
