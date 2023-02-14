package mypackage.mouse_keyboard;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyboardActionMultipleKeys {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://text-compare.com/");

        WebElement input1 = driver.findElement(By.xpath("//textarea[@id='inputText1']"));
        WebElement input2 = driver.findElement(By.xpath("//textarea[@id='inputText2']"));
        input1.sendKeys("Welcome to Africa");

        Actions act = new Actions(driver);

        // CTRL+A
        act.keyDown(Keys.CONTROL);
        act.sendKeys("a");
        act.keyUp(Keys.CONTROL);
        act.perform();
        // .keyDown означает что нажать и не отпускать клавишу на клавиатуре CTRL+A затем отпускаем .keyUp(Keys.CONTROL)
        // и далее вызываем метод .perform();

        // CTRL+C
        act.keyDown(Keys.CONTROL);
        act.sendKeys("c");
        act.keyUp(Keys.CONTROL);
        act.perform();

        act.sendKeys(Keys.TAB).perform();

        // CTRL+V
        act.keyDown(Keys.CONTROL);
        act.sendKeys("v");
        act.keyUp(Keys.CONTROL);
        act.perform();

    }
}
