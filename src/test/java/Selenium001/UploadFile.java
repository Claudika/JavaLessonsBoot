package Selenium001;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class UploadFile {

    private WebDriver driver;
    @BeforeMethod
            public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    @Test
    public void fileUpload() throws InterruptedException {
     driver.get("https://demoqa.com/automation-practice-form");
     driver.manage().window().maximize();
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebElement upload = driver.findElement(By.xpath("//input[@class='form-control-file']"));

        upload.sendKeys("C:\\Users\\mia_o\\OneDrive\\Desktop\\May 2023 QA\\homeworkwebsite");
        Thread.sleep(3000);

    }
    @AfterMethod
    public void clean(){
        driver.close();
        driver.quit();
    }


}
