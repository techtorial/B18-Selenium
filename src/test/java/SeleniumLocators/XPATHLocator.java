package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XPATHLocator {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");
        WebElement abTesting=driver.findElement(By.partialLinkText("Testing"));
        abTesting.click();
        WebElement header=driver.findElement(By.xpath("/html/body/div[2]/div/div/h3"));
        System.out.println(header.getText().trim());
        WebElement paragraph=driver.findElement(By.xpath("/html/body/div[2]/div/div/p"));
        System.out.println(paragraph.getText());
        System.out.println("  ahmet loves Selenium    ");
        System.out.println("   ahmet loves  Selenium   ".trim());
//        WebElement selenium=driver.findElement(By.xpath("//a[contains(text(),'Selenium')]"));
        WebElement selenium=driver.findElement(By.xpath("//a[.='Elemental Selenium']"));
        selenium.click();
    }
}
