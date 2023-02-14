package mypackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class ActionVSActions {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.hdfcbank.com/");
        driver.manage().window().maximize();
        WebElement features = driver.findElement(By.xpath("//button[@class='desktop-login position-find btn btn-primary login-btn ng-scope']"));
        Actions act = new Actions(driver);
        act.moveToElement(features).perform();

//        Action action = act.moveToElement(features).build();
//        action.perform();
        // Actions это КЛАСС и он имеет свои методы, а Action это всего лишь интерфейс (создать переменную с действием,
        // но не выполнять его прямо сейчас.
        // Actions уже имеет вид .build().perform() по этому для Actions можно не вызывать метод .build а сразу .perform()
    }
}
