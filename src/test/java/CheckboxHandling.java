import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckboxHandling {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Open Checkboxes page
        driver.get("https://the-internet.herokuapp.com/checkboxes");

       WebElement chkBox1=driver.findElement(By.xpath("//input[@type='checkbox'][1]"));
       WebElement chkBox2=driver.findElement(By.xpath("//input[@type='checkbox'][2]"));

       if(!chkBox1.isSelected()){
       chkBox1.click();
           System.out.println("Chkbox is not selected but now selected");
       }else
           System.out.println("chkbox is selected");

        if (!chkBox2.isSelected()) {
            chkBox2.click();
            System.out.println("Checkbox 2 was not selected → Now selected ✅");
        } else {
            System.out.println("Checkbox 2 was already selected ✅");
        }
        driver.quit();
    }



    }
