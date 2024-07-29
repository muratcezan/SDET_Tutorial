import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Homework2_KeyboardActions {
    public static void main(String[] args) {
        // Set up WebDriver
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
        WebDriver driver = new ChromeDriver();

        try {
            // Navigate to the URL
            driver.get("https://html.com/tags/iframe/");

            // Scroll down until the YouTube video is visible
            WebElement iframe = driver.findElement(By.cssSelector("iframe[src*='youtube.com']"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", iframe);

            // Switch to the iframe containing the YouTube video
            driver.switchTo().frame(iframe);

            // Click the Play button to start the video
            WebElement playButton = driver.findElement(By.cssSelector("button[aria-label='Play']"));
            playButton.click();
            Thread.sleep(5000);

            // TODO: Add code to pause the video
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement pauseButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[aria-label='Pause']")));

            if (pauseButton.isDisplayed()) {
                System.out.println("The Pause button is displayed.");
            } else {
                System.out.println("The Pause button is not displayed.");
            }

            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            driver.quit();
        }
    }
}