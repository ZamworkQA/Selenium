package mypackage.dropdown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class DataPicker_DropDownMethod {
    public static void main(String[] args) {
        SetYearMonthDay("1987","Mar","10");
        SetYearMonthDay("1999","Sep","29");


    }
    public static void SetYearMonthDay (String year, String month, String day){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.dummyticket.com/dummy-ticket-for-visa-application/");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//input[@id='dob']")).click();

        Select month_drp = new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-month']")));
        month_drp.selectByVisibleText(month);

        Select year_drp = new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-year']")));
        year_drp.selectByVisibleText(year);

        List<WebElement> alldates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));
        for (WebElement elem:alldates){
            String dt = elem.getText();
            if(dt.equals(day)){
                elem.click();
                break;
            }
        }
        driver.close();
    }
}
