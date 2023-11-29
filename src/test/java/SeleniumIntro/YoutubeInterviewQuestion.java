package SeleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class YoutubeInterviewQuestion {

    /*
    1-Navigate to the youtube
    2-Search for Justin Bieber
    3-Find the location of all links(I showed you)(go with a tagname)
    4-Once any of links equals to "Justin Bieber - Baby ft. Ludacris)
    5-Click the link and make sure the video is playing

    NOTE:Inside of loop you can ARROW DOWN like we did before if you get exception
    Thread.sleep might help for failures
     */
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.youtube.com/");
        WebElement searchBar=driver.findElement(By.xpath("//input[@id='search']"));
        searchBar.sendKeys("Justin Bieber");
        WebElement searchButton=driver.findElement(By.cssSelector("#search-icon-legacy"));
        searchButton.click();
        Thread.sleep(3000);
        List<WebElement> allSongs=driver.findElements(By.xpath("//a[@id='video-title']"));
        String expectedTitle="Justin Bieber - Baby ft. Ludacris";
        for(WebElement song:allSongs){
            song.sendKeys(Keys.ARROW_DOWN);
            Thread.sleep(1000);
            if(song.getAttribute("title").equals(expectedTitle)){
                song.click();
                break;
            }
        }
    }
}
