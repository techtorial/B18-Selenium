package SelectClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class SelectBasicsPractice {

    @Test
    public void practice() throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("file:///Users/techtorialacademy/Downloads/Techtorialhtml.html");
        WebElement countryBox=driver.findElement(By.xpath("//select[@name='country']"));
        Select country=new Select(countryBox);
        String actualDefault=country.getFirstSelectedOption().getText().trim();
        String expectedDefault="UNITED STATES";
        Assert.assertEquals(actualDefault,expectedDefault);
        List<WebElement> allCountries= country.getOptions();

        for(WebElement cntry:allCountries){
            System.out.println(cntry.getText().trim());
        }
        System.out.println("The number of country is : "+ allCountries.size());
        country.selectByVisibleText("TURKEY");
        Thread.sleep(2000);
        country.selectByValue("111");
        Thread.sleep(2000);
        country.selectByIndex(57);

        /*
        1-Go to html and validate default value is "UNITED STATES"
        2-Get all the options from list-->Print out and count
        3-Choose your own country from list with Visible text method
        4-Choose your favorite country from list with value
        5-Choose your travel country from list with index
        NOTE:You can use the Thread.sleep between selecting to see all the options slowly.
         */
    }
}
