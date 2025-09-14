import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
     WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/login");
        driver.manage().window().maximize();
    }
    @Test(priority  =1)
    public void validLogin()
    {
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();

        String successMessage = driver.findElement(By.cssSelector("div.flash.success")).getText();
        System.out.println("Message: " + successMessage);

    }
    @Test(priority = 2)
    public void invalidLogin(){
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.name("password")).sendKeys("SuperSecret!");
        driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();

        String errorMessage = driver.findElement(By.cssSelector("div.flash.error")).getText();
        System.out.println("Message: " + errorMessage);

    }
    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }


}
