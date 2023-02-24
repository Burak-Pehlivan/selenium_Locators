package Exercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Q5_Frame_Assignment {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\burak\\Desktop\\Burak\\Selenium_RahulShetty\\RahulCourse\\Drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://the-internet.herokuapp.com/");
        driver.findElement(By.linkText("Nested Frames")).click();

        driver.switchTo().frame(driver.findElement(By.cssSelector("frame[src='/frame_top']")));
//        driver.switchTo().frame("frame-top");
        driver.switchTo().frame(driver.findElement(By.cssSelector("frame[src='/frame_middle']")));
//        driver.switchTo().frame("frame-middle");

        System.out.println(driver.findElement(By.cssSelector("div[id='content']")).getText());

    }
}
