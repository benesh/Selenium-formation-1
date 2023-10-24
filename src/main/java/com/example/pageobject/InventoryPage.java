package com.example.pageobject;

import org.testng.Assert;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


@Log4j2
public class InventoryPage {
    WebDriver driver;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement addItemBackpack;
    @FindBy(css=".shopping_cart_link")
    private WebElement buttonCart;
    public InventoryPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public InventoryPage addCartItemBackpack(){
        this.addItemBackpack.click();
        log.info("Element succesfully added");
        return this;
    }
    public CartPage cartClick(){
        buttonCart.click();
        return new CartPage(this.driver);
    }
    public void checkPageTitle(String titleExpected ){
        Assert.assertEquals(driver.getTitle(),titleExpected);
    }

}
