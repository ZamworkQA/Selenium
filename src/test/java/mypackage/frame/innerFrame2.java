package mypackage.frame;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class innerFrame2 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_iframe_height_width");
        driver.manage().window().maximize();

        driver.switchTo().frame("iframeResult");
        driver.switchTo().frame(0);
        System.out.println("Text inside the inner frame: " + driver.findElement(By.xpath("//h1")).getText());

        driver.switchTo().parentFrame(); // переключение на родительский фрейм
        String text = driver.findElement(By.xpath("//p[contains(text(),'You can use the height and width attributes to spe')]")).getText();
        System.out.println("Text the parent frame: " + text);

    }
}
