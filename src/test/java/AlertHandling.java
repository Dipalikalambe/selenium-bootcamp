import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertHandling {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Open Alerts page
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        WebElement clkJSAlert=driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
        clkJSAlert.click();
        Alert alert=driver.switchTo().alert();

        alert.accept();
        Thread.sleep(5000);

        WebElement clickJSconfirm= driver.findElement(By.xpath("//button[text()='Click for JS Confirm']"));
        clickJSconfirm.click();
        alert.dismiss();
        Thread.sleep(5000);

        WebElement clickOnJSprompt=driver.findElement(By.xpath("//button[text()='Click for JS Prompt']"));
        clickOnJSprompt.click();
        alert.sendKeys("okay");
        alert.accept();

        Thread.sleep(3000);
        driver.quit();

    }
}
