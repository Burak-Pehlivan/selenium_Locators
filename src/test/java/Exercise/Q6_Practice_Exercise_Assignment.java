package Exercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Q6_Practice_Exercise_Assignment {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\burak\\Desktop\\Burak\\Selenium_RahulShetty\\RahulCourse\\Drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://qaclickacademy.com/practice.php");


        WebElement checkboxExample = driver.findElements(By.cssSelector("div[id='checkbox-example'] label input")).get(1); // Option2
        checkboxExample.click();
        WebElement checkboxExamples = driver.findElements(By.cssSelector("div[id='checkbox-example'] label")).get(1);
        String optionsText = checkboxExamples.getText();
        System.out.println(optionsText);



        List<WebElement> option = driver.findElements(By.cssSelector("select[id='dropdown-class-example'] option[value*='option']"));
        for (WebElement options : option) {
            if (options.getText().equalsIgnoreCase(optionsText)) {
                options.click();
                System.out.println("Selected " + optionsText + " in dropdown.");
                break;
            } else {
                System.out.println(options.getText());
            }
        }

        driver.findElement(By.cssSelector("input[placeholder='Enter Your Name']")).sendKeys(optionsText);
        driver.findElement(By.cssSelector("input[onclick='displayAlert()']")).click();

        System.out.println(driver.switchTo().alert().getText());

        driver.switchTo().alert().accept();


    }
}
