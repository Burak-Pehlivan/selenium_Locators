package Frame;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class Frame_Check {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\burak\\Desktop\\Burak\\Selenium_RahulShetty\\RahulCourse\\Drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://jqueryui.com/droppable/");

        System.out.println(driver.findElements(By.tagName("iframe")).size());

        /**  Switch Frame  */
        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame")));
        // driver.switchTo().frame(0);

        /** Drag frame into other frame */
        Actions a = new Actions(driver);
        WebElement sourceFrame = driver.findElement(By.cssSelector("[id='draggable']"));
        WebElement targetFrame = driver.findElement(By.cssSelector("[id='droppable']"));
        a.dragAndDrop(sourceFrame,targetFrame).build().perform();


        /** Return Default page */
        driver.switchTo().defaultContent();    // Return Main page
        driver.findElement(By.linkText("Accept")).click();

    }
}
