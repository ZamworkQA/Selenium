package mypackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class getTextVsgetAttributeValue {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://admin-demo.nopcommerce.com/login");
        WebElement emailinputbox = driver.findElement(By.id("Email"));
        WebElement gettext = driver.findElement(By.xpath("//button[normalize-space()='Log in']"));
//        emailinputbox.clear();
//        emailinputbox.sendKeys("admin123@gmail.com");
        System.out.println("This result getAttribute() method " + emailinputbox.getAttribute("value"));
        System.out.println("This result getText() method " + emailinputbox.getText());
        System.out.println("This result getText() method " + gettext.getText());
        // getAttribute("") принимает значение любого атрибута и выводит его
        // getText() выводит внутренний текст который обычно заключен в >text< и не принадлежит никакому атрибуту
        String title = driver.findElement(By.xpath("//div[@class='page-title']//h1")).getText();
        System.out.println(title);
        driver.quit();
    }
}
