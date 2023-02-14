package mypackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alerts {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

//        driver.findElement(By.xpath("//button[normalize-space()='Click for JS Alert']")).click();
//        Thread.sleep(2000);
//        driver.switchTo().alert().accept(); // закрываем алерт у которого только кнопка ОК

//        driver.findElement(By.xpath("//button[normalize-space()='Click for JS Confirm']")).click();
//        Thread.sleep(2000);
//        driver.switchTo().alert().accept(); // нажимаем на алерте ОК
//        driver.switchTo().alert().dismiss(); // нажимаем на алерте ОТМЕНА

        driver.findElement(By.xpath("//button[normalize-space()='Click for JS Prompt']")).click();
        Thread.sleep(2000);
        Alert alertwindow = driver.switchTo().alert();
        System.out.println("This is text alert: " + alertwindow.getText());
        alertwindow.sendKeys("Welcome");
        alertwindow.accept();
    }
}
