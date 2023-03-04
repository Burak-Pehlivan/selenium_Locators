package Streams;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class L2_Web_Table_Sorting {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\burak\\Desktop\\Burak\\Selenium_RahulShetty\\RahulCourse\\Drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));  // wait up to 5 seconds, tries every moment in 5 seconds
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        Thread.sleep(1000);

        // click on column
        driver.findElement(By.xpath("//tr/th[1]")).click();   // header click

        // capture all webelements into list
        List<WebElement> firstColumnList = driver.findElements(By.xpath("//tr/td[1]"));

        // capture text of all webelements into new list
        List <String> firstColumnTexts = firstColumnList.stream().map(s->s.getText()).collect(Collectors.toList());

        // sort on the original list of step 3 -> sorted list
        List<String> sortedList = firstColumnTexts.stream().sorted().collect(Collectors.toList());

        // compare original list vs sorted list
        Assert.assertTrue(firstColumnTexts.equals(sortedList));

        List <String> price;
        // scan the name column with getText -> Beans -> print the price of the Rice
        do
        { List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));
        price = rows.stream().filter(s->s.getText().contains("Rice"))
                .map(s->getPriceVeggie(s)).collect(Collectors.toList());
        price.forEach(a-> System.out.println(a));

        if (price.size()<1){
            driver.findElement(By.cssSelector("[aria-label='Next']")).click();
        }
        }while (price.size()<1);


    }

    private static String getPriceVeggie(WebElement s) {
        String priceValue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
        return priceValue;
    }
}
