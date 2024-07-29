import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Homework1_MouseActions {
    public static void main(String[] args) {
        // Set up WebDriver
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            // Navigate to the URL
            driver.get("https://the-internet.herokuapp.com/context_menu");

            // Locate the drawn area and perform a right-click action
            WebElement drawnArea = driver.findElement(By.id("hot-spot"));
            Actions actions = new Actions(driver);
            actions.contextClick(drawnArea).perform();

            // Verify the alert text and close the alert
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            String alertText = alert.getText();
            if ("You selected a context menu".equals(alertText)) {
                System.out.println("Alert text is correct: " + alertText);
            } else {
                System.out.println("Alert text is incorrect: " + alertText);
            }
            alert.accept();

            // Click on the "Elemental Selenium" link
            WebElement seleniumLink = driver.findElement(By.linkText("Elemental Selenium"));
            String seleniumLinkHref = seleniumLink.getAttribute("href");

            // Open the link in a new tab
            System.out.println(seleniumLinkHref);
            driver.navigate().to(seleniumLinkHref);

            WebElement h1Tag = driver.findElement(By.tagName("h1"));

            // Verify the text in the h1 tag
            if (h1Tag.getText().contains("Elemental Selenium")) {
                System.out.println("Page contains the text 'Elemental Selenium' in the h1 tag");
            } else {
                System.out.println("Page does not contain the text 'Elemental Selenium' in the h1 tag");
            }
        } finally {
            driver.quit();
        }
    }
}