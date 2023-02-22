package Exercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Q3_Synchronization_with_Explicit_wait {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\burak\\Desktop\\Burak\\Selenium_RahulShetty\\RahulCourse\\Drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(3));
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");

        String userName= "rahulshettyacademy";
        String passWord= "learning";

        driver.findElement(By.cssSelector("input[type='text']")).sendKeys(userName);
        driver.findElement(By.cssSelector("input[type='password']")).sendKeys(passWord);

        driver.findElement(By.xpath("//label[@class='customradio'][2]")).click();
//        Thread.sleep(3000);
        w.until(ExpectedConditions.elementToBeClickable(By.xpath("//div/button[@id='okayBtn']")));
        driver.findElement(By.xpath("//div/button[@id='okayBtn']")).click();
//        driver.findElement(By.cssSelector("button.btn.btn-success")).click();

        driver.findElement(By.cssSelector("select.form-control")).click();
        driver.findElement(By.cssSelector("option[value='consult']")).click();

        driver.findElement(By.cssSelector("input[id='terms']")).click();

        driver.findElement(By.cssSelector("input[id='signInBtn']")).click();
    }
}
