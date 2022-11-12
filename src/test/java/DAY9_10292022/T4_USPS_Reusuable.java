package DAY9_10292022;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class T4_USPS_Reusuable {
    public static void main(String[] args) {
        //define the webdriver manager setup for chromedriver
        WebDriverManager.chromedriver().setup();

//initialize chrome options
        ChromeOptions options = new ChromeOptions();

// add the options for maximizing the chrome meeting
// options.addArguments("start-fullscreen") for mac
        options.addArguments("--kiosk");

//define the chrome driver to use for your test
//creating an instance for a chrome driver(browser) to use for automation
        WebDriver driver = new ChromeDriver(options);


        //declate imlicit wait
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


//navigate to mlcalc
        driver.navigate().to("https://www.usps.com");


    }
}
