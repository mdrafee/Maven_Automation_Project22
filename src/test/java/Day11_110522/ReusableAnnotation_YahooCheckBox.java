package Day11_110522;

import Reusable_Library.ReusableActions;
import Reusable_Library.Reusable_Annotation;
import Reusuable_Library.ReusableActions1;
import Reusuable_Library.Reusuable_Anotation1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class ReusableAnnotation_YahooCheckBox extends Reusable_Annotation {

    @Test(priority = 1)
    public void tc001_verifySignedInOptionIsChecked() {
             //this part includes extended reusuable anotation
             //first navigate to yahoo homepage
                 driver.navigate().to("https://www.yahoo.com/");
                //next we need to click on sign in button
                ReusableActions.clickAction(driver, "//*[@class = '_yb_1933e']", "Sign in button");
                //we need to verify that signed in option is checked
                boolean isSignInChecked = driver.findElement(By.xpath("//*[@id= 'persistent']")).isSelected();
                System.out.println("The checkbox check condition is: " + isSignInChecked);
              }//end of test 1
              // @Test(dependsOnMethods = "tc001_verifySignedInOptionIsChecked")
    @Test(dependsOnMethods = "tc001_verifySignedInOptionIsChecked")
            public void tc002_verifySignedInOptionIsUnChecked() {
             //click on check box to uncheck it
            ReusableActions.clickAction(driver, "//*[@class= 'stay-signed-in checkbox-container']", "SignedInCheckBox");
            //we need to verify that signed in option is checked
            boolean isSignInChecked = driver.findElement(By.xpath("//*[@id= 'persistent']")).isSelected();
            System.out.println("The checkbox check condition is: " + isSignInChecked);
            }//end of test 2




    }//class





