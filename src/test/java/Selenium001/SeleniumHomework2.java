package Selenium001;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.netty.buffer.ByteBufProcessor;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class SeleniumHomework2 {
    private WebDriver driver;
    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }@Test
    public void orangeHrm() throws InterruptedException {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        //once in, click Admin
        driver.findElement(By.xpath("//span[text()='Admin']")).click();
        //fill up the boxes
        driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]")).sendKeys("ABCD1");

//        WebElement dynaDropdown= driver.findElement(By.xpath("(//div[@class='oxd-select-text oxd-select-text--active'])[1]"));
//        dynaDropdown.click();



       // WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(4));
        WebElement dynaDropdown= driver.findElement(By.xpath("(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[1]"));
        dynaDropdown.click();

        //Maybe Javascript to click on Admin
        JavascriptExecutor js=(JavascriptExecutor)driver;
        WebElement dynamicDrop= driver.findElement(By.xpath("(//div[@class='oxd-select-text-input'])[1]"));
        js.executeScript("arguments[0].click();",dynamicDrop);
// Normal way to click xx Admin
//        WebElement adminSelection= driver.findElement(By.xpath("(//div[@class='oxd-select-text-input'])[1]"));
//        wait.until(ExpectedConditions.elementToBeClickable(adminSelection));
//        adminSelection.click();
        Thread.sleep(4);

//Actions way to click on Admin
//        Actions actions= new Actions(driver);
//        WebElement adminSelection= driver.findElement(By.xpath("(//div[@tabindex='0'])[1]"));
//        actions.moveToElement(adminSelection).build().perform();
//        actions.click(adminSelection).build().perform();

        driver.findElement(By.xpath("//input[@placeholder='Type for hints...']")).sendKeys("Sania  Shaheen");

        WebElement statusDropDown = driver.findElement(By.xpath("(//div[@class='oxd-select-text-input'])[2]"));
        statusDropDown.sendKeys("Ena"+ Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        WebElement searchButton = driver.findElement(By.xpath("//button[text()=' Search ']"));

        searchButton.submit();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        //no records found xpath to assert we land on the next page= (//span[@class='oxd-text oxd-text--span'])[1]


    }@AfterMethod
    public void cleanUp(){
        driver.close();
        driver.quit();
    }

    }
