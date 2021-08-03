package TestNG;

import org.testng.annotations.Test;

@Test(groups = "AllTests")
public class TestNGGroupDemo {

    @Test(groups = "smoke")
    public void test1(){
        System.out.println("Test1");
    }

    @Test(groups = "sanity")
    public void test2(){
        System.out.println("Test2");
    }

    @Test(groups = {"smoke","sanity"})
    public void test3(){
        System.out.println("Test3");
    }

    @Test
    public void test4(){
        System.out.println("Test4");
    }
}
