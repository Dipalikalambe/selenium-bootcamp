import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class TestAnotation {
    WebDriver driver;
    @BeforeClass
    public void setup(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println("Browser open");
    }

    @BeforeMethod
    public void bedoreTest(){
        System.out.println("new test start.....");
    }
    @AfterMethod
    public void afterTest(){
        System.out.println("fghj");
    }
    @Test
    public void openBrowser(){
        driver.get("https://www.google.com");
        System.out.println("google open");
    }
    @Test
    public void openBing(){
        driver.get("https://www.bing.com");
        System.out.println("Bing test executed!");
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
