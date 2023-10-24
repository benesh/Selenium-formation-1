package features;

import com.example.core.BaseDriver;
import com.example.demoqaSite.ElementPage;
import com.example.demoqaSite.HomePage;
import com.example.demoqaSite.WebtablesPage;
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
        String pageNameelements = "elements";

        //Act1
        ElementPage elementPageObject = new HomePage(driver)
                .clickElementPage();

        //Assert
        String pagetoAssert = elementPageObject.getPageNamePath();
        Assert.assertEquals(pagetoAssert,"elements","Assertion Done");

        //Act 2
        WebtablesPage wettablespage = elementPageObject
                .clickWebtablesPage()
                .salaryClickToSort()
                .salaryClickToSort()
                .clickIconeDeleteLastElement();

        // Asser 2
        

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
