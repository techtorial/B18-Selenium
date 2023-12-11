package FileUpload;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class Practice {

    @Test
    public void practice1() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.navigate().to("https://demo.guru99.com/test/upload/");
        WebElement chooseFile=driver.findElement(By.cssSelector("#uploadfile_0"));
        chooseFile.sendKeys("/Users/techtorial/Downloads/usa.png");
        WebElement selectFileText=driver.findElement(By.xpath("//b[contains(text(),'Select file')]"));
        System.out.println(BrowserUtils.getText(selectFileText));
        WebElement box=driver.findElement(By.cssSelector("#terms"));
        if(!box.isSelected()&&box.isDisplayed()&&box.isEnabled()){
            box.click();
        }
        Assert.assertTrue(box.isSelected());
        WebElement submitFile=driver.findElement(By.xpath("//button[@id='submitbutton']"));
        submitFile.click();
        Thread.sleep(2000);
        WebElement text=driver.findElement(By.tagName("h3"));
        String actualText=BrowserUtils.getText(text);
        String expectedText="1 file\n" +
                "has been successfully uploaded.";
        Assert.assertEquals(actualText,expectedText);

    }

    @Test
    public void practice2(){
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/upload");
        WebElement chooseFile=driver.findElement(By.cssSelector("#file-upload"));
        chooseFile.sendKeys("/Users/techtorial/Downloads/Batch18.rb");
        WebElement uploadButton=driver.findElement(By.cssSelector("#file-submit"));
        uploadButton.submit();
        WebElement text=driver.findElement(By.cssSelector("#uploaded-files"));
        String actualText=BrowserUtils.getText(text);
        String expectedText="Batch18.rb";
        Assert.assertEquals(actualText,expectedText);
    }
}
