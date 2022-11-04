package First;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FirstTest {

    static {
        WebDriverManager.chromedriver().setup();
    }
    private WebDriver driver;

    @Test
    public void testFirst() throws InterruptedException {
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
        WebElement text = driver.findElement(By.id("my-text-id"));
        Thread.sleep(2000);
        text.sendKeys("Testing Chrome");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button")).click();
        Thread.sleep(4000);
        String actualText = driver.findElement(By.xpath("//h1")).getText();
        Assert.assertEquals(actualText, "Form submitted");
    }
    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
