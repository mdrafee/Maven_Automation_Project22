package ActionItem;

import Reusable_Library.ReusableActions;
import Reusable_Library.ReusableActions_Loggers;
import Reusable_Library.Reusable_Annotation;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class AI3_MoneyMarket_Mortgage extends Reusable_Annotation {
    @Test
    public void tc001() throws InterruptedException {
        driver.navigate().to("https://www.ally.com/education/financial-life/");
        //click on what ot consider
        ReusableActions_Loggers.clickAction(driver,"//*[text()='What to Consider']",logger," click what to consider");
        Thread.sleep(1000);
        //click on learn more about the cost of homer ownership
        ReusableActions_Loggers.clickAction(driver,"//*[text()='Learn more about the costs of homeownership']",logger," click on more deatils");
        //click on get pre apprived today
        ReusableActions_Loggers.clickAction(driver,"//*[text()='Get Pre-Approved Today']",logger," click onpre approvedtoday");
        ReusableActions_Loggers.clickAction(driver,"//*[text()='Get Pre-approved']",logger," click on pre approved");

        //click Next
        ReusableActions_Loggers.clickAction(driver,"//*[text()='Next']",logger," click next ");
        //click on i am jsut searching
        ReusableActions_Loggers.clickActionByIndex(driver,"//*[@class='better-crate-2-Jyw']",0,logger," click options such as Jsut Researching");
        Thread.sleep(1000);
        //click to see how much i can affford
        ReusableActions_Loggers.clickAction(driver,"//*[text()='See how much I can afford']",logger," click to seee how much i can afford");
        //click not sure
        ReusableActions_Loggers.clickAction(driver,"//*[text()='Not sure']",logger," click to seee how much i can afford");
        //send zip
        ReusableActions_Loggers.sendKeysAction(driver,"//*[@class='better-crate-1lnme']","11361",logger,"sending zip");
        //clikc on next
        ReusableActions_Loggers.clickAction(driver,"//*[text()='Next']",logger," click next to geet pre Approved");
        //click on most interested
        ReusableActions_Loggers.clickAction(driver,"//*[text()='Primary residence']",logger," click on most interested type of home condo");
        //click on types of property
        Thread.sleep(1000);
        ReusableActions_Loggers.clickAction(driver,"//*[text()='Townhouse or condo']",logger," clickon type of property");
        //clikc on next
        ReusableActions_Loggers.clickAction(driver,"//*[text()='Next']",logger," click next to geet pre Approved");

        //click on primary residence
       // ReusableActions_Loggers.clickAction(driver,"//*[text()='Primary residence']",logger," click on primary residence");
        //click on properrty time condo

Thread.sleep(1000);






    }//test001

}//class
