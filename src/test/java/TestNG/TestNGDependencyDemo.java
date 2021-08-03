package TestNG;

import org.testng.annotations.Test;

public class TestNGDependencyDemo {

//    @Test(dependsOnMethods = {"test3","test2"}, priority = 1)
    @Test(dependsOnGroups = "s.*")
    public void test1(){
        System.out.println("Test1");
    }

    @Test(groups = "sanity")
    public void test2(){
        System.out.println("Test2");
    }

    @Test(groups = "smoke")
    public void test3(){
        System.out.println("Test3");
    }
}
