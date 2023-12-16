package com.test.spruce.tests;

import com.test.spruce.pages.SpruceMainPage;
import com.test.spruce.pages.SpruceSeaFoodPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SpruceSeaFoodTest extends SpruceTestBase {
    @Parameters({"search","expectedHeader"})
    @Test
    public void validateTheSeaFoodProduct(String search,String expectedHeader) throws InterruptedException {
        SpruceMainPage spruceMainPage=new SpruceMainPage(driver);
        spruceMainPage.chooseFishSeaFood(driver);
        SpruceSeaFoodPage spruceSeaFoodPage=new SpruceSeaFoodPage(driver);
        spruceSeaFoodPage.searchForValue(driver,search);
        spruceSeaFoodPage.productInformation(expectedHeader);
    }
}
