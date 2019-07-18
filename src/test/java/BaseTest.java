import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected String user;
    protected String password;

    @Before
    public void init(){
        WebDriverManager.chromedriver().setup();;
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 30);
        driver.manage().window().maximize();
        user = System.getProperty("user");
        password = System.getProperty("password");
    }

    @After
    public void tearDown(){
        if (driver != null)
            driver.close();
    }
}
