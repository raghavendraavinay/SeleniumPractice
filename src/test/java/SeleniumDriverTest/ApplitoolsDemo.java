package SeleniumDriverTest;

import com.applitools.eyes.selenium.Eyes;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class ApplitoolsDemo {

    @Test
    public void test1() throws InterruptedException, MalformedURLException {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        Eyes eyes = new Eyes();
        eyes.setApiKey("");
        eyes.open(driver,"Hello World","Test1");

        driver.get("https://applitools.com/helloworld2/?diff2");
        eyes.checkWindow("Hello!");

        driver.findElement(By.tagName("button")).click();
        eyes.checkWindow("Click!");
        eyes.close();

        Thread.sleep(2000);
        driver.close();
        System.out.println("Execution Completed");
    }
}
