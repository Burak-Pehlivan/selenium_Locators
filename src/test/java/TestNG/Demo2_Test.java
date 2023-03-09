package TestNG;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Demo2_Test {
    @Test (groups = {"smoke"})
    public void thirdTest (){
        System.out.println("Another Class");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("  Execute before test");
    }


}
