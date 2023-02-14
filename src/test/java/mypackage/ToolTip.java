package mypackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToolTip {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://jqueryui.com/tooltip/");
        driver.switchTo().frame(0);
        WebElement inputbox = driver.findElement(By.xpath("//input[@id='age']"));
        String tooltipText = inputbox.getAttribute("title");
        System.out.println(tooltipText);
        // тут мы захватили в переменную всплывающую подсказку которая появляется при наведении на строку ввода

    }
}
