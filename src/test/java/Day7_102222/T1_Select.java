package Day7_102222;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class T1_Select {
    public static void main(String[] args) {
        //set up
        WebDriverManager.chromedriver().setup();
        //options
        ChromeOptions options = new ChromeOptions();
        //options argg
        options.addArguments("--incognito");
       // options.addArguments("--kiosk");
        //call the driver with otoins
        WebDriver driver = new ChromeDriver(options);

        driver.navigate().to("https://www.mlcalc.com");

        //click on advanced options
        driver.findElement(By.xpath("//*[text() = 'Show advanced options']")).click();
/*          //this approcah will work in all drop down and not jsut select tags
        driver.findElement(By.xpath("//*[@name='sy']")).click();
        driver.findElement(By.xpath("//*[text()='2023']")).click();                 */


    }//method
}//class
