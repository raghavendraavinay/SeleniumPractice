package SeleniumDriverTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class SeleniumWaitDemo {

    WebDriver driver;

    @Test
    public void seleniumWait(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
//        Implicit Wait
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://google.co.in");
        driver.findElement(By.name("q")).sendKeys("Automation Step by Step");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        //        Explicit Wait
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("a")));
        driver.findElement(By.name("a")).click();
        driver.close();

    }
}
