package SeleniumDriverTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import pages.GoogleSearchPage;

import java.util.concurrent.TimeUnit;

public class DesiredCapabilitiesDemo {

    WebDriver driver;
    GoogleSearchPage googleSearchPage;

    @Test
    public void test1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("ignoreProtectedModeSettings",true);
        driver = new ChromeDriver(options);
        googleSearchPage = new GoogleSearchPage(driver);

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
        driver.get("https://www.google.co.in");

        googleSearchPage.textboxSearch("TestingStepByStepAutomation 1");
        Thread.sleep(2000);
        googleSearchPage.closeBrowser();
    }
}












