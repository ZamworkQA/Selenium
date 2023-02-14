package mypackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class DataPicker {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.redbus.in/");
        driver.manage().window().maximize();

        String year = "2024";
        String month = "October";
        String day = "24";

        driver.findElement(By.xpath("//input[@id='onward_cal']")).click();
        // элемент с выбором даты

        while (true){
            String month_year = driver.findElement(By.xpath("//td[@class='monthTitle']")).getText();
            // элемент с месяцем и годом (Feb 2023)
            String arr[] = month_year.split(" ");
            // создаем массив строк из строки с годом и месяцем, разделителем на элементы будет ПРОБЕЛ
            String mon = arr[0]; // переменная месяц первый элемент из массива
            String yr = arr[1];  // переменная год второй элемент из массива
//            System.out.println(mon + "  " + yr);
//            System.out.println(month.substring(0,3));

            if (mon.equalsIgnoreCase(month.substring(0,3)) && yr.equals(year))
            // если месяц эквивалентен с игнорированием регистра значению первых 3 символов месяца и так же
            // год равен году, то останови цикл, если нет то нажми элемент прокрутки дальше
                break;
            else
                driver.findElement(By.xpath("//button[normalize-space()='>']")).click();
        }
        List<WebElement> alldates =  driver.findElements(By.xpath("//table[@class='rb-monthTable first last']//td"));
        // в переменную сохраняем все элементы дат из открытого календаря

        for (WebElement elem : alldates){ // дальше берем текст из каждого элемента и проверяем его с днём в начале
            String dt = elem.getText();
            if (dt.equals(day)){ // если они совпадают кликаем по этой дате и останавливаем цикл
                elem.click();
                break;
            }

        }


    }
}
