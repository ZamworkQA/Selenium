package mypackage.dropdown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class HandleDropDownJQuery {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
        driver.manage().window().maximize();

        driver.findElement(By.id("justAnInputBox")).click();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        selectChoiceValues(driver, "choice 1");
//        selectChoiceValues(driver, "choice 2", "choice 2 3", "choice 6", "choice 6 2 1", "choice 6 2");
        selectChoiceValues(driver, "all");

    }
    public static void selectChoiceValues(WebDriver driver, String... value){
    // Значение вида (String... value) означает что мы можем добавлять несколько параметров, а не только один
        List<WebElement> choiceList = driver.findElements(By.xpath("//span[@class='comboTreeItemTitle']"));

        if(!value[0].equalsIgnoreCase("all")){
            for(WebElement item : choiceList){
                String text = item.getText();
                for(String val : value){
                    if(text.equals(val)){
                        item.click();
                        break;
                    }
                }
            }
        }
        else{
            try{
                for(WebElement item : choiceList){
                    item.click();
                }
            } catch (Exception e){

            }

        }
    }
}
/*
Мы создали метод, который на вход принимает первым значением драйвер, а вторым названия тех пунктов в выпадающем
списке, которые мы хотим отметить. Значений может быть больше чем одно. Так же если мы введем "all" то будут
выбраны все пункты. В список мы записали вообще все элементы из всех трех выпадающих списков (45 элементов).
При выборе "all" будут отмечены все элементы из открытого списка, а все остальные элементы будут записаны в
эксепшен (Exception e), но мы его обрабатываем в блоке TRY, по этому скрипт будет закончен без ошибки.

По поводу цикла:
* */
