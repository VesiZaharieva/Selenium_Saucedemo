package Selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class MainDriverProductPage {
    WebDriver driver;

    @BeforeMethod
    public void Login(){
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        driver.get ("https://www.saucedemo.com/");
            WebElement username = driver.findElement(By.cssSelector("[placeholder = Username]"));
            username.sendKeys("standard_user");

            WebElement password = driver.findElement(By.cssSelector("[placeholder=Password]"));
            password.sendKeys("secret_sauce");

            WebElement loginButton = driver.findElement(By.cssSelector("[value=Login]"));
            loginButton.click();
            }
    //@AfterMethod
    //public void tearDown() {
    //driver.quit();
    //}
}
