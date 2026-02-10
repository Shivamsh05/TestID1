package Automation_Sample.TestID1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login_test {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//
        // Wait for Username field
        WebElement username =
                wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//input[@placeholder='Username']")));
        username.sendKeys("Admin");

        // Wait for Password field
        WebElement password =
                wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//input[@placeholder='Password']")));
        password.sendKeys("admin123");
        Thread.sleep(3000);
//       wait for login button 
    	 WebElement loginBtn =
               wait.until(ExpectedConditions.elementToBeClickable(
                       By.xpath("//button[@type='submit']")));
       loginBtn.click();
    	Thread.sleep(5000);

        driver.quit();
    }
}
