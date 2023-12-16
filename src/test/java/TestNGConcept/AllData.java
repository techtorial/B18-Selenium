package TestNGConcept;

import org.testng.annotations.DataProvider;

public class AllData {

        @DataProvider(name = "couples")
    public Object[][] getData(){
        return new Object[][]{
                {"Azzedine","Lilia","Ahmet"},
                {"Nail","Nazgul","Mehmet"},
                {"Hacer","Omer Tarik","Ayse"},
                {"Elvira","Mr.K","Mahmut"}
        };
    }
}
