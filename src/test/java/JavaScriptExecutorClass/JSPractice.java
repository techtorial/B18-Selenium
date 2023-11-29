package JavaScriptExecutorClass;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class JSPractice {

    @Test
    public void clickJS(){
        ChromeDriver driver=new ChromeDriver();
        // WebDriver driver1=new ChromeDriver();//polymorphism
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/radio-button");
        WebElement yesRadio=driver.findElement(By.cssSelector("#yesRadio"));
//        yesRadio.click();
//        Actions actions=new Actions(driver);
//        actions.click(yesRadio).perform();
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()",yesRadio);
        WebElement text=driver.findElement(By.cssSelector(".mt-3"));
        System.out.println(BrowserUtils.getText(text));
    }
    @Test
    public void allJSPractice(){
        ChromeDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.techtorialacademy.com/");
        WebElement training=driver.findElement(By.xpath("//div[contains(text(),'Corporate Training')]"));
        JavascriptExecutor js=driver;
        js.executeScript("arguments[0].scrollIntoView(true)",training);
        String actualText=BrowserUtils.getText(training);
        String expectedText="Corporate Training";
        Assert.assertEquals(actualText,expectedText);
        WebElement applyNowButton=driver.findElement(By.xpath("//span[.='Apply Now']"));
        js.executeScript("arguments[0].scrollIntoView(true)",applyNowButton);
        js.executeScript("arguments[0].click()",applyNowButton);
        String actualTitle= (String) js.executeScript("return document.title");
        String expectedTitle="Apply Now";
        Assert.assertEquals(actualTitle,expectedTitle);
        List<WebElement> actualInformation=driver.findElements(By.xpath("//h3[@data-element-id='heading3Normal']"));
        List<String> expectedInformation= Arrays.asList("info@techtorialacademy.com","+ 1 (224) 570 91 91","Chicago & Houston");

        for(int i=0;i<actualInformation.size();i++){
            Assert.assertEquals(BrowserUtils.getText(actualInformation.get(i)),expectedInformation.get(i));
        }

        driver.close();
        /*
        1-Scroll All the way down to the Corporate Training and validate the name
        2-Scroll All the way up to Apply Now button at the corner and click with JS
        3-Validate title with JS
        4-Validate the information at the middle (info@techtorialacademy.com,+ 1 (224) 570 91 91,Chicago & Houston)
        5-Close
         */
    }
    @Test
    public void utilsPracticeJS(){
        ChromeDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.techtorialacademy.com/");
        WebElement training=driver.findElement(By.xpath("//div[contains(text(),'Corporate Training')]"));
        BrowserUtils.scrollIntoView(driver,training);
        String actualText=BrowserUtils.getText(training);
        String expectedText="Corporate Training";
        Assert.assertEquals(actualText,expectedText);
        WebElement applyNowButton=driver.findElement(By.xpath("//span[.='Apply Now']"));
        BrowserUtils.scrollIntoView(driver,applyNowButton);
        BrowserUtils.clickWithJS(driver,applyNowButton);
        String actualTitle= BrowserUtils.getTitleJS(driver);
        String expectedTitle="Apply Now";
        Assert.assertEquals(actualTitle,expectedTitle);
        List<WebElement> actualInformation=driver.findElements(By.xpath("//h3[@data-element-id='heading3Normal']"));
        List<String> expectedInformation= Arrays.asList("info@techtorialacademy.com","+ 1 (224) 570 91 91","Chicago & Houston");

        for(int i=0;i<actualInformation.size();i++){
            Assert.assertEquals(BrowserUtils.getText(actualInformation.get(i)),expectedInformation.get(i));
        }

        driver.close();
    }
}
