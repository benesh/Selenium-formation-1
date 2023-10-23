package com.example.demoqaSite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ElementPage {

    WebDriver driver;
    @FindBy(css="elelmerando")
    WebElement input;

    public ElementPage(WebDriver paramDriver){
        this.driver=paramDriver;
        PageFactory.initElements(driver,this);
    }


}
