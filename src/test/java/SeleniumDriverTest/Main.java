package SeleniumDriverTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.GoogleSearchPage;

import java.util.concurrent.TimeUnit;

public class Main {

    WebDriver driver;
    GoogleSearchPage googleSearchPage;


    @BeforeTest
    public void BeforeTest(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        googleSearchPage = new GoogleSearchPage(driver);
    }

    @Test
    public void testDriver() throws InterruptedException {
//        System.setProperty("webdriver.chrome.driver","Drivers/chromedriver.exe");
//        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
        driver.get("https://www.google.co.in");
//        driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("Testing");
        googleSearchPage.textboxSearch("TestingStepByStepAutomation");
        googleSearchPage.closeBrowser();

    }
}
