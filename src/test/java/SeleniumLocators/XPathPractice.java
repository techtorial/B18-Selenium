package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XPathPractice {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("http://tutorialsninja.com/demo/index.php?route=account/register");
        WebElement firstName=driver.findElement(By.xpath("//input[@id='input-firstname']"));
        firstName.sendKeys("Ahmet");
        WebElement lastName=driver.findElement(By.xpath("//input[@name='lastname']"));
        lastName.sendKeys("Baldir");
        WebElement email=driver.findElement(By.xpath("//input[@type='email']"));
        email.sendKeys("ahmetasdasd12@gmail.com");
        WebElement telephone=driver.findElement(By.xpath("//input[@placeholder='Telephone']"));
        telephone.sendKeys("2433423423423");
        WebElement password=driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("ahmet1234");
        WebElement confirmPassword=driver.findElement(By.xpath("//input[@name='confirm']"));
        confirmPassword.sendKeys("ahmet1234");
        WebElement privacyPolicy=driver.findElement(By.xpath("//input[@name='agree']"));
        if(privacyPolicy.isDisplayed()&&!privacyPolicy.isSelected()){
            privacyPolicy.click();
        }
        Thread.sleep(3000);
        WebElement continueButton=driver.findElement(By.xpath("//input[@value='Continue']"));
        continueButton.click();
        WebElement header=driver.findElement(By.xpath("//h1[contains(text(),'Created!')]"));
        String actualHeader=header.getText().trim();
        String expectedHeader="Your Account Has Been Created!";
        System.out.println(actualHeader.equals(expectedHeader)? "Account Created":"Account Not Created");
        WebElement continueButton2=driver.findElement(By.xpath("//a[.='Continue']"));
        continueButton2.click();
        String actualUrl=driver.getCurrentUrl();
        String expectedUrl="https://tutorialsninja.com/demo/index.php?route=account/account";
        System.out.println(actualUrl.equals(expectedUrl)? "URL PASSED":"URL FAILED");
        Thread.sleep(5000);
        driver.close();





    }


/*
   1-Navigate to the website http://tutorialsninja.com/demo/index.php?route=account/register
   2-Provide First name,LastName,Email,Telephone,password,confirm password
   and click privacy policy button.(isDisplayed and notSelected then click)
   3-Click Continue Button
   4-Validate message (Your Account Has Been Created!) -->if statement
   5-Click Continue Button
   6-Validate the url https://tutorialsninja.com/demo/index.php?route=account/account
   7-Close your browser
   NOTE:Please USE ALL XPATH TO LOCATE THE ELEMENT
    */


}
