package steps;

import com.example.pageobject.CartPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CartSteps {
    CartPage cartpage;

    public  CartSteps(StandardSteps std){
        WebDriver driver = std.getDriver();
        cartpage = PageFactory.initElements(driver,CartPage.class);
    }

    @Then("je verifie si le titre du panier est {string}")
    public void je_verifie_le_titre(String cartTitleExpected){
        cartpage.checkPageTitle(cartTitleExpected);
    }
}
