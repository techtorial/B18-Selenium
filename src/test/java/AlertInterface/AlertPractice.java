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

public class AlertPractice {

    @Test
    public void practice() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.navigate().to("https://www.hyrtutorials.com/p/alertsdemo.html");
        WebElement alertBoxClick=driver.findElement(By.cssSelector("#alertBox"));
        alertBoxClick.click();
        Thread.sleep(2000);
        Alert alert=driver.switchTo().alert();
        String actualAlertText=alert.getText();
        String expectedAlertText="I am an alert box!";
        Assert.assertEquals(actualAlertText,expectedAlertText);
        alert.accept();
        WebElement message=driver.findElement(By.cssSelector("#output"));
        String actualMessageText= BrowserUtils.getText(message);
        String expectedMessageText="You selected alert popup";
        Assert.assertEquals(actualMessageText,expectedMessageText);
        WebElement promptBox=driver.findElement(By.cssSelector("#promptBox"));
        promptBox.click();
        alert=driver.switchTo().alert();
        alert.sendKeys("Ahmet");
        alert.accept();
        message=driver.findElement(By.cssSelector("#output"));
        String actualMessage=BrowserUtils.getText(message);
        String expectedMessage="You entered text Ahmet in prompt popup";
        Assert.assertEquals(actualMessage,expectedMessage);
    }
}
