package SDET_Tutorial_5;

import org.openqa.selenium.*;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AutomationPracticeForm {
    public static void main(String[] args) {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();

        try {
            driver.get("https://demoqa.com/automation-practice-form");

            Thread.sleep(500); // 2 saniye bekle
            System.out.println("Page title: " + driver.getTitle());

            SDET_Tutorial_5.PageLoadStrategy pageLoadStrategy = new SDET_Tutorial_5.PageLoadStrategy();

            pageLoadStrategy.sendKeysWebElement(driver, "firstName", "Murat");
            pageLoadStrategy.sendKeysWebElement(driver, "lastName", "Cezan");
            pageLoadStrategy.sendKeysWebElement(driver, "userEmail", "murat.cezan@orioninc.com");
            pageLoadStrategy.selectCheckbox(driver, "gender-radio-1");
            pageLoadStrategy.sendKeysWebElement(driver, "userNumber", "1234567890");
            pageLoadStrategy.selectBirthday(driver);
            pageLoadStrategy.sendKeysWebElement(driver, "subjectsInput", "SDET Tutorial");
            pageLoadStrategy.selectCheckbox(driver, "hobbies-checkbox-1");
            pageLoadStrategy.selectCheckbox(driver, "hobbies-checkbox-3");
            pageLoadStrategy.sendKeysWebElement(driver, "uploadPicture", "/home/murat/Orion/Projects/Tutorial/README.md");
            pageLoadStrategy.sendKeysWebElement(driver, "currentAddress", "Istanbul, Turkey");

            pageLoadStrategy.sendKeysWebElement(driver, "react-select-3-input", "NCR");
            pageLoadStrategy.pressEnter(driver, "react-select-3-input");

            pageLoadStrategy.sendKeysWebElement(driver, "react-select-4-input", "Delhi");
            pageLoadStrategy.pressEnter(driver, "react-select-4-input");

            pageLoadStrategy.pressEnter(driver, "submit");

            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            driver.quit();
        }
    }
}