package Reusable_Library;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.ArrayList;
import java.util.logging.Logger;

public class ReusableActions_Loggers {
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

    public static void clickAction(WebDriver driver, String xpath, ExtentTest logger,String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            element.click();
            //verify click action
            logger.log(LogStatus.PASS,"  Succesfully clicked " + elementName);

        } catch (Exception e) {
            System.out.println("Unable to click on element: " + elementName + " for reason: " + e);
            logger.log(LogStatus.FAIL,"-- unable to click on element " + elementName +  "b/c" + e);
        }
    }

    public static void clickActionByIndex(WebDriver driver, String xpath, int index,ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath))).get(index).click();
            //verify click action log
            logger.log(LogStatus.PASS,"  Succesfully clicked on index" + elementName);
        } catch (Exception e) {
            System.out.println(" -- Unable to click on element: " + elementName + " for reason: " + e);
            //fail lgger
            logger.log(LogStatus.FAIL,"-- unable to click on element by index" + elementName +  "b/c" + e);
        }
    }

    public static void mouseHover(WebDriver driver, String xpath, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        //declare mouse actions
        Actions actions = new Actions(driver);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            actions.moveToElement(element).perform();
            //verify logger
            logger.log(LogStatus.PASS," Successfully hovered " + elementName);

        } catch (Exception e) {
            System.out.println("Unable to hover to element: " + elementName + " for reason: " + e);
            //verify fail log
            logger.log(LogStatus.FAIL," -- UNABLE to hover "+ elementName + " B/C " + e);
        }
    }

    public static void sendKeysAction(WebDriver driver, String xpath, String userInput, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            element.sendKeys(userInput);
            //verify the element is successful
            logger.log(LogStatus.PASS,"succefully entered the value on " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to send keys to : " + elementName + " for reason: " + e);
            logger.log(LogStatus.FAIL, "Unable to send keys to : " +elementName + " B/C " + e);
        }
    }

    public static String getTextAction(WebDriver driver, String xpath, ExtentTest logger,String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        //this is equal to null or nothing
        String textOutput = "";
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            textOutput = element.getText();
            //verify pass
            logger.log(LogStatus.PASS,"-- Successfully performed gettext " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to get text for : " + elementName + " for reason: " + e);
            //verify fail log
            logger.log(LogStatus.FAIL, "Unable to get text to : " +elementName + " B/C " + e);

        }
        return textOutput;
    }
    public static void submitAction(WebDriver driver, String xpath, ExtentTest logger,String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            element.submit();
            //verify submit action logger
            logger.log(LogStatus.PASS," -- successfully submitted /entered " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to submit on element: " + elementName + " for reason: " + e);
            //verify fail log
            logger.log(LogStatus.FAIL," --unable to enter or submit " +elementName + " b/c " + e);

        }
    }//end of submit action

    public static void switchTabByIndex(WebDriver driver,int tabID) {
        //store tabs
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        //switch to new tab
        driver.switchTo().window(tabs.get(tabID));
    }//end of switch tab index

    public static void selectByText(WebDriver driver, String xpath, String text, ExtentTest logger,String elementname) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            //wait statement to load up the dropdown
            Thread.sleep(2000);
            Select elementdropDn = new Select(element);
            elementdropDn.selectByVisibleText(text);
            logger.log(LogStatus.PASS," --Successfully selected dropdown " + elementname);
        }catch (Exception e){
            System.out.println( "--  Unable to click on dropdown using Select" + e + elementname );
            //verify fail
            logger.log(LogStatus.FAIL, " -- Unable to click on drop down " + elementname + " B/C " + e);
        }
    }//select by index

    public static void scrollByElement(WebDriver driver, String xpath, int scrollIndex, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        try {
            ArrayList<WebElement> scrollElement = new ArrayList<>(wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath))));
            //scroll into view of calculate button
            jse.executeScript("arguments[0].scrollIntoView(true);", scrollElement.get(scrollIndex));
            logger.log(LogStatus.PASS, " Successflly scrolled " + elementName);
        } catch (Exception e){
            System.out.println("Unable to scroll by view: " + elementName + "for reason: " + e);
            logger.log(LogStatus.FAIL, "-- Unable to scroll " + elementName + " b/c " + e);
        }//end of catch
    }//end scroll By View

    public static void getScreenShot(WebDriver driver, String imageName, ExtentTest logger) {
        try {
            String fileName = imageName + ".png";
            String directory = null;
            String snPath = null;
            directory = "src/main/java/HTML_Report/Screenshots/";
            snPath = "Screenshots//";
            File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(sourceFile, new File(directory + fileName));
            //String imgPath = directory + fileName;
            String image = logger.addScreenCapture(snPath + fileName);
            logger.log(LogStatus.FAIL, "", image);
        } catch (Exception e) {
            logger.log(LogStatus.FAIL, "Error Occured while taking SCREENSHOT!!!");
            e.printStackTrace();
        }//catch
    }//screenshot
    public static void compareExpectedAndActualText(String expectedText, String actualText, ExtentTest logger) {
        if (actualText.equals(expectedText)) {
            logger.log(LogStatus.PASS, "Expected Text: " + expectedText + " and Actual Text: " + actualText + " match");
        }
        else{
            logger.log(LogStatus.FAIL, "Expected Text: " + expectedText + " and Actual Text: " + actualText + " does not match");
        }
    }//end of compareExpectedAndActualText
}//class
    //end of getScreenshot method}
