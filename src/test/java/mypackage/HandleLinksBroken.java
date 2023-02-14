package mypackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class HandleLinksBroken {
    public static void main(String[] args) throws MalformedURLException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.deadlinkcity.com/");
        List<WebElement> links = driver.findElements(By.tagName("a"));

        int brokenlinks = 0;

        for(WebElement element:links){
            String url = element.getAttribute("href");
            if(url==null || url.isEmpty()){
                System.out.println("URL is Empty");
                continue;
            }
            URL link = new URL(url);

            try {
                HttpURLConnection httpconn = (HttpURLConnection) link.openConnection();
                httpconn.connect();
                if(httpconn.getResponseCode()>=400){
                    System.out.println(httpconn.getResponseCode() + url + " is" + "  Broken link");
                    brokenlinks++;
                }
                else {
                    System.out.println(httpconn.getResponseCode() + url + " is" + "  Valid link");
                }
            } catch (Exception e) {

            }
        }
        System.out.println("Number of broken links: " + brokenlinks);
        driver.quit();

    }
}
