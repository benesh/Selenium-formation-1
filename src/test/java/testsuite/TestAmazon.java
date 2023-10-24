package testsuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestAmazon {
    public final long WAIT_DURATION=10;


    @Test
    public void TestNavBarClick(){
        //add the different webdrivers
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");

        //initiate the webdriver wnated
        WebDriver driverFirfox = new FirefoxDriver();
        driverFirfox.get("https://www.amazon.fr/");

        By navcartID = By.id("nav-cart");
        By accepCookieCSS = By.cssSelector("input#sp-cc-accept");
        //By navcartPATH = By.xpath("");
        //By accueil = By.id("")

        driverFirfox.manage().window().maximize();

        //cliquer sur Accept Cookie
        WebElement buttonAcceptCookie = driverFirfox.findElement(accepCookieCSS);
        buttonAcceptCookie.click();

        //Test de sur les meilleurs ventes
        testClickBestSeller(driverFirfox,WAIT_DURATION);

        //cliquer sur Panier
        WebElement webElementBoutonPanier = driverFirfox.findElement(navcartID);

        WebDriverWait wait = new WebDriverWait(driverFirfox, Duration.ofSeconds(WAIT_DURATION));
        wait.until(ExpectedConditions.visibilityOfAllElements(webElementBoutonPanier));

        webElementBoutonPanier.click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driverFirfox.quit();
    }

    /**
    * 1. Cas de test
    * 2. Cliqyer sur le menue burger qui s'appelle "Toute"
    * 3. Cliquer sur la "MEiileurs ventes"
    * 4. Attendre de l'écran des meilleurs ventes (sans sleep)
     */

    @Test
    public void testClickBestSeller(WebDriver driver,long duration){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));

        By buttonTout = By.id("nav-hamburger-menu");
        WebElement buttonToute =  driver.findElement(buttonTout);
        wait.until(ExpectedConditions.visibilityOfAllElements(buttonToute));
        buttonToute.click();


        //By buttonBestSeller = By.xpath("//li/a[contains(concat(' ',normalize-space(@href),' '),'bestsellers')]");
        //By buttonBestSeller = By.cssSelector("li a[href*=\"bestsellers\"]");

        By buttonBestSeller = By.xpath("//li/a[contains(@href, 'bestsellers')]");
        WebElement elemButtonBestSeller =  driver.findElement(buttonBestSeller);

        wait.until(ExpectedConditions.visibilityOfAllElements(elemButtonBestSeller));

        elemButtonBestSeller.click();

    }

    /**
     * Selecteur à chercher sur le site : https://www.saucedemo.com
     * 0. champs User (sans id)
     *      .form_group input[name="user-name"]
     * 1. Bouton Filtres "Name (A to Z)
     *      .product_sort_container
     * 2. Texte du tshirt "Bolt T-Shirt"
     *      //div[contains(text(),"Get your testing superhero on with")]
     * 3. Déroulez menu burger
     *       #react-burger-menu-btn
     * 4. Menu burger : bouton all items
     *
     * 5. Menu burger : bouton logout
     * 6. Ajouter 3 élements dans le panier -> bouton "Remove" du 2eme élément dans le panier
     */
    public void testSaucedemo(WebDriver driver,long duration){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
        By user_name= By.id("user-name");
        By psswd = By.id("password");
        By button_login = By.id("login-button");

        WebElement elem_user_name = driver.findElement(user_name);
        WebElement  element_pwd = driver.findElement(psswd);
        WebElement  elem_button_login = driver.findElement(button_login);

        elem_user_name.sendKeys("standard_user");
        element_pwd.sendKeys("secret_sauce");
        elem_button_login.click();
    }

}

