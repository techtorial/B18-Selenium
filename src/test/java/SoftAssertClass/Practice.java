package SoftAssertClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.BrowserUtils;

import java.time.Duration;

public class Practice {

    @Test(invocationCount=1)
    public void Practice() throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
        driver.navigate().to("https://demoqa.com/droppable");
        WebElement acceptButton=driver.findElement(By.cssSelector("#droppableExample-tab-accept"));
        Actions actions=new Actions(driver);
        actions.click(acceptButton).perform();
        Thread.sleep(5000);
        WebElement dropBox=driver.findElement(By.xpath("//div[@id='acceptDropContainer']//div[@id='droppable']"));
        String actualTextBefore= BrowserUtils.getText(dropBox);
        String expectedTextBefore="Drop hereghh";
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(actualTextBefore,expectedTextBefore);
//        Assert.assertEquals(actualTextBefore,expectedTextBefore);
        WebElement notAcceptable=driver.findElement(By.cssSelector("#notAcceptable"));
        actions.clickAndHold(notAcceptable).moveToElement(dropBox).release().perform();
        String actualTextAfter=BrowserUtils.getText(dropBox);
        String expectedTextAfter="Drop here";
        softAssert.assertEquals(actualTextAfter,expectedTextAfter);
//        Assert.assertEquals(actualTextAfter,expectedTextAfter);
        WebElement acceptable=driver.findElement(By.cssSelector("#acceptable"));
        actions.clickAndHold(acceptable).moveToElement(dropBox).release().perform();
        String actualAfter=BrowserUtils.getText(dropBox);
        String expectedAfter="Dropped!";
        softAssert.assertEquals(actualAfter,expectedAfter);
//        Assert.assertEquals(actualAfter,expectedAfter);
        softAssert.assertAll();
    }
}
