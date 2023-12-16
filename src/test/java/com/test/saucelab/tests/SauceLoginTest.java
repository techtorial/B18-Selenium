package com.test.saucelab.tests;

import com.test.saucelab.pages.SauceLoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SauceLoginTest extends SauceLabTestBase{

    @Test(dataProvider = "positiveLogin",dataProviderClass = SauceAllData.class)
    public void validatePositiveLogin(String username,String password,String expectedUrl,String expectedTitle) throws InterruptedException {
        SauceLoginPage sauceLoginPage=new SauceLoginPage(driver);
        sauceLoginPage.login(username,password);
        Assert.assertEquals(driver.getCurrentUrl(),expectedUrl);
        Assert.assertEquals(driver.getTitle(),expectedTitle);
    }

    @Test(dataProvider = "negativeLogin",dataProviderClass = SauceAllData.class)
    public void validateNegativeLogin(String username,String password,String expectedMessage) throws InterruptedException {
        SauceLoginPage sauceLoginPage=new SauceLoginPage(driver);
        sauceLoginPage.login(username,password);
        Assert.assertEquals(sauceLoginPage.errorMessage(),expectedMessage);
    }


}
