package TestNGConcept;

import org.testng.annotations.*;

public class TestNGAnnotations {
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("I am beforeSuite annotation");
    }
    @BeforeTest
    public void beforeTest(){
        System.out.println("I am beforeTest annotation");
    }
    @BeforeClass
    public void beforeClass(){
        System.out.println("I am beforeClass annotation");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("I am beforeMethod annotation");
    }
    @Test(priority = 1,invocationCount = 1)
    public void test1(){
        System.out.println("I am test1 annotation");
    }
    @Test(priority = 2)
    public void test2(){
        System.out.println("I am test2 annotation");
    }
    @AfterMethod
    public void asdasd(){
        System.out.println("I am AfterMethod Annotation");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("I am AfterClass annotation");
    }
    @AfterTest
    public void afterTest(){
        System.out.println("I am AfterTest annotation");
    }
    @AfterSuite
    public void afterSuite(){
        System.out.println("I am AfterSuite Annotation");

    }



}
