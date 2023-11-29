package JavaScriptExecutorClass;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class JavaScriptMethods {

    @Test
    public void getTitle() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.techtorialacademy.com/");
        System.out.println(driver.getTitle() + " for Selenium Title");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        System.out.println(js.executeScript("return document.title") + " for JS");
        //Please USE JS WHENEVER REGULAR METHOD FROM SELENIUM IS NOT WORKING*****
    }

    @Test
    public void clickJS() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.techtorialacademy.com/");
        WebElement aboutUs = driver.findElement(By.xpath("//span[.='About Us']"));
//        aboutUs.click();
//        Actions actions=new Actions(driver);
//        actions.click(aboutUs).perform();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", aboutUs);
    }

    @Test
    public void scrollIntoView() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.techtorialacademy.com/");
        WebElement copyRight = driver.findElement(By.xpath("//div[contains(text(),'Copyright')]"));
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)",copyRight);
        System.out.println(BrowserUtils.getText(copyRight));
        Thread.sleep(2000);
        WebElement header=driver.findElement(By.xpath("//b[contains(text(),'LAUNCH')]"));
        js.executeScript("arguments[0].scrollIntoView(true)",header);
        System.out.println(BrowserUtils.getText(header));
    }
}
