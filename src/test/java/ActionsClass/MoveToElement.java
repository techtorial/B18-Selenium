package ActionsClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.Browser;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MoveToElement {

    @Test
    public void moveToElement() throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/hovers");
        List<WebElement> allUsers=driver.findElements(By.xpath("//h5"));
        List<WebElement> allAvatars=driver.findElements(By.xpath("//img[@alt='User Avatar']"));
        List<String> expectedText= Arrays.asList("name: user1","name: user2","name: user3");
        Actions actions=new Actions(driver);
        for(int i=0;i<allUsers.size();i++){
            actions.moveToElement(allAvatars.get(i)).perform();//stay on the avatar(hover over)
            Thread.sleep(1000);
            Assert.assertEquals(BrowserUtils.getText(allUsers.get(i)),expectedText.get(i));//Validate text
            System.out.println(BrowserUtils.getText(allUsers.get(i)));
        }
    }
    @Test
    public void moveToElementPractice() throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demos.telerik.com/kendo-ui/fx/expand");
        WebElement closeButton=driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']"));
      Thread.sleep(2000);
        closeButton.click();
        Actions actions=new Actions(driver);
        actions.scrollByAmount(200,200).perform();
        List<WebElement> allImages=driver.findElements(By.xpath("//div[@class='product k-listview-item']//img"));
        List<WebElement> allDescription=driver.findElements(By.xpath("//div[@class='product-description']//h3"));
        List<WebElement> allPrices=driver.findElements(By.xpath("//div[@class='product-description']//p"));
        Map<String,String> productInfo=new HashMap<>();
        for(int i=0;i<allImages.size();i++){
            actions.moveToElement(allImages.get(i)).perform();//stay on the picture
            Thread.sleep(500);
            productInfo.put(BrowserUtils.getText(allDescription.get(i)),BrowserUtils.getText(allPrices.get(i)));
        }
        System.out.println(productInfo);
    }











}
