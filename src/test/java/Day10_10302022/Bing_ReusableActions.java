package Day10_10302022;

import Reusuable_Library.ReusableActions1;
import org.openqa.selenium.WebDriver;

public class Bing_ReusableActions {
    public static void main(String[] args) {
        //calling reusable method for set driver
        WebDriver driver = ReusableActions1.setUpDriver();

        //navigate
        driver.navigate().to("https://www.bing.com");

        //enter a keyword in search field using reusable method
        ReusableActions1.sendKeysAction(driver,"//*[@name='q']","soccer","Search Field");

        //click on search icon using reusable method
        ReusableActions1.clickAction(driver,"//*[@id='search_icon']","Search Icon");

        //capture the result and extract out the number
        String result = ReusableActions1.getTextAction(driver,"//*[@class='sb_count']","Search Results");
        System.out.println("Result is " + result);
    }
}
