package Mouse_Keyboard;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Mouse_Keyboard {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\burak\\Desktop\\Burak\\Selenium_RahulShetty\\RahulCourse\\Drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.amazon.com/");
        Actions mouseKeyboard = new Actions(driver);

        // shift bas, yaziyi gonder, yaziya cift click
        mouseKeyboard.moveToElement(driver.findElement(By.cssSelector("[id='twotabsearchtextbox']")))
                .click()
                .keyDown(Keys.SHIFT)
                .sendKeys("motherboard")
                .doubleClick()
                .build()
                .perform();


        /** Mouse over element */
        WebElement move = driver.findElement(By.cssSelector("[id='nav-link-accountList']"));

        mouseKeyboard.moveToElement(move)
                .contextClick().build().perform();  // contextclick = right click


    }
}
