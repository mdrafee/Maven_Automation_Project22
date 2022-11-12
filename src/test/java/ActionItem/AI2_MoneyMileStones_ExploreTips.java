package ActionItem;

import Reusable_Library.ReusableActions;
import Reusable_Library.ReusableActions_Loggers;
import Reusable_Library.Reusable_Annotation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class AI2_MoneyMileStones_ExploreTips extends Reusable_Annotation {
    @Test
    public void tc001_StocksEtf() throws InterruptedException {
        //navigate to the website
        driver.navigate().to("https://www.ally.com");
        //click on the investmenet header
        ReusableActions_Loggers.clickAction(driver, "//*[@allytmln='investMenu']", logger,"click on investment");
        Thread.sleep(1000);
        //navigate
        ReusableActions_Loggers.clickAction(driver,"//*[text()=' Money & Milestones ']",logger,"Money Miles stones click ");
        Thread.sleep(3000);

        //scroll to emergencies
      //  ReusableActions.scrollByElement(driver,"//*[text()='recommend']",0,"click on the element to scrol");
    }//test 1
    @Test(dependsOnMethods = "tc001_StocksEtf")
    public void tc002_MoneyMileS_SavingTips() throws InterruptedException {
        ArrayList<String> monthlyIncome = new ArrayList<>();
        //array list for income
        monthlyIncome.add("2600");
        monthlyIncome.add("5000");
        monthlyIncome.add("10000");
        for (int i=0; i<monthlyIncome.size();i++){
            //explore tips
            ReusableActions.clickAction(driver,"//*[text()='Explore Tips and Tools']","Explore tips following MMLS");
          //  driver.navigate().refresh();
            Thread.sleep(3000);
            ReusableActions_Loggers.sendKeysAction(driver,"//*[@id='income']",monthlyIncome.get(i),logger,"monthly income");
            //set monthly expenses
            Thread.sleep(2000);
          //  driver.findElement(By.xpath("//*[@id='expenses']")).clear();
            ReusableActions_Loggers.sendKeysAction(driver,"//*[@id='expenses']","2500",logger,"fix monthly expenses");
            //future emergency save              //*[@id='income']
            Thread.sleep(2000);
          //  driver.findElement(By.xpath("//*[@id='future-emergency']")).clear();
            ReusableActions_Loggers.sendKeysAction(driver,"//*[@id='future-emergency']","50000",logger,"Save for Emergencies");
            //future emergency
            Thread.sleep(2000);
           // driver.findElement(By.xpath("//*[@id='current-emergency']")).clear();
            ReusableActions_Loggers.sendKeysAction(driver,"//*[@id='current-emergency']","5000",logger,"Starting savings");
           Thread.sleep(2000);
            //click see results
            ReusableActions_Loggers.clickAction(driver,"//*[@id='emergency-calculate']",logger,"click results");
            Thread.sleep(3000);
            //click on the detailed schedule
            ReusableActions_Loggers.clickAction(driver,"//*[text()='detailed schedule']",logger,"click detailed schedule");
            Thread.sleep(2000);
            //click on the plus icon for
            ReusableActions_Loggers.clickAction(driver,"//*[@class='plus is-initial']",logger,"click results");
            //print the mssg
            String times = driver.findElement(By.xpath("//*[@class='sm-col-12']/table/tfoot")).getText();
            System.out.println(" The expected time for savings is " + times);
            Thread.sleep(3000);
            //return to the previous page
            driver.navigate().back();
            Thread.sleep(4000);


        }//forloop

    }//test 2
}//class
