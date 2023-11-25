package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class XPathHealthPractice {

    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        WebElement makeAppointment=driver.findElement(By.xpath("//a[@id='btn-make-appointment']"));
        makeAppointment.click();
        WebElement username=driver.findElement(By.xpath("//input[@name='username']"));
        username.sendKeys("John Doe");
        WebElement password=driver.findElement(By.xpath("//input[@id='txt-password']"));
        password.sendKeys("ThisIsNotAPassword");
        WebElement loginButton=driver.findElement(By.xpath("//button"));
        loginButton.click();
        WebElement facility=driver.findElement(By.xpath("//select[@id='combo_facility']"));
        facility.sendKeys("Hongkong CURA Healthcare Center");
        WebElement admissionBox=driver.findElement(By.xpath("//input[@name='hospital_readmission']"));
//        if(admissionBox.isDisplayed() && !admissionBox.isSelected()){
//            admissionBox.click();
//        }
        Assert.assertTrue(admissionBox.isDisplayed());//true
        Assert.assertFalse(admissionBox.isSelected());
        admissionBox.click();
        Assert.assertTrue(admissionBox.isSelected());
        WebElement medicaidProgram=driver.findElement(By.xpath("//input[@value='Medicaid']"));
        medicaidProgram.click();
        WebElement visitDate=driver.findElement(By.xpath("//input[@id='txt_visit_date']"));
        visitDate.sendKeys("08/11/2023");
        WebElement comment=driver.findElement(By.xpath("//textarea[@name='comment']"));
        comment.sendKeys("I love Selenium");
        WebElement bookAppointment=driver.findElement(By.xpath("//button[.='Book Appointment']"));
        bookAppointment.click();
        WebElement header=driver.findElement(By.xpath("//h2[contains(text(),'Appointment')]"));
        String actualHeader=header.getText().trim();
        String expectedHeader="Appointment Confirmation";
        System.out.println(actualHeader.equals(expectedHeader)? "PASSED":"FAILED");
        Assert.assertEquals(actualHeader,expectedHeader);
        WebElement facilityValidation=driver.findElement(By.xpath("//p[contains(text(),'Hongkong')]"));
        System.out.println(facilityValidation.getText());
    }


    /*
//THESE PARTS SHOULD BE DONE BY XPATH:
1-Navigate to the https://katalon-demo-cura.herokuapp.com/
2-Click Make an Appointment
3-Login the username and password provided and Login successfully
4-Choose the facility either HongKong or Seoul -->send keys
5-Click apply for hospital admission box if it is displayed and validate it is selected
6-Healthcare program 'Medicaid'
7-Visit date should be provided -->send keys
8-Put your comment for this box -->send keys
9-Book your appointment
THESE PARTS SHOULD BE DONE BY CONTAINS or .equals XPATH METHOD
10-Validate the header is "Appointment Confirmation" (if statement)
11-Print out the headers and values(only values) on your console.
12)Click go to homepage and print out url
13)Driver.quit or close.


     */
}