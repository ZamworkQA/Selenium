package mypackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class exemple {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.zkoss.org/zkdemo/getting_started/selection_dropdown");

        WebElement drp = driver.findElement(By.className("z-selectbox"));
        // находим вэб элемент по classname
        String iddrp = (drp.getAttribute("id").substring(0,4)) + "v";
        // У найденного элемента берем значение атрибута id, это значение 5 знаков, далее мы берем первые 4 знака
        // и в конце добавляем к этому значению символ (Потому что айди мало того что динамический так еще и
        // последний пятый знак нужно менять на статический знак)
//        System.out.println(iddrp);
        WebElement drpDown = driver.findElement(By.id(iddrp));
        // полученный ид является строкой, тут мы ищем вэб элемент на таким ид
        Select drpCountry = new Select(drpDown);
        // найденный элемент имеет в консоле тэг <select></select> по этому мы создаем новый элемент SELECT
        // SELECT элементы имеют свои методы и ниже мы используем метод выбора видимого текста
        drpCountry.selectByVisibleText("Sport");
        // если у элемента нет тэга SELECT, то эти методы использовать НЕЛЬЗЯ

        String idcheck = (drp.getAttribute("id").substring(0,4)) + "g1-cave";
        WebElement name = driver.findElement(By.id(idcheck));
        name.click();

        String idcheck2 = (drp.getAttribute("id").substring(0,4)) + "61-cave";
        WebElement name2 = driver.findElement(By.id(idcheck2));
        name2.click();

        String countryid = (drp.getAttribute("id").substring(0,4)) + "y-icon";
        WebElement countrypress = driver.findElement(By.id(countryid));
        countrypress.click();


    }
}
