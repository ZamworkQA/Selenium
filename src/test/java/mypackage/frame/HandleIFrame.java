package mypackage.frame;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleIFrame {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.selenium.dev/selenium/docs/api/java/index.html?overview-summary.html");
        driver.manage().window().maximize();

        // этот элемент находится внутри фрейма, по этому мы его не сможем найти на странице

        driver.switchTo().frame("packageListFrame");
        // переключаемся на нужный блок(ФРЕЙМ)
        driver.findElement(By.xpath("//a[normalize-space()='org.openqa.selenium']")).click();
        // этот элемент находится внутри фрейма, по этому мы его не сможем найти на странице пока не войдем во фрейм
        driver.switchTo().defaultContent();
        // после действий внутри нужного фрейма надо переключиться на основную страницу, т.к. перейти сразу из фрейма1
        // во фрейм2 мы не можем, выполняем .switchTo().defaultContent(); и потом переключаемся на фрейм2

        Thread.sleep(3000);

        driver.switchTo().frame("packageFrame");
        driver.findElement(By.xpath("//span[normalize-space()='WebDriver']")).click();
        driver.switchTo().defaultContent();

        Thread.sleep(3000);

        driver.switchTo().frame("classFrame");
        driver.findElement(By.xpath("//div[@class='topNav']//a[normalize-space()='Help']")).click();

    }

}
