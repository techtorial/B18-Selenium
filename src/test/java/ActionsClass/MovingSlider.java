package ActionsClass;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class MovingSlider {

    @Test
    public void validateSliderFunctionality() throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/horizontal_slider");
        WebElement slider=driver.findElement(By.tagName("input"));
        WebElement value=driver.findElement(By.xpath("//span[@id='range']"));
        String expectedValue="3.5";
        while(!BrowserUtils.getText(value).equals(expectedValue)){
            Thread.sleep(500);
            slider.sendKeys(Keys.ARROW_RIGHT);
        }
        Assert.assertEquals(BrowserUtils.getText(value),expectedValue);
    }

}
