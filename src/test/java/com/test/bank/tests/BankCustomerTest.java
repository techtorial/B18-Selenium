package com.test.bank.tests;

import com.test.bank.pages.BankCustomerPage;
import com.test.bank.pages.BankLoginPage;
import com.test.bank.pages.BankManagerPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class BankCustomerTest extends BankTestBase {

    @Test
    public void validateBankTransaction() throws InterruptedException {
//        WebDriver driver=new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        BankLoginPage bankLoginPage=new BankLoginPage(driver);
        bankLoginPage.clickManagerLogin();
        BankManagerPage bankManagerPage=new BankManagerPage(driver);
        bankManagerPage.addCustomerFunctionality(driver,"Ahmet","Baldir","52454", "Customer added successfully");
        bankManagerPage.openAccountFunctionality(driver,"Ahmet Baldir","Dollar","Account created successfully with account Number :");
        bankManagerPage.customersFunctionality("Ahmet","Baldir","52454");
        bankLoginPage.clickHomeButton();
        bankLoginPage.clickCustomerLogin();
        BankCustomerPage bankCustomerPage=new BankCustomerPage(driver);
        bankCustomerPage.loginWithCustomer("Ahmet Baldir");
        bankCustomerPage.accountGeneralInformation("Welcome Ahmet Baldir !!","0","Dollar");
        bankCustomerPage.depositProcess("500","Deposit Successful","rgba(255, 0, 0, 1)");
        bankCustomerPage.withdrawalProcess("300","Transaction successful","rgba(255, 0, 0, 1)");
        bankCustomerPage.transactionFunctionality();
    }
}
