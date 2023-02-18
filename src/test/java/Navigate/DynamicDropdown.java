package Navigate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicDropdown {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\burak\\Desktop\\Burak\\Selenium_RahulShetty\\RahulCourse\\Drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();

        driver.findElement(By.xpath("//a[@value='BLR']")).click();   // From place
        Thread.sleep(2000);
//       driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();
        driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();  // To place

        driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();   //Date
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@name='ctl00$mainContent$view_date1'][1]")).click(); // Date space
        driver.findElement(By.linkText("24")).click();   // <a class="ui-state-default ui-state-highlight ui-state-active" href="#">18</a>  // date
        Thread.sleep(3000);
        driver.quit();
   }
}
