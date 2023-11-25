package ActionsClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;

public class ActionsMethods {

    @Test
    public void contextClick(){
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/context_menu");
        WebElement box=driver.findElement(By.cssSelector("#hot-spot"));
        Actions actions=new Actions(driver);
        actions.contextClick(box).perform();
    }
    @Test
    public void practiceContextClick(){
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.guru99.com/test/simple_context_menu.html");
        WebElement button=driver.findElement(By.xpath("//span[.='right click me']"));
        Actions actions=new Actions(driver);
        actions.contextClick(button).perform();
    }

    @Test
    public void doubleClick(){
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.guru99.com/test/simple_context_menu.html");
        WebElement doubleClickButton=driver.findElement(By.xpath("//button[.='Double-Click Me To See Alert']"));
        Actions actions=new Actions(driver);
        actions.doubleClick(doubleClickButton).perform();
    }
}
