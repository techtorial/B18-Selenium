package GetWindowHandle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.Set;

public class SwitchWindow {

    @Test
    public void switchWindow(){
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/windows");
        WebElement clickHere=driver.findElement(By.linkText("Click Here"));
        clickHere.click();
        WebElement header=driver.findElement(By.tagName("h3"));
        System.out.println(BrowserUtils.getText(header));
        System.out.println(driver.getWindowHandle());
        String mainPageId=driver.getWindowHandle();//driver first navigation
        Set<String> allPages=driver.getWindowHandles();
        System.out.println(mainPageId);//123
        System.out.println(allPages);//123,456

        for(String id:allPages){
            if(!id.equals(mainPageId)){
                driver.switchTo().window(id);
            }
        }
        header=driver.findElement(By.tagName("h3"));
        System.out.println(BrowserUtils.getText(header));//New Window
    }

    @Test
    public void switchWindowPractice(){
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.hyrtutorials.com/p/window-handles-practice.html");
        WebElement button2=driver.findElement(By.cssSelector("#newTabBtn"));
        BrowserUtils.scrollIntoView(driver,button2);
        button2.click();
        String mainPageId=driver.getWindowHandle();
        Set<String> allPagesId=driver.getWindowHandles();
        for(String id:allPagesId){
            if(!id.equals(mainPageId)){
                driver.switchTo().window(id);
            }
        }
        WebElement header=driver.findElement(By.xpath("//h1[contains(text(),'AlertsDemo')]"));
        String actualHeader=BrowserUtils.getText(header);
        String expectedHeader="AlertsDemo";
        Assert.assertEquals(actualHeader,expectedHeader);
        WebElement box= driver.findElement(By.cssSelector("#alertBox"));
        box.click();
    }

    /*
    1-Navigate to the website
    2-Scroll down to the button 2 and click
    3-Validate the header "AlertsDemo"
    4-Click the first click me button

     */






}
