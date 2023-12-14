package com.test.blaze.tests;

import com.test.blaze.pages.BlazeLaptopsPage;
import com.test.blaze.pages.BlazeMacBookProPage;
import com.test.blaze.pages.BlazeMainPage;
import org.testng.annotations.Test;

public class BlazeMacBookProTest extends BlazeTestBase{

    @Test
    public void validateMacBookProductInformation() throws InterruptedException {
        BlazeMainPage blazeMainPage=new BlazeMainPage(driver);
        blazeMainPage.chooseCategory("Laptops");
        BlazeLaptopsPage blazeLaptopsPage=new BlazeLaptopsPage(driver);
        blazeLaptopsPage.chooseProduct("MacBook Pro");
        BlazeMacBookProPage blazeMacBookProPage=new BlazeMacBookProPage(driver);
        blazeMacBookProPage.productInformation(driver,"MacBook Pro","$1100 *includes tax",
                "MacBook Pro","Product added");
    }
}
