package SeleniumDriverTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.GoogleSearchPage;

import java.util.concurrent.TimeUnit;

public class ExtentReportTest {
    private static WebDriver driver;
    private static GoogleSearchPage googleSearchPage;


    public static void main(String[] args) throws InterruptedException {
        ExtentSparkReporter reporter = new ExtentSparkReporter("ExtentReport.html");
        ExtentReports reports = new ExtentReports();
        reports.attachReporter(reporter);

        ExtentTest test = reports.createTest("Testing Extent Report");

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        googleSearchPage = new GoogleSearchPage(driver);
        test.log(Status.PASS,"Driver loaded successfully");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
        driver.get("https://www.google.co.in");
        test.log(Status.PASS,"Google page loaded successfully");
        googleSearchPage.textboxSearch("TestingStepByStepAutomation");
        test.log(Status.PASS,"Text entered successfully");
        googleSearchPage.closeBrowser();
        test.log(Status.PASS,"Browser Closed successfully");
        reports.flush();
    }
}
