import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownSelectclass {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dropdown");

        WebElement dropDown=driver.findElement(By.id("dropdown"));
        dropDown.click();
        Select select= new Select(dropDown);
       //select.selectByValue("1");
        select.selectByVisibleText("Option 1");
        //select.selectByIndex(2);
        System.out.println("Selected by Index → " + select.getFirstSelectedOption().getText());

        Thread.sleep(5000);
        driver.quit();
    }
}
