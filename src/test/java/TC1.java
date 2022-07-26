import io.netty.util.Timeout;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.management.timer.Timer;
import java.time.Duration;

public class TC1 {
    WebDriver driver;
    String uri = "http://localhost:8080/";

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "driver/chrome/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void test1() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(uri);
        driver.manage().window().fullscreen();
        String title = driver.getTitle();
        Assert.assertEquals(title, "Sign in [Jenkins]");

    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
