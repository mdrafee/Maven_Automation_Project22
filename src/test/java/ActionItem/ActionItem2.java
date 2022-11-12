package ActionItem;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class ActionItem2 {
    public static void main(String[] args) throws InterruptedException {

        ArrayList<String> population = new ArrayList<>();
        population.add("Beef Population");
        population.add("chicken population");
        population.add("mutton population");
        population.add("pig population");

        //setup webdriver manager
        WebDriverManager.chromedriver().setup();
        // initial driver
        WebDriver driver = new ChromeDriver();

        for (int i=0;i< population.size();i++){
            //navigate to bring
       driver.navigate().to("https://bing.com");
        //enlarg
       driver.manage().window().fullscreen();
        Thread.sleep(2000);

       //send keys to search
       driver.findElement(By.xpath("//*[@name='q']")).sendKeys(population.get(i));
       // press enter
       driver.findElement(By.xpath("//*[@id='search_icon']")).click();
       //capture the value using GET TEXT
       String SearchValue = driver.findElement(By.xpath("//*[@class=\"sb_count\"]")).getText();
       //split comment
       String[] splitword = SearchValue.split(" ");
       //print the split value
       System.out.println("the value for "+population.get(i)+" is "+splitword[0]);
       //sleep
       Thread.sleep(2000);
        } //END LOOP

        driver.quit();
    }//main
}// class
