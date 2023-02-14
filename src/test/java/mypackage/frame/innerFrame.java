package mypackage.frame;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class innerFrame {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.automationtesting.in/Frames.html");

        driver.findElement(By.xpath("//a[normalize-space()='Iframe with in an Iframe']innerFrame")).click();

        WebElement outerframe = driver.findElement(By.xpath("//*[@id='Multiple']/iframe"));
        driver.switchTo().frame(outerframe);

        WebElement innerframe = driver.findElement(By.xpath("/html/body/section/div/div/iframe"));
        driver.switchTo().frame(innerframe);

        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Welcome");

    }
}
