package com.example.demoqapages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Log4j2
public class HomePage {
    WebDriver driver;

    @FindBy(css = ".category-cards>div:first-child")
    private WebElement cardElement;

    public HomePage(WebDriver paramDriver){
        this.driver=paramDriver;
        PageFactory.initElements(driver,this);
    }
    public ElementPage clickElementPage(){
        cardElement.click();
        log.info("Open Element Page");
        return new ElementPage(this.driver);
    }
}
