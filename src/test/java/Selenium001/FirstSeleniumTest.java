package Selenium001;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class FirstSeleniumTest {
    private WebDriver driver;
    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
    }@Test
    public void testGoogleSearch(){
        //open the browser and get to url for Google
        driver.get("https://www.google.com");

        //find the element on the page
        driver.findElement(By.name("q")).sendKeys("yahoo" + Keys.ENTER);
        //Keys.ENTER    OR
        //pressing keyboard keys to send it
        //driver.findElement(By.name("q")).sendKeys(Keys.ENTER);


        //wait for the results to show
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver){
                return driver.getTitle().contains("yahoo");
            }
        });

        driver.findElement(By.className("LC20lb")).click();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.findElement(By.className("_yb_hwn0z")).click();
       // driver.findElement(By.className("_yb_6k8xk")).click();
        driver.findElement(By.className("signups")).click();

        //Assert the results
        String ExpectedTitle ="Yahoo";
        String actualTitle = driver.getTitle();

      //  Assert.assertEquals(actualTitle,ExpectedTitle);

    }
    @AfterMethod
    public void tearDown(){
        //closes the window?
        driver.close();
        //close the browser
        driver.quit();
    }

}
