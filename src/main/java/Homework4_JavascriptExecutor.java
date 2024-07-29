import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Homework4_JavascriptExecutor {
    public static void main(String[] args) {
        // Set up WebDriver
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
        WebDriver driver = new ChromeDriver();

        try {
            // Navigate to the URL
            driver.get("http://webdriveruniversity.com/Click-Buttons/index.html");

            // Locate the "JavaScript Click" button using a CSS locator
            WebElement jsClickButton = driver.findElement(By.cssSelector("#button2"));
            Thread.sleep(2000);

            // Use JavascriptExecutor to click the button
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", jsClickButton);
            Thread.sleep(5000);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            driver.quit();
        }
    }
}