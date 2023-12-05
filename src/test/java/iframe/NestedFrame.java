package iframe;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class NestedFrame {

 @Test
    public void nestedFrame(){
     WebDriver driver=new ChromeDriver();
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
     driver.manage().window().maximize();
     driver.get("https://the-internet.herokuapp.com/nested_frames");
     driver.switchTo().frame("frame-top");
     driver.switchTo().frame("frame-left");
     WebElement left=driver.findElement(By.xpath("//body[contains(text(),'LEFT')]"));
     System.out.println(BrowserUtils.getText(left));

 }

}
