package com.test.bank.tests;

import com.test.bank.pages.BankCustomerPage;
import com.test.bank.pages.BankLoginPage;
import com.test.bank.pages.BankManagerPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BankCustomerTest extends BankTestBase {

    @Test
    public void validateBankTransaction() throws InterruptedException {
        BankLoginPage bankLoginPage = new BankLoginPage(driver);
        bankLoginPage.clickManagerLogin();
        BankManagerPage bankManagerPage = new BankManagerPage(driver);
        bankManagerPage.addCustomerFunctionality(driver, "Ahmet", "Baldir", "52454", "Customer added successfully");
        bankManagerPage.openAccountFunctionality(driver, "Ahmet Baldir", "Dollar", "Account created successfully with account Number :");
        bankManagerPage.customersFunctionality("Ahmet", "Baldir", "52454");
        bankLoginPage.clickHomeButton();
        bankLoginPage.clickCustomerLogin();
        BankCustomerPage bankCustomerPage = new BankCustomerPage(driver);
        bankCustomerPage.loginWithCustomer("Ahmet Baldir");
        bankCustomerPage.accountGeneralInformation("Welcome Ahmet Baldir !!", "0", "Dollar");
        bankCustomerPage.depositProcess("500", "Deposit Successful", "rgba(255, 0, 0, 1)");
        bankCustomerPage.withdrawalProcess("300", "Transaction successful", "rgba(255, 0, 0, 1)");
        bankCustomerPage.transactionFunctionality();
    }

    @Parameters({"firstName", "lastName", "zipCode", "expectedMessageCustomer", "fullName", "currency", "expectedMessageAccount",
            "expectedHeader", "expectedBalance", "depositAmount", "expectedMessageDeposit", "expectedColor", "expectedWithdrawal",
            "expectedMessageWithDraw"})
    @Test
    public void validateBankTransaction1(String firstName, String lastName, String zipCode, String expectedMessageCustomer,
                                         String fullName, String currency, String expectedMessageAccount, String expectedHeader,
                                         String expectedBalance, String depositAmount, String expectedMessageDeposit,
                                         String expectedColor, String expectedWithdrawal, String expectedMessageWithDraw) throws InterruptedException {
        BankLoginPage bankLoginPage = new BankLoginPage(driver);
        bankLoginPage.clickManagerLogin();
        BankManagerPage bankManagerPage = new BankManagerPage(driver);
        bankManagerPage.addCustomerFunctionality(driver, firstName, lastName, zipCode, expectedMessageCustomer);
        bankManagerPage.openAccountFunctionality(driver, fullName, currency, expectedMessageAccount);
        bankManagerPage.customersFunctionality(firstName, lastName, zipCode);
        bankLoginPage.clickHomeButton();
        bankLoginPage.clickCustomerLogin();
        BankCustomerPage bankCustomerPage = new BankCustomerPage(driver);
        bankCustomerPage.loginWithCustomer(fullName);
        bankCustomerPage.accountGeneralInformation(expectedHeader, expectedBalance, currency);
        bankCustomerPage.depositProcess(depositAmount, expectedMessageDeposit, expectedColor);
        bankCustomerPage.withdrawalProcess(expectedWithdrawal, expectedMessageWithDraw, expectedColor);
        bankCustomerPage.transactionFunctionality();
    }
}
