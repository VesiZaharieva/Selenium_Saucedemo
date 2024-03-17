package Selenium;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

public class MainDriverLogin {
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
