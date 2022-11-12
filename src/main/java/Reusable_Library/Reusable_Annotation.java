package Reusable_Library;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;


public class Reusable_Annotation {

        public static WebDriver driver;
        public static ExtentReports reports;
        public static ExtentTest logger;
    //setup driver

    @BeforeSuite
    public void setTheDriver() {
        driver = ReusableActions.setUpDriver();
        //path
        reports = new ExtentReports("src/main/java/HTML_Reports/Automation_Report.html",true);
        }//before


    @BeforeMethod
    public void captureTestName(Method testName){
        //before every test, this method will be called and take the name of your test
        //and it will add your test method name to the html report
        logger = reports.startTest(testName.getName());
    }//end of before method

    @AfterMethod
    public void endLogger(){
        reports.endTest(logger);
    }//end of after method

    @AfterSuite
    public void quitSession(){
        driver.quit();
        //writing back to one html report
        reports.flush();
    }//end of aftersuite


}
