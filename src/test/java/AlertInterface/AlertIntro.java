package AlertInterface;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class AlertIntro {

    @Test
    public void AcceptAndGetText(){
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement jsAlert=driver.findElement(By.xpath("//button[contains(@onclick,'jsAlert')]"));
        jsAlert.click();
        Alert alert=driver.switchTo().alert();
        String actualJSText=alert.getText();
        String expectedJSText="I am a JS Alert";
        Assert.assertEquals(actualJSText,expectedJSText);
        alert.accept();
        WebElement text=driver.findElement(By.cssSelector("#result"));
        System.out.println(BrowserUtils.getText(text));
    }
    @Test
    public void Dismiss(){
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement jsConfirm=driver.findElement(By.xpath("//button[contains(@onclick,'jsConfirm')]"));
        jsConfirm.click();
        Alert alert=driver.switchTo().alert();
        alert.dismiss();
        WebElement text=driver.findElement(By.cssSelector("#result"));
        System.out.println(BrowserUtils.getText(text));
    }

    @Test
    public void SendKeys(){
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement JsPrompt=driver.findElement(By.xpath("//button[contains(@onclick,'jsPrompt')]"));
        JsPrompt.click();
        Alert alert=driver.switchTo().alert();
        alert.sendKeys("Ahmet");
        alert.accept();
        WebElement text=driver.findElement(By.cssSelector("#result"));
        System.out.println(BrowserUtils.getText(text));
    }


}
