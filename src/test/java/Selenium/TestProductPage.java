package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestProductPage extends MainDriverProductPage {
    @Test
    public void assertTitle() {
        WebElement pageTitle = driver.findElement(By.className("title"));
        String pageTitleText = pageTitle.getText();
        Assert.assertEquals(pageTitleText, "Products");
        Assert.assertTrue(pageTitle.isDisplayed());
    }

    @Test
    public void reviewProduct() {
        WebElement productTitle = driver.findElement(By.xpath("//div[contains(text(),'Sauce Labs Backpack')]"));
        productTitle.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory-item.html?id=4");
    }
    @Test
    public void reviewProductAndAddProduct() {
        WebElement productTitle = driver.findElement(By.xpath("//div[contains(text(),'Sauce Labs Backpack')]"));
        productTitle.click();
        WebElement addProductButton = driver.findElement(By.cssSelector("[name^=add-to-cart-sauce]"));
        addProductButton.click();
        WebElement BasketRedMark = driver.findElement(By.className("shopping_cart_badge"));
        Assert.assertTrue(BasketRedMark.isDisplayed());
    }
    @Test
    public void rejectProductFromReviewProduct() {
        WebElement productTitle = driver.findElement(By.xpath("//div[contains(text(),'Sauce Labs Backpack')]"));
        productTitle.click();
        WebElement addProductButton = driver.findElement(By.cssSelector("[name^=add-to-cart-sauce]"));
        addProductButton.click();
        WebElement removeProductButton = driver.findElement(By.cssSelector("[name^=remove-sauce-labs]"));
        removeProductButton.click();
        //...
            }
    @Test
    public void addProductFromProducts() {
        WebElement addProductButton = driver.findElement(By.cssSelector("[name^=add-to-cart-sauce]"));
        addProductButton.click();
        WebElement BasketRedMark = driver.findElement(By.className("shopping_cart_badge"));
        Assert.assertTrue(BasketRedMark.isDisplayed());
    }
    @Test
    public void rejectProductFromProducts() {
        WebElement addProductButton = driver.findElement(By.cssSelector("[name^=add-to-cart-sauce]"));
        addProductButton.click();
        WebElement removeProductButton = driver.findElement(By.cssSelector("[name^=remove-sauce-labs]"));
        removeProductButton.click();
        //...
    }
    @Test
    public void reviewBasket() {
        WebElement addProductButton = driver.findElement(By.cssSelector("[name^=add-to-cart-sauce]"));
        addProductButton.click();
        WebElement basketIcon = driver.findElement(By.className("shopping_cart_link"));
        basketIcon.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/cart.html");
    }
    @Test
    public void continueShoppingFromBasket(){
        WebElement addProductButton = driver.findElement(By.cssSelector("[name^=add-to-cart-sauce]"));
        addProductButton.click();
        WebElement basketIcon = driver.findElement(By.className("shopping_cart_link"));
        basketIcon.click();
        WebElement continueShoppingButton = driver.findElement(By.cssSelector("[name^=continue-shopping]"));
        continueShoppingButton.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
    }
    @Test
    public void checkoutBasket(){
        WebElement addProductButton = driver.findElement(By.cssSelector("[name^=add-to-cart-sauce]"));
        addProductButton.click();
        WebElement basketIcon = driver.findElement(By.className("shopping_cart_link"));
        basketIcon.click();
        WebElement checkoutButton = driver.findElement(By.cssSelector("#checkout"));
        checkoutButton.click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/checkout-step-one.html");
    }
    @Test
    public void checkoutEmptyEntries(){
        WebElement addProductButton = driver.findElement(By.cssSelector("[name^=add-to-cart-sauce]"));
        addProductButton.click();
        WebElement basketIcon = driver.findElement(By.className("shopping_cart_link"));
        basketIcon.click();
        WebElement checkoutButton = driver.findElement(By.cssSelector("#checkout"));
        checkoutButton.click();
        WebElement continueButton = driver.findElement(By.cssSelector("#continue"));
        continueButton.click();
        WebElement errorMessageContainer = driver.findElement(By.cssSelector("[class^=error-message-container]"));
        Assert.assertTrue(errorMessageContainer.isDisplayed());
    }
    @Test
    public void checkoutEmptyEntriesErrorMessage(){
        WebElement addProductButton = driver.findElement(By.cssSelector("[name^=add-to-cart-sauce]"));
        addProductButton.click();
        WebElement basketIcon = driver.findElement(By.className("shopping_cart_link"));
        basketIcon.click();
        WebElement checkoutButton = driver.findElement(By.cssSelector("#checkout"));
        checkoutButton.click();
        WebElement continueButton = driver.findElement(By.cssSelector("#continue"));
        continueButton.click();
        WebElement errorMessage = driver.findElement(By.cssSelector("[data-test=error]"));
        Assert.assertTrue(errorMessage.isDisplayed());
        String errorMessageText = errorMessage.getText();
        Assert.assertEquals(errorMessageText, "Error: First Name is required");
    }
    @Test
    public void checkoutEmptyEntriesRedFisrtname(){
        WebElement addProductButton = driver.findElement(By.cssSelector("[name^=add-to-cart-sauce]"));
        addProductButton.click();
        WebElement basketIcon = driver.findElement(By.className("shopping_cart_link"));
        basketIcon.click();
        WebElement checkoutButton = driver.findElement(By.cssSelector("#checkout"));
        checkoutButton.click();
        WebElement continueButton = driver.findElement(By.cssSelector("#continue"));
        continueButton.click();
        WebElement firstNameRed = driver.findElement(By.cssSelector("[placeholder='First Name']"));
        Assert.assertTrue(firstNameRed.isDisplayed());
        String firstNameRedColor = firstNameRed.getCssValue("border-bottom-color");
         Assert.assertEquals(firstNameRedColor, "rgba(226, 35, 26, 1)");
    }
    @Test
    public void checkoutEmptyEntriesRedLastname(){
        WebElement addProductButton = driver.findElement(By.cssSelector("[name^=add-to-cart-sauce]"));
        addProductButton.click();
        WebElement basketIcon = driver.findElement(By.className("shopping_cart_link"));
        basketIcon.click();
        WebElement checkoutButton = driver.findElement(By.cssSelector("#checkout"));
        checkoutButton.click();
        WebElement continueButton = driver.findElement(By.cssSelector("#continue"));
        continueButton.click();
        WebElement lastNameRed = driver.findElement(By.cssSelector("[placeholder='Last Name']"));
        Assert.assertTrue(lastNameRed.isDisplayed());
        String lastNameRedColor = lastNameRed.getCssValue("border-bottom-color");
        Assert.assertEquals(lastNameRedColor, "rgba(226, 35, 26, 1)");
    }
    @Test
    public void checkoutEmptyEntriesRedPostalcode(){
        WebElement addProductButton = driver.findElement(By.cssSelector("[name^=add-to-cart-sauce]"));
        addProductButton.click();
        WebElement basketIcon = driver.findElement(By.className("shopping_cart_link"));
        basketIcon.click();
        WebElement checkoutButton = driver.findElement(By.cssSelector("#checkout"));
        checkoutButton.click();
        WebElement continueButton = driver.findElement(By.cssSelector("#continue"));
        continueButton.click();
        WebElement postalCodeRed = driver.findElement(By.cssSelector("[placeholder^='Zip/Postal']"));
        Assert.assertTrue(postalCodeRed.isDisplayed());
        String postalCodeRedColor = postalCodeRed.getCssValue("border-bottom-color");
        Assert.assertEquals(postalCodeRedColor, "rgba(226, 35, 26, 1)");
    }
    @Test
    public void checkoutEmptyEntriesXiconFirstName(){
        WebElement addProductButton = driver.findElement(By.cssSelector("[name^=add-to-cart-sauce]"));
        addProductButton.click();
        WebElement basketIcon = driver.findElement(By.className("shopping_cart_link"));
        basketIcon.click();
        WebElement checkoutButton = driver.findElement(By.cssSelector("#checkout"));
        checkoutButton.click();
        WebElement continueButton = driver.findElement(By.cssSelector("#continue"));
        continueButton.click();
        WebElement firstNameXicon = driver.findElement(By.xpath("//*[@placeholder='First Name']/..//*[@data-icon='times-circle']"));
        Assert.assertTrue(firstNameXicon.isDisplayed());
        }
    @Test
    public void removeProductFromBasket() {
        WebElement productTitle = driver.findElement(By.xpath("//div[contains(text(),'Sauce Labs Backpack')]"));
        productTitle.click();
        WebElement addProductButton = driver.findElement(By.cssSelector("[name^=add-to-cart-sauce]"));
        addProductButton.click();
        WebElement basketIcon = driver.findElement(By.className("shopping_cart_link"));
        basketIcon.click();
        //...
    }

}
