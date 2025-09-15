import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LocatorTest {
    public static void main(String[] args){
        WebDriver driver= new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/login");
        driver.manage().window().maximize();

        //Username locate using different locator
        WebElement usernameBtID= driver.findElement(By.id("username"));
        WebElement usernameByxpath= driver.findElement(By.xpath("//input[@id='username']"));
        WebElement usernameByCSSselector= driver.findElement(By.cssSelector("input#username"));

        //Password
        WebElement passwordByname=driver.findElement(By.name("password"));
        WebElement passworByXpath=driver.findElement(By.xpath("//input(@name='password')"));
        WebElement passwordBycssSector= driver.findElement(By.cssSelector("input#password"));

        //login button
        WebElement loginBy=driver.findElement(By.tagName("button"));
        WebElement loginByxpath=driver.findElement(By.xpath("//button[@type='submit']"));
        WebElement loginBycssselector=driver.findElement(By.cssSelector("button#submit"));

usernameBtID.sendKeys("tomsmith");
passworByXpath.sendKeys("tomsmith");
loginBycssselector.click();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

WebElement flashMessageById = driver.findElement(By.id("flash"));
        System.out.println("Message:"+flashMessageById);

        driver.quit();


    }
}
