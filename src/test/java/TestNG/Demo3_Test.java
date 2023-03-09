package TestNG;

import org.testng.annotations.*;

public class Demo3_Test {
    @Parameters({"NAME"})
    @Test
    public void WebloginCarLoan(String my){

        System.out.println("weblogincar");
        System.out.println(my);
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("  before Class execution in demo3");
    }

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("  Execute Before suit");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("  Before every Demo3 class's tests...........");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("  After class execution in demo3");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("  After every Demo3 class's tests...........");
    }
    @Parameters({"NAME"})
    @Test
    public void MobileloginCarLoan(String my){
        System.out.println("Mobilelogincar");
        System.out.println(my);
    }

    @Test (dependsOnMethods = {"WebloginCarLoan","MobileloginCarLoan"})
    public void LoginAPICarLoan(){
        System.out.println("APIlogincar");
    }
}
