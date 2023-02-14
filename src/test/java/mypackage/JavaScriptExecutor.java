package mypackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class JavaScriptExecutor {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();

//        WebElement logo = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
//        JavaScriptUtil.drawBorder(logo, driver);
        // нашли элемент далее берем класс JavaScriptUtil и вызываем метод обводки элемента

//        TakesScreenshot ts = (TakesScreenshot) driver;
//        File src = ts.getScreenshotAs(OutputType.FILE);
//        File trg = new File(".\\screenshots\\obvodka.png");
//        FileUtils.copyFile(src,trg);

//        String title = JavaScriptUtil.getTitleByJS(driver);
//        System.out.println(title);
        // вызываем метод, который выведет нам название заголовка

//        WebElement registrLink = driver.findElement(By.xpath("//a[normalize-space()='Register']"));
//        JavaScriptUtil.clickElementByJS(registrLink, driver);
        // нашли элемент и применили метод клика по нему. Это если вызов стандартного метода клика не доступен

//        JavaScriptUtil.generateAlert(driver, "Welcome to AFRICA");
        // метод выведет на экран алерт с нашим сообщением
        /*
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

         */
//        JavaScriptUtil.refreshBrowserByJS(driver); // обновление страницы

        /*
        JavaScriptUtil.scrollPageDown(driver); // прокрутка вниз страницы
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        JavaScriptUtil.scrollPageUp(driver); // прокрутка вверх страницы
        */

//        JavaScriptUtil.zoomPageByJS(driver,50);
        // в данном методе я добавил переменную которая принимаем число, это % зума страницы

        WebElement logo = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
        JavaScriptUtil.flash(logo, driver);
    }
}
