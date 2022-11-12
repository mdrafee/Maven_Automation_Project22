package ActionItem;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;

public class hotel {
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
        adult.add(2);
        adult.add(3);
        adult.add(4);
        //array list of adults
        ArrayList<String> destination = new ArrayList<>();
        destination.add("New york");
        destination.add("california");
        destination.add("florida");

//navigate to mlcalc
        driver.navigate().to("https://www.hotels.com/");
        Thread.sleep(2000);

        try {
            //click on the location
            WebElement location = driver.findElement(By.xpath("//*[@class='uitk-fake-input uitk-form-field-trigger']"));
            location.click();
            driver.findElement(By.xpath("//*[@id='destination_form_field']")).sendKeys(destination.get(0));
            Thread.sleep(2000);
            //click on dorp down
            driver.findElements(By.xpath("//*[@class='is-subText truncate']")).get(0).click();
        } catch (Exception e) {
            System.out.println("destination error " + e);
        }//catch


        Thread.sleep(3000);
        try {
            //click on travlers
            driver.findElement(By.xpath("//*[@class='uitk-menu-trigger uitk-fake-input uitk-form-field-trigger']")).click();
        } catch (Exception e) {
            System.out.println(" -- click on tarvlers error  " + e);
        }//catch

        Thread.sleep(2000);
        try {
            //reduce the adult number by1
            driver.findElements(By.xpath("//*[@class='uitk-icon uitk-step-input-icon uitk-icon-medium']")).get(0).click();
          //  class="uitk-icon uitk-step-input-icon uitk-icon-medium"
        } catch (Exception e) {
            System.out.println(" -- reduce travelers number change error " + e);
        }//catch

        Thread.sleep(2000);
        try {
            //adding 1 to adult
            driver.findElements(By.xpath("//*[@class='uitk-icon uitk-step-input-icon uitk-icon-medium']")).get(1).click();
        } catch (Exception e) {
            System.out.println(" -- add adult number by 1" + e);
        }//catch

        try {
            //click on child to add 1
            driver.findElements(By.xpath("//*[@class='uitk-icon uitk-step-input-icon uitk-icon-medium']")).get(3).click();
        } catch (Exception e) {
            System.out.println(" -- chil added by 1 error" + e);
        }//catch

        try {
            //click on dropdown forchild by select
            WebElement childAge = driver.findElement(By.xpath("//*[@name='child-traveler_selector_children_age_selector-0-0']"));
            //childAge.click();
            Thread.sleep(2000);
            Select childageDp = new Select(childAge);
            childageDp.selectByVisibleText("3");

        } catch (Exception e) {
            System.out.println("child error  " + e);
        }

        Thread.sleep(3000);
        try {
            //click done
            driver.findElement(By.xpath("//*[@id='traveler_selector_done_button']")).click();
            Thread.sleep(2000);
            //click search
            driver.findElement(By.xpath("//*[@id='submit_button']")).click();
            //*[@class="uitk-icon uitk-icon-leading uitk-icon-medium"]
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println(" -- Search error after entering adult adn chld infor proeprly " + e);
        }
        //click on package
        driver.findElements(By.xpath("//*[@class='uitk-image-link']")).get(0).click();
        try {
            //store tabs
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            //switch to new tab
            driver.switchTo().window(tabs.get(1));
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println(" --Switch tab error from page reserve hotel page " + e);
        }//catch

        //capture the mssage and print it
        try {
            String resortName = driver.findElements(By.xpath("//*[@class='uitk-heading uitk-heading-3']")).get(0).getText();
            System.out.println(resortName);
        } catch (Exception e) {
            System.out.println(" --Capture ERROR -- " + e);
        }//try

        try {
            //optional
            Thread.sleep(1000);
            driver.findElement(By.xpath("//*[text()='Reserve a room']")).click();
        } catch (Exception e) {
            System.out.println(" -- Clicking reserve room after second page " + e);
        } //catch


        try {
            String datein = driver.findElements(By.xpath("//*[@class='uitk-type-400 uitk-type-regular']")).get(0).getText();
            System.out.println(datein);

            //*[contains(@class,"uitk-cell all-y-gutter-zero")]
        } catch (Exception e) {
            System.out.println("-- capture teh and date in " + e);
        }//catch

        try {
            String dateOut = driver.findElements(By.xpath("//*[@class='uitk-type-400 uitk-type-regular']")).get(1).getText();

            System.out.println(dateOut);
            //*[contains(@class,"uitk-cell all-y-gutter-zero")]

        } catch (Exception e) {
            System.out.println(" --capture teh and date OUT " + e);
        }//catch
        Thread.sleep(8000);

        /*
        try{
            //optional
            driver.findElements(By.xpath("//*[text()='Reserve']")).get(0).click();
        } catch (Exception e) {
            System.out.println(" -- Clicking reserve room after second page " + e);
        }//catch
*/
    }//main

}//class
