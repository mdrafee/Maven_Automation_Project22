package day5_101522;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class T1_XpathTextContains {
    public static void main(String[] args) throws InterruptedException {
        //define the webdriver manager setup for chroedriver
        WebDriverManager.chromedriver().setup();

        //define the chrome driver to use for your test
        ChromeOptions options = new ChromeOptions();

        WebDriver driver = new ChromeDriver(options);

       //chrome options
       options.addArguments("incognito");
      //  options.addArguments("start-maximized");
      //  options.addArguments("headless");


        driver.navigate().to("https://www.yahoo.com");

        // maximize driver
        // driver.manage().window().maximize();

        //click
        driver.findElement(By.xpath("//*[text()='sign in']")).click();
        //wait
        Thread.sleep(1000);

        //quit
        driver.quit();
    }
}
