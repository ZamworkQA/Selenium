package mypackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class HandleLinks{
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.wildberries.ru/");
        driver.manage().window().maximize();
        driver.findElement(By.className("nav-element__burger-line")).click();
        Thread.sleep(1000);
//        driver.findElement(By.linkText("Электроника")).click();
//        driver.findElement(By.partialLinkText("ктроника")).click();
        // методы By.linkText и By.partialLinkText находят локаторы по тексту внутри тега
        // <а href='***' class='***'> !тут будет располагаться текст по которому мы ищем!  </a>

        List<WebElement> links = driver.findElements(By.tagName("a"));
//        for(int i=0;i< links.size();i++){
//            System.out.println(links.get(i).getText());
//            System.out.println(links.get(i).getAttribute("href"));
//
//        }
        for(WebElement link:links){
            System.out.println(link.getText());
            System.out.println(link.getAttribute("href"));
        }
    }

}
