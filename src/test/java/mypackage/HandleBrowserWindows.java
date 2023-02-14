package mypackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class HandleBrowserWindows {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        // В наборе SET ДУБЛИКАТЫ ЗАПРЕЩЕНЫ, а в списке LIST МОГУТ БЫТЬ ДУБЛИКАТЫ

//        String windowID = driver.getWindowHandle(); // получаем айди активного окна
//        System.out.println(windowID);
        Thread.sleep(1000); // без этой задержки драйвер не находит ЭЛЕМЕНТ
        driver.findElement(By.xpath("//a[text()='OrangeHRM, Inc']")).click();

        Set<String> windowsID = driver.getWindowHandles();
        // SET это набор строковых переменных, в этот набор войдут ID всех окон в браузере
//        Iterator<String> iter = windowsID.iterator();
//        // Итератор берет строки из набора SET
//        String parentWindowID = iter.next(); // создаем строковую переменную с ID первого (родительского окна)
//        String childWindowID = iter.next();  // создаем переменную с ID второго окна, которое будет (дочерним)

//        System.out.println("Parent window ID: " + parentWindowID);
//        System.out.println("Child window ID: " + childWindowID);
        List<String> windowsIDList = new ArrayList(windowsID); // тут мы ПРЕОБРАЗУЕМ НАБОР SET В СПИСОК LIST
        // В наборе SET ДУБЛИКАТЫ ЗАПРЕЩЕНЫ, а в списке LIST МОГУТ БЫТЬ ДУБЛИКАТЫ
        /*
        String parentWindowID = windowsIDList.get(0); // айди родительского окна
        String childWindowID = windowsIDList.get(1);  // айди дочернего окна
        System.out.println("Parent window ID: " + parentWindowID);
        System.out.println("Child window ID: " + childWindowID);

        driver.switchTo().window(parentWindowID); // выбираем родительское окно
        System.out.println("Parent window Url: " + driver.getCurrentUrl());

        driver.switchTo().window(childWindowID);
        System.out.println("Child window Url: " + driver.getCurrentUrl());


        for(String winID:windowsIDList){
            System.out.println(winID);
            String curl = driver.switchTo().window(winID).getCurrentUrl();
            System.out.println(curl);
        }
        driver.quit();
         */
        for(String winID:windowsIDList) {
            String curl = driver.switchTo().window(winID).getCurrentUrl();
            if(curl.equals("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login")){
        // можно указать несколько вариантов curl.equals("bla") || curl.equals("bla2") || curl.equals("bla3")
                driver.close();
            }

        }
    }

}
