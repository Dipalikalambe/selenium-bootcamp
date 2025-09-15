import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataproviderTest {

    WebDriver driver;

    @DataProvider(name="loginData")
    public Object[][] getData(){
        return new Object[][]{
                {"tomsmith", "SuperSecretPassword!"},   // ✅ valid login
                {"wrongUser", "wrongPass"},             // ❌ invalid login
                {"", ""}
        };
    }

    @Test(dataProvider ="loginData")
    public void loginTest(String username,String password){
        driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/login");
        driver.manage().window().maximize();

        WebElement userField = driver.findElement(By.id("username"));
        WebElement passField = driver.findElement(By.id("password"));

        userField.sendKeys(username);
        passField.sendKeys(password);


        // Click Login button
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        driver.quit();

    }

}
