import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class ActionTest {
    WebDriver driver;
    Actions actions;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        actions = new Actions(driver);
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

    @Test(priority = 1)
    public void rightClickTest() {
        driver.get("https://demo.guru99.com/test/simple_context_menu.html");

        WebElement element = driver.findElement(By.xpath("//span[text()='right click me']"));
        actions.contextClick(element).perform();  // ✅ Right-click instead of double-click

        // Assertion → check if context menu is displayed
        WebElement contextMenu = driver.findElement(By.xpath("//ul[@class='context-menu-list context-menu-root']"));
        Assert.assertTrue(contextMenu.isDisplayed(), "Context menu should appear after right-click!");
    }

    @Test(priority = 2)
    public void dragAndDropTest() {
        driver.get("https://the-internet.herokuapp.com/drag_and_drop");

        WebElement source = driver.findElement(By.id("column-a"));
        WebElement target = driver.findElement(By.id("column-b"));

        actions.dragAndDrop(source, target).perform();

        // ✅ Assertion → after DnD, column B should contain "A"
        String targetText = driver.findElement(By.id("column-b")).getText();
        Assert.assertTrue(targetText.contains("A"), "Drag and Drop failed! Expected A in Column B");
    }

    @Test(priority = 3)
    public void keyActionTest() {
        driver.get("https://the-internet.herokuapp.com/key_presses");

        // Perform ENTER key press
        actions.sendKeys(Keys.ENTER).perform();

        WebElement result = driver.findElement(By.id("result"));
        String message = result.getText();
        System.out.println("Result message: " + message);

        // ✅ Assertion
        Assert.assertTrue(message.contains("ENTER"), "Expected result to contain ENTER, but got: " + message);
    }
}
