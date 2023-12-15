package TestNGConcept;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterAnnotation {

    @Parameters("firstName")
    @Test
    public void name(String firstName){
        System.out.println(firstName);
    }
    @Parameters({"country","city","zipCode"})
    @Test(priority = 2)
    public void information(String country,String city,String zipCode){
        System.out.println(country);
        System.out.println(city);
        System.out.println(zipCode);
    }
}
