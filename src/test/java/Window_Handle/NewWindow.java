package Window_Handle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class NewWindow {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\burak\\Desktop\\Burak\\Selenium_RahulShetty\\RahulCourse\\Drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));  // wait up to 5 seconds, tries every moment in 5 seconds
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/angularpractice/");

        driver.switchTo().newWindow(WindowType.WINDOW);  /**   .newWindow(WindowType.TAB) */

        Set<String> windowTab = driver.getWindowHandles();
        Iterator<String> it =  windowTab.iterator();
        String parentWindowId = it.next();
        String childWindow = it.next();

        driver.switchTo().window(childWindow);
        driver.get("https://rahulshettyacademy.com/");
        String courseName = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']"))
                .get(5).getText();
        driver.switchTo().window(parentWindowId);

        WebElement nameText = driver.findElement(By.xpath("//label[text()='Email']"));
        driver.findElement(with(By.tagName("input")).above(nameText)).sendKeys(courseName);

        driver.quit();
    }
}
