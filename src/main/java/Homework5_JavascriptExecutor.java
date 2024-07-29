import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Homework5_JavascriptExecutor {
    public static void main(String[] args) {
        // Set up WebDriver
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
        WebDriver driver = new ChromeDriver();

        try {
            // Navigate to the URL
            driver.get("https://www.selenium.dev/");

            // Locate the "About Selenium" link using a CSS locator
            WebElement aboutSeleniumLink = driver.findElement(By.linkText("About Selenium"));

            // Use JavascriptExecutor to scroll down to the "About Selenium" section
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", aboutSeleniumLink);
            Thread.sleep(5000);
            // Use JavascriptExecutor to click the "About Selenium" link
            js.executeScript("arguments[0].click();", aboutSeleniumLink);
            Thread.sleep(5000);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            driver.quit();
        }
    }
}