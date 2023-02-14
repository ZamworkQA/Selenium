package mypackage.dropdown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutocompliteGooglePlacesDropDown {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.twoplugs.com");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//a[text()='Live Posting']")).click();
        WebElement searchBox = driver.findElement(By.id("autocomplete"));
        searchBox.clear();
        Thread.sleep(3000);
        searchBox.sendKeys("Toronto");

        String text;

        do{
            searchBox.sendKeys(Keys.ARROW_DOWN);
            text = searchBox.getAttribute("value");
            if(text.equals("Toronto, Огайо, США")){
                searchBox.sendKeys(Keys.ENTER);
                break;
            }
            Thread.sleep(3000);

        }while (!text.isEmpty());
    }
}
