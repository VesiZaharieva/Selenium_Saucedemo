package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class SeleniumTestLogin extends MainDriverLogin {
    @Test
    public void loginButtonColor() {
        WebElement loginButton = driver.findElement(By.cssSelector("[data-test=login-button]"));
        Assert.assertTrue(loginButton.isDisplayed());
        String loginButtonColor = loginButton.getCssValue("background-color");
        Assert.assertEquals(loginButtonColor, "rgba(61, 220, 145, 1)");
    }

    @Test
    public void correctLogin() {
        WebElement username = driver.findElement(By.cssSelector("[placeholder = Username]"));
        username.sendKeys("standard_user");

        WebElement password = driver.findElement(By.cssSelector("[placeholder=Password]"));
        password.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.cssSelector("[value=Login]"));
        loginButton.click();

        assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
    }
    @Test
    public void emptyUsername() {
        WebElement password = driver.findElement(By.cssSelector("[placeholder=Password]"));
        password.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.cssSelector("[value=Login]"));
        loginButton.click();

        WebElement errorMessage = driver.findElement(By.cssSelector("[data-test=error]"));
        String errorMessageText = errorMessage.getText();
        Assert.assertEquals(errorMessageText, "Epic sadface: Username is required");
    }
    @Test
    public void emptyPassword() {
        WebElement username = driver.findElement(By.cssSelector("[placeholder = Username]"));
        username.sendKeys("standard_user");

        WebElement loginButton = driver.findElement(By.cssSelector("[value=Login]"));
        loginButton.click();

        WebElement errorMessage = driver.findElement(By.cssSelector("[data-test=error]"));
        String errorMessageText = errorMessage.getText();
        Assert.assertEquals(errorMessageText, "Epic sadface: Password is required");
    }
    @Test
    public void emptyUsernameAndPassword() {
        WebElement username = driver.findElement(By.cssSelector("[placeholder = Username]"));
        username.click();

        WebElement password = driver.findElement(By.cssSelector("[placeholder=Password]"));
        password.click();

        WebElement loginButton = driver.findElement(By.cssSelector("[value=Login]"));
        loginButton.click();

        WebElement errorMessage = driver.findElement(By.cssSelector("[data-test=error]"));
        String errorMessageText = errorMessage.getText();
        Assert.assertEquals(errorMessageText, "Epic sadface: Username is required");
    }
    @Test
    public void errorXiconForDifferentUsername() {
        WebElement username = driver.findElement(By.cssSelector("[placeholder = Username]"));
        username.sendKeys("standard_userX");

        WebElement password = driver.findElement(By.cssSelector("[placeholder=Password]"));
        password.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.cssSelector("[value=Login]"));
        loginButton.click();

        WebElement errorX = driver.findElement(By.xpath("//*[@id='user-name']/..//*[@data-icon='times-circle']"));
        Assert.assertTrue(errorX.isDisplayed());
    }

    @Test
    public void errorMessageContainerColorsForDifferentUsername() {
        WebElement username = driver.findElement(By.cssSelector("[placeholder = Username]"));
        username.sendKeys("standard_userX");

        WebElement password = driver.findElement(By.cssSelector("[placeholder=Password]"));
        password.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.cssSelector("[value=Login]"));
        loginButton.click();

        WebElement errorMessageContainer = driver.findElement(By.className("error-message-container"));
        Assert.assertTrue(errorMessageContainer.isDisplayed());
        String errorMessageContainerColor = errorMessageContainer.getCssValue("background-color");
        Assert.assertEquals(errorMessageContainerColor, "rgba(226, 35, 26, 1)");

    }

    @Test
    public void errorMessageTextForDifferentUsername() {
        WebElement username = driver.findElement(By.cssSelector("[placeholder = Username]"));
        username.sendKeys("standard_userX");

        WebElement password = driver.findElement(By.cssSelector("[placeholder=Password]"));
        password.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.cssSelector("[value=Login]"));
        loginButton.click();

        WebElement errorMessage = driver.findElement(By.cssSelector("[data-test=error]"));
        String errorMessageText = errorMessage.getText();
        Assert.assertEquals(errorMessageText, "Epic sadface: Username and password do not match any user in this service");
    }

    @Test
    public void errorMessageTextColorForDifferentUsername() {
        WebElement username = driver.findElement(By.cssSelector("[placeholder = Username]"));
        username.sendKeys("standard_userX");

        WebElement password = driver.findElement(By.cssSelector("[placeholder=Password]"));
        password.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.cssSelector("[value=Login]"));
        loginButton.click();

        WebElement errorMessage = driver.findElement(By.cssSelector("[data-test=error]"));
        String errorMessageColor = errorMessage.getCssValue("color");
        Assert.assertEquals(errorMessageColor, "rgba(255, 255, 255, 1)");
    }

    @Test
    public void errorXiconForLockedUser() {
        WebElement username = driver.findElement(By.cssSelector("[placeholder = Username]"));
        username.sendKeys("locked_out_user");

        WebElement password = driver.findElement(By.cssSelector("[placeholder=Password]"));
        password.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.cssSelector("[value=Login]"));
        loginButton.click();

        WebElement errorX = driver.findElement(By.xpath("//*[@id='user-name']/..//*[@data-icon='times-circle']"));
        Assert.assertTrue(errorX.isDisplayed());
    }

    @Test
    public void errorMessageContainerColorsForLockedUser() {
        WebElement username = driver.findElement(By.cssSelector("[placeholder = Username]"));
        username.sendKeys("locked_out_user");

        WebElement password = driver.findElement(By.cssSelector("[placeholder=Password]"));
        password.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.cssSelector("[value=Login]"));
        loginButton.click();

        WebElement errorMessageContainer = driver.findElement(By.className("error-message-container"));
        Assert.assertTrue(errorMessageContainer.isDisplayed());
        String errorMessageContainerColor = errorMessageContainer.getCssValue("background-color");
        Assert.assertEquals(errorMessageContainerColor, "rgba(226, 35, 26, 1)");
    }

    @Test
    public void errorMessageTextForLockedUser() {
        WebElement username = driver.findElement(By.cssSelector("[placeholder = Username]"));
        username.sendKeys("locked_out_user");

        WebElement password = driver.findElement(By.cssSelector("[placeholder=Password]"));
        password.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.cssSelector("[value=Login]"));
        loginButton.click();

        WebElement errorMessage = driver.findElement(By.cssSelector("[data-test=error]"));
        String errorMessageText = errorMessage.getText();
        Assert.assertEquals(errorMessageText, "Epic sadface: Sorry, this user has been locked out.");
    }

    @Test
    public void errorMessageTextColorForLockedUser() {
        WebElement username = driver.findElement(By.cssSelector("[placeholder = Username]"));
        username.sendKeys("locked_out_user");

        WebElement password = driver.findElement(By.cssSelector("[placeholder=Password]"));
        password.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.cssSelector("[value=Login]"));
        loginButton.click();

        WebElement errorMessage = driver.findElement(By.cssSelector("[data-test=error]"));
        String errorMessageColor = errorMessage.getCssValue("color");
        Assert.assertEquals(errorMessageColor, "rgba(255, 255, 255, 1)");
    }

    @Test
    public void correctUsernameAfterDifferentUsername() {
        WebElement username = driver.findElement(By.cssSelector("[placeholder = Username]"));
        username.sendKeys("standard_userX");

        WebElement password = driver.findElement(By.cssSelector("[placeholder=Password]"));
        password.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.cssSelector("[value=Login]"));
        loginButton.click();

        username.clear();
        username.sendKeys("standard_user");

        loginButton = driver.findElement(By.cssSelector("[value=Login]"));
        loginButton.click();

        assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
    }

    @Test
    public void TwoEntriesDifferentUsername() {
        WebElement differentUsername = driver.findElement(By.cssSelector("[placeholder = Username]"));
        differentUsername.sendKeys("standard_userX");

        WebElement password = driver.findElement(By.cssSelector("[placeholder=Password]"));
        password.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.cssSelector("[value=Login]"));
        loginButton.click();

        //WebElement lockedUser = driver.findElement(By.cssSelector("[placeholder = Username]"));
        differentUsername.clear();
        differentUsername.sendKeys("standard_userX");

        loginButton = driver.findElement(By.cssSelector("[value=Login]"));
        loginButton.click();

        WebElement errorMessageContainer = driver.findElement(By.className("error-message-container"));
        Assert.assertTrue(errorMessageContainer.isDisplayed());
    }

    @Test
    public void lockedUserAfterDifferentUsername() {
        WebElement username = driver.findElement(By.cssSelector("[placeholder = Username]"));
        username.sendKeys("standard_userX");

        WebElement password = driver.findElement(By.cssSelector("[placeholder=Password]"));
        password.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.cssSelector("[value=Login]"));
        loginButton.click();

        username.clear();
        username.sendKeys("locked_out_user");

        loginButton = driver.findElement(By.cssSelector("[value=Login]"));
        loginButton.click();

        WebElement errorMessageContainer = driver.findElement(By.className("error-message-container"));
        Assert.assertTrue(errorMessageContainer.isDisplayed());
    }
    @Test
    public void wrongPassword() {
        WebElement username = driver.findElement(By.cssSelector("[placeholder = Username]"));
        username.sendKeys("standard_user");

        WebElement password = driver.findElement(By.cssSelector("[placeholder=Password]"));
        password.sendKeys("secret_sauceX");

        WebElement loginButton = driver.findElement(By.cssSelector("[value=Login]"));
        loginButton.click();

        WebElement errorMessage = driver.findElement(By.cssSelector("[data-test=error]"));
        String errorMessageText = errorMessage.getText();
        Assert.assertEquals(errorMessageText, "Epic sadface: Username and password do not match any user in this service");
    }

}
