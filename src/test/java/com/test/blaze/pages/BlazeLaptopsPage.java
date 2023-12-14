package com.test.blaze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.util.List;

public class BlazeLaptopsPage {

    public BlazeLaptopsPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//a[@class='hrefch']")
    List<WebElement> allProducts;

    public void chooseProduct(String expectedProduct) throws InterruptedException {
        Thread.sleep(1000);
        for(WebElement product:allProducts){
            if(BrowserUtils.getText(product).contains(expectedProduct)){
                product.click();
                break;
            }
        }
    }
}
