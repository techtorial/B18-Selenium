package SelectClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.sql.Array;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DreamCar {

    @Test
    public void SearchFunctionality(){
        /*
NOTE: Please use browser utils for the select classes if it is needed or getText.
1-Navigate to the website
2-Choose the "New & used" from the New/used option
3-Choose "Lexus" for Make part
4-Choose "RX-350"
5-Validate the Price is selected "No max price"-->getFirstSelectedOption -->regular select
6-Choose the distance 40 miles
7-Put your Zip code-->Before that Clear it.60056 element.clear()
8-Click Search Button
9-Validate the header "New and used Lexus RX 350 for sale"
10-Click Sort by and choose the Lowest Price
11-Validate the all titles has Lexus RX 350
 */
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.cars.com/shopping/");
        WebElement newUsed=driver.findElement(By.cssSelector("#make-model-search-stocktype"));
        BrowserUtils.selectBy(newUsed,"all","value");
        WebElement make=driver.findElement(By.cssSelector("#makes"));
        BrowserUtils.selectBy(make,"Lexus","text");
        WebElement models=driver.findElement(By.cssSelector("#models"));
        BrowserUtils.selectBy(models,"lexus-rx_350","value");
        WebElement price=driver.findElement(By.cssSelector("#make-model-max-price"));
        Select priceOption=new Select(price);
        String actualText=BrowserUtils.getText(priceOption.getFirstSelectedOption());
        String expectedText="No max price";
        Assert.assertEquals(actualText,expectedText);
        WebElement distance=driver.findElement(By.cssSelector("#make-model-maximum-distance"));
        BrowserUtils.selectBy(distance,"3","index");//just practice index purposes
        WebElement zipCode=driver.findElement(By.cssSelector("#make-model-zip"));
        zipCode.clear();
        zipCode.sendKeys("60056");
        WebElement searchButton=driver.findElement(By.xpath("//button[@data-linkname='search-all-make']"));
        searchButton.click();
        WebElement header=driver.findElement(By.tagName("h1"));
        String actualHeader=BrowserUtils.getText(header); //header.getText().trim()
        String expectedHeader="New and used Lexus RX 350 for sale";
        Assert.assertEquals(actualHeader,expectedHeader);
        WebElement lowestPrice=driver.findElement(By.cssSelector("#sort-dropdown"));
        BrowserUtils.selectBy(lowestPrice,"Lowest price","text");
        List<WebElement> allTitles=driver.findElements(By.xpath("//h2[@class='title']"));

        for(WebElement title:allTitles){
            Assert.assertTrue(BrowserUtils.getText(title).contains("Lexus RX 350"));
        }

    }

    @Test
    public void validateLowestToHighestPrice() throws InterruptedException {
        /*
NOTE: Please use browser utils for the select classes if it is needed or getText.
1-Navigate to the website
2-Choose the "New & used" from the New/used option
3-Choose "Lexus" for Make part
4-Choose "RX-350"
5-Validate the Price is selected "No max price"-->getFirstSelectedOption -->regular select
6-Choose the distance 40 miles
7-Put your Zip code-->Before that Clear it.60056 element.clear()
8-Click Search Button
9-Validate the header "New and used Lexus RX 350 for sale"
10-Click Sort by and choose the Lowest Price
11-Validate the prices are ascending order
Note:You can think about ascending order logic that we worked yesterday like 2 lists
Note:Think about parsing to double or int but you need to change $ with "" and "," with ""
Note:Sponsor cars can make your test fails, think about solution like starting from index 1 like that

 */
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.cars.com/shopping/");
        WebElement newUsed=driver.findElement(By.cssSelector("#make-model-search-stocktype"));
        BrowserUtils.selectBy(newUsed,"all","value");
        WebElement make=driver.findElement(By.cssSelector("#makes"));
        BrowserUtils.selectBy(make,"Lexus","text");
        WebElement models=driver.findElement(By.cssSelector("#models"));
        BrowserUtils.selectBy(models,"lexus-rx_350","value");
        WebElement price=driver.findElement(By.cssSelector("#make-model-max-price"));
        Select priceOption=new Select(price);
        String actualText=BrowserUtils.getText(priceOption.getFirstSelectedOption());
        String expectedText="No max price";
        Assert.assertEquals(actualText,expectedText);
        WebElement distance=driver.findElement(By.cssSelector("#make-model-maximum-distance"));
        BrowserUtils.selectBy(distance,"3","index");//just practice index purposes
        WebElement zipCode=driver.findElement(By.cssSelector("#make-model-zip"));
        zipCode.clear();
        zipCode.sendKeys("60056");
        WebElement searchButton=driver.findElement(By.xpath("//button[@data-linkname='search-all-make']"));
        searchButton.click();
        Thread.sleep(2000);
        WebElement header=driver.findElement(By.tagName("h1"));
        String actualHeader=BrowserUtils.getText(header); //header.getText().trim()
        String expectedHeader="New and used Lexus RX 350 for sale";
        Assert.assertEquals(actualHeader,expectedHeader);
        WebElement lowestPrice=driver.findElement(By.cssSelector("#sort-dropdown"));
        BrowserUtils.selectBy(lowestPrice,"Lowest price","text");
        Thread.sleep(2000);
        List<WebElement> allPrices=driver.findElements(By.xpath("//span[@class='primary-price']"));
        List<Integer> actualPrices=new ArrayList<>();
        List<Integer> expectedPrices=new ArrayList<>();
        for(int i=1;i<allPrices.size();i++){
            actualPrices.add(Integer.parseInt(BrowserUtils.getText(allPrices.get(i)).replace("$","").replace(",","")));
            expectedPrices.add(Integer.parseInt(BrowserUtils.getText(allPrices.get(i)).replace("$","").replace(",","")));
        }
        Collections.sort(expectedPrices);
        Thread.sleep(2000);
        System.out.println(actualPrices);
        System.out.println(expectedPrices);
        Assert.assertEquals(actualPrices,expectedPrices);
    }

    @Test
    public void validateHighestToLowest() throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.cars.com/shopping/");
        WebElement newUsed=driver.findElement(By.cssSelector("#make-model-search-stocktype"));
        BrowserUtils.selectBy(newUsed,"all","value");
        WebElement make=driver.findElement(By.cssSelector("#makes"));
        BrowserUtils.selectBy(make,"Lexus","text");
        WebElement models=driver.findElement(By.cssSelector("#models"));
        BrowserUtils.selectBy(models,"lexus-rx_350","value");
        WebElement price=driver.findElement(By.cssSelector("#make-model-max-price"));
        Select priceOption=new Select(price);
        String actualText=BrowserUtils.getText(priceOption.getFirstSelectedOption());
        String expectedText="No max price";
        Assert.assertEquals(actualText,expectedText);
        WebElement distance=driver.findElement(By.cssSelector("#make-model-maximum-distance"));
        BrowserUtils.selectBy(distance,"3","index");//just practice index purposes
        WebElement zipCode=driver.findElement(By.cssSelector("#make-model-zip"));
        zipCode.clear();
        zipCode.sendKeys("60056");
        WebElement searchButton=driver.findElement(By.xpath("//button[@data-linkname='search-all-make']"));
        searchButton.click();
        Thread.sleep(2000);
        WebElement header=driver.findElement(By.tagName("h1"));
        String actualHeader=BrowserUtils.getText(header); //header.getText().trim()
        String expectedHeader="New and used Lexus RX 350 for sale";
        Assert.assertEquals(actualHeader,expectedHeader);
        WebElement highestPrice=driver.findElement(By.cssSelector("#sort-dropdown"));
        BrowserUtils.selectBy(highestPrice,"Highest price","text");
        Thread.sleep(2000);
        List<WebElement> allPrices=driver.findElements(By.xpath("//span[@class='primary-price']"));
        List<Integer> actualPrices=new ArrayList<>();
        List<Integer> expectedPrices=new ArrayList<>();
        for(int i=1;i<allPrices.size();i++){
            actualPrices.add(Integer.parseInt(BrowserUtils.getText(allPrices.get(i)).replace("$","").replace(",","")));
            expectedPrices.add(Integer.parseInt(BrowserUtils.getText(allPrices.get(i)).replace("$","").replace(",","")));
        }
        Collections.sort(expectedPrices);
        Thread.sleep(2000);
        Collections.reverse(expectedPrices);
        System.out.println(actualPrices);
        System.out.println(expectedPrices);
        Assert.assertEquals(actualPrices,expectedPrices);
    }

}
