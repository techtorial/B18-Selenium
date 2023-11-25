package SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumBasics {

    public static void main(String[] args) {
        //First STEP:Setting up automation
        WebDriverManager.chromedriver().setup();
        //SECOND STEP:Creating driver to make a connection with website
        WebDriver driver=new ChromeDriver();
        //THIRD STEP:Navigating to the website
        driver.get("https://www.amazon.com/");
        System.out.println(driver.getTitle());
        String actualTitle=driver.getTitle();
        String expectedTitle="Amazon.com. Spend less. Smile more.";
        if(actualTitle.equals(expectedTitle)){
            System.out.println("TITLE IS PASSED");
        }else{
            System.out.println("TITLE IS FAILED");
        }
        String actualUrl=driver.getCurrentUrl();
        String expectedUrl="https://www.amazon.com/";
        if(actualUrl.equals(expectedUrl)){
            System.out.println("URL IS PASSING");
        }else{
            System.out.println("URL IS FAILING");
        }
        //HOMEWORK:
        //I WANT YOU GO TO 3 different websites and validate TITLE AND URL
        driver.close();
    }
}
