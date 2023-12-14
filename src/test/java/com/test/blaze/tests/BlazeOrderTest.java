package com.test.blaze.tests;

import com.test.blaze.pages.*;
import org.testng.annotations.Test;

public class BlazeOrderTest extends BlazeTestBase{

    @Test
    public void validateOrderFunctionality() throws InterruptedException {
        BlazeMainPage blazeMainPage=new BlazeMainPage(driver);
        blazeMainPage.chooseCategory("Laptops");
        BlazeLaptopsPage blazeLaptopsPage=new BlazeLaptopsPage(driver);
        blazeLaptopsPage.chooseProduct("MacBook Pro");
        BlazeMacBookProPage blazeMacBookProPage=new BlazeMacBookProPage(driver);
        blazeMacBookProPage.productInformation(driver,"MacBook Pro","$1100 *includes tax",
                "MacBook Pro","Product added");
        blazeMainPage.clickCartButton();
        BlazeCartPage blazeCartPage=new BlazeCartPage(driver);
        blazeCartPage.clickPlaceOrderButton();
        BlazeOrderPage blazeOrderPage=new BlazeOrderPage(driver);
        blazeOrderPage.orderFunctionality(driver,"Ahmet","USA","CHICAGO","12324535",
                "12","2025","Thank you for your purchase!","https://www.demoblaze.com/index.html");
    }
}
