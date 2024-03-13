package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class SeleniumTest extends MainDriver{
    @Test
            public void userName() {

        WebElement username = driver.findElement(By.cssSelector("[placeholder = Username]"));
        username.click();
        username.sendKeys("standard_user");

        WebElement password = driver.findElement(By.cssSelector("[placeholder=Password]"));
        password.click();
        password.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.cssSelector("[value=Login]"));
        loginButton.click();


    }
}
