package com.test.bank.tests;

import com.test.bank.pages.BankLoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class BankLoginTest extends BankTestBase{

    @Parameters({"header","url"})
    @Test
    public void validateHeaderTitleAndURL(String header,String url){
//        WebDriver driver=new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        BankLoginPage bankLoginPage=new BankLoginPage(driver);
        Assert.assertEquals(bankLoginPage.headerFromLoginPage(),header);
        Assert.assertEquals(driver.getTitle(),header);
        Assert.assertEquals(driver.getCurrentUrl(),url);
    }
}
