package Day10_10302022;


import Reusuable_Library.ReusableActions1;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class T2_Testng_GoogleSearch {
    WebDriver driver;
    @BeforeSuite
    public void SetChromeDriver(){
         driver = ReusableActions1.setUpDriver();
    }//end of set driver method

    @AfterSuite
    public void quitTheSession(){
        driver.quit();
    }//end of after suite

    @Test(priority = 1)
    public void SearchForCar(){
        driver.navigate().to("https://www.google.com");
        //enter a car on search field
        ReusableActions1.sendKeysAction(driver,"//*[@name='q']","BMW","Search Field");
        //hit submit on the google search button
        ReusableActions1.submitAction(driver,"//*[@name='btnK']","Google Search Button");
    }//end of test 1

    @Test(priority = 2)
    public void CaptureSearchNumber(){
        String result = ReusableActions1.getTextAction(driver,"//*[@id='result-stats']","Search Results");
        String[] arrayResult = result.split(" ");
        System.out.println("Result is " + arrayResult[1]);
    }//end of test 2
}//class

