package TestNGConcept;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ConfigReader;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class OpenChartTestNGPractice {

    @Test
    public void validateSuccessfulLogin() throws InterruptedException {
        /*
        1-setup your automation
        2-Navigate to the website https://demo.opencart.com/admin/
        3-provide username=demo and password=demo
        4-Validate(assert) the title is "Dashboard" (actual,expected)
        5-driver.close()
         */
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(ConfigReader.readProperty("opencharturl"));
        WebElement username=driver.findElement(By.cssSelector("#input-username"));
        username.sendKeys(ConfigReader.readProperty("openchartusername"));
        WebElement password=driver.findElement(By.cssSelector("#input-password"));
        password.sendKeys(ConfigReader.readProperty("openchartpassword"));
        WebElement loginButton=driver.findElement(By.cssSelector(".btn-primary"));
        loginButton.click();
        Thread.sleep(2000);
        String actualTitle=driver.getTitle();
        String expectedTitle="Dashboard";
        Assert.assertEquals(actualTitle,expectedTitle);
        driver.close();
    }
    @Test
    public void validateNegativeLogin() throws InterruptedException {//the name is not clear can you make it like validateNegative

               /*
        1-setup your automation
        2-Navigate to the website https://demo.opencart.com/admin/
        3-provide username=demo and password=asdasd
        4-Validate(assert) the message "No match for Username and/or Password."
        5-driver.close()
         */
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.opencart.com/admin/");
        WebElement username=driver.findElement(By.cssSelector("#input-username"));
        username.sendKeys("demo");
        WebElement password=driver.findElement(By.cssSelector("#input-password"));
        password.sendKeys("wdasds");
        WebElement loginButton=driver.findElement(By.cssSelector(".btn-primary"));
        loginButton.click();
        Thread.sleep(1000);
        WebElement alertMessage=driver.findElement(By.cssSelector("#alert"));
        String actualMessage=alertMessage.getText().trim();
        String expectedMessage="No match for Username and/or Password.";
        Assert.assertEquals(actualMessage,expectedMessage);
        driver.close();
    }
    @Test
    public void validateProductButton() throws InterruptedException {
          /*
        1-setup your automation
        2-Navigate to the website https://demo.opencart.com/admin/
        3-provide username=demo and password=demo
        4-Click X button from pop-up
        5-Click Catalog
        6-Validate Product button is displayed
        7-Validate Product button is enabled
        8-Click the button and validate the header is "Products"
        9-close your browser
         */

        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.opencart.com/admin/");
        WebElement username=driver.findElement(By.cssSelector("#input-username"));
        username.sendKeys("demo");
        WebElement password=driver.findElement(By.cssSelector("#input-password"));
        password.sendKeys("demo");
        WebElement loginButton=driver.findElement(By.cssSelector(".btn-primary"));
        loginButton.click();
        Thread.sleep(2000);
        WebElement xButton=driver.findElement(By.cssSelector(".btn-close"));
        xButton.click();
        WebElement catalogButton=driver.findElement(By.xpath("//a[contains(text(),'Catalog')]"));
        catalogButton.click();
        WebElement productsButton=driver.findElement(By.linkText("Products"));
        Assert.assertTrue(productsButton.isDisplayed()&& productsButton.isEnabled());
//        Assert.assertTrue(productsButton.isEnabled());
        productsButton.click();
        WebElement productHeader=driver.findElement(By.tagName("h1"));
        String actualHeader=productHeader.getText().trim();
        String expectedHeader="Products";
        Assert.assertEquals(actualHeader,expectedHeader);
        driver.quit();
    }
    @Test
    public void validateBoxesFunctionalityInProducts() throws InterruptedException {
        /*
         /*
        1-setup your automation
        2-Navigate to the website https://demo.opencart.com/admin/
        3-provide username=demo and password=demo
        4-Click X button from pop-up
        5-Click Catalog
        6-CLick product button
        7-Find the locations of all boxes(first page only) and test these
          ->Use regular loop since first box is selecting all which I do not want. Start from index 1
          ->Assert the box is displayed,is not selected
          ->Click the box
          -->Assert the box is selected
          -->Arrow down the page(put inside of loop)
          8-Close the page
         */

        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.opencart.com/admin/");
        WebElement username=driver.findElement(By.cssSelector("#input-username"));
        username.sendKeys("demo");
        WebElement password=driver.findElement(By.cssSelector("#input-password"));
        password.sendKeys("demo");
        WebElement loginButton=driver.findElement(By.cssSelector(".btn-primary"));
        loginButton.click();
        Thread.sleep(2000);
        WebElement xButton=driver.findElement(By.cssSelector(".btn-close"));
        xButton.click();
        WebElement catalogButton=driver.findElement(By.xpath("//a[contains(text(),'Catalog')]"));
        catalogButton.click();
        WebElement productsButton=driver.findElement(By.linkText("Products"));
        Assert.assertTrue(productsButton.isDisplayed()&& productsButton.isEnabled());
//        Assert.assertTrue(productsButton.isEnabled());
        productsButton.click();
        Thread.sleep(1000);
        List<WebElement> allBoxes=driver.findElements(By.xpath("//input[@type='checkbox']"));

        for(int i=1;i<allBoxes.size();i++){
            Assert.assertTrue(allBoxes.get(i).isDisplayed());
            Assert.assertFalse(allBoxes.get(i).isSelected());
            allBoxes.get(i).click();
            Assert.assertTrue(allBoxes.get(i).isSelected());
            Thread.sleep(500);
            allBoxes.get(i).sendKeys(Keys.ARROW_DOWN);
        }
        driver.close();
    }
    @Test
    public void validateAscendingOrder() throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.opencart.com/admin/");
        WebElement username=driver.findElement(By.cssSelector("#input-username"));
        username.sendKeys("demo");
        WebElement password=driver.findElement(By.cssSelector("#input-password"));
        password.sendKeys("demo");
        WebElement loginButton=driver.findElement(By.cssSelector(".btn-primary"));
        loginButton.click();
        Thread.sleep(2000);
        WebElement xButton=driver.findElement(By.cssSelector(".btn-close"));
        xButton.click();
        WebElement catalogButton=driver.findElement(By.xpath("//a[contains(text(),'Catalog')]"));
        catalogButton.click();
        WebElement productsButton=driver.findElement(By.linkText("Products"));
        productsButton.click();
        List<WebElement> allProductNames=driver.findElements(By.xpath("//td[@class='text-start']"));//11
        List<String> actualOrder=new ArrayList<>();
        List<String> expectedOrder=new ArrayList<>();

        for(int i=1;i<allProductNames.size();i++){
            actualOrder.add(allProductNames.get(i).getText().trim().toLowerCase());//to remove the confusion of ASCII TABLE
            expectedOrder.add(allProductNames.get(i).getText().trim().toLowerCase());
        }
        Collections.sort(expectedOrder);
        System.out.println(actualOrder);
        System.out.println(expectedOrder);
        Assert.assertEquals(actualOrder,expectedOrder);
    }

    @Test
    public void validateDescendingOrder() throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.opencart.com/admin/");
        WebElement username=driver.findElement(By.cssSelector("#input-username"));
        username.sendKeys("demo");
        WebElement password=driver.findElement(By.cssSelector("#input-password"));
        password.sendKeys("demo");
        WebElement loginButton=driver.findElement(By.cssSelector(".btn-primary"));
        loginButton.click();
        Thread.sleep(2000);
        WebElement xButton=driver.findElement(By.cssSelector(".btn-close"));
        xButton.click();
        WebElement catalogButton=driver.findElement(By.xpath("//a[contains(text(),'Catalog')]"));
        catalogButton.click();
        WebElement productsButton=driver.findElement(By.linkText("Products"));
        productsButton.click();
        Thread.sleep(1000);
        WebElement productName=driver.findElement(By.linkText("Product Name"));
        productName.click();
        Thread.sleep(1000);
        List<WebElement> allProducts=driver.findElements(By.xpath("//td[@class='text-start']"));//11

        List<String> actualOrder=new ArrayList<>();
        List<String> expectedOrder=new ArrayList<>();

        for(int i=1;i<allProducts.size();i++){
            actualOrder.add(allProducts.get(i).getText().toLowerCase().trim());
            expectedOrder.add(allProducts.get(i).getText().toLowerCase().trim());
        }
        Collections.sort(expectedOrder);
        Collections.reverse(expectedOrder);
        System.out.println(actualOrder);
        System.out.println(expectedOrder);
        Assert.assertEquals(actualOrder,expectedOrder);

        driver.close();
    }
}
