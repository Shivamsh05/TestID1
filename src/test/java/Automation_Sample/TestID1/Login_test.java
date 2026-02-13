package Automation_Sample.TestID1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import Pages.Login_Page;

public class Login_test {

    public static void main(String[] args) throws InterruptedException {

    	
//        WebDriver driver = new ChromeDriver();
        WebDriver driver = new FirefoxDriver();
        FirefoxOptions options = new FirefoxOptions();
        String BaseURL= "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
        
        // Add the "--headless" argument
//        options.addArguments("--headless");
//        driver.manage().window().maximize();

        driver.get(BaseURL);
       

        Login_Page loginpage = new Login_Page(driver); 
        loginpage.login();
        loginpage.logout();
        driver.quit();
    }
}
