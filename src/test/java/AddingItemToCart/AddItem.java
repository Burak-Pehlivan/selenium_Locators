package AddingItemToCart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class AddItem {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\burak\\Desktop\\Burak\\Selenium_RahulShetty\\RahulCourse\\Drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        String[] itemsNeeded = {"Brocolli","Cucumber"};
        System.out.println(itemsNeeded.length);
        int j = 0;
        driver.get("https://rahulshettyacademy.com/seleniumPractise/");

        Thread.sleep(3000);
        List <WebElement> products =  driver.findElements(By.cssSelector("h4.product-name"));

        for (int i = 0; i< products.size();i++){
            String[] name = products.get(i).getText().split("-");
            String formattedName = name[0].trim();   // delete space


            //Chech whether name you extraced is present in array or not
            // convert array into array list for easy search

            List itemsNeededList = Arrays.asList(itemsNeeded);

            if(itemsNeededList.contains(formattedName)){

                // click on Add to Cart
                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();

                j++;
                if (j==itemsNeeded.length){
                    break;
                }

            }
        }

    }
}
