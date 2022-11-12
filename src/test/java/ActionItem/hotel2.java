package ActionItem;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;

public class hotel2 {
    public static void main(String[] args) throws InterruptedException {


        //define the webdriver manager setup for chromedriver
        WebDriverManager.chromedriver().setup();

        //initialize chrome options
        ChromeOptions options = new ChromeOptions();

// add the options for maximizing the chrome meeting
// options.addArguments("start-fullscreen") for mac
        options.addArguments("start-fullscreen");

        //define the chrome driver to use for your test
//creating an instance for a chrome driver(browser) to use for automation
        WebDriver driver = new ChromeDriver(options);

        //array list of adults
        ArrayList<Integer> adult = new ArrayList<>();
        adult.add(1);
        adult.add(2);
        adult.add(3);

        //array list of adults
        ArrayList<String> destination = new ArrayList<>();
        destination.add("New york");
        destination.add("california");
        destination.add("florida");

        //ARRAY LIST FOR CHILD AGE
        ArrayList<Integer> childAgeArray = new ArrayList<>();
        childAgeArray.add(2);
        childAgeArray.add(5);
        childAgeArray.add(8);

        for (int i = 0; i < destination.size(); i++) {
            //navigate to hotels.com
            driver.navigate().to("https://www.hotels.com/");
            Thread.sleep(2000);

            try {
                //click on the location
                WebElement location = driver.findElement(By.xpath("//*[@class='uitk-fake-input uitk-form-field-trigger']"));
                location.click();
                //searching destination
                driver.findElement(By.xpath("//*[@id='destination_form_field']")).sendKeys(destination.get(i));
                Thread.sleep(2000);
                //click on dorp down
                driver.findElements(By.xpath("//*[@class='is-subText truncate']")).get(0).click();
            } catch (Exception e) {
                System.out.println("destination error " + e);
            }//catch

            Thread.sleep(3000);
            //click on travlers
            try {
                driver.findElement(By.xpath("//*[@class='uitk-menu-trigger uitk-fake-input uitk-form-field-trigger']")).click();
            } catch (Exception e) {
                System.out.println("click on traveler.." + e);
            }
            Thread.sleep(2000);

            //reduce the adult number by1
            try {
                driver.findElement(By.xpath("//*[@class='uitk-icon uitk-step-input-icon uitk-icon-medium']")).click();
            } catch (Exception e) {
                System.out.println("reduce adult number.." + e);
            }
            Thread.sleep(3000);

            //defining webelement for clicking to add passengers
            try {
                ArrayList<WebElement> adultPass = new ArrayList<>(driver.findElements(By.xpath("//*[@class='uitk-icon uitk-step-input-icon uitk-icon-medium']")));

                //click on add adults. The number of times to click is gotten from the adultPass array list. THIS CODE MADE IT SO SIMPLE COMPARED TO MINE!!!
                for (int j = 0; j < adult.get(i); j++) {
                    adultPass.get(1).click();
                }//end of for loop
            } catch (Exception e) {
                System.out.println("clicking to add passengers.." + e);
            }//end of catch

            //click on child to add 1
            try {
                driver.findElements(By.xpath("//*[@class='uitk-icon uitk-step-input-icon uitk-icon-medium']")).get(3).click();
            } catch (Exception e) {
                System.out.println("adding child.." + e);
            }//end of catch

            //adding child age
            //click on dropdown forchild by select and using index. So the child age will be 1 less than the index
            try {
                WebElement childAge = driver.findElement(By.xpath("//*[@name='child-traveler_selector_children_age_selector-0-0']"));
                //wait statement to load up the dropdown
                Thread.sleep(2000);
                Select childageDp = new Select(childAge);
                childageDp.selectByIndex(childAgeArray.get(i));
            } catch (Exception e) {
                System.out.println("Adding child age error.." + e);
            }//end of catch

            Thread.sleep(3000);

            //click done after child age
            try {
                driver.findElement(By.xpath("//*[@id='traveler_selector_done_button']")).click();
            } catch (Exception e) {
                System.out.println("clicking done error..." + e);
            }//end of catch

            Thread.sleep(2000);

            //click search icon
            try {
                driver.findElement(By.xpath("//*[@id='submit_button']")).click();
            } catch (Exception e) {
                System.out.println("click search icon error.." + e);
            }//end of catch

            Thread.sleep(2000);

            //clicking on specific hotel package
            try {
                if (i == 0) {
                    //click on 1st hotel package
                    driver.findElements(By.xpath("//*[@class='uitk-image-link']")).get(0).click();
                } else if (i == 1) {
                    //click on 4th hotel package
                    driver.findElements(By.xpath("//*[@class='uitk-image-link']")).get(3).click();
                } else if (i == 2) {
                    //click on 2nd hotel package
                    driver.findElements(By.xpath("//*[@class='uitk-image-link']")).get(1).click();
                }
            } catch (Exception e) {
                System.out.println("clicking on specific hotel package error..." + e);
            }//end of catch

            //store tabs
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            //switch to new tab
            driver.switchTo().window(tabs.get(1));
            Thread.sleep(2000);

            //capturing resort name
            try {
                String resortName = driver.findElements(By.xpath("//*[@class='uitk-heading uitk-heading-3']")).get(0).getText();
                System.out.println(resortName);
            } catch (Exception e) {
                System.out.println("capturing resort name error.." + e);
            }//end of catch

            //optional
            Thread.sleep(2000);

            //clicking reserve now
            try {
                driver.findElement(By.xpath("//*[text()='Reserve a room']")).click();
            } catch (Exception e) {
                System.out.println("clicking reserve now error.." + e);
            }//end of catch

            //capturing 1st price per night
            try {
                String pricePerNight = driver.findElements(By.xpath("//*[@class='uitk-text uitk-type-600 uitk-type-bold uitk-text-emphasis-theme']")).get(0).getText();
                System.out.println("Price per night = " + pricePerNight);
            } catch (Exception e) {
                System.out.println("capturing package price error.." + e);
            }//end of catch

            //Clicking on reserve button on price per night
            try {
                driver.findElements(By.xpath("//*[@class='uitk-button uitk-button-medium uitk-button-primary']")).get(0).click();
            } catch (Exception e) {
                System.out.println(" clicking on room reserve button error..." + e);
            }//end of catch

            Thread.sleep(2000);

            //Capturing check in and check out times
            try {
                String times = driver.findElement(By.xpath("//*[@class='travel-details w-full table-bc-s ph-base mt-mouse mb-tiny']")).getText();
                String[] timesSplit = times.split("\\R");
                System.out.println(timesSplit[0]);
                System.out.println(timesSplit[1]);
            } catch (Exception e) {
                System.out.println("capturing check in and check out error..." + e);
            }//end of catch

            //optional print statement to show a break between each iteration
            //closing current tab
            driver.close();
            //switching to first tab
            driver.switchTo().window(tabs.get(0));

        }//end of main for loop

        Thread.sleep(2000);
        driver.quit();
    }
}