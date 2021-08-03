package listeners;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

//@Listeners(listeners.TestNGListener.class)
public class ListenerDemo {

    @Test
    public void test1() throws InterruptedException {
        System.out.println("Inside Test1");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.findElement(By.id("txtUsername")).sendKeys("admin1");
        driver.findElement(By.id("txtPassword")).sendKeys("password");
        driver.findElement(By.name("Submit")).click();
        Thread.sleep(2000);
        driver.close();
    }

    @Test
    public void test2(){
        System.out.println("Inside Test2");
        Assert.fail("Assertion Failed");
    }

    @Test
    public void test3(){
        System.out.println("Inside Test3");
        throw new SkipException("Test Skipped");
    }
}
