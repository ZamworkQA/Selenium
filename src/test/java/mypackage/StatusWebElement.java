package mypackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StatusWebElement {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup(); // выбираем хром драйвер
        WebDriver driver = new ChromeDriver(); // создаем драйвер, который будет хром драйвером
        driver.get("https://demo.nopcommerce.com/register");

        WebElement searchStore = driver.findElement(By.xpath("//input[@id='small-searchterms']"));
        System.out.println("Display status: " + searchStore.isDisplayed()); // true
        System.out.println("Enabled status: " + searchStore.isEnabled()); // true

        WebElement male = driver.findElement(By.xpath("//input[@id='gender-male']"));
        WebElement female = driver.findElement(By.xpath("//input[@id='gender-female']"));
        System.out.println("Selected status male: " + male.isSelected());
        System.out.println("Selected status female: " + female.isSelected());
        // isSelected() используется для радиобаттомов, чек боксов

        male.click();
        System.out.println("Press radiobuttom male");
        System.out.println("Selected status male: " + male.isSelected());
        System.out.println("Selected status female: " + female.isSelected());

        WebElement checkBox = driver.findElement(By.xpath("//input[@id='Newsletter']"));
        System.out.println("Selected status checkbox: " + checkBox.isSelected());
        driver.quit();
    }
}
