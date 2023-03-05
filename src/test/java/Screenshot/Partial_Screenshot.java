package Screenshot;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class Partial_Screenshot {
    public static void main(String[] args) throws IOException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\burak\\Desktop\\Burak\\Selenium_RahulShetty\\RahulCourse\\Drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));  // wait up to 5 seconds, tries every moment in 5 seconds
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/angularpractice/");

        // Switching Window
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
        WebElement name = driver.findElement(with(By.tagName("input")).above(nameText));
        name.sendKeys(courseName);

        // Screenshot
        File file = name.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file , new File("name.png"));

        // Get Height & Width
        System.out.println(name.getRect().getDimension().getHeight());
        System.out.println(name.getRect().getDimension().getWidth());

        //driver.quit();


    }
}
