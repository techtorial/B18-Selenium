package TestNGConcept;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGAssertion {

    public int multiplication(int number,int number2){
        return number*number2;
    }

    @Test
    public void validateMultiplication(){
        int actualResult=multiplication(3,4);
        int expectedResult=12;
        System.out.println(actualResult==expectedResult ? "TRUE":"FALSE");
        if(actualResult==expectedResult){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }
        Assert.assertEquals(actualResult,expectedResult);
    }
    @Test
    public void validateZer0Logic(){
        int actualResult=multiplication(0,9999);
        int expectedResult=0;
        Assert.assertEquals(actualResult,expectedResult);
        Assert.assertTrue(actualResult==expectedResult);
    }
}
