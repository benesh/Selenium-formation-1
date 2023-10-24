package testsuite;

import com.example.core.BaseDriver;
import com.example.pageobject.LoginUserPage;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

@Log4j2
public class TestPatternPageObject {
    public final static  String URL= "https://www.saucedemo.com/";
    //le driver
    WebDriver driver;
    //Before mothod for initalis
    @BeforeMethod
    public void  setup(){
        BaseDriver bd = new BaseDriver();
        driver = bd.get_driver();
        driver.get(URL);
        log.info("Ouverture du site");
        driver.manage().window().maximize();

    }

    @Test
    public void testExerciceDay2(){
        //Arrange
        String userName="standard_user";
        String pwd =  "secret_sauce";
        String titleExpected = "Your Cart";

        //Act

        String cp = new LoginUserPage(driver)
                .inputUserName(userName)
                .inputPwd(pwd)
                .loginButton()
                .addCartItemBackpack()
                .cartClick()
                .getTitle();
        log.info("Act gettin Title successfull");
        //Assert
        Assert.assertEquals(cp,titleExpected,"Assertion Done");
        //Assert.fail(" Je test le screenshot");
    }

    @AfterMethod
    public void resulscreenshot(ITestResult result){
        if (result.getStatus() == ITestResult.FAILURE){
            File scrFile =  ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            String name = "screenshot.png";

            try {
                FileUtils.copyFile(scrFile,new File("test_output/screenshots/" + name));
            } catch (IOException e) {
                log.error(e);
                throw new RuntimeException(e);
            }
        }
        log.info("Quitting Driver");
        driver.quit();
    }

    @AfterMethod
    public void quittingDriver(){
        log.info("Quitting Driver");
        driver.quit();
    }
}
