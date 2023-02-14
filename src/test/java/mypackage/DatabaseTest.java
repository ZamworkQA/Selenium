package mypackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Random;

public class DatabaseTest {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.opencart.com/index.php?route=common/home&language=en-gb");
        driver.manage().window().maximize();

        Random rand = new Random();
        int num = rand.nextInt(10000) + 1;

        String cust_firstname = "anonim"+num+"name";
        String cust_lastname = "demo"+num+"name";
        String cust_email = "demoty"+num+"@mail.com";
        String cust_password = "Passw0rd";

        driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
        driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();

        driver.findElement(By.name("firstname")).sendKeys(cust_firstname);
        driver.findElement(By.name("lastname")).sendKeys(cust_lastname);
        driver.findElement(By.name("email")).sendKeys(cust_email);
        driver.findElement(By.name("password")).sendKeys(cust_password);
        driver.findElement(By.name("agree")).click();


        driver.findElement(By.xpath("//button[normalize-space()='Continue']")).click();
        try {

            String confmsg = driver.findElement(By.xpath("//h1[text()='Your Account Has Been Created!']")).getText();
            if (confmsg.equals("Your Account Has Been Created!")) {
                System.out.println("Register successful ");
            } else {
                System.out.println("Register FAIL");
            }

        }catch (Exception e){
            System.out.println("Some problem in the application");
        }

    }
}
