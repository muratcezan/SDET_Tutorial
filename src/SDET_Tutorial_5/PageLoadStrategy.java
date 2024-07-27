package SDET_Tutorial_5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PageLoadStrategy {
    public PageLoadStrategy()  {
        System.out.println("Initiated PageLoadStrategy class");
    }

    void sendKeysWebElement(WebDriver driver, String id, String value) throws InterruptedException {
        WebElement element = driver.findElement(By.id(id));
        element.sendKeys(value);
        System.out.println(id + " : " + element.getAttribute("value"));
        Thread.sleep(1000);
    }

    void selectCheckbox(WebDriver driver, String id) throws InterruptedException {
        WebElement element = driver.findElement(By.xpath("//label[@for='" + id + "']"));
        element.click();
        System.out.println(id + " : " + element.getAttribute("value"));
        Thread.sleep(500);
    }

    void pressEnter(WebDriver driver, String id) throws InterruptedException {
        WebElement element = driver.findElement(By.id(id));
        element.sendKeys("\n");
        System.out.println(id + " : " + element.getAttribute("value"));
        Thread.sleep(1000);
    }

    void selectBirthday(WebDriver driver)throws InterruptedException{
        System.out.println("SelectBirthday class is created");
        WebElement dateOfBirth = driver.findElement(By.id("dateOfBirthInput"));
        dateOfBirth.click();
        Thread.sleep(500);

        Select yearSelect = new Select(driver.findElement(By.className("react-datepicker__year-select")));
        yearSelect.selectByVisibleText("1991");
        System.out.println("Year Selected");
        Thread.sleep(500);

        Select monthSelect = new Select(driver.findElement(By.className("react-datepicker__month-select")));
        monthSelect.selectByVisibleText("August");
        System.out.println("Month Selected");
        Thread.sleep(500);

        WebElement daySelect =  driver.findElement(By.className("react-datepicker__day--001"));
        daySelect.click();
        System.out.println("Day Selected");
        Thread.sleep(2000);
    }
}
