package com.example.demoqaSite;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Log4j2
public class WebtablesPage {
    WebDriver driver;
    // '//*[@class="rt-tbody"]/div[3]//*[@title="Delete"]'
    WebDriverWait wait;
    public final long WAIT_DURATION=10;
    @FindBy(xpath="//*[@class=\"rt-tbody\"]/div[3]//*[@title=\"Delete\"]")
    WebElement iconeDeleteLastElement;
    @FindBy(xpath = "//div[@class=\"rt-thead -header\"]/div/div[5]")
    WebElement selerylabelElement;

    ////div[@class="rt-thead -header"]/div/div[5]
    //.rt-thead>div>div:nth-child(5)

    public WebtablesPage(WebDriver paramDriver){
        this.driver=paramDriver;
        PageFactory.initElements(driver,this);
        wait = new WebDriverWait(paramDriver, Duration.ofSeconds(WAIT_DURATION));
        log.info("Opening Webtables Pages");
    }
    public WebtablesPage salaryClickToSort(){
        wait.until(ExpectedConditions.visibilityOfAllElements(selerylabelElement));
        selerylabelElement.click();
        log.info("Clik To sort the Salary Column");
        return this;
    }

    public WebtablesPage clickIconeDeleteLastElement(){
        iconeDeleteLastElement.click();
        log.info("Deleting Last Element");
        return this;
    }

    public void verifyIFLastElementDeleted(){
        
    }

}
