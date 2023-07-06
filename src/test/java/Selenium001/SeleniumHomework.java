package Selenium001;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.security.Key;
import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class SeleniumHomework {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    @Test
    public void testGoogleSearch() {
        //find the element on the page
        driver.get("https://slack.com/signin#/signin");
        driver.manage().window().maximize();
        //signing manually instead
        driver.findElement(By.xpath("//*[@id=\"get_started_app_root\"]/div[1]/div[2]/div[4]/span/a")).click();
        driver.findElement(By.className("c-input_text")).sendKeys("CreativeCodingcollect");
        driver.findElement(By.className("c-button")).click();
        //signing in
        driver.findElement(By.xpath("//*[@id=\"page_contents\"]/div/div/div[2]/div[3]/div[4]/span/a")).click();
        driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("claudiaramirez232110@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("703Clauclau!");
        driver.findElement(By.xpath("//button[@id='signin_btn']")).click();

        Alert alert = driver.switchTo().alert();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));//waits for the driver, the given time

        alert.accept();

//        WebDriver wait = new WebD
    }


//        Actions actions = new Actions(driver);
//        actions.sendKeys(Keys.ESCAPE).perform();
//
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.switchTo().defaultContent();
//        driver.findElement(By.xpath("//*[@id=\"page_contents\"]/div/div/div[2]/p/a")).click();



//        driver.findElement(By.xpath("//*[@id=\"C058KJYKP24\"]/div/span[1]")).click();
//        driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[5]/div[2]/div/div[4]/div/div[2]/div/div/div/div[2]/div/div/div/div[2]/div/div[1]")).click();
//
//        WebElement element = driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[5]/div[2]/div/div[4]/div/div[2]/div/div/div/div[2]/div/div/div/div[2]/div/div[1]"));
//
//        element.click();
//        element.sendKeys("Hello this is automated message");
//        element.sendKeys(Keys.ENTER);
//

 @AfterMethod
    public void clean(){
        driver.close();// closes only the page that the driver is focusing on.(maybe you are in 3rd page open, will close only 3rd one)
     //they both close the page
        driver.quit();//closes all the pages and kills the driver session. This is the one I use because closes everything
 }
//       }
    }
