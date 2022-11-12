package Day6_101622;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.plaf.TableHeaderUI;

public class T7_WebElement_calc {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        //define the chrome driver to use for your test
        WebDriver driver = new ChromeDriver();

        //navigate to the google site
        driver.navigate().to("https://www.mlcalc.com");


        Thread.sleep(3000);
        //clear and enter new value on purchase price field
        WebElement pPrice = driver.findElement(By.xpath("//*[@name='ma"));
        //clear the purchase price
        pPrice.clear();
        //sendkeys
        pPrice.sendKeys("45000");

        //clear and enter new value on purchase price field
        WebElement dPayment = driver.findElement(By.xpath("//*[@name='dp'"));
      //clear down payment
        dPayment.clear();
        //clear the purchase price
        pPrice.sendKeys("45000");
    }
}
