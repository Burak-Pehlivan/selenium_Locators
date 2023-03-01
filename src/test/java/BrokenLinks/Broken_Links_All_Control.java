package BrokenLinks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;

public class Broken_Links_All_Control {
    public static void main(String[] args) throws IOException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\burak\\Desktop\\Burak\\Selenium_RahulShetty\\RahulCourse\\Drivers\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        List<WebElement> links = driver.findElements(By.cssSelector("div[id='gf-BIG'] a"));
        SoftAssert a = new SoftAssert();

        for (WebElement link : links)
        {
            String url = link.getAttribute("href");
            HttpURLConnection conn =(HttpURLConnection) new URL(url).openConnection();
            conn.setRequestMethod("HEAD");
            conn.connect();

            int respCode = conn.getResponseCode();
            System.out.print(link.getText() + " : ");
            System.out.println(respCode);
            a.assertTrue(respCode<400,"The " + link.getText() + " is broken. The response code is : " + respCode);
        }

        a.assertAll();
    }
}
