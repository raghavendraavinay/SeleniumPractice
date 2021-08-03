package SeleniumDriverTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.GoogleSearchPage;

import java.util.concurrent.TimeUnit;

public class Test1_GoogleSearch {

    GoogleSearchPage googleSearchPage;
    @Test
    public void googleSearch() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
        driver.get("https://google.com");
        googleSearchPage = new GoogleSearchPage(driver);
        googleSearchPage.textboxSearch("Automation Step By Step");
        Thread.sleep(2000);
        googleSearchPage.closeBrowser();
    }
}
