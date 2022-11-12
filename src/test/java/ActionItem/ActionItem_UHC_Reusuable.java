package ActionItem;

import Reusuable_Library.ReusableActions1;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class ActionItem_UHC_Reusuable {
    WebDriver driver;

    @BeforeSuite
    public void setupDriver() {
        driver = ReusableActions1.setUpDriver();
    }//end of set driver method

    @AfterSuite
    public void quitTheSession() throws InterruptedException {
//        driver.quit();
    }//end of after suite

    @Test()
    public void test1() throws InterruptedException {

        Thread.sleep(2000);
        //navigete
        driver.navigate().to("https://www.uhc.com/");
        //click on find doc
        ReusableActions1.clickAction(driver, "//*[contains(@class,'position-relative bg-blueDark color-white')]", "click on find doctor");
        //scroll
        //click no on popup if it appears
        ReusableActions1.clickAction(driver, "//*[@id='ip-no']", "clickPopUp");
        //click find dentist
        ReusableActions1.clickAction(driver, "//*[text()='Find a dentist']", "click on find dentist");

        //reusuable switch tab
        ReusableActions1.switchTabByIndex(driver, 1);
        //refresh
        driver.navigate().refresh();
        Thread.sleep(2000);
        //click on the emplyeers and individual palns
        ReusableActions1.clickAction(driver, "//*[text()='Employer and Individual Plans']", "clicking on second page employers and indv plans");
        Thread.sleep(2000);

    }//test1

    @Test(dependsOnMethods = "test1")

    public void test2() throws InterruptedException {
        Thread.sleep(2000);

        //click on zip search bar
        ReusableActions1.clickAction(driver, "//*[@id='location']", "click before entering zip");
        //enter zip
        ReusableActions1.sendKeysAction(driver, "//*[@id='location']", "10009\n", "sending zip in employe and indv plan search");
        //submit zip
        Thread.sleep(1000);
        //click on continue to submit zip
        //  ReusableActions.clickAction(driver,"//*[text()='Continue']","click on continue");

        //click on national option ppo
        ReusableActions1.clickActionByIndex(driver, "//*[@class='sc-jomqko TEkcT']", 0, "click on national ppo class");
        //ReusableActions.clickAction(driver,"//*[text()='*National Options PPO 30']","click on national options ppo");
        //*National Options PPO 30
        Thread.sleep(1100);
        //driver.navigate().refresh();
        Thread.sleep(8000);
        //click on general dentist
        ReusableActions1.clickAction(driver, "//*[@id='nodeDescription1']", "click on general dentist");


    }//test2

    @Test(dependsOnMethods = "test2")
    public void test3() throws InterruptedException {
        //select a different mileage
        ReusableActions1.selectByText(driver, "//*[@id='distance']", "Within 50 Miles", "miles dropdown on general dentist page ");
        //class="radiusMiles ng-valid ng-not-empty ng-touched ng-dirty ng-valid-parse ally-focus-within"
        //click on first doctor
        ReusableActions1.clickActionByIndex(driver, "//*[@data-test-id='provider-name-link']", 0, "First Doctor");
        //click on save button
        ReusableActions1.clickActionByIndex(driver, "//*[@data-test-id='saved-provider-button']", 0, "Save button");
        //capture address, miles, & network type
        String info = ReusableActions1.getTextAction(driver, "//*[@class='outer-container tbl']", "Address, Miles, & Network Type");
        //print out information
        System.out.println(info);
        //close out the tab
        driver.close();
    }//test 3

    @Test(dependsOnMethods = "test3")
    public void test4() throws InterruptedException {
        //switch back to default tab
        ReusableActions1.switchTabByIndex(driver, 0);
        //navigate back to website
        driver.navigate().to("https://www.uhc.com/");
        Thread.sleep(1000);
        //enter keyword doctor on the search field
        ReusableActions1.sendKeysAction(driver, "//*[@id='search-desktop']", "Doctor", "Search Doctor");
        // click submit on the search
        ReusableActions1.clickAction(driver, "//*[@id='search__button-desktop']", "submit icon");
        //capture search results
        String searchResult = ReusableActions1.getTextAction(driver, "//*[@id='search-results-count__header']", "Search Results");

        String[] arrayMessage = searchResult.split(" ");
        System.out.println(arrayMessage[0] + arrayMessage[1] + arrayMessage[2]);
    }// end of test 4
}
