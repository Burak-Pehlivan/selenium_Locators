package Exercise;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class Print_Links_Count_in_the_page {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\burak\\Desktop\\Burak\\Selenium_RahulShetty\\RahulCourse\\Drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        /** First link count */
        System.out.println(driver.findElements(By.tagName("a")).size());  // Linklerin tagname'i "a" oldugu icin sayim yaparken kullaniliyor.

        /** Second area link count **/
        WebElement footerdriver = driver.findElement(By.id("gf-BIG"));    // limiting webdriver scope
        System.out.println(footerdriver.findElements(By.tagName("a")).size());

        /** Third area link count  */
        WebElement columndriver = footerdriver.findElement(By.xpath("//div/table/tbody/tr/td[1]/ul"));
        System.out.println(columndriver.findElements(By.tagName("a")).size());

        /** Click on each link in column */   /** Check if the pages are opening */
        for (int i = 1; i < columndriver.findElements(By.tagName("a")).size(); i++)
        {
            String clickonlinkTab = Keys.chord(Keys.CONTROL,Keys.ENTER);
            columndriver.findElements(By.tagName("a")).get(i).sendKeys(clickonlinkTab);
            Thread.sleep(2000);
        }

        /**  Get title each opened page  */

        Set<String > tabs = driver.getWindowHandles();
        Iterator <String> it = tabs.iterator();


        while(it.hasNext()){
            String clickonthetab = it.next();
            driver.switchTo().window(clickonthetab);
            System.out.println(driver.getTitle());

        }
    }
}