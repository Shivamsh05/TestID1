package Pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login_Page {

    WebDriver driver;
    WebDriverWait wait;

    By Username = By.xpath("//input[@name='username']");
    By Password = By.xpath("//input[@placeholder='Password']");
    By LoginButton = By.xpath("//button[@type='submit']");

    public Login_Page(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void login() {
    	try {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Username)).sendKeys("Admin");
    	}catch(Exception e) {
    		
    	}
    	try {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Password)).sendKeys("admin123");
        }catch(Exception e) {
        	
        }
    	try {
        wait.until(ExpectedConditions.elementToBeClickable(LoginButton)).click();
    	}catch(Exception e) {
    		
    	}
    }
}
