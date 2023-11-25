package SeleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FindElementsPractice {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/");
        List<WebElement> allLinks = driver.findElements(By.xpath("//li//a"));
        int counter = 0;
        int counter2=0;
        for (WebElement link : allLinks) {
            System.out.println(link.getText());
            System.out.println(link.getAttribute("href"));
            link.sendKeys(Keys.ARROW_DOWN);
            Thread.sleep(500);
            counter++;
        }
//        for(int i=0;i<allLinks.size();i++){
//            System.out.println(allLinks.get(i).getText().trim());
//            System.out.println(allLinks.get(i).getAttribute("href"));
//            counter++;
//        }
       System.out.println(counter);
//    }
        for(WebElement link:allLinks){
            if(link.getText().trim().length()>=12){
                System.out.println(link.getText());
                counter2++;
            }
        }
        System.out.println(counter2);

    }
}
















