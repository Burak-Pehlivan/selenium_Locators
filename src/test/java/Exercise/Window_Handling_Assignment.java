package Exercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.Iterator;
import java.util.Set;

public class Window_Handling_Assignment {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\burak\\Desktop\\Burak\\Selenium_RahulShetty\\RahulCourse\\Drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");

        driver.findElement(By.linkText("Multiple Windows")).click();

        driver.findElement(By.cssSelector("div.large-12.columns a[target='_blank']")).click();

        // Switch window tab
        Set<String> tabs = driver.getWindowHandles();
        Iterator <String> window = tabs.iterator();

        String parentTab = window.next();
        String childTab = window.next();

        driver.switchTo().window(childTab);
        System.out.println(driver.findElement(By.cssSelector("div.example")).getText());

        Thread.sleep(3000);

        driver.switchTo().window(parentTab);
        System.out.println(driver.findElement(By.cssSelector("div.example h3")).getText());


    }
}
