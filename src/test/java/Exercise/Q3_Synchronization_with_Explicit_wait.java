package Exercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Q3_Synchronization_with_Explicit_wait {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\burak\\Desktop\\Burak\\Selenium_RahulShetty\\RahulCourse\\Drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");

        String userName= "rahulshettyacademy";
        String passWord= "learning";


        /** Login process */
        driver.findElement(By.cssSelector("input[type='text']")).sendKeys(userName);
        driver.findElement(By.cssSelector("input[type='password']")).sendKeys(passWord);

        driver.findElement(By.xpath("//label[@class='customradio'][2]")).click();
//        Thread.sleep(3000);
        w.until(ExpectedConditions.elementToBeClickable(By.xpath("//div/button[@id='okayBtn']")));
        driver.findElement(By.xpath("//div/button[@id='okayBtn']")).click();
//        driver.findElement(By.cssSelector("button.btn.btn-success")).click();

        WebElement options = driver.findElement(By.cssSelector("select.form-control"));
        Select dropdown = new Select(options);
        dropdown.selectByValue("consult");
//        driver.findElement(By.cssSelector("option[value='consult']")).click();

        driver.findElement(By.cssSelector("input[id='terms']")).click();

        driver.findElement(By.cssSelector("input[id='signInBtn']")).click();

        /**  Logined now  */

        /** Cart adding */
        w.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.btn.btn-info")));
        List <WebElement> addCart = driver.findElements(By.cssSelector("button.btn.btn-info"));

        for (int i=0; i< addCart.size(); i++){
            addCart.get(i).click();
        }

        /** Checkout clicking  */
        driver.findElement(By.cssSelector("a.nav-link.btn.btn-primary")).click();

    }
}
