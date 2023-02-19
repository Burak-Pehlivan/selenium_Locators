package Exercise;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class ChecboxAssert {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\burak\\Desktop\\Burak\\Selenium_RahulShetty\\RahulCourse\\Drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        /** Checkbox list  */
        // List<WebElement> checboxTicks = driver.findElements(By.cssSelector("input[id*='checkBoxOption']"));

        /**  First checkbox select verify  */
        driver.findElement(By.id("checkBoxOption1")).click();
        System.out.println(driver.findElement(By.id("checkBoxOption1")).isSelected());
        Assert.assertEquals(driver.findElement(By.id("checkBoxOption1")).isSelected(),true);

        /**  Wait 3 sec */
        Thread.sleep(3000);

        /** First checkbox unselect verify */
        driver.findElement(By.id("checkBoxOption1")).click();
        System.out.println(driver.findElement(By.id("checkBoxOption1")).isSelected());
        Assert.assertEquals(driver.findElement(By.id("checkBoxOption1")).isSelected(),false);

        /**  Wait 3 sec */
        Thread.sleep(3000);

        /** Checbox count */

        System.out.println(driver.findElements(By.cssSelector("input[id*='checkBoxOption']")).size());

        /** Quit driver , so we can understand that our project is succesfully done*/
        driver.quit();
        }



    }

