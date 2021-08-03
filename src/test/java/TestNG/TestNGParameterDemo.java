package TestNG;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGParameterDemo {

    @Test
    @Parameters("Name")
    public void test1(@Optional("Raghav") String name){
        System.out.println("Name: "+name);
    }
}
