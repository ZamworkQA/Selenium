package mypackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class UploadFile {
    public static void main(String[] args) throws AWTException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.foundit.in/");
//        driver.manage().window().maximize();

        driver.findElement(By.xpath("//div[@class='heroSection-buttonContainer_secondaryBtn__text']")).click();
//        driver.findElement(By.xpath("//input[@id='file-upload']")).sendKeys("C:\\Users\\Work\\IdeaProjects\\Selenium\\Downloads\\test.pdf");
        /*
        Мы нашли форму для загрузки файлов на сайт. После ее открытия появляется окно в которое можно перетащить файл либо
        нажать выбрать, тогда откроется окно проводника. В HTML разметке эта форма имеет тег INPUT и TYPE='FILE'
        ВАЖНО ЧТОБЫ БЫЛ ИМЕННО ТИП='ФАЙЛ', тогда можно добавлять файл через .sendKeys
        Если тип не ФАЙЛ тогда нужно использовать методы класса РОБОТ
         */
        // Используем метод класса РОБОТ
        WebElement button = driver.findElement(By.xpath("//input[@id='file-upload']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", button); // клик по кнопке с помощью JavaScript
        //создали новый экземпляр класса робот
        Robot bot = new Robot();
        bot.delay(2000);
        // Помещаем путь в буфер обмена CTRL+C
        StringSelection ss = new StringSelection("C:\\Users\\Work\\IdeaProjects\\Selenium\\Downloads\\test.pdf");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
        // Вставляем из буфера обмена
        bot.keyPress(KeyEvent.VK_CONTROL); // зажимаем кнопку CTRL
        bot.keyPress(KeyEvent.VK_V); // зажимаем кнопку V
        bot.delay(2000);

        bot.keyRelease(KeyEvent.VK_CONTROL); // отпускаем CTRL
        bot.keyRelease(KeyEvent.VK_V); // отпускаем V
        bot.delay(2000);

        bot.keyPress(KeyEvent.VK_ENTER); // нажимаем ENTER
        bot.keyRelease(KeyEvent.VK_ENTER); //  отпускаем ENTER

    }
}
