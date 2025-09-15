import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MouseHoverAction {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/hovers");
        driver.manage().window().maximize();

        // Actions class
        Actions action = new Actions(driver);

        // Locate first user avatar
        WebElement user1 = driver.findElement(By.xpath("(//img[@src='/img/avatar-blank.jpg'])[1]"));

        // Hover over the element
        action.moveToElement(user1).perform();

        // Wait until "View profile" link is visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement viewProfile = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[text()='View profile'])[1]"))
        );

        // Click o
        viewProfile.click();

        WebElement user2=driver.findElement(By.xpath("(//img[@src='/img/avatar-blank.jpg'])[2]"));
        action.moveToElement(user2).perform();

        WebDriverWait wait1=new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement viewProfile2=wait1.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[text()='View profile'])[2]")));

    viewProfile2.click();
        // Close browser
        driver.quit();
    }
}
