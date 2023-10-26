package steps;


import com.example.saucedemopages.LoginUserPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

@Log4j2
public class LoginSteps {

    LoginUserPage pagelogin;

    public LoginSteps(StandardSteps std){
        WebDriver driver = std.getDriver();
        pagelogin = PageFactory.initElements(driver, LoginUserPage.class);
    }

    @And("j'entre un unsename {string}")
    public void j_entre_un(String username) {
        pagelogin.inputUserName(username);
    }

    @And("j'entre un mot de passe {string}")
    public void j_entre_un_pswd(String pswd) {
        pagelogin.inputPwd(pswd);
    }

    @When("je clique sur le bouton login")
    public void je_clique_sur_le_bouton_login() {
        pagelogin.loginButton();
    }

}
