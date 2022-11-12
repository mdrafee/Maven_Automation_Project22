package Day6_101622;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class T6_Find_Elements {
    public static void main(String[] args) throws InterruptedException {

        //Define webdrive
        WebDriverManager.chromedriver().setup();
        //initialize chrome otions
        ChromeOptions options = new ChromeOptions();
        //add the otions for maximizing the chrome meeting
        options.addArguments("--kiosk");
        //
        WebDriver driver = new ChromeDriver(options);
        //define the chrome driver to use for test
        driver.navigate().to("https://www.yahoo.com");
        //slleep
        Thread.sleep(2000);
        //
        driver.findElements(By.xpath("//*[contains(@class,'_yb_sc88r')]")).get(1).click();

    }//main
}//class
