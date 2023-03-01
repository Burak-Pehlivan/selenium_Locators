package BrokenLinks;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Broken_Links {
    public static void main(String[] args) throws IOException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\burak\\Desktop\\Burak\\Selenium_RahulShetty\\RahulCourse\\Drivers\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        // broken URL
        //Step 1 - IS to get all urls tied up to the links using Selenium
        // Java methods will call URL's and gets you the status code
        //if status code >400 then that url is not working-> link which tied to url
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        String url1 = driver.findElement(By.cssSelector("a[href*='soapui']")).getAttribute("href");

        HttpURLConnection conn =(HttpURLConnection) new URL(url1).openConnection();
        conn.setRequestMethod("HEAD");
        conn.connect();

        int respCode = conn.getResponseCode();
        System.out.println(respCode);


        /** Broken link */
        String urlBroken = driver.findElement(By.linkText("Broken Link")).getAttribute("href");
        HttpURLConnection connBroken = (HttpURLConnection) new URL(urlBroken).openConnection();
        connBroken.setRequestMethod("HEAD");
        connBroken.connect();
        System.out.println(connBroken.getResponseCode());

    }
}
