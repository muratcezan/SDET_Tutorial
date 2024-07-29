import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Homework3_DownloadAndFileExists {
    private static final String DOWNLOAD_DIR = "/home/murat/Downloads";
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public boolean isExist() {
        File file = new File(DOWNLOAD_DIR + "/sample.png");
        return file.exists();
    }

    @Test
    public void downloadTest() throws InterruptedException {
        // Navigate to the URL
        driver.get("https://the-internet.herokuapp.com/download");

        // Locate and click the download link for sample.png
        WebElement downloadLink = driver.findElement(By.linkText("sample.png"));
        downloadLink.click();

        // Wait for the download to complete (this is a simple wait, adjust as needed)
        Thread.sleep(5000);

        // Verify if the file was downloaded successfully
        assertTrue(isExist(), "The file was not downloaded.");
    }
}