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

public class JSAndHtmlPractice {

    @Test
    public void practice(){
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.navigate().to("https://sweetalert.js.org/");
        WebElement previewJS=driver.findElement(By.xpath("//button[contains(@onclick,'alert')]"));
        previewJS.click();
        Alert alert=driver.switchTo().alert();
        String actualText=alert.getText();
        String expectedText="Oops, something went wrong!";
        Assert.assertEquals(actualText,expectedText);
        alert.accept();
        WebElement previewHtml=driver.findElement(By.xpath("//button[contains(@onclick,'swal')]"));
        previewHtml.click();
        WebElement text=driver.findElement(By.xpath("//div[@class='swal-text']"));
        Assert.assertTrue(BrowserUtils.getText(text).contains("Something went wrong!"));
        WebElement okButton=driver.findElement(By.xpath("//button[.='OK']"));
        okButton.click();
    }
}
