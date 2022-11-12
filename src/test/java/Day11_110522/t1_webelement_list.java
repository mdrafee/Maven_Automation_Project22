package Day11_110522;

import Reusuable_Library.ReusableActions1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class t1_webelement_list {

    WebDriver driver;
    ArrayList<WebElement> totalMenuHeaders, mainMenuHeaders;
    @BeforeSuite
    public void SetChromeDriver() {
        driver = ReusableActions1.setUpDriver();
        //navigate to usps.com home page
        driver.navigate().to("https://www.usps.com/");
        //store all the elements of the menu header into an arraylist of webelements
        totalMenuHeaders = new ArrayList<>(driver.findElements(By.xpath("//*[@class = 'nav-list']/li")));
    }//end of set driver method
    @AfterSuite
    public void quitTheSession() {
        driver.quit();
    }//end of after suite

    //tst case 1 should verify the total count of the displayed header
    @Test(priority = 1)
    public void tc001_verifTotalCountofHeader(){
        System.out.println("the total number of menu header is" + totalMenuHeaders.size());        //store
    }//end of test 1

    @Test(priority = 2)
    public void tc002_clickOnTheFirstDropDoown(){
        totalMenuHeaders.get(0).click();
    }//end of test 2
    @Test(priority = 3)
    public void tc003_verifyCountOfMainMenuHeader(){
        mainMenuHeaders = new ArrayList<>(driver.findElements(By.xpath("//*[@class='menuheader']")));
        System.out.println("the total number of main menu headder is " + mainMenuHeaders.size());
    }//end of test 2

}//class
