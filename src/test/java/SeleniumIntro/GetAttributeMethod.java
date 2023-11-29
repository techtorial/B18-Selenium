package SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetAttributeMethod {

    public static void main(String[] args) {
        //TASK
        //print out the John Doe
        //Print out the ThisIsNotPassword on the console
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://katalon-demo-cura.herokuapp.com/profile.php#login");
        WebElement username=driver.findElement(By.xpath("//input[@aria-describedby='demo_username_label']"));
        System.out.println(username.getText());//input[@aria-describedby='demo_password_label']
        System.out.println(username.getAttribute("value"));
        WebElement password=driver.findElement(By.xpath("//input[@aria-describedby='demo_password_label']"));
        System.out.println(password.getAttribute("value"));
        System.out.println(password.getAttribute("placeholder"));
    }
}
