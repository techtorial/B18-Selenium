package com.test.spruce.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

public class SpruceSeaFoodPage {

    public SpruceSeaFoodPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "#search-form-input")
    WebElement searchBar;

    @FindBy(xpath = "//label[@for='starRating_score_4Star']")
    WebElement fourStar;

    @FindBy(xpath = "//label[@for='pop_search_editor']")
    WebElement firstEditorBox;

    @FindBy(xpath = "//h4[@class='card__title']")
    WebElement foodHeader;

    public void searchForValue(WebDriver driver,String expectedValue){
        BrowserUtils.scrollIntoView(driver,searchBar);
        searchBar.sendKeys(expectedValue, Keys.ENTER);
    }

    public void productInformation(String expectedValue) throws InterruptedException {
        fourStar.click();
        Thread.sleep(1000);
        firstEditorBox.click();
        Thread.sleep(1000);
        Assert.assertEquals(BrowserUtils.getText(foodHeader),expectedValue);
    }

}
