import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IframeHandling {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver=new ChromeDriver();
        driver.get("https://demoqa.com/frames");
        driver.manage().window().maximize();
    }
    @Test
    public void testIframe(){

        driver.switchTo().frame("frame1");

        WebElement handle= driver.findElement(By.id("sampleHeading"));
        System.out.println("Frame text="+handle.getText());
        Assert.assertTrue(handle.getText().contains("This is a sample page"));
        driver.switchTo().defaultContent();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
