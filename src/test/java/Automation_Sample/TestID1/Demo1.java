package Automation_Sample.TestID1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Demo1 {

    static WebDriver driver;
    static WebDriverWait wait;
    static String BaseURL = "https://www.automationtesting.co.uk/dropdown.html";

    // Setup method
    public static void setup() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        driver.get(BaseURL);
        driver.manage().window().maximize();
    }

    // Teardown method
    public static void teardown() {
        driver.quit();
    }

    // Main method
    public static void main(String[] args) throws InterruptedException {

        setup();  // call setup

        WebElement dropDown = driver.findElement(By.id("cars"));
        Select select = new Select(dropDown);

        select.selectByVisibleText("Ford");

        List<WebElement> list = select.getOptions();

        for (WebElement i : list) {
            System.out.println(i.getText()); // print text
        }
        WebElement checkbox = driver.findElement(By.xpath("//label[@for='cb_green']"));
        checkbox.click();
        teardown(); // call teardown
    }
}
