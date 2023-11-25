package SeleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FindElementsMethod {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("file:///Users/techtorialacademy/Downloads/Techtorialhtml.html");
       List<WebElement> allBoxes= driver.findElements(By.xpath("//input[@type='checkbox']"));//4

        for(WebElement box:allBoxes){
            if(box.isDisplayed() && !box.isSelected()){
                Thread.sleep(2000);
                box.click();
            }
            System.out.println(box.isSelected()? "SELECTED" : "NOT SELECTED");
        }

    }
}
