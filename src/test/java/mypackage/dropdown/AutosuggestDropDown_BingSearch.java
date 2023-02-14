package mypackage.dropdown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;


public class AutosuggestDropDown_BingSearch {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.bing.com/");
        driver.manage().window().maximize();
        driver.findElement(By.id("sb_form_q")).sendKeys("selenium");

        List<WebElement> results = driver.findElements(By.xpath("//li[@class='sa_sg']//span"));
        System.out.println("Size of results: " + results.size());
        for(WebElement result:results){
//            if(result.getText().equals("selenium grid")){ // полное совпадение
            if(result.getText().contains("grid")){ // .contains значит содержит, можно использовать часть текста
                result.click();
                break;
            }
        }


    }
}
