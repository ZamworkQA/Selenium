package mypackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class HandleCheckBox {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://itera-qa.azurewebsites.net/home/automation");

//        driver.findElement(By.xpath("//input[@id='monday']")).click();
        List<WebElement> checkBoxes = driver.findElements(By.xpath("//input[@type='checkbox' and contains(@id,'day')]"));
        System.out.println("Total checkBoxes: " + checkBoxes.size());
//        for(int i=0;i<checkBoxes.size();i++){
//            checkBoxes.get(i).click();
//        }
        // ниже те же самые действия , но описаны более простым циклом
//        for(WebElement chkBox:checkBoxes){
//           chkBox.click();
//        }

//       for(WebElement chkBox:checkBoxes){
//            String chkBoxName = chkBox.getAttribute("id");
//            // id атрибуты равны дням недели в нижнем регистре далее мы добавляем условие равны, и отмечаем чекбоксы
//            if(chkBoxName.equals("monday") || chkBoxName.equals("wednesday") || chkBoxName.equals("friday")){
//                chkBox.click();
//            }
//        }
        int totalchkBoxes = checkBoxes.size();
        // в условии цикла - начальное значение это int i = totalchkBoxes-3(мы хотим отметить 3 последних чекбокса)
        // далее i<totalchkBoxes, тут 3<6(наш список начинается с 0, а всего элементов 7, по этому последний эот 6)
        // ну и в конце каждого цикла мы увеличиваем i на 1
//        for (int i = totalchkBoxes-3;i<totalchkBoxes;i++) {
//            checkBoxes.get(i).click();
//        }
        // тут мы выбираем первые 3 чекбокса, добавим IF с условием что i < 3 , если i равен/больше то цикл офф
        for (int i=0;i<totalchkBoxes;i++){
            if(i<3){
                checkBoxes.get(i).click();
            }
        }
    }
}
