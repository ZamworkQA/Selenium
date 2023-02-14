package mypackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenNewTab {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");

        String tab = Keys.chord(Keys.CONTROL,Keys.RETURN);
        // записываем в строковую переменную сочетание клавиш CTRL+ENTER это сочетание открытия ссылки в новой вкладке

        driver.findElement(By.linkText("Register")).sendKeys(tab);
        /* Тут мы ищем элемент по пояснительному тексту к ссылке. Пример
         <a href="/register?returnUrl=%2F" class="ico-register">Register</a>
         тут мы выбрали By.linkText("Register")
         */



    }
}
