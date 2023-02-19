package Exercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Q2_UI_Dropdowns_EditBoxes_ErrorValidation_Assignment {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\burak\\Desktop\\Burak\\Selenium_RahulShetty\\RahulCourse\\Drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/angularpractice/");

        /** Name */
        driver.findElement(By.xpath("//div/input[@name='name']")).sendKeys("name");

        /** Email */
        driver.findElement(By.xpath("//div/input[@name='email']")).sendKeys("asdfg@gitmail.com");

        /** Password */
        driver.findElement(By.id("exampleInputPassword1")).sendKeys("1234321");

        /** IceCreams checkbox */
        driver.findElement(By.xpath("//div/label[@for='exampleCheck1']")).click();

        /**  Gender dropdown  */
        System.out.println(driver.findElements(By.cssSelector("div option")).size());
        driver.findElement(By.cssSelector("div option:nth-child(2)")).click();


        /** Employment checkbox */
        driver.findElement(By.id("inlineRadio1")).click();
        System.out.println("Student selected : " + driver.findElement(By.id("inlineRadio1")).isSelected());

        /** Date Of Birth */
        driver.findElement(By.xpath("//div[@class='form-group']/input[@name='bday']")).sendKeys("17.12.1994");

        /** submit and assert message */

        driver.findElement(By.cssSelector("input[class*='btn-success']")).click();
        String submitMessage = "Success! The Form has been submitted successfully!.";
        System.out.println(driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText().substring(1,submitMessage.length()+2));
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText().substring(2),submitMessage);
    }

}
