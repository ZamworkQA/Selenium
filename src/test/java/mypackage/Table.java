package mypackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Table {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");
//        driver.manage().window().maximize();
        int rowsTable = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr/th")).size();
        // извлекаем колво столбцов в таблице
        System.out.println("Total number of rows in a table" + rowsTable);
        int  columnsTable = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr")).size();
        // извлекаем колво строк в таблице
        System.out.println("Total number of columns in a table" + columnsTable);
        String value = driver.findElement(By.xpath("//table[@id='customers']//tr[4]//td[1]")).getText();
        // извлекаем конкретное значение из таблицы
//        System.out.println("This value: " + value);
        /*
        for (int c=2; c<=columnsTable; c++){
            for(int r=1; r<=rowsTable; r++){
                String data = driver.findElement(By.xpath("//table[@id='customers']//tr["+c+"]//td["+r+"]")).getText();
        // параметризация строки //tr["+c+"] , тут мы прямо в строку вставляем переменную
                System.out.print(data+"     ");
            }
            System.out.println();
        }

         */
        for (int c=2; c<=columnsTable; c++){
        //  int c=2 потому что в данном примере на сайте разметка начинается с 2 , в обычном примере тут должно быть с=1
            String company = driver.findElement(By.xpath("//table[@id='customers']//tr["+c+"]//td[1]")).getText();
    //  мы начинаем проверять 1 столбец сверху вниз, если значение будет равно Adobe, то дальше мы начинаем идти
    //  вправо забирая значения из 2 и 3 столбцов для строки Adobe
            if(company.equals("Adobe")){
                String contact = driver.findElement(By.xpath("//table[@id='customers']//tr["+c+"]//td[2]")).getText();
                String country = driver.findElement(By.xpath("//table[@id='customers']//tr["+c+"]//td[3]")).getText();
                System.out.println(company + "   " + contact + "   " + country);

            }
        }

    }
}
