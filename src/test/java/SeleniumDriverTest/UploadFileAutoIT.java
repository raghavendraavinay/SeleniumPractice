package SeleniumDriverTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class UploadFileAutoIT {

    @Test
    public void uploadDemo() throws InterruptedException, IOException {

        WebDriverManager.chromedriver().setup();
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("acceptInsecureCerts=true");
//        options.setCapability("acceptInsecureCerts","true");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://filetransfer.io/");
        driver.findElement(By.xpath("//a[@class='btn btn-primary select-files']")).click();
        Runtime.getRuntime().exec("C:/Users/raghavendra_av/Downloads/UploadScript.exe");
        Thread.sleep(2000);
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='alert alert-warning alert-noremove']")).isDisplayed());
        driver.close();

    }
}
