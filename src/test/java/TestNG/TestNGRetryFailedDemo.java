package TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGRetryFailedDemo {

    @Test
    public void test1(){
        System.out.println("Test1");
    }

    @Test
    public void test2(){
        System.out.println("Test2");
        int i = 1/0;
    }

    @Test(retryAnalyzer = listeners.RetryAnalyser.class)
    public void test3(){
        System.out.println("Test3");
        Assert.fail("Testing Failure");
    }
}
