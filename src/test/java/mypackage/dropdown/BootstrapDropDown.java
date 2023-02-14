package mypackage.dropdown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class BootstrapDropDown {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://hdfcbank.com");
//        driver.manage().window().maximize(); // развернуть окно на весь экран

        driver.findElement(By.xpath("//div[@class='drp1']//div[@class='dropdown']")).click();
        List<WebElement> productTypes = driver.findElements(By.xpath("//ul[@class='dropdown1 dropdown-menu']/li"));
//        System.out.println("Number of options: " + productTypes.size());

        try {
            Thread.sleep(1000);
        } catch(InterruptedException ex) {}

        for(WebElement ptype:productTypes) {
            if(ptype.getText().equals("Invest")) {
                ptype.click();
                break;
            }

        }

        try {
            Thread.sleep(1000);
        } catch(InterruptedException ex) {}

        driver.findElement(By.xpath("//div[@class='drp2']//div[@class='dropdown']")).click();

        List<WebElement> products = driver.findElements(By.xpath("//ul[@class='dropdown2 dropdown-menu']/li"));
        for(WebElement product:products){
            if(product.getText().equals("Demat Account")){
                product.click();
                break;
            }
        }
    }
}
