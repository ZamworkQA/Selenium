package mypackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class ScreenShots {
    public static void main(String[] args) throws IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();
/*
        TakesScreenshot screen  = (TakesScreenshot)driver;
        File src =  screen.getScreenshotAs(OutputType.FILE);
        File placeFile = new File(".\\screenshots\\TestScreenShot.png");
        FileUtils.copyFile(src,placeFile);
        // снимок всей страницы
 */
/*
        WebElement section = driver.findElement(By.xpath("//div[@class='product-grid home-page-product-grid']"));
        File src =  section.getScreenshotAs(OutputType.FILE);
        File placeFile = new File(".\\screenshots\\TestScreenShotSection.png");
        FileUtils.copyFile(src,placeFile);
        // снимок отдельного блока, который мы нашли ранее
*/
        WebElement elem = driver.findElement(By.xpath("//img[@class='nivo-main-image']"));
        File src =  elem.getScreenshotAs(OutputType.FILE);
        File placeFile = new File(".\\screenshots\\TestScreenShotElement.png");
        FileUtils.copyFile(src,placeFile);
        // снимок отдельного элемента
        driver.close();

    }
}
