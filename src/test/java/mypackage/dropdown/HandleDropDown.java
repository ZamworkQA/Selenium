package mypackage.dropdown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HandleDropDown {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.opencart.com/index.php?route=account/register");

        WebElement drpCountryElem = driver.findElement(By.id("input-country"));
        // ищем элемент выпадающего списка и записываем его в переменную вэб элемента
        Select drpCountry = new Select(drpCountryElem);
        // Импортируем класс Select и создаем новый класс Select со значением найденного выпадающего списка
//        drpCountry.selectByVisibleText("India");
        // 1. выбираем значение по "видимому тексту" т.е. как и метод getText() выбираем внутренний текст
//        drpCountry.selectByValue("13");
        // 2. выбираем значение по атрибуту Value(если он есть)
//        drpCountry.selectByIndex(13);
        // 3. выбираем по индексу. Он не отображается в HTML и начинается с 0 по этому в данном методе мы не знаем
        //  точно какой элемент выберем и просто указываем каким по счету он идет, начиная с 0(нуля)
        // ОБЫЧНО НУЛЕВОЙ ЭЛЕМЕНТ В ВЫПАДАЮЩЕМ СПИСКЕ ПУСТОЙ, ПО ЭТОМУ В НАШЕМ СЛУЧАЕМ ИНДЕКС И VALUE РАВНЫ,
        // НО МОЖЕТ БЫТЬ ЧТО ИНДЕКС НА 1 МЕНЬШЕ ЧЕМ ЗНАЧЕНИЕ VALUE

        // Как еще можно выбрать элем из вып.списка не используя стандартные методы

        List<WebElement> alloptins = drpCountry.getOptions();
        // Для элемента выпадающий список применяем метод .getOptions() , который запишет каждую опцию как
        // отдельный вэб элемент в общий список(list). Дальше мы уже будем работать с этим списком элементов
        for (WebElement option: alloptins){
            if(option.getText().equals("Cuba")){
                option.click();
                break;
            }
        }

    }
}
