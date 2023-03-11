package TestNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Iterator;

public class Demo4_Test {
    @Test (enabled = false)
    public void WebloginHomeLoan(){
        System.out.println("webloginHome");
    }

    @Test (groups = {"smoke"})
    public void MobileloginHomeLoan(){
        System.out.println("MobileloginHome");
    }

    @Test (dataProvider = "getData")
    public void LoginAPIHomeLoan(String username, String password){
        System.out.println("APIloginHome");
        System.out.println(username);
        System.out.println(password);
    }

    @DataProvider
    public Object[][] getData(){
        Object[][] data = new Object[3][2];
        data[0][0]="firstsetusername";
        data[0][1]="password";

        data[1][0]="secondsetusername";
        data[1][1]="secondpassword";

        data[2][0]="thirdsetusername";
        data[2][1]="thirdpassword";

        return data;
    }
}
