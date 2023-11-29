package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsPractice {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://formy-project.herokuapp.com/form");
        //1.suggesstion time to time run your code
        WebElement firstName=driver.findElement(By.id("first-name"));
        firstName.sendKeys("Ahmet");
        Thread.sleep(1000);
        WebElement lastName=driver.findElement(By.id("last-name"));
        lastName.sendKeys("Baldir");
        Thread.sleep(1000);
        WebElement jobTitle=driver.findElement(By.id("job-title"));
        jobTitle.sendKeys("SDET");
        Thread.sleep(1000);
        WebElement education=driver.findElement(By.id("radio-button-1"));
        education.click();
        Thread.sleep(1000);
        WebElement male=driver.findElement(By.id("checkbox-1"));
        if(male.isDisplayed()&&!male.isSelected()){
            male.click();
        }
        Thread.sleep(1000);
        WebElement experienceBox=driver.findElement(By.id("select-menu"));
        experienceBox.sendKeys("2-4");
        Thread.sleep(1000);
        WebElement date=driver.findElement(By.id("datepicker"));
        date.sendKeys("07/12/1991");
        Thread.sleep(1000);
        WebElement submitButton=driver.findElement(By.linkText("Submit"));
        submitButton.click();
        Thread.sleep(2000);
        WebElement message=driver.findElement(By.className("alert-success"));
        System.out.println(message);
        System.out.println(message.getText().trim().equals("The form was successfully submitted!") ? "Passed":"Failed");



    }
}
