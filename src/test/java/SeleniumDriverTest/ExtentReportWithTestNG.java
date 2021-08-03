package SeleniumDriverTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.GoogleSearchPage;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ExtentReportWithTestNG {
    ExtentReports reports;
    WebDriver driver;
    GoogleSearchPage googleSearchPage;
    ExtentTest test;
    Properties properties = new Properties();

    @BeforeSuite
    public void setUp() throws IOException {

        ExtentSparkReporter reporter = new ExtentSparkReporter("ExtentReport.html");
        reports = new ExtentReports();
        reports.attachReporter(reporter);
        InputStream file = new FileInputStream("src/test/resources/config.properties");
        properties.load(file);
        if (properties.getProperty("browser").equals("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if(properties.getProperty("browser").equals("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else {
            throw new NotFoundException("Browser was not found");
        }

    }

    @Test
    public void test1() throws InterruptedException {
        test = reports.createTest("Testing Extent Report 1");
        googleSearchPage = new GoogleSearchPage(driver);
        test.log(Status.PASS,"Driver loaded successfully");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
        driver.get("https://www.google.co.in");
        test.log(Status.PASS,"Google page loaded successfully");
        googleSearchPage.textboxSearch("TestingStepByStepAutomation 1");
        test.log(Status.PASS,"Text entered successfully");
        test.addScreenCaptureFromPath("Screenshot1.png");
        Thread.sleep(2000);
    }

    @Test
    public void test2() throws InterruptedException {
        test = reports.createTest("Testing Extent Report 2");
        googleSearchPage = new GoogleSearchPage(driver);
        test.log(Status.PASS,"Driver loaded successfully");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
        driver.get("https://www.google.co.in");
        test.log(Status.PASS,"Google page loaded successfully");
        googleSearchPage.textboxSearch("TestingStepByStepAutomation 2");
        test.log(Status.PASS,"Text entered successfully");
        test.addScreenCaptureFromPath("Screenshot2.png");
        Thread.sleep(2000);
    }

    @AfterTest
    public void closeBrowser(){
        googleSearchPage.closeBrowser();
        test.log(Status.PASS,"Browser Closed successfully");
    }

    @AfterSuite
    public void teardown(){
        reports.flush();
    }
}
