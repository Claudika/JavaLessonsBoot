package Selenium001;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class demoqaTestDrop {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    @Test
    public void dragAndDrop(){
        driver.get("https://demoqa.com/droppable");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//a[@id='droppableExample-tab-preventPropogation']")).click();

        Actions action = new Actions(driver);
        WebElement dragBox= driver.findElement(By.xpath("//div[@id='dragBox']"));
        WebElement dropBox= driver.findElement(By.xpath("//p[text()='Inner droppable (not greedy)']"));
        action.dragAndDrop(dragBox,dropBox).build().perform();
        WebElement droppedMessage= driver.findElement(By.xpath("(//p[text()='Dropped!'])[1]"));
        
        if(droppedMessage.isDisplayed()){
            System.out.println("Element dropped was successful, test past!");

        }else {
            System.out.println("the test fail"+ droppedMessage.getText());
        }
    }@AfterMethod
    public void clean(){
        driver.close();
        driver.quit();
    }
}
