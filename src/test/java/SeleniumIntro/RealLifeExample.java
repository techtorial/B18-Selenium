package SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RealLifeExample {

    //  Test Case - Open Godaddy.com and validate it's Page title and the url.
//    Steps to Automate:
//            1. Launch browser of your choice say., Firefox, chrome etc.
//            2. Open this URL - https://www.godaddy.com/
//3. Get Title of page and validate it.(if conditions) expected title from website
//3. Get URL of current page and validate it.          expected url from website
//            4. Close browser.

    public static void main(String[] args) {
        //SETUP YOUR AUTOMATION
        WebDriverManager.chromedriver().setup();
        //YOU NEED TO CREATE DRIVER OBJECT
        WebDriver driver=new ChromeDriver();
        //Maximize your screen
        driver.manage().window().maximize();
        //I need to go to the website
        driver.get("https://www.godaddy.com/");
        String actualTitle=driver.getTitle();
        String expectedTitle="Domain Names, Websites, Hosting & Online Marketing Tools - GoDaddy";
        if(actualTitle.equals(expectedTitle)){
            System.out.println("TITLE is Passed");
        }else{
            System.out.println("Title is Failed");
        }
        System.out.println(actualTitle.equals(expectedTitle) ? "TITLE PASSED":"TITLE FAILED");

        String actualUrl=driver.getCurrentUrl();
        String expectedUrl="https://www.godaddy.com/";
        System.out.println(actualUrl.equals(expectedUrl) ? "URL PASSED":"URL FAILED");

        driver.close();
    }
}
