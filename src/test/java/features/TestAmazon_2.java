package features;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestAmazon_2 {

    public final long WAIT_DURATION=10;

    @Test
    public void testExerciceAmazon(){
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
        WebDriver driverFirfox = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driverFirfox, Duration.ofSeconds(WAIT_DURATION));

        //open Browser with the site amazon
        driverFirfox.get("https://www.amazon.fr/");
        // maximize the browser
        driverFirfox.manage().window().maximize();
        // Validate Cookie
        By accepCookieCSS = By.id("sp-cc-accept");
        WebElement buttonAcceptCookie = driverFirfox.findElement(accepCookieCSS);
        buttonAcceptCookie.click();
        //input iphone 1' vert
        By barResearch = By.cssSelector("input#twotabsearchtextbox");
        By loupe_Research = By.cssSelector("input#nav-search-submit-button");
        WebElement element_barResearch =  driverFirfox.findElement(barResearch);
        WebElement element_buttonLoupe_Research =  driverFirfox.findElement(loupe_Research);

        element_barResearch.sendKeys("iphone 14 vert");
        wait.until(ExpectedConditions.visibilityOfAllElements(element_buttonLoupe_Research));
        element_buttonLoupe_Research.click();

        //Prendre le premier elelment de la liste
        By firstresult = By.cssSelector("div.s-result-list >div[data-component-type=\"s-search-result\"]");
        WebElement element_firstElement = driverFirfox.findElement(firstresult);
        wait.until(ExpectedConditions.visibilityOfAllElements(element_firstElement));
        element_firstElement.click();

        //adding to the chart
        By addchart = By.id("add-to-cart-button");
        By chart_icone =  By.id("nav-cart");
        WebElement button_addchart= driverFirfox.findElement(addchart);
        WebElement button_charticone = driverFirfox.findElement(chart_icone);
        wait.until(ExpectedConditions.visibilityOfAllElements(button_charticone));
        button_addchart.click();

        button_charticone.click();


        driverFirfox.quit();
    }







}
