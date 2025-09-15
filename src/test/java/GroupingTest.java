import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class GroupingTest {

    @Test(groups = {"smoke"})
    public void searchTest(){
        System.out.println("welcome");
    }
    @Test(groups = {"regression"})
    public void regressionTest(){
        System.out.println("go");
    }

    @Test(groups = {"smoke","regression"})
    public void demo(){
        System.out.println("fcvgbhnj");
    }
}
