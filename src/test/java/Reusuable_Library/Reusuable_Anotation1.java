package Reusuable_Library;

import Reusable_Library.ReusableActions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class Reusuable_Anotation1 {
    WebDriver driver;
    @BeforeSuite
    public void SetTheDriver(){
        driver = ReusableActions.setUpDriver();
    };//BEFORE
    @AfterSuite
    public void quitscession (){
        driver.quit();
    }
}
