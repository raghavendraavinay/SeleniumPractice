package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class ExcelProvider {

    private WebDriver driver;

    @BeforeTest
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test(dataProvider = "test1data")
    public void testdata(String username, String password) throws IOException, InterruptedException {
        System.out.println(username+" | "+password);
        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.findElement(By.id("txtUsername")).sendKeys(username);
        driver.findElement(By.id("txtPassword")).sendKeys(password);
        driver.findElement(By.name("Submit")).click();
        Thread.sleep(2000);

    }

    @AfterTest
    public void tearDown(){
        driver.close();
    }

    @DataProvider(name = "test1data")
    public Object[][] getData() throws IOException {
        return testData("src/test/resources/data.xlsx","Sheet1");
    }
    public Object[][] testData(String excelPath, String sheetName) throws IOException {
        ExcelUtils util = new ExcelUtils(excelPath,sheetName);

        int rowCnt = util.getRowCount();
        int colCnt = util.getColumnCount();
        Object[][] data = new Object[rowCnt-1][colCnt];
        for (int i=1;i<rowCnt;i++){
            for (int j=0;j<colCnt;j++){
                System.out.println("Row "+i+" Col "+j+" :"+util.getCellData(i,j));
                data[i-1][j] = util.getCellData(i,j);
            }
        }
        return data;
    }
}
