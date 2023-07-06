package Selenium001;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.security.Key;
import java.time.Duration;
import java.util.List;

public class AmazonTest {
    //google
     //search amazon
    //wait for amazon.com to load
    //assert if you are on amazon.com
    //search for socks on amazon
    //count how many socks are displayed on the page
    //assert the expected with actual number
    //do all this with xpath and creating webElements
    private WebDriver driver;
    @BeforeMethod
    public void SetUp(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void AmazonSearch(){
        driver.get("https://www.google.com");
        driver.navigate().to("https://www.amazon.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //ASSERT WE ARE IN THE CORRECT URL
        String url= driver.getCurrentUrl();
        String expectedUrl= "https://www.amazon.com/";
        Assert.assertEquals(url,expectedUrl);
        // ASSERT THE TITLE OF THE PAGE
        String tittle= driver.getTitle();
        String amazonTitle= "Amazon.com. Spend less. Smile more.";
        Assert.assertEquals(amazonTitle,tittle);
        // STORE WEB ELEMENTS
        WebElement searchBar= driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]"));
       // WebElement socks= driver.findElement(By.xpath("//span[@class='a-color-state a-text-bold']"));

        //SEARCH FOR SOCKS
        searchBar.click();
        searchBar.sendKeys("socks");
        searchBar.sendKeys(Keys.ENTER);

        //WAIT UNTIL SOCKS ARE DISPLAYED
        FluentWait<WebDriver> wait= new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(500));

        //ASSERT SOCKS ARE DISPLAYED
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//span[@class='a-color-state a-text-bold']"),"socks"));
        String actual= driver.findElement(By.xpath("//span[@class='a-color-state a-text-bold']")).getText();
        String result="\"socks\"";
        Assert.assertEquals(actual,result);

       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        List<WebElement> sockElement =driver.findElements(By.cssSelector("s-result-item"));
        int total= countSocks(sockElement);
        System.out.println(total);
    }
    private static int countSocks(List<WebElement>sockElement){
        int count =0;
        for(WebElement item: sockElement) {
            if (item.getText().contains("socks")) {
                count++;
            }
        }return count;
        }
    @AfterMethod
    public void clean(){
        driver.close();
        driver.quit();
    }
}
