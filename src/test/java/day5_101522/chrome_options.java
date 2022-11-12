package day5_101522;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class chrome_options {
    public static void main(String[] args) {
        //setup chrome driver
        WebDriverManager.chromedriver().setup();
        //options
        ChromeOptions options = new ChromeOptions();

        //initial
        WebDriver driver = new ChromeDriver(options);
        //add arguments
        options.addArguments("incognito");
        //go to google page
        driver.navigate().to("https://www.google.com");
        //locate element for search field and type cars
        //this is an example of relative xpath
        driver.findElement(By.xpath("//*[@name = 'q']")).sendKeys("cars");
        //submit on google search button
        driver.findElement(By.xpath("//*[@name ='btnK']")).submit();
        //capture the search result and print it
        String searchResult = driver.findElement(By.xpath("//*[@id='result-stats']")).getText();
        //extract out the number and print the search number only
        String[] arrayResult = searchResult.split(" ");
        System.out.println("My search number is " + arrayResult[1]);
        //quit driver
        driver.quit();
    }
}
