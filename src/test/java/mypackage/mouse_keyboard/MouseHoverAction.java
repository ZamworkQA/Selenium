package mypackage.mouse_keyboard;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHoverAction {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.opencart.com/");

        WebElement desktopMenu = driver.findElement(By.xpath("//a[normalize-space()='Desktops']"));
        WebElement macMenuItem = driver.findElement(By.xpath("//a[normalize-space()='Mac (1)']"));

        Actions act = new Actions(driver); // импортируем класс Actions
        act.moveToElement(desktopMenu).moveToElement(macMenuItem).click().perform();




    }
}
