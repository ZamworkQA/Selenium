package mypackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LaunchBrowser {
    public static void main(String[] args) {

//        System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver.exe");
//        ChromeDriver driver = new ChromeDriver();
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://dtf.ru");

//        System.setProperty("webdriver.gecko.driver", "C:\\Driver\\geckodriver.exe");
//        ChromeDriver driver = new ChromeDriver();
//        WebDriver driver = new FirefoxDriver();
//        driver.get("https://dtf.ru");
        // Мы скачали с мавен репозитория и добавили в POM WebDriverManager
        // С его помощью нам не надо скачивать вэб драйвер для каждого браузера

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

//        WebDriverManager.firefoxdriver().setup(); // не работает!!!
//        WebDriver driver = new FirefoxDriver();   // не работает!!!

        // ДЛЯ FIREFOX
//        System.setProperty("webdriver.gecko.driver", "C:\\Driver\\geckodriver.exe");
//        WebDriver driver = new FirefoxDriver();

//        WebDriverManager.edgedriver().setup();
//        WebDriver driver = new EdgeDriver();

        driver.get("https://dtf.ru");
        System.out.println("This of the web page is: " + driver.getTitle());
        System.out.println("Current URL the web page is: " + driver.getCurrentUrl());
//        System.out.println(driver.getPageSource()); // Печатает весь HTML страницы
        driver.quit();

    }
}
