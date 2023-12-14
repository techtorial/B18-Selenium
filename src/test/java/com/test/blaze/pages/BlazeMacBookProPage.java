package com.test.blaze.pages;

import com.test.blaze.tests.BlazeMacBookProTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

public class BlazeMacBookProPage {

    public BlazeMacBookProPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(tagName = "h2")
    WebElement header;
    @FindBy(tagName = "h3")
    WebElement price;
    @FindBy(xpath = "//div[@id='more-information']//p")
    WebElement productDescription;
    @FindBy(linkText = "Add to cart")
    WebElement addToCartButton;

    public void productInformation(WebDriver driver,String expectedHeader,String expectedPrice,String expectedDescription,String expectedMessage) throws InterruptedException {
        Assert.assertEquals(BrowserUtils.getText(header),expectedHeader);
        Assert.assertEquals(BrowserUtils.getText(price),expectedPrice);
        Assert.assertTrue(BrowserUtils.getText(productDescription).contains(expectedDescription));
        addToCartButton.click();
        Thread.sleep(1000);
        Alert alert=driver.switchTo().alert();
        Assert.assertEquals(alert.getText(),expectedMessage);
        alert.accept();
    }







}
