package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsIntro2 {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("file:///Users/techtorialacademy/Downloads/Techtorialhtml.html");
        //TAGNAME LOCATOR:
        WebElement javaVersion=driver.findElement(By.tagName("u"));
        System.out.println(javaVersion.getText());

        //LINKTEXT LOCATOR:
        WebElement java=driver.findElement(By.linkText("Java"));
        java.click();
        WebElement header=driver.findElement(By.tagName("h1"));
        String actualHeader=header.getText().trim();
        String expectedHeader="Java";
        System.out.println(actualHeader.equals(expectedHeader) ? "Java Passed":"Java Failed");
        driver.navigate().back();
        WebElement selenium=driver.findElement(By.linkText("Selenium"));
        selenium.click();
        WebElement seleniumHeader=driver.findElement(By.tagName("h1"));
        System.out.println(seleniumHeader.getText().trim().equals("Selenium automates browsers. That's it!"));
        driver.navigate().back();

        //PARTIALLINKTEXT:
        WebElement restApi=driver.findElement(By.partialLinkText("Rest"));
        restApi.click();
        System.out.println(driver.getCurrentUrl());
        driver.navigate().back();

        //CSS:
        WebElement techtorialHeader=driver.findElement(By.cssSelector("#techtorial1"));
        System.out.println(techtorialHeader.getText());
        WebElement allTools=driver.findElement(By.cssSelector(".group_checkbox"));
        System.out.println(allTools.getText());

        /*
1-Click Selenium and validate(ternary) header -->Selenium automates browsers. That's it!
2-Go back to the main page
3-Click Cucumber and validate(ternary) header -->Tools & techniques that elevate teams to greatness
4-Go back to the main page
5-Click TestNG and validate(ternary) header -->TestNG
6-Go back to the main page
7-Validate(ternary) the url is "file:///Users/codefish/Downloads/Techtorial.html"
 */
    }
}
