package mypackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DynamicWebTable {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get("https://demo.opencart.com/admin/index.php");
        WebElement username = driver.findElement(By.id("input-username"));
//        username.clear();
        username.sendKeys("demo");
        WebElement password = driver.findElement(By.id("input-password"));
//        password.clear();
        password.sendKeys("demo");

        driver.findElement(By.xpath("//button[text()=' Login']")).click();
        driver.findElement(By.className("btn-close")).click();
        driver.findElement(By.xpath("//a[text()=' Sales']")).click();
        driver.findElement(By.xpath("//a[text()='Orders']")).click();

        String textpages = driver.findElement(By.xpath("//div[@class='col-sm-6 text-end']")).getText();
        System.out.println(textpages); // тут будет -Showing 1 to 10 of 83 (9 Pages)-
        // Далее нам нужно взять только общее колво страниц, это делаем с помощью индексов
//        textpages.indexOf("("); // начальный индекс
//        textpages.indexOf("Pages"); // конечный индекс
        int totalPages = Integer.valueOf(textpages.substring(textpages.indexOf("(")+1, textpages.indexOf("Pages")-1));
        /*
        1. textpages получает значение -Showing 1 to 10 of 83 (9 Pages)-
        2. textpages.indexOf("(")+1 тут мы получаем индекс открытой скобки "(" и добавляем 1 чтобы получить
           начальный индекс нужного нам первого(если число не однозначное) числа колва страниц
        3. textpages.indexOf("Pages")-1 тут мы получаем последний индекс, так как оригинал ....(N Pages) нам нужно
            вычеркнуть пробел, который есть между числом и словом " Pages"
        4. Метод textpages.substring(начальный индекс, конечный индекс) возьмет часть текста, от начального индекса
            до конечного индекса. В итоге это будет общее колво страниц(не важно сколько их 9, 14, 175)
        5. Метод Integer.valueOf преобразует результат в число (Integer), т.к. значение получается STRING
        6. int totalPages = Этим действием мы записываем полученное значение в переменную
        7. По итогу мы получаем общее колво страниц, в виде ЧИСЛА, а не строки
         */
        System.out.println(totalPages);

        for (int p=1;p<=totalPages;p++){
            WebElement active_page = driver.findElement(By.xpath("//ul[@class='pagination']//li//span"));
            System.out.println("Active Page: " + active_page.getText());
            active_page.click();

            int rows = driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']//tbody/tr")).size();
            System.out.println("Number of rows: " + rows);
                for (int r=1;r<=rows;r++){
                    String orderID = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+r+"]//td[2]")).getText();
                    String customerName = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+r+"]//td[3]")).getText();
                    String status = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+r+"]//td[4]")).getText();
                    System.out.println(orderID + "   " + customerName + "   " + status);
        /*
        В этом цикле мы переходим на активную страницу, (первая страница активна изначально) и считываем 3 выбранных
        колонки для каждой строки на странице, ниже мы переключаемся на следующую страницу, так же добавлен IF если
        следующая страница больше общего колва страниц то цикл завершиться
         */
                }

            String pageno = Integer.toString(p+1);
            // ниже цикл которого нет в видео, без него после перехода на последнюю страницу скрипт падает потому что
            // не может найти "последняя страница" + 1. Тут я добавил этот вариант и БРЭЙК при его срабатывании
                if (totalPages < p+1){
                    break;
                }else {
                    driver.findElement(By.xpath("//ul[@class='pagination']//li//a[text()='"+pageno+"']")).click();
                }
            Thread.sleep(100);// без задержки не срабатывает
        }
    }
}
