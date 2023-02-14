package mypackage.download;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;


public class DownloadPDFFileFireFox {
    public static void main(String[] args) {
        String location = System.getProperty("user.dir")+"\\Downloads\\"; // переменная содержит путь куда сохр файлы

        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("pdfjs.disabled", true); //по умолчанию false
        profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/pdf");
        profile.setPreference("browser.download.folderList", 2); // тут 0-Рабочий стол; 1-Загрузки по умолчанию
        // 2-это место куда мы хотим сохранить файл, но следующей строкой мы указываем это место. У нас это location
        profile.setPreference("browser.download.dir", location);

        FirefoxOptions options = new FirefoxOptions();
        options.setProfile(profile);

        System.setProperty("webdriver.gecko.driver", "C:\\Driver\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver(options);
        driver.get("https://file-examples.com/index.php/sample-documents-download/sample-pdf-download/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//tbody/tr[1]/td[5]/a[1]")).click();

    }
}
