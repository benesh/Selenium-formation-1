package testsuite;

import com.example.core.BaseDriver;
import com.example.demoqapages.HomePage;
import com.example.demoqapages.WebtablesPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;

@Log4j2
public class TestDemoqua {
    public final static String URL = "https://demoqa.com/";
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        BaseDriver bd = new BaseDriver();
        driver = bd.get_driver();
        driver.get(URL);
        log.info("Ouverture du site");
        driver.manage().window().maximize();
    }

    @Test
    public void exerciseDay3() {
        //Arragne
        String expectedTextCell = " ";

        //Act
        WebtablesPage wettablespage = new HomePage(driver)
                .clickElementPage()
                .verifyingCurrentPageIsElement()
                .clickWebtablesPage()
                .salaryClickToSort()
                .salaryClickToSort()
                .clickIconeDeleteLastElement();

        // Asser
        Assert.assertEquals(wettablespage.getTextOfLastRow(),expectedTextCell,"Assert Done");
    }

    @AfterMethod
    public void resultScreenshot() {

    }

    @AfterMethod
    public void quittingDriver(){
        log.info("Quitting Driver");
        driver.quit();
    }
}
