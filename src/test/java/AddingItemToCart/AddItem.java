package AddingItemToCart;

import com.beust.ah.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class AddItem {


    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\burak\\Desktop\\Burak\\Selenium_RahulShetty\\RahulCourse\\Drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));  // wait up to 5 seconds, tries every moment in 5 seconds
        driver.manage().window().maximize();
        WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(5));

        String[] itemsNeeded = {"Brocolli","Cucumber"};
        String promoCode="rahulshettyacademy";
        System.out.println(itemsNeeded.length);

        driver.get("https://rahulshettyacademy.com/seleniumPractise/");

        Thread.sleep(3000);

        addItems(driver,itemsNeeded);
        driver.findElement(By.cssSelector("img[alt='Cart']")).click(); // cart symbol
//        driver.findElement(By.xpath("//div[@class='cart-preview active']/div[@class='action-block']/button[@type='button']")).click(); /** Proceed to checkout */
        driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();  /** Proceed to checkout */
        w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[placeholder='Enter promo code']")));
        /**Thread.sleep(3000); */

        driver.findElement(By.cssSelector("input[placeholder='Enter promo code']")).sendKeys(promoCode);
        driver.findElement(By.cssSelector("button.promoBtn")).click();
        /**  Explicit wait */

        w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));

        System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());


    }

    public static void addItems(WebDriver driver, String[] itemsNeeded){

        int j = 0;
        List <WebElement> products =  driver.findElements(By.cssSelector("h4.product-name"));

        for (int i = 0; i< products.size();i++)
        {
            String[] name = products.get(i).getText().split("-");
            String formattedName = name[0].trim();   // delete space


            //Chech whether name you extraced is present in array or not
            // convert array into array list for easy search

            List itemsNeededList = Arrays.asList(itemsNeeded);

            if(itemsNeededList.contains(formattedName))
            {
                // click on Add to Cart
                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
                j++;
                if (j==itemsNeeded.length)
                {
                    break;
                }

            }

        }
    }
}
