package OOP;

import Navigate.AutoSuggestDropdown;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Constructor_This_1 extends Constructor_This{

    @Test
    public void testRun(){

        Constructor_This_2 ct = new Constructor_This_2(5);   // Constructor
        int a = 3;
        doThis();

        System.out.println(ct.increment());
        System.out.println(ct.decrement());

//        Constructor_Super cs = new Constructor_Super(4);
        System.out.println(ct.multiplyThree());
    }
}
