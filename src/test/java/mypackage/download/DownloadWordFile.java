package mypackage.download;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;

public class DownloadWordFile {
    public static void main(String[] args) {

        String location = System.getProperty("user.dir")+"\\Downloads\\"; // переменная содержит путь куда сохр файлы

        HashMap preferences = new HashMap();
        preferences.put("download.default_directory", location);
        ChromeOptions options = new ChromeOptions();
//        EdgeOptions options = new EdgeOptions();
        options.setExperimentalOption("prefs", preferences);


        /*
        создали хэш карту preferences(предпочтения). Хэш карта имеет метод добавления настроек, добавляем каталог
        сохранения файлов по умолчанию, второй параметр это созданная нами переменная с путем до папки Downloads
        внутри проекта
        Дальше создаем ОПЦИИ браузера хром и в них добавляем переменную с папкой сохранения.
        Дальше при создании нового браузера добавляем параметр наших ОПЦИЙ  WebDriver driver = new ChromeDriver(options);
         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(options);

//        WebDriverManager.edgedriver().setup();
//        WebDriver driver = new EdgeDriver(options);

        driver.get("https://file-examples.com/index.php/sample-documents-download/sample-doc-download/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//tbody/tr[1]/td[5]/a[1]")).click();

    }
}
