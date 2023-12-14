package com.test.bank.tests;

import com.test.bank.pages.BankLoginPage;
import com.test.bank.pages.BankManagerPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import utils.ConfigReader;

import java.time.Duration;

public class BankManagerTest extends BankTestBase{

    @Test
    public void validateAddCustomerFunctionality() throws InterruptedException {
//        WebDriver driver=new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        BankLoginPage bankLoginPage=new BankLoginPage(driver);
        bankLoginPage.clickManagerLogin();
        BankManagerPage bankManagerPage=new BankManagerPage(driver);
        bankManagerPage.addCustomerFunctionality(driver, ConfigReader.readProperty("bankFirstName"),
                ConfigReader.readProperty("bankLastName"),ConfigReader.readProperty("bankZipCode"), "Customer added successfully");
    }

    @Test
    public void validateOpenAccountFunctionality() throws InterruptedException {
//        WebDriver driver=new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        BankLoginPage bankLoginPage=new BankLoginPage(driver);
        bankLoginPage.clickManagerLogin();
        BankManagerPage bankManagerPage=new BankManagerPage(driver);
        bankManagerPage.addCustomerFunctionality(driver,"Ahmet","Baldir","52454", "Customer added successfully");
        bankManagerPage.openAccountFunctionality(driver,"Ahmet Baldir","Dollar","Account created successfully with account Number :");
    }

    @Test
    public void validateCustomersFunctionality() throws InterruptedException {
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

    }
    /*TASK 1:
    Create another TestCase for OpenAccountFunctionality
    1-Copy everything from First Test to Second Test and continue with Open Account
    2-Choose your name from list
    3-Choose Currency Dolar
    4-Click Process button
    5-Validate(contains) "Account created successfully"
    6-driver.quit

    TASK 2:
    Create another TestCase for Customers
    1-Copy everything from Second Test to Third Test and continue with Customers
    2-Search your name from Search bar
    3-Validate Firstname,LastName and ZipCode (Use Arrays.Aslist)
    4-driver.quit
     */



}
