package Day10_10302022;

import org.testng.annotations.Test;

import java.util.ArrayList;

public class T4_TestNg_ForLoop {
    /*
    @Test(priority = 1)
    public void SearchForCar() {
        //add sports to search criteria
        ArrayList<String> sports = new ArrayList<>();
        sports.add("Soccer");
        sports.add("Basketball");
        sports.add("Tennis");

        for (int i = 0; i < sports.size(); i++) {
            driver.navigate().to("https://www.google.com");
            //enter a car on search field
            ReusableActions.sendKeysAction(driver, "//*[@name='q']", sports.get(i), "Search Field");
            //hit submit on the google search button
            ReusableActions.submitAction(driver, "//*[@name='btnK']", "Google Search Button");
            //capture result text
            String result = ReusableActions.getTextAction(driver, "//*[@id='result-stats']", "Search Results");
            //split result for the number
            String[] arrayResult = result.split(" ");
            //print number to the console
            System.out.println("Result is " + arrayResult[1]);
        }//end of for loop
    }//end of test 1

     */
}
