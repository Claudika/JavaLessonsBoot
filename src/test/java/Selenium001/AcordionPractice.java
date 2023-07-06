package Selenium001;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AcordionPractice {
    private WebDriver driver;
    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    @Test
    public void acordionTest() throws InterruptedException {
        driver.get("https://demoqa.com/accordian");
        driver.manage().window().maximize();
       WebElement text= driver.findElement(By.id("section1Content"));
       System.out.println(text.isDisplayed()?"First test pass, text is displayed":"test failed, text is not displayed");
      Thread.sleep(2000);
        driver.findElement(By.id("section2Heading")).click();
        WebElement secondText= driver.findElement(By.id("section2Content"));
        System.out.println(secondText.isDisplayed()?"Second test pass, text is displayed":"test failed, text is not displayed");
      Thread.sleep(20000);
        driver.findElement(By.id("section3Heading")).click();
        WebElement thirdText= driver.findElement(By.id("section3Content"));
        System.out.println(thirdText.isDisplayed()?"Third test pass, text is displayed":"test failed, text is not displayed");
       Thread.sleep(2000);
    }
    @AfterMethod
    public void clear(){
        driver.close();
        driver.quit();
    }
}
