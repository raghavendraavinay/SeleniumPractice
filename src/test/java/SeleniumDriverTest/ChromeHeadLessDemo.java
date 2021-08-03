package SeleniumDriverTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

import java.time.Duration;

public class ChromeHeadLessDemo {

    @Test
    public void headless() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);
        WebDriver driver = new ChromeDriver(options);

        driver.get("https://google.co.in");
        driver.findElement(By.name("q")).sendKeys("Automation");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        driver.findElement(By.linkText("2")).click();
        Wait wait = new FluentWait(driver)
                .withTimeout(Duration.ofMillis(10000))
                .pollingEvery(Duration.ofMillis(20))
                .ignoring(NoSuchElementException.class);
        WebElement element = (WebElement) wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("UiPath: Automation Platform - Leading RPA Company")));
        element.click();
        Thread.sleep(2000);
        driver.close();
    }
}
