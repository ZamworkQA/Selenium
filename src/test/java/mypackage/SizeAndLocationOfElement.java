package mypackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class SizeAndLocationOfElement {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://opensource-demo.orangehrmlive.com/");
//        driver.manage().window().maximize();
        WebElement logo = driver.findElement(By.xpath("//img[@alt='company-branding']"));
        // в переменную мы записали вэб элемент изображения
        // 1 Способ расположение элемента
        Thread.sleep(1000);
        System.out.println("Location X and Y : " + logo.getLocation()); // выводим координаты картинки по Х и У
        System.out.println("Location X : " + logo.getLocation().getX()); // выводим только по Х
        System.out.println("Location Y : " + logo.getLocation().getY()); // выводим только по У
        // 2 Способ расположение элемента
        System.out.println("Location X : " + logo.getRect().getX()); // выводим только по Х другим методом
        System.out.println("Location Y : " + logo.getRect().getY()); // выводим только по У другим методом
        // 1 Способ размеры элемента
        System.out.println("Size Width, Height : " + logo.getSize());
        System.out.println("Size Width : " + logo.getSize().getWidth()); // ширина
        System.out.println("Size Height : " + logo.getSize().getHeight()); // высота
        // без добавления задержки в 1 сек высота элемента определяется как НОЛЬ
        // 2 Способ размеры элемента
        System.out.println("Size Width : " + logo.getRect().getDimension().getWidth());
        System.out.println("Size Height : " + logo.getRect().getDimension().getHeight());
    }
}
