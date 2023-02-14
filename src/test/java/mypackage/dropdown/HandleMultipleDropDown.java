package mypackage.dropdown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HandleMultipleDropDown {
    static WebDriver driver;
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("https://demoqa.com/select-menu");
/*
        Select firstdrp = new Select(driver.findElement(By.xpath("//select[@id='oldSelectMenu']")));
        firstdrp.selectByVisibleText("Black");
        Select seconddrp = new Select(driver.findElement(By.id("cars")));
        seconddrp.selectByVisibleText("Opel");

 */
        WebElement oldStyle = driver.findElement(By.xpath("//select[@id='oldSelectMenu']"));
        selectOptionFromDropDown(oldStyle, "Black");

        WebElement cars = driver.findElement(By.id("cars"));
        selectOptionFromDropDown(cars, "Opel");
    }
    public static void selectOptionFromDropDown(WebElement elem, String value){
        Select drp = new Select(elem);
        List<WebElement>allooptions = drp.getOptions();
        for(WebElement option : allooptions){
            if(option.getText().equals(value)){
                option.click();
                break;
            }
        }
    }

}
