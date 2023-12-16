package com.test.saucelab.tests;

import com.test.saucelab.pages.SauceInventoryPage;
import com.test.saucelab.pages.SauceLoginPage;
import org.testng.annotations.Test;
import utils.ConfigReader;

public class SauceInventoryTest extends SauceLabTestBase{

    @Test(dataProvider = "productinformation",dataProviderClass = SauceAllData.class)
    public void validateProductInformation(String expectedHeader,String expectedDescription,String expectedPrice) throws InterruptedException {
        SauceLoginPage sauceLoginPage=new SauceLoginPage(driver);
        sauceLoginPage.login(ConfigReader.readProperty("sauce_username"),
                             ConfigReader.readProperty("sauce_password"));
        SauceInventoryPage sauceInventoryPage=new SauceInventoryPage(driver);
        sauceInventoryPage.chooseItem(expectedHeader);
        sauceInventoryPage.productInformation(expectedHeader,expectedDescription,expectedPrice);
    }
}
