package DAY9_10292022;

import Reusuable_Library.ReusableActions1;
import org.openqa.selenium.WebDriver;

import static Reusuable_Library.ReusableActions1.setUpDriver;

public class T5_Metlife_Reusuable {


        public static void main(String[] args) throws InterruptedException {
            //call webdriver method from reusable library
            WebDriver driver = setUpDriver();
            //navigate to MetLife
            driver.navigate().to("https://www.metLife.com");
            //hover over the solutions dropdown
            //ReusableActions.mouseHover(driver, "//*[contains(text(), 'SOLUTIONS')]", "Solutions Dropdown");
            //or click on solutions dropdown


            ReusableActions1.clickActionByIndex(driver, "//*[contains(text(), 'SOLUTIONS')]", 0, "Solutions Link");
Thread.sleep(99999999);
            //click on dental link

           ReusableActions1.clickAction(driver, "//*[text() = 'Dental']", "Dental Link");

            //capture the headline title

            String headlineTitle = ReusableActions1.getTextAction(driver, "//*[@class = 'headline__title']", "Headline Title");

            //print out the title
            System.out.println("The headline title is " + headlineTitle);
            //quit driver
            driver.quit();
        }//end of main
    }

