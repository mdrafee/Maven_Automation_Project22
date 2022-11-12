package ActionItem;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Automation_AI03 {
    public static void main(String[] args) throws InterruptedException {

        //array list
        ArrayList <String>  zip = new ArrayList<>();
        zip.add("11101");
        zip.add("11423");
        zip.add("11103");

        //setup Webdriver manger to initialize webdriver
        WebDriverManager.chromedriver().setup();
        //options to control the driver
        ChromeOptions options = new ChromeOptions();
        //add argument to actually use options
        options.addArguments("--kiosk");
        options.addArguments("--in``cognito");
        //initialize webdriver with options comamnds
        WebDriver driver = new ChromeDriver(options);

      for (int i=0; i < zip.size(); i++) {
          //go to websidete
          driver.navigate().to("https://www.weightwatchers.com/us/find-a-workshop/");
          //search element at the find zipcode work shop page
          WebElement search = driver.findElement(By.xpath("//*[@class='input input-3TfT5']"));
          search.clear();
          search.sendKeys(zip.get(i));
          //click to enter teh values
          driver.findElement(By.xpath("//*[@id='location-search-cta']")).click();

          //wait
          Thread.sleep(2000);
          // click on the dopr down
      //    WebElement clicklink =
         List<WebElement> link;
          link = driver.findElements(By.xpath("//*[@class='linkUnderline-1_h4g']"));


          //if statement for different links
         if (  i== 0) {
            link.get(1).click();
            Thread.sleep(3000);
          }   else if ( i== 1){
             link.get(2).click();
             Thread.sleep(3000);
          }   else if ( i == 2){
             link.get(0).click();
             Thread.sleep(3000);
          }//if else`````

          //capture
         WebElement address=  driver.findElement(By.xpath("//*[@class='address-2PZwW']"));
          System.out.println(address.getText());


 /*  String newaddress= address.getText();
    //convert to string
          String stringAddress = address.getText();
          //spit the webelemenet string
           String[] NewSplitAddress = stringAddress.split(" ");
          //print a perper address
*/
        //  System.out.println("The address of this zip " + zip.get(i) + " is " +  newaddress);

          WebElement scheduleChart = driver.findElement(By.xpath("//*[contains(@class,'scheduleContainerMobile')]"));

          System.out.println(scheduleChart.getText());



     }//loop


    }//main
}//class
