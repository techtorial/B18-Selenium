package SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumDriverMethods {

    //driver.get()
    //driver.manage.window.maximize()
    //driver.getTitle()
    //driver.GetCurrentUrl()
    //driver.navigate.to()
    //driver.navigate.refresh()
    //driver.navigate.forward()
    //driver.navigate.back()
    //driver.getPageSource()
    //driver.close()
    //driver.quit()
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver=new ChromeDriver();
        driver.manage().window().maximize();//it maximizes your screen
        driver.get("https://www.google.com/");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        Thread.sleep(2000);//this will wait for 2 sec
        driver.navigate().to("https://www.facebook.com/");
        System.out.println(driver.getTitle());
        Thread.sleep(2000);
        driver.navigate().back();//google
        System.out.println(driver.getCurrentUrl());
        Thread.sleep(2000);
        driver.navigate().forward();//facebook
        System.out.println(driver.getTitle());
        System.out.println(driver.getPageSource());//this will give you html structure of the page.
        driver.quit();//it closes all the pages that opened during automation
    }
}
