package Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CalendarSelect {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\burak\\Desktop\\Burak\\Selenium_RahulShetty\\RahulCourse\\Drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(5));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.manage().window().maximize();
        driver.get("https://www.path2usa.com/travel-companions");

        WebElement calendar = driver.findElement(By.xpath("//div/input[@name='form_fields[travel_comp_date]']"));
//        w.until(ExpectedConditions.elementToBeClickable(calendar));
        js.executeScript("arguments[0].scrollIntoView();",calendar);  // scroll to calendar variables

        Thread.sleep(2000);
        calendar.click();
        driver.findElement(By.cssSelector("span.flatpickr-next-month")).click();
        Thread.sleep(1000);

        List <WebElement> dates = driver.findElements(By.cssSelector("span.flatpickr-day"));

        int count = dates.size();
        String day = "23";

        for (int i = 0; i < count; i++) {
            String text = dates.get(i).getText();
            if (text.equalsIgnoreCase(day)){
                dates.get(i).click();
                break;
            }
            else {
                System.out.println(dates.get(i).getText());
            }

        }

    }
}
