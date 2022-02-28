import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Selenium {


    private static WebDriver driver;

    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver-98.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://18.156.17.83:9095/");
    }

    public static void quit() {
        driver.quit();
    }

    public static void logIn() {
        WebElement logInBtn = driver.findElement(By.xpath("//*[@id=\"login\"]/span[2]"));
        logInBtn.click();

        WebElement userNameTxt = driver.findElement(By.xpath("//*[@id=\"username\"]"));
        userNameTxt.sendKeys("petrovskidr@gmail.com");

        WebElement passwordTxt = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        passwordTxt.sendKeys("Тестp@ssword1%A");

        WebElement logMeInBtn = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/form/button"));
        logMeInBtn.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static String invalidLogIn() {
        WebElement logInBtn = driver.findElement(By.xpath("//*[@id=\"login\"]/span[2]"));
        logInBtn.click();

        WebElement logMeInBtn = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/form/button"));
        logMeInBtn.click();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[1]/div")).getText();
    }
}
