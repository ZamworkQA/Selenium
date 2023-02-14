package mypackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class Cookies {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");
        Set<Cookie> cookies = driver.manage().getCookies(); // получаем куки и записываем их в переменную(это набор SET)
        System.out.println("Size of Cookies: " + cookies.size());
        for(Cookie cookie : cookies){
            System.out.println(cookie.getName() + " : " + cookie.getValue());
        }
        // добавляем собственное куки
        /*
        Cookie cookieobj = new Cookie("MyCookie123", "Welcome");
        driver.manage().addCookie(cookieobj);
        cookies=driver.manage().getCookies();
        System.out.println("Size of Cookies after adding: " + cookies.size());
        for(Cookie cookie : cookies){
            System.out.println(cookie.getName() + " : " + cookie.getValue());
        }
         */
//        driver.manage().deleteCookie(cookieobj); // удаляем куки
        /*
        System.out.println("Cookie after Delete");
        driver.manage().deleteCookieNamed(".Nop.Customer");
        cookies=driver.manage().getCookies();
        for(Cookie cookie : cookies){
            System.out.println(cookie.getName() + " : " + cookie.getValue());
        }
         */
        driver.manage().deleteAllCookies();
        cookies=driver.manage().getCookies();
        System.out.println("Size of Cookies after All Delete: " + cookies.size());
        driver.quit();


    }
}
