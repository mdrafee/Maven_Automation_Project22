package ActionItem;

import Reusable_Library.ReusableActions_Loggers;
import Reusable_Library.Reusable_Annotation;
import org.testng.annotations.Test;

public class AI1_OPTIONS extends Reusable_Annotation {
    @Test(priority = 1)
    public void tc001_CustomerAccessOptionsPage() throws InterruptedException {
        //navigate to the website
        driver.navigate().to("https://www.ally.com");
        //click on the investmenet header
        ReusableActions_Loggers.clickAction(driver, "//*[@allytmln='investMenu']", logger,"click on investment");
        Thread.sleep(1000);
        //click on options
        ReusableActions_Loggers.clickAction(driver, "//*[@href='/invest/self-directed-trading/options-trading/']", logger,"click on Options");
        Thread.sleep(1000);
        //click on why options
        ReusableActions_Loggers.clickAction(driver, "//*[text()='Why Options']", logger,"click on Options");
        Thread.sleep(2000);
        //click on pdf
        ReusableActions_Loggers.clickAction(driver,"//*[text()='Characteristics and Risks of Standardized Options brochure']",logger,"click on the pdf");
        Thread.sleep(5000);
        //click continue if pop up
        ReusableActions_Loggers.clickAction(driver,"//*[@allytmln='continue']",logger,"click continue after pdf click");
        Thread.sleep(4000);
        //switch tab
        ReusableActions_Loggers.switchTabByIndex(driver,1);
        //capture the title of the pdf
        Thread.sleep(4000);
      String title = ReusableActions_Loggers.getTextAction(driver,"//*[@class='content-intro text-left']",logger,"get text from new page");
        System.out.println(title);
        Thread.sleep(3000);
    }//tc001

}//class