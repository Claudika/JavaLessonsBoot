package Selenium001;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class PracticeSelenium1 {
    private WebDriver driver;

    @BeforeMethod
    @Parameters("browser")
        public void setup(String browser){
            switch (browser) {
                case "chrome" -> {
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                }
                case "edge" -> {
                    WebDriverManager.firefoxdriver().setup();
                    driver = new EdgeDriver();
                    driver.manage().window().maximize();
                }
                default -> throw new IllegalArgumentException("Invalid browser specified: " + browser);
            }
                }
                @Test
                public void testGoogleSearch () {
                    //open the browser and get to url for Google
                    driver.get("https://fs2.formsite.com/meherpavan/form2/index.html?1537702596407");
                    driver.findElement(By.id("RESULT_TextField-1")).sendKeys("Claudia");
                    driver.findElement(By.id("RESULT_TextField-2")).sendKeys("Ramirez");
                    driver.findElement(By.id("RESULT_TextField-3")).sendKeys("7038993802");
                    driver.findElement(By.id("RESULT_TextField-4")).sendKeys("USA");
                    driver.findElement(By.id("RESULT_TextField-5")).sendKeys("Woodbridge");
                    driver.findElement(By.id("RESULT_TextField-6")).sendKeys("claudiaramirez232110@gmail.com");

                    driver.findElement(By.xpath("//label[@for='RESULT_RadioButton-7_1']")).click();
                    driver.findElement(By.xpath("//label[@for='RESULT_CheckBox-8_1']")).click();
                    driver.findElement(By.xpath("//label[@for='RESULT_CheckBox-8_3']")).click();
                    driver.findElement(By.xpath("//label[@for='RESULT_CheckBox-8_5']")).click();
                    driver.findElement(By.xpath("//select [@class='drop_down']")).click();
                    driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
                    driver.findElement(By.xpath("//option [@value='Radio-0']")).click();
//        driver.findElement(By.id("FSsubmit")).click();
                }
                @AfterMethod
                public void clean () {
                    driver.close();
                    driver.quit();
                }
            }