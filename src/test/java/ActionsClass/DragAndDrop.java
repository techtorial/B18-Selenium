package ActionsClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class DragAndDrop {

    @Test
    public void DragAndDropMethod() throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
        driver.navigate().to("https://demos.telerik.com/kendo-ui/dragdrop/area");
        WebElement orangeBox=driver.findElement(By.xpath("//div[@class='test2']"));
        String actualColor=orangeBox.getCssValue("background-color");
        String expectedColor="rgba(238, 111, 11, 1)";//238 111 11 11
        Assert.assertEquals(actualColor,expectedColor);
        String actualText= BrowserUtils.getText(orangeBox);
        String expectedText="... Or here.";
        Assert.assertEquals(actualText,expectedText);
        WebElement draggable=driver.findElement(By.xpath("//div[@id='draggable']"));
        Actions actions=new Actions(driver);
        actions.scrollByAmount(300,300).perform();
        actions.dragAndDrop(draggable,orangeBox).perform();
        Thread.sleep(2000);
        orangeBox=driver.findElement(By.xpath("//div[@class='test2']"));
        String actualTextAfter=BrowserUtils.getText(orangeBox);
        String expectedTextAfter="You did great!";
        Assert.assertEquals(actualTextAfter,expectedTextAfter);
    }

    @Test
    public void practiceDragAndDrop(){
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
        driver.navigate().to("https://demoqa.com/droppable");
        WebElement dropBox=driver.findElement(By.xpath("//div[@id='simpleDropContainer']/div[@id='droppable']"));
        String actualTextBefore=BrowserUtils.getText(dropBox);
        String expectedTextBefore="Drop here";
        Assert.assertEquals(actualTextBefore,expectedTextBefore);
        WebElement draggable=driver.findElement(By.cssSelector("#draggable"));
        Actions actions=new Actions(driver);
        actions.dragAndDrop(draggable,dropBox).perform();
        String actualTextAfter=BrowserUtils.getText(dropBox);
        String expectedTextAfter="Dropped!";
        Assert.assertEquals(actualTextAfter,expectedTextAfter);
        String actualColor=dropBox.getCssValue("background-color");
        String expectedColor="rgba(70, 130, 180, 1)";
        Assert.assertEquals(actualColor,expectedColor);
    }

    @Test
    public void validateClickAndHold() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
        driver.navigate().to("https://demos.telerik.com/kendo-ui/dragdrop/area");
        WebElement blueBox = driver.findElement(By.xpath("//div[@class='test1']"));
        String actualText = BrowserUtils.getText(blueBox);
        String expectedText = "Drag the small circle here ...";
        Assert.assertEquals(actualText, expectedText);
        WebElement draggable = driver.findElement(By.xpath("//div[@id='draggable']"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(draggable).moveToElement(blueBox).release().perform();
        blueBox = driver.findElement(By.xpath("//div[@class='test1']"));
        String actualTestAfter = BrowserUtils.getText(blueBox);
        String expectedTestAfter = "You did great!";
        Assert.assertEquals(actualTestAfter, expectedTestAfter);
    }

    @Test
    public void ClickAndHoldPractice() throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
        driver.navigate().to("https://demoqa.com/droppable");
        WebElement acceptButton=driver.findElement(By.cssSelector("#droppableExample-tab-accept"));
        Actions actions=new Actions(driver);
        actions.click(acceptButton).perform();
        Thread.sleep(5000);
        WebElement dropBox=driver.findElement(By.xpath("//div[@id='acceptDropContainer']//div[@id='droppable']"));
        String actualTextBefore=BrowserUtils.getText(dropBox);
        String expectedTextBefore="Drop here";
        Assert.assertEquals(actualTextBefore,expectedTextBefore);
        WebElement notAcceptable=driver.findElement(By.cssSelector("#notAcceptable"));
        actions.clickAndHold(notAcceptable).moveToElement(dropBox).release().perform();
        String actualTextAfter=BrowserUtils.getText(dropBox);
        String expectedTextAfter="Drop here";
        Assert.assertEquals(actualTextAfter,expectedTextAfter);
        WebElement acceptable=driver.findElement(By.cssSelector("#acceptable"));
        actions.clickAndHold(acceptable).moveToElement(dropBox).release().perform();
        String actualAfter=BrowserUtils.getText(dropBox);
        String expectedAfter="Dropped!";
        Assert.assertEquals(actualAfter,expectedAfter);


 /*
 1-Click accept Button
 2-Validate the message in box "Drop here"
 3-Click and hold Not Acceptable and put it in Drop box
 4-Validate the message in box "Drop here" still
 5-Click and Hold Acceptable and put it in Drop Box
 6-Validate the message in box "Dropped!"
 7-driver.quit or close
  */
    }
}
