package Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class L2_CalenderSelect {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\burak\\Desktop\\Burak\\Selenium_RahulShetty\\RahulCourse\\Drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.manage().window().maximize();
        driver.get("https://www.path2usa.com/travel-companions");

        WebElement datespace = driver.findElement(By.cssSelector("input[id='form-field-travel_comp_date']"));

        js.executeScript("arguments[0].scrollIntoView();",datespace);
//        js.executeScript("window.scrollBy(0,700)");
        Thread.sleep(3000);
        datespace.click();

        String months = driver.findElement(By.cssSelector("span.cur-month")).getText();

        while (!months.contains("April")){
            driver.findElement(By.cssSelector("span.flatpickr-next-month")).click();
            Thread.sleep(1000);
            months = driver.findElement(By.cssSelector("span.cur-month")).getText();
        }

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
