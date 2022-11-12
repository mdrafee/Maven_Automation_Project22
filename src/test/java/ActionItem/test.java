package ActionItem;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class test {
    public static void main(String[] args) throws InterruptedException {

        //array list
        ArrayList<String> zip = new ArrayList<>();
        zip.add("11101");
        zip.add("11102");
        zip.add("11103");

        //setup Webdriver manger to initialize webdriver
        WebDriverManager.chromedriver().setup();
        //options to control the driver
        ChromeOptions options = new ChromeOptions();
        //add argument to actually use options
        options.addArguments("--kiosk");
        options.addArguments("--incognito");
        //initialize webdriver with options comamnds
        WebDriver driver = new ChromeDriver(options);
        //go to websidete
        driver.navigate().to("https://www.weightwatchers.com/us/find-a-workshop/");

      //  for (int i=0; i >= zip.size(); i++) {
            //search element at the find zipcode work shop page
            WebElement search = driver.findElement(By.xpath("//*[@class='input input-3TfT5']"));
            search.clear();
            search.sendKeys("11355");
            //click to enter teh values
            driver.findElement(By.xpath("//*[@id='location-search-cta']")).click();

            //wait
            Thread.sleep(2000);
            // click on the dopr down
            //    WebElement clicklink =
            driver.findElements(By.xpath("//*[contains(@class,'linkUnderline')]")).get(0).click();



     //   }//loop


    }//main
}
