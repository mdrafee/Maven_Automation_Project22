package day4_100922;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T5_WebDriverEx {
    public static void main(String[] args) throws InterruptedException {
        //define the webdriver manager setup for chroedriver
        WebDriverManager.chromedriver().setup();
        //define the chrome driver to use for your test
        WebDriver driver = new ChromeDriver();

        //navigate to the google site
        driver.navigate().to("https://www.google.com");

        //wait
        Thread.sleep(3000);

        //quit
        driver.quit();
    }//mina
}//class
