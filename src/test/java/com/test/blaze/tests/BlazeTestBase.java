package com.test.blaze.tests;

import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.BrowserUtils;
import utils.ConfigReader;
import utils.DriverHelper;

public class BlazeTestBase {

    public WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver= DriverHelper.getDriver();
        driver.get(ConfigReader.readProperty("blazeurl"));
    }

    @AfterMethod
    public void tearDown(ITestResult iTestResult){
        if(!iTestResult.isSuccess()){
            BrowserUtils.getScreenShot(driver,"BlazeFailures");
        }
//        driver.quit();
    }
}
