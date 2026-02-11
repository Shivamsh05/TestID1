package Automation_Sample.TestID1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import Pages.Login_Page;

public class Login_test {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        Login_Page loginpage = new Login_Page(driver); 
        loginpage.login();
        Thread.sleep(5000);

        driver.quit();
    }
}
