package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsIntro {

    //Locator:Is a way to locate(find) the element and manipulate on it

    public static void main(String[] args) {
        //ID LOCATOR:
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("file:///Users/techtorialacademy/Downloads/Techtorialhtml.html");
        WebElement header=driver.findElement(By.id("techtorial1"));
        System.out.println(header.getText());
        WebElement paragraph=driver.findElement(By.id("details2"));
        System.out.println(paragraph.getText());
        //NAME LOCATOR:
        WebElement firstName=driver.findElement(By.name("firstName"));
        System.out.println(firstName.getText());
        firstName.sendKeys("Ahmet");
        WebElement lastName=driver.findElement(By.name("lastName"));
        lastName.sendKeys("Baldir");
        WebElement phone=driver.findElement(By.name("phone"));
        phone.sendKeys("132312312");
        WebElement email=driver.findElement(By.id("userName"));
        email.sendKeys("Ahmet@gmail.com");
        WebElement address=driver.findElement(By.name("address1"));
        address.sendKeys("1345 Gozilla Avenue");
        WebElement address2=driver.findElement(By.name("address2"));
        address2.sendKeys("122 driver");
        WebElement city=driver.findElement(By.name("city"));
        city.sendKeys("Chicago");
        WebElement state=driver.findElement(By.name("state"));
        state.sendKeys("IL");
        WebElement postalCode=driver.findElement(By.name("postalCode"));
        postalCode.sendKeys("1312343");

        //CLASSNAME LOCATOR:
        WebElement allTools=driver.findElement(By.className("group_checkbox"));
        System.out.println(allTools.getText().equals("All Tools") ? "Passed":"Failed");
        String actualText=allTools.getText().trim();
        String expectedText="All Tools";
        if(actualText.equals(expectedText)){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }
        WebElement javaBox=driver.findElement(By.id("cond1"));
        if(javaBox.isDisplayed()&&!javaBox.isSelected()){
            javaBox.click();
            System.out.println(javaBox.isSelected() ? "Selected" : "Not Selected");
        }
        WebElement seleniumBox=driver.findElement(By.id("cond2"));
        if(seleniumBox.isDisplayed()&&!seleniumBox.isSelected()){
            seleniumBox.click();
            System.out.println(seleniumBox.isSelected() ? "SeleniumBox is Selected" : "SeleniumBox is not Selected");
        }else{
            System.out.println(seleniumBox.isSelected() ? "SeleniumBox is Selected" : "SeleniumBox is not Selected");
        }
        driver.quit();
    }
}
