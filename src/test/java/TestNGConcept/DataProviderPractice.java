package TestNGConcept;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice {

//    @DataProvider(name = "couples")
//    public Object[][] getData(){
//        return new Object[][]{
//                {"Azzedine","Lilia","Ahmet"},
//                {"Nail","Nazgul","Mehmet"},
//                {"Hacer","Omer Tarik","Ayse"},
//                {"Elvira","Mr.K","Mahmut"}
//        };
//    }

    @Test(dataProvider = "couples",dataProviderClass = AllData.class)
    public void couples(String firstCouple,String secondCouple,String child){
        System.out.println(firstCouple + secondCouple +child);
    }

//    @Test
//    public void couples1(){
//        System.out.println("Nail"+"Nazgul");
//    }
//
//    @Test
//    public void couples2(){
//        System.out.println("Hacer"+"Omer Tarik");
//    }
//
//    @Test
//    public void couples3(){
//        System.out.println("Elvira"+"Mr.K");
//    }

}
