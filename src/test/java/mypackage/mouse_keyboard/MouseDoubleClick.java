package mypackage.mouse_keyboard;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseDoubleClick {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick3");

        driver.switchTo().frame("iframeResult");

        WebElement field1 = driver.findElement(By.xpath("//input[@id='field1']"));
        field1.clear();
        field1.sendKeys("Hello mr. Marathon");

        WebElement button = driver.findElement(By.xpath("//button[normalize-space()='Copy Text']"));
        Actions act = new Actions(driver); // импортируем класс Actions
        act.doubleClick(button).perform();




    }
}
