package TestNGConcept;

import org.testng.annotations.Test;

public class TestNGIntro {

    @Test(priority =1,invocationCount = 20)
    public void test1(){
        System.out.println("Test1");
        System.out.println("Creating data");//20 data
    }

    @Test(priority = 3)
    public void test2(){
        System.out.println("Test2");
    }

    @Test(priority = 2)
    public void test3(){
        System.out.println("Test3");
    }

    @Test(priority = 4)
    public void ahmet(){
        System.out.println("Test4");
    }

}
