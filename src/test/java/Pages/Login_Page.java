package Pages;

import java.util.List;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.Assert;
//For soft assertions
import org.testng.asserts.SoftAssert;

import Automation_Sample.TestID1.Login_test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Login_Page {

    WebDriver driver;
    WebDriverWait wait;
    private static final Logger logger = LogManager.getLogger(Login_test.class);
    
    
    
    By Username = By.xpath("//input[@name='username']");
    By Password = By.xpath("//input[@placeholder='Password']");
    By LoginButton = By.xpath("//button[@type='submit']");
    By profileMenu = By.xpath("//span[@class='oxd-userdropdown-tab']");
    By LogoutButton = By.xpath("//ul[@class='oxd-dropdown-menu']");
    By LogoutBtn = By.xpath("//a[text()='Logout']");

    public Login_Page(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }
    public void login() {
    	try {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Username)).sendKeys("Admin");
    	}catch(Exception e) {
    		 logger.error("Error occurred", e);
    	}
    	try {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Password)).sendKeys("admin123");
        }catch(Exception e) {
        	 logger.error("Error occurred", e);
        }
    	try {
        wait.until(ExpectedConditions.elementToBeClickable(LoginButton)).click();
        Assert.assertEquals(driver.getTitle(), "OrangeHRM", "Page title mismatch"); 
        logger.info("User logged in successfully..");
        System.out.println("Login work..");
        System.out.println(System.getProperty("log4j.configurationFile"));
    	}catch(Exception e) {
    		 logger.error("Error occurred", e);
    	}
    }
    public void logout() throws InterruptedException {
    	//To be continue....
    	
    	try {
    		wait.until(ExpectedConditions.elementToBeClickable(profileMenu)).click();
    		System.out.println("Profile menu clicked");

    		}catch(Exception e) {
    		System.out.println("Profile menu not found"+e);
    		 logger.error("Error occurred", e);
    		}
    	try {
    		Thread.sleep(5000);
        	wait.until(ExpectedConditions.elementToBeClickable(LogoutBtn)).click();

        	logger.info("User logged out successfully..");
        	}catch(Exception e) {
        		System.out.println("Logout button not found"+e);
        		 logger.error("Error occurred", e);
        	}
    }
}
