package Exercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Q7_Web_Table_Assignment {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\burak\\Desktop\\Burak\\Selenium_RahulShetty\\RahulCourse\\Drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(30));
        driver.manage().window().maximize();
        driver.get("https://qaclickacademy.com");

        /** For Opening pop up in main page */
        w.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.sumome-react-svg-image-container")));
        driver.findElement(By.xpath("//div[@style='position: absolute; inset: 0px; box-shadow: rgba(0, 0, 0, 0) 0px 0px 0px inset;']")).click();

        w.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href='https://www.rahulshettyacademy.com/AutomationPractice']")));
        driver.findElement(By.cssSelector("a[href='https://www.rahulshettyacademy.com/AutomationPractice']")).click();

        /** Count Rows */
        System.out.println(driver.findElements(By.cssSelector(".table-display tr")).size()); // rows

        /** Count Column */
        System.out.println(driver.findElements(By.tagName("tr")).get(0).findElements(By.tagName("th")).size()); // column

        /** Get 2nd row's context  */
        // System.out.println(driver.findElement(By.cssSelector(".table-display tr:nth-child(3)")).getText()); // second row's content

        List<WebElement> secondrow = driver.findElement(By.cssSelector("table.table-display")).findElements(By.tagName("tr")).get(2).findElements(By.tagName("td"));

        for (int i = 0; i < secondrow.size(); i++) {
            System.out.println(secondrow.get(i).getText());
        }
    }
}
