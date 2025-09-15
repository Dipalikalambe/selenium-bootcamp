import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class MouseOverSelect {

    WebDriver driver;
    Actions actions;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/hovers");
        actions = new Actions(driver);
    }

    @Test
    public void testHoverProfiles() {
        // Locate all user blocks
        List<WebElement> users = driver.findElements(By.xpath("//div[@class='figure']"));

        for (int i = 0; i < users.size(); i++) {
            WebElement user = users.get(i);

            // Hover on each avatar
            actions.moveToElement(user).perform();

            // Click "View profile" inside that user block
            WebElement viewProfile = user.findElement(By.xpath(".//a[text()='View profile']"));
            viewProfile.click();

            // ✅ Assertion: Profile page URL contains "/users/"
            String currentUrl = driver.getCurrentUrl();
            Assert.assertTrue(currentUrl.contains("/users/"),
                    "Expected profile URL to contain '/users/', but found: " + currentUrl);

            System.out.println("✅ Opened profile " + (i + 1) + " → " + currentUrl);

            // Navigate back
            driver.navigate().back();

            // Re-fetch user elements (to avoid stale element exception)
            users = driver.findElements(By.xpath("//div[@class='figure']"));
        }
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }
}
