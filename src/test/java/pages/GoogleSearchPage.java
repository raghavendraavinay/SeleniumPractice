package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleSearchPage {

    By txtSearch = By.xpath("//input[@name='q']");

    WebDriver driver;

    public GoogleSearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public void textboxSearch(String text) {

        WebElement webElement = driver.findElement(txtSearch);
        webElement.sendKeys(text);
        webElement.sendKeys(Keys.ENTER);
    }

    public void closeBrowser(){
        driver.close();
    }
}
