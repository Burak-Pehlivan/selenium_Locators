package Button;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ButtonSelecting {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\burak\\Desktop\\Burak\\Selenium_RahulShetty\\RahulCourse\\Drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        System.out.println(driver.findElement(By.cssSelector("input[id='ctl00_mainContent_chk_SeniorCitizenDiscount'")).isSelected());
        driver.findElement(By.cssSelector("input[id='ctl00_mainContent_chk_SeniorCitizenDiscount'")).click();
        System.out.println(driver.findElement(By.cssSelector("input[id='ctl00_mainContent_chk_SeniorCitizenDiscount'")).isSelected());

        System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());

        driver.findElement(By.id("divpaxinfo")).click(); // Passenger Count
        Thread.sleep(3000);

        System.out.println(driver.findElement(By.id("divpaxinfo")).getText()); // 1 Adult
        int i = 1;
        while (i<5)
        {
            driver.findElement(By.id("hrefIncAdt")).click();
            i++;
        }
        driver.findElement(By.id("btnclosepaxoption")).click();
        System.out.println(driver.findElement(By.id("divpaxinfo")).getText()); // 5 Adult
    }
}
