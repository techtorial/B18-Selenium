package iframe;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.List;

public class FramePractice {

    @Test
    public void frame(){
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/iframe");
        WebElement header=driver.findElement(By.tagName("h3"));
        System.out.println(BrowserUtils.getText(header));
        driver.switchTo().frame("mce_0_ifr");
        WebElement box=driver.findElement(By.cssSelector("#tinymce"));
        box.clear();
        box.sendKeys("I love Selenium");
        driver.switchTo().parentFrame();
        WebElement elementalSelenium=driver.findElement(By.linkText("Elemental Selenium"));
        elementalSelenium.click();
    }

    @Test
    public void practiceFrame() throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://skpatro.github.io/demo/iframes");
        WebElement pavilion=driver.findElement(By.linkText("Pavilion"));
        pavilion.click();
        Thread.sleep(1000);
        BrowserUtils.switchWindow(driver,"Privacy error");
        try {
            WebElement advanceButton=driver.findElement(By.xpath("//button[contains(text(),'Advanced')]"));
            BrowserUtils.clickWithJS(driver,advanceButton);
            WebElement unsafe=driver.findElement(By.xpath("//a[contains(text(),'qavalidation.com')]"));
            unsafe.click();
        }catch (NoSuchElementException e){
            e.printStackTrace();
        }
        Thread.sleep(1000);

        WebElement selenium=driver.findElement(By.xpath("//ul[@id='primary-menu']//span[.='Selenium']"));
        Actions actions=new Actions(driver);
        actions.moveToElement(selenium).perform();
        WebElement selenium_phyton=driver.findElement(By.xpath("//ul[@id='primary-menu']//span[.='Selenium-Python']"));
        actions.click(selenium_phyton).perform();
        driver.navigate().refresh();
        Thread.sleep(3000);
        selenium=driver.findElement(By.xpath("//ul[@id='primary-menu']//span[.='Selenium']"));
        actions.moveToElement(selenium).perform();
        selenium_phyton=driver.findElement(By.xpath("//ul[@id='primary-menu']//span[.='Selenium-Python']"));
        actions.click(selenium_phyton).perform();
        List<WebElement> allLinks=driver.findElements(By.xpath("//p//a"));

        for(WebElement link:allLinks){
            System.out.println(BrowserUtils.getText(link));
        }

        BrowserUtils.switchWindow(driver,"iframes");
        WebElement iframe=driver.findElement(By.xpath("//iframe[@id='Frame1']"));
        driver.switchTo().frame(iframe);
        WebElement category1=driver.findElement(By.linkText("Category1"));
        category1.click();
        BrowserUtils.switchWindow(driver,"SeleniumTesting Archives");
        WebElement header=driver.findElement(By.tagName("h1"));
        String actualHeader=BrowserUtils.getText(header);
        String expectedHeader="Category Archives: SeleniumTesting";
        Assert.assertEquals(actualHeader,expectedHeader);
        List<WebElement> allBoxText=driver.findElements(By.xpath("//h3//a"));
        for(WebElement boxText:allBoxText){
            System.out.println(BrowserUtils.getText(boxText));
        }
        BrowserUtils.switchWindow(driver,"iframes");
        driver.switchTo().frame("Framename1");
        WebElement insideFrame=driver.findElement(By.cssSelector("#frametext"));
        System.out.println(BrowserUtils.getText(insideFrame));
        driver.switchTo().parentFrame();
        driver.switchTo().frame("Frame2");
        WebElement category3=driver.findElement(By.linkText("Category3"));
        category3.click();
        BrowserUtils.switchWindow(driver,"SoftwareTesting Archives");
        header=driver.findElement(By.tagName("h1"));
        System.out.println(BrowserUtils.getText(header));




        /*
          TASK 1:
        1-Navigate to the website "https://skpatro.github.io/demo/iframes/"
        2-Click Pavilion
        3-Hover Over Selenium then click Selenium-Phyton
        4-Print out all the links(only links)
         /
        /
        TASK2:
        1-Click the category 1 button
        2-Validate the header is "Category Archives: SeleniumTesting"
        3-Print out the top of the each box(text). I showed you during manual steps
         /
        /
        TASK3:
        1-Go to the iframe tab
        2-print out "I am inside Frame"
        3-Click category 3
        4-print out the header "Category Archives: SoftwareTesting"
         */

    }
}
