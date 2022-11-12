package Day7_102222;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class T2_SwitchTab {
    public static void main(String[] args) {
        //setup Webdriver manger to initialize webdriver
        WebDriverManager.chromedriver().setup();
        //options to control the driver
        ChromeOptions options = new ChromeOptions();
        //add argument to actually use options
       // options.addArguments("--kiosk");
        options.addArguments("--incognito");
        //initialize webdriver with options comamnds
        WebDriver driver = new ChromeDriver(options);
        //navigate
        driver.navigate().to("https://www.mlcalc.com");

/*  /click on shop for a plan
        driver.findElement(By.xpath("//*[text() = 'Shop For a Plan']")).click();
        //wait a bit
        Thread.sleep(2000);
        //click on medicaid managed care
        driver.findElement(By.xpath("//*[text() = 'Medicaid Managed Care']")).click();
        //wait a bit
        Thread.sleep(2000);
        //click on find a doctor search icon (which will launch a new tab)
        driver.findElement(By.xpath("//*[@class= 'btn btn-outline-primary btn-external btn-show link-external']")).click();
        //wait a bit
        Thread.sleep(2000);

        //store the tabs in arraylist
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        //switch to the new tab
        driver.switchTo().window(tabs.get(1));
        //enter a zip code on the search field
        driver.findElement(By.xpath("//*[@id = 'searchLocation']")).sendKeys("11230");
        //wait a bit
        Thread.sleep(2000);

 */

    }//main
}
