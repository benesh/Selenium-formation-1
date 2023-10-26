package com.example.demoqapages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.apache.commons.lang3.StringUtils;


@Log4j2
public class ElementPage {
    WebDriver driver;
    @FindBy(css=".accordion > div:first-child>div #item-3")
    WebElement webtables;
    public ElementPage(WebDriver paramDriver){
        this.driver=paramDriver;
        PageFactory.initElements(driver,this);
        log.info("Opening Element Page");
    }
    public ElementPage verifyingCurrentPageIsElement(){
        log.info("Verifying the Current URL or Page Element");
        String sep = "/";
        String url =driver.getCurrentUrl();
        String curentPage = StringUtils.substringAfterLast(url,sep);
        if (curentPage == "elements"){
            return this;
        } else{
            return this;
        }
    }


    public WebtablesPage clickWebtablesPage(){
        webtables.click();
        log.info("Opening WebTablesPage");
        return new WebtablesPage(driver);
    }
}
