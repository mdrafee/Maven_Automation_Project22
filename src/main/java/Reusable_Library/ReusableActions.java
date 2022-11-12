package Reusable_Library;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class ReusableActions {
    static int timeout = 8;

    //reusable method to define and launch webdriver
    public static WebDriver setUpDriver() {
        //define the webdriver manager setup for chromedriver
        WebDriverManager.chromedriver().setup();
        //initialize chrome options
        ChromeOptions options = new ChromeOptions();
        //add argument to chrome options
        // options.addArguments("start-maximized");
        //for mac use "start-fullscreen"
        //options.addArguments("start-fullscreen");
        //if above does not work on mac, then try --kiosk
        options.addArguments("--kiosk");
        //initialize driver with chrome options
        WebDriver driver = new ChromeDriver(options);
        return driver;
    }//end of setup driver method

    public static void clickAction(WebDriver driver, String xpath, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            element.click();
        } catch (Exception e) {
            System.out.println("Unable to click on element: " + elementName + " for reason: " + e);
        }
    }

    public static void clickActionByIndex(WebDriver driver, String xpath, int index, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath))).get(index).click();
        } catch (Exception e) {
            System.out.println("Unable to click on element: " + elementName + " for reason: " + e);
        }
    }

    public static void mouseHover(WebDriver driver, String xpath, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        //declare mouse actions
        Actions actions = new Actions(driver);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            actions.moveToElement(element).perform();
        } catch (Exception e) {
            System.out.println("Unable to hover to element: " + elementName + " for reason: " + e);
        }
    }

    public static void sendKeysAction(WebDriver driver, String xpath, String userInput, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            element.sendKeys(userInput);
        } catch (Exception e) {
            System.out.println("Unable to send keys to : " + elementName + " for reason: " + e);
        }
    }

    public static String getTextAction(WebDriver driver, String xpath, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        //this is equal to null or nothing
        String textOutput = "";
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            textOutput = element.getText();
        } catch (Exception e) {
            System.out.println("Unable to get text for : " + elementName + " for reason: " + e);
        }
        return textOutput;
    }
    public static void submitAction(WebDriver driver, String xpath, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            element.submit();
        } catch (Exception e) {
            System.out.println("Unable to submit on element: " + elementName + " for reason: " + e);
        }
    }//end of submit action

    public static void switchTabByIndex(WebDriver driver,int tabID) {
        //store tabs
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        //switch to new tab
        driver.switchTo().window(tabs.get(tabID));
    }//end of switch tab index

    public static void selectByText(WebDriver driver, String xpath, String text, String elementname) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            //wait statement to load up the dropdown
            Thread.sleep(2000);
            Select elementdropDn = new Select(element);
            elementdropDn.selectByVisibleText(text);
        }catch (Exception e){
            System.out.println( "--  Unluable to click on dropdown using Select" + e + elementname );
        }
    }//select by index

    public static void scrollByElement(WebDriver driver, String xpath, int scrollIndex, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        try {
            ArrayList<WebElement> scrollElement = new ArrayList<>(wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath))));
            //scroll into view of calculate button
            jse.executeScript("arguments[0].scrollIntoView(true);", scrollElement.get(scrollIndex));
        } catch (Exception e){
            System.out.println("Unable to scroll by view: " + elementName + "for reason: " + e);
        }//end of catch
    }//end scroll By View
}
