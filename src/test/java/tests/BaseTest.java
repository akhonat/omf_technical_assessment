package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import utils.logs.Log;

public class BaseTest {
    public WebDriver driver;

    public WebDriver getDriver(){
        return driver;
    }

    @BeforeClass
    public void classLevelSetup(){
        Log.info("Tests is starting.");
    }

    @BeforeMethod
    public void methodLevelSetup(){
        Log.info("Tests is starting.");
    }

    @AfterClass
    public void teardown(){
        Log.info("Tests is ending.");
        driver.quit();
    }
}
