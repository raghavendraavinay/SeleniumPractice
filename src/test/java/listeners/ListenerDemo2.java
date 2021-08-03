package listeners;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestNGListener.class)
public class ListenerDemo2 {

    @Test
    public void test4(){
        System.out.println("Inside Test4");
    }

    @Test
    public void test5(){
        System.out.println("Inside 5");
        Assert.fail("Assertion Failed");
    }

    @Test
    public void test6(){
        System.out.println("Inside Test6");
        throw new SkipException("Test Skipped");
    }
}
