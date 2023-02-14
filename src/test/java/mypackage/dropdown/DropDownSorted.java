package mypackage.dropdown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DropDownSorted {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://twoplugs.com/");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//a[text()='Live Posting']")).click();
        WebElement drpElement = driver.findElement(By.name("category_id"));
        // мы находим xpath не просто элемента, а именно <select name="categoty_id" /select> потому что дальше
        // мы создадим новую переменную именно СЕЛЕКТА в которой будут все категории из этого выпад.списка
        // чтобы потом мы применили метод .getOptins() и взяли все опции из этого выпад списка
        Select drpselect = new Select(drpElement);
        List<WebElement> options = drpselect.getOptions();
        // создаем список в который мы запишем все опции из выпадающего списка

        ArrayList originallist = new ArrayList(); // создадим массив оригинального списка
        ArrayList templist = new ArrayList(); // создадим массив временного списка

        for (WebElement option:options){
            originallist.add(option.getText());
            templist.add(option.getText());
        }

        System.out.println("Original list: " + originallist);
        System.out.println("Temp list: " + templist);
        Collections.sort(templist);
        // класс коллекции имеет собственный метод сортировки, на вход который принимает массив
        System.out.println("Original list: " + originallist);
        System.out.println("Temp list after sorting: " + templist);

        if (originallist.equals(templist)){
            System.out.println("DropDown Sorted...");
        } else{
            System.out.println("DropDown Unsorted...");
        }
        driver.close();


    }
}
