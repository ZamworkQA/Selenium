package mypackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenURLinTab2 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");
//        driver.switchTo().newWindow(WindowType.TAB); // эта команда откроет другую ссылку в новой ВКДАЛКЕ
        driver.switchTo().newWindow(WindowType.WINDOW); // откроет другую ссылку в новом ОКНЕ БРАУЗЕРА
        driver.get("https://www.opencart.com/");
    }
}
