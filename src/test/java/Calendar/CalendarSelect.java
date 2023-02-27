package Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CalendarSelect {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\burak\\Desktop\\Burak\\Selenium_RahulShetty\\RahulCourse\\Drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.path2usa.com/travel-companions");

        Thread.sleep(1000);
        driver.findElement(By.xpath("//div/input[@name='form_fields[travel_comp_date]']")).click();
//        List <WebElement> dates = driver.findElements(By.className(".flatpickr-day"));
//
//        int count = driver.findElements(By.className(".flatpickr-day")).size();
//        String day = "23";
//
//        for (int i = 0; i < count; i++) {
//            String text = driver.findElements(By.className(".flatpickr-day")).get(i).getText();
//            if (text.equalsIgnoreCase(day)){
//                driver.findElements(By.className(".flatpickr-day")).get(i).click();
//            }
//            else {
//                System.out.println(driver.findElements(By.className(".flatpickr-day")).get(i).getText());
//            }
//
//        }

    }
}
