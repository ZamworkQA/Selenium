package mypackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class ElementVsElements {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");
        // 1. Находим один элемент и вводим текст
//        WebElement searchbox = driver.findElement(By.xpath("//input[@id='small-searchterms']"));
//        searchbox.sendKeys("XYZ");
        // 2. Находим первый элемент(по данному xpath существует 22 элемента)
//        WebElement elem = driver.findElement(By.xpath("//div[@class='footer-upper']//a"));
//        System.out.println(elem.getText());
        // 3. Пытаемся найти элемент которого не существует (кнопка Login) БУДЕТ ОШИБКА(ИСКЛЮЧЕНИЕ)
//        WebElement searchButton = driver.findElement(By.xpath("//button[normalize-space()='login']"));
        // Выдаст ошибку, не нашлось такого элемента
        // 4. Используем .findElements()
//        List<WebElement>links = driver.findElements(By.xpath("//div[@class='footer-upper']//a"));
//        System.out.println("Мы нашли " + links.size() + " элемента");
        // 5. Используем .findElements() , но по итогу будет только 1 элемент
//        List<WebElement>links1 = driver.findElements(By.xpath("//div[@class='footer-upper']"));
//        System.out.println("Мы нашли " + links1.size() + " элемента");
        // 6. Создадим цикл который будет производить действия с каждым элементом списка
        List<WebElement>links = driver.findElements(By.xpath("//div[@class='footer-upper']//a"));
        Integer iteration = 1;
        for (WebElement ellement:links)
        {
            System.out.println(iteration + "." + ellement.getText());
            iteration ++;
        }
        // 7. Используем .findElements() для поиска несуществующего элемента
        List<WebElement> img = driver.findElements(By.xpath("//button[normalize-space()='login']"));
        System.out.println("Мы нашли элементов: " + img.size());
        driver.quit();
    }
}
