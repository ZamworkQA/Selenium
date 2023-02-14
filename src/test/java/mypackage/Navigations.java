package mypackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

    /*
    В чем разница между методами get() navigate().to()
    1. get() переходит по ссылке и ждет загрузки страницы
    2. navigate().to() не ждет загрузки страницы, а просто переходит по ссылке, так же он сохраняет историю или
        куку при переходах вперед и назад.
    3. НО НА САМОМ ДЕЛЕ МЕЖДУ НИМИ НЕТ РАЗНЦЫ, они оба вызывают метод get(), но первый принимает в качестве
        параметра только строку (STRING), а метод navigate().to() может и строку и URL
     */

public class Navigations {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.dtf.ru");
//        driver.get("https://www.amazon.com");
        driver.navigate().to("https://www.amazon.com");

        driver.navigate().back(); // вернёмся назад на первую ссылку
        driver.navigate().forward(); // вперед на вторую ссылку
        driver.navigate().refresh(); // обновим страницу

        driver.quit();



    }

}
