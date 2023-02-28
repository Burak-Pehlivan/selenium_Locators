package Table_Grid_Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class Grid_Elements {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\burak\\Desktop\\Burak\\Selenium_RahulShetty\\RahulCourse\\Drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));  // wait up to 5 seconds, tries every moment in 5 seconds
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        List<WebElement> amountGrid = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
        int sum = 0 ;

        for (int i = 0; i < amountGrid.size(); i++) {
           sum += Integer.parseInt(amountGrid.get(i).getText());
        }
        System.out.println(sum);
        int total = Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim());

        Assert.assertEquals(sum,total);

    }
}
