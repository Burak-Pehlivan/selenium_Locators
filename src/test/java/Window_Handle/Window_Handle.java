package Window_Handle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class Window_Handle
{
    public static void main(String[] args) throws InterruptedException
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\burak\\Desktop\\Burak\\Selenium_RahulShetty\\RahulCourse\\Drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");

        Thread.sleep(2000);
        driver.findElement(By.cssSelector("a[class='blinkingText']")).click();

        /**  Change Window tabs */
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        String parentId = it.next();
        String childId = it.next();
        driver.switchTo().window(childId);
//        Thread.sleep(3000);

//        Thread.sleep(3000);
//        driver.switchTo().window(childId);
        System.out.println(driver.findElement(By.cssSelector("p[class='im-para red']")).getText());

        /** Choose specific word in text */
        String email = driver.findElement(By.cssSelector("p[class='im-para red']")).getText().split("at")[1].trim().split(" ")[0];
        System.out.println(email);
        driver.switchTo().window(parentId);
        driver.findElement(By.cssSelector("input[id='username']")).sendKeys(email);
    }
}

