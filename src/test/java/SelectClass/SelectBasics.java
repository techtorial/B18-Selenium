package SelectClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class SelectBasics {

    @Test
    public void selectMethods() throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/dropdown");
        WebElement dropBox=driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select box=new Select(dropBox);
        String actualText=box.getFirstSelectedOption().getText().trim();
        String expectedText="Please select an option";
        Assert.assertEquals(actualText,expectedText);
        box.selectByVisibleText("Option 1");//the most common way
        Thread.sleep(2000);
        box.selectByValue("2");
        Thread.sleep(2000);
        box.selectByIndex(1);

        List<WebElement> allOptions= box.getOptions();//actualList from website (3)
        List<String> expectedOptions= Arrays.asList("Please select an option","Option 1","Option 2");
        //is coming from documentation(3)
       for(int i=0;i<allOptions.size();i++){
           Assert.assertEquals(allOptions.get(i).getText().trim(),expectedOptions.get(i));
       }
    }


}
