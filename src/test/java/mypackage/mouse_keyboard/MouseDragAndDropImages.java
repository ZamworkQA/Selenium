package mypackage.mouse_keyboard;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class MouseDragAndDropImages {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.globalsqa.com/demo-site/draganddrop/");

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame lazyloaded']")));
        
        WebElement item1 = driver.findElement(By.xpath("//li[1]")); // первая картинка
        WebElement item2 = driver.findElement(By.xpath("//li[2]"));
        WebElement item3 = driver.findElement(By.xpath("//li[3]"));
        WebElement item4 = driver.findElement(By.xpath("//li[4]"));

        WebElement trash = driver.findElement(By.xpath("//div[@id='trash']"));

        Actions act = new Actions(driver); // импортируем класс Actions
        act.dragAndDrop(item1, trash).perform();
        act.dragAndDrop(item2, trash).perform();
        act.dragAndDrop(item3, trash).perform();
        act.dragAndDrop(item4, trash).perform();




    }
}
