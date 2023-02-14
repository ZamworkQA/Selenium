package mypackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertAuthPopup {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

//        driver.get("https://the-internet.herokuapp.com/basic_auth");
        // после входа появляется алерт в котором форма логин, пароль и кнопки вход и отмена
        // после добавления в урл логина и пароля в виде "логин":"пароль"@ссылка (http://login:password@url),
        // будет сразу введены значения логина и пароля и нажата кнопка входа
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");




    }
}
