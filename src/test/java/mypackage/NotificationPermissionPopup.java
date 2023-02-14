package mypackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class NotificationPermissionPopup {
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions(); // создаем новую переменную опций браузера ХРОМ
        options.addArguments("--disable-notifications"); // в эти опции передаем аргумент, что выключить уведомления

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(options); // добавляем опции к создаваемому драйверу браузера ХРОМА
        driver.get("https://www.redbus.in/");
        driver.navigate().refresh(); // без обновления страницы попап с разрешением показа уведомлений не появляется
    }
}
