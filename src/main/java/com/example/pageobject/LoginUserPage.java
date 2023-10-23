package com.example.pageobject;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Log4j2
public class LoginUserPage {
    WebDriver driver;

    @FindBy(id="user-name")
    private WebElement inputUsername;
    @FindBy(id="password")
    private WebElement inputPwd;
    @FindBy(id="login-button")
    private WebElement loginButton ;

    public LoginUserPage(WebDriver param_driver){
        driver = param_driver;
        PageFactory.initElements(driver,this);
    }
    public LoginUserPage inputUserName(String unserNname){
        inputUsername.sendKeys(unserNname);
        log.info("inputUserName successfully done [{}]",unserNname);
        return this;
    }
    public LoginUserPage inputPwd(String pwd){
        inputPwd.sendKeys(pwd);
        log.info("Password successfully done");
        return this;
    }
    public InventoryPage loginButton(){
        loginButton.click();
        log.info("Login successfully Done");
        return new InventoryPage(this.driver);
    }
}
