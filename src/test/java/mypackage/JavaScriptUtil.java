package mypackage;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptUtil {

    public static void drawBorder(WebElement element, WebDriver driver){
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].style.border='3px solid red'", element);
    }

    public static String getTitleByJS(WebDriver driver){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String title = js.executeScript("return document.title;").toString();
        return title;
    }

    public static void clickElementByJS(WebElement element, WebDriver driver){
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].click();", element);
    }

    public static void generateAlert(WebDriver driver, String message){
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("alert('" + message + "')");
    }

    public static void refreshBrowserByJS(WebDriver driver){
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("history.go(0)");
    }

    public static void scrollPageDown(WebDriver driver){
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollBy(0, document.body.scrollHeight)");
        // скролл от 0-это начало страницы до document.body.scrollHeight это конец страницы(самый низ)
    }

    public static void scrollPageUp(WebDriver driver){
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollBy(0, -document.body.scrollHeight)");
        // скролл от 0-это начало страницы до -document.body.scrollHeight это начало страницы(самый верх)
    }

    public static void zoomPageByJS(WebDriver driver, int number){
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("document.body.style.zoom='"+number+"%'");
        // js.executeScript("document.body.style.zoom='50%'"); // 50% захардкоржено
        // добавил переменную number, она принимает % зумирования страницы
    }

    public static void flash(WebElement element, WebDriver driver){
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        String bgcolor = element.getCssValue("backgroundColor");
        for (int i = 0; i < 10; i++){
            changeColor("#FF84BF", element, driver); // #000000 - черный цвет. # и 6 знаков это обозначение цвета
            changeColor(bgcolor, element, driver);
    /*
    Тут мы в переменную записываем цвет фона элемента используя метод .getCssValue, дальше мы запускаем цикл, который
    повторится 10 раз. В этом цикле мы будем менять цвет фона элемента со стандартного на выбранный нами(черный)
    Внутри есть еще один метод changeColor который меняет цвет а затем ждет 500мс
     */
        }
    }

    public static void changeColor(String color, WebElement element, WebDriver driver){
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].style.backgroundColor = '" + color + "'", element);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
        }

    }
}
