package steps;

import com.example.pageobject.InventoryPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class InventorySteps {
    InventoryPage inventoryPage;


    public InventorySteps(StandardSteps std){
        WebDriver driver = std.getDriver();
        inventoryPage = PageFactory.initElements(driver,InventoryPage.class);
    }
    @Then("la page des articles est affichée {string}")
    public void la_page_des_articles_est_affichée(String titreAttendu) {
        inventoryPage.checkPageTitle(titreAttendu);
    }

    @And("j'ajoute un backpack dans le panier")
    public void jAjouteUnBackpackDansLePanier() {
        inventoryPage.addCartItemBackpack();
    }

    @And("j'ouvre le panier")
    public void j_ouvre_le_panier(){
        inventoryPage.cartClick();
    }
}

