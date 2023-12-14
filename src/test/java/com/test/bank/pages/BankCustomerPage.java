package com.test.bank.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

public class BankCustomerPage {

    public BankCustomerPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "userSelect")
    WebElement yourNameBox;
    @FindBy(xpath = "//button[.='Login']")
    WebElement loginButton;
    @FindBy(xpath = "//strong[contains(text(),'Welcome')]")
    WebElement welcomeHeader;
    @FindBy(xpath = "//strong[2]")
    WebElement balance;
    @FindBy(xpath = "//strong[3]")
    WebElement currency;
    @FindBy(xpath = "//button[contains(text(),'Deposit')]")
    WebElement depositButton;
    @FindBy(xpath = "//input[@placeholder='amount'] ")
    WebElement amount;
    @FindBy(xpath = "//button[@type='submit'] ")
    WebElement submitButton;
    @FindBy(xpath = "//span[@ng-show='message']")
    WebElement message;
    @FindBy(xpath = "//button[contains(text(),'Withdrawl')]")
    WebElement withdrawalButton;
    @FindBy(xpath = "//button[contains(text(),'Transactions')]")
    WebElement transactionButton;
    @FindBy(xpath = "//tr[@id='anchor0']//td[2]")
    WebElement firstTransaction;
    @FindBy(xpath = "//tr[@id='anchor1']//td[2]")
    WebElement secondTransaction;

    public void loginWithCustomer(String customerName){
        BrowserUtils.selectBy(this.yourNameBox,customerName,"text");
        loginButton.click();
    }

    public void accountGeneralInformation(String expectedHeader,String expectedBalance,String expectedCurrency){
        Assert.assertEquals(BrowserUtils.getText(welcomeHeader),expectedHeader);
        Assert.assertEquals(BrowserUtils.getText(balance),expectedBalance);
        Assert.assertEquals(BrowserUtils.getText(currency),expectedCurrency);
    }
    public void depositProcess(String amount,String expectedMessage,String expectedColor) throws InterruptedException {
        depositButton.click();
        this.amount.sendKeys(amount);
        submitButton.click();
        Thread.sleep(1000);
        Assert.assertEquals(BrowserUtils.getText(message),expectedMessage);
        Assert.assertEquals(message.getCssValue("color"),expectedColor);
        Thread.sleep(1000);
    }

    public void withdrawalProcess(String amount,String expectedMessage,String expectedColor) throws InterruptedException {
        withdrawalButton.click();
        Thread.sleep(1000);
        this.amount.sendKeys(amount);
        submitButton.click();
        Assert.assertEquals(BrowserUtils.getText(message),expectedMessage);
        Assert.assertEquals(message.getCssValue("color"),expectedColor);
    }

    public void transactionFunctionality() throws InterruptedException {
        Thread.sleep(3000);
        int balance=Integer.parseInt(BrowserUtils.getText(this.balance));
        transactionButton.click();
        Thread.sleep(5000);
        int actualBalance=Integer.parseInt(BrowserUtils.getText(firstTransaction))-
                Integer.parseInt(BrowserUtils.getText(secondTransaction));
        Assert.assertEquals(actualBalance,balance);
    }



    /*
    1-create a test case like validateBankTransaction
    2-Copy everything from testCase3 from ManagerTest to here
    3-Click Home Button
    4-Click Customer Login
    5-Find your name from list and click login
    6-Validate Welcome yourName !!
    7-Validate Balance is 0 and Currency is Dollar
    8-Click Deposit Button
    9-Provide amount 500 and validate "Deposit Successful" and color is red
    10-Click withdrawl button
    11-Provide amount 300 and validate "Transaction successful and color is red
    12-Store the balance 200 in int variable.
    13-Click Transaction
    14-Get the amount 500 and substract from 300 from list and validate actual and
    expected are matching (int variable value should equal the substraction amount)
    15-driver.quit
     */
}
