package features;

import com.example.core.BaseDriver;
import org.openqa.selenium.WebDriver;
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
