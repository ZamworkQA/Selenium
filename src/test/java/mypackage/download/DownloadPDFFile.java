package mypackage.download;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;

public class DownloadPDFFile {
    public static void main(String[] args) {

        String location = System.getProperty("user.dir")+"\\Downloads\\"; // переменная содержит путь куда сохр файлы

        HashMap preferences = new HashMap();
        preferences.put("plugins.always_open_pdf_externally", true);
        // по умолчанию этот параметр false и при скачивании PDF файла он будет открываться для просмотра в нов. вкладке
        preferences.put("download.default_directory", location);
        ChromeOptions options = new ChromeOptions();
//        EdgeOptions options = new EdgeOptions();
        options.setExperimentalOption("prefs", preferences);


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(options);

//        WebDriverManager.edgedriver().setup();
//        WebDriver driver = new EdgeDriver(options);

        driver.get("https://file-examples.com/index.php/sample-documents-download/sample-pdf-download/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//tbody/tr[1]/td[5]/a[1]")).click();

    }
}
