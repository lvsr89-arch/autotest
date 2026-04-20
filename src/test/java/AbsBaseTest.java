import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AbsBaseTest {
    protected WebDriver driver;
    protected String testName = "Name";
    protected String testEmail = "test@email.test";
    protected Logger logger = LoggerFactory.getLogger(AbsBaseTest.class);

    @BeforeAll
    public static void init(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void beforeEach(){
        ChromeOptions options = getChromeOptions();
        driver = new ChromeDriver(options);
        driver.get(System.getenv("URL"));
    }

    @AfterEach
    public void teardown(){
        if(driver != null) {
            driver.quit();
        }
    }

    protected ChromeOptions getChromeOptions() {
        return new ChromeOptions();
    }

}
