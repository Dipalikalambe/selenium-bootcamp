import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;


public class WaitsTest {
    WebDriver driver;
@BeforeMethod
     public void setUp(){
         driver=new ChromeDriver();
         driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
         driver.manage().window().maximize();
    }


    @Test
    public void explicitWaitEx(){
        driver.findElement(By.cssSelector("#start button")).click();

        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement message=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("finish")));

        System.out.println("Message: " + message.getText());

    }
    @Test
    public void fluentWaitExample() {
        driver.findElement(By.cssSelector("#start button")).click();

        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);

        WebElement message = wait.until(driver -> driver.findElement(By.id("finish")));
        System.out.println("Message (Fluent Wait): " + message.getText());
    }

    @AfterMethod
    public void tearDown(){
         driver.quit();
    }
}
