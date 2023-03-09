package TestNG;

import org.testng.annotations.*;

public class Demo1_Test {
    @Parameters({"NAME","APIkey"})
    @Test
    public void demo(String abcdefgh, String key){
        System.out.println("Demo Start");
        System.out.println(abcdefgh);
        System.out.println(key);
    }

    @AfterTest
    public void afterTest(){
        System.out.println("  Execute after Test");
    }
    @BeforeTest
    public void secondBeforeTest(){
        System.out.println("  second before Test");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("  Execute After Suite");
    }

    @Test
    public void secondTest(){
        System.out.println("Demo finished");
    }
}
