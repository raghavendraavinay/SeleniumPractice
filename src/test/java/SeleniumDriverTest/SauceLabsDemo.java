package SeleniumDriverTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class SauceLabsDemo {

    public static final String USERNAME = "";
    public static final String ACCESS_KEY = "";
    public static final String URL = "";

    @Test
    public void test1() throws InterruptedException, MalformedURLException {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.setCapability("platform","Linux");
        options.setCapability("version","latest");
        options.setCapability("name","Google Test");
        options.setCapability("extendedDebugging","true");
//        WebDriver driver = new ChromeDriver(options);

        WebDriver driver = new RemoteWebDriver(new URL(URL),options);

        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("admin123");
        driver.findElement(By.name("Submit")).click();
        Thread.sleep(2000);
        driver.close();
        System.out.println("Execution Completed");
    }
}
