package GetWindowHandle;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.Set;

public class MultipleWindows {

    @Test
    public void multipleWindows(){
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("window.open('https://www.techtorialacademy.com/')");
        js.executeScript("window.open('https://www.techtorialacademy.com/about')");
        js.executeScript("window.open('https://www.techtorialacademy.com/contact-us-techtorial')");

//        Set<String> allPagesId=driver.getWindowHandles();//4 ids
//        for(String pageId:allPagesId){
//            driver.switchTo().window(pageId);
//            if(driver.getTitle().contains("About")){
//                break;
//            }
//        }
        BrowserUtils.switchWindow(driver,"About");
        System.out.println(driver.getTitle());
//        for(String pageId:allPagesId){
//            driver.switchTo().window(pageId);
//            if(driver.getTitle().contains("KickStart")){
//                break;
//            }
//        }
        BrowserUtils.switchWindow(driver,"KickStart");
        System.out.println(driver.getTitle());

//        for(String pageId:allPagesId){
//            driver.switchTo().window(pageId);
//            if(driver.getTitle().contains("Contact")){
//                break;
//            }
//        }
        BrowserUtils.switchWindow(driver,"Contact");
        System.out.println(driver.getTitle());
    }

    @Test
    public void practiceWindows() throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
        WebElement button4=driver.findElement(By.cssSelector("#newTabsBtn"));
        BrowserUtils.scrollIntoView(driver,button4);
        button4.click();
        BrowserUtils.switchWindow(driver,"Basic Controls");
        WebElement firstName=driver.findElement(By.cssSelector("#firstName"));
        firstName.sendKeys("Ahmet");
        WebElement lastName=driver.findElement(By.cssSelector("#lastName"));
        lastName.sendKeys("Baldir");
        WebElement gender=driver.findElement(By.cssSelector("#malerb"));
        gender.click();
        Thread.sleep(1000);
        WebElement englishBox=driver.findElement(By.cssSelector("#englishchbx"));
        BrowserUtils.scrollIntoView(driver,englishBox);
        if(englishBox.isDisplayed()&&!englishBox.isSelected()){
            englishBox.click();
        }
        WebElement email=driver.findElement(By.cssSelector("#email"));
        email.sendKeys("ahmet@gmail.com");
        WebElement password=driver.findElement(By.cssSelector("#password"));
        password.sendKeys("1231232");
        WebElement registerButton=driver.findElement(By.cssSelector("#registerbtn"));
        BrowserUtils.scrollIntoView(driver,registerButton);
        registerButton.click();
        WebElement message=driver.findElement(By.cssSelector("#msg"));
        String actualMessage=BrowserUtils.getText(message);
        String expectedMessage="Registration is Successful";
        Assert.assertEquals(actualMessage,expectedMessage);
        BrowserUtils.switchWindow(driver,"Window Handles Practice");
        WebElement WindowHandleHeader=driver.findElement(By.xpath("//h1[contains(text(),'Window Handles Practice')]"));
        String actualHeader=BrowserUtils.getText(WindowHandleHeader);
        String expectedHeader="Window Handles Practice";
        Assert.assertEquals(actualHeader,expectedHeader);
        BrowserUtils.switchWindow(driver,"AlertsDemo");
        WebElement alertDemoHeader=driver.findElement(By.xpath("//h1[@itemprop='name']"));
        String actualDemoHeader=BrowserUtils.getText(alertDemoHeader);
        String expectedDemoHeader="AlertsDemo";
        Assert.assertEquals(actualDemoHeader,expectedDemoHeader);
        WebElement clickMe=driver.findElement(By.xpath("//button[@id='promptBox']"));
        clickMe.click();

        /*
        1-Navigate to https://www.hyrtutorials.com/p/window-handles-practice.html
        2-scroll down to button 4 and Click open multiple tabs under Button 4
        3-the Basic Control and fill all the blanks
        4-Click Register button and validate the message "Registration is Successful"
        5-GO to the Window handle practice page and validate Header  which is Window Handles Practice
        6- go to the alertsDemo page and validate "AlertsDemo" then click  the "Click Me" button under prompt box
        7-Proud of yourself
 */
    }

















}
