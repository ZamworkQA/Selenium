package mypackage.dropdown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;


public class AutosuggestDropDown_GoogleSearch {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
        driver.findElement(By.name("q")).sendKeys("java tutorial");
        Thread.sleep(3000); // если не добавить это ожидание, то в список будет добавлено только 1 значение

        List<WebElement> results = driver.findElements(By.xpath("//li[@class='sbct']//div[@role='option']//div[1]/span"));
        System.out.println("Size of results: " + results.size());
        for(WebElement result:results){
//            if(result.getText().equals("java tutorial oracle")){ // полное совпадение
            if(result.getText().contains("beginners")){ // .contains значит содержит, можно использовать часть текста
                result.click();
                break;
            }
        }


    }
}
