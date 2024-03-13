package Selenium;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class MainDriver {
    WebDriver driver;

    @BeforeMethod
    public void before(){
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        driver.get ("https://www.saucedemo.com/");
    }
    //@AfterMethod
    //public void tearDown() {
    //driver.quit();
    //}
}
