package OOP;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Constructor_This {

    public void doThis(){
        System.out.println("Hello There");
    }

    @BeforeMethod
    public void beforeRun(){
        System.out.println("Run me First");
    }

    @AfterMethod
    public void afterRun(){
        System.out.println("Run me Last");
    }

}
