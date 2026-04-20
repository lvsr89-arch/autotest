import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AbsBaseTest {
    protected WebDriver driver;
    protected String testName = "Name";
    protected String testEmail = "test@email.test";

    @BeforeAll
    public static void init(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void beforeEach(){
        driver = new ChromeDriver();
        driver.get(System.getenv("URL"));
        driver.manage().window().fullscreen();
    }

    @AfterEach
    public void teardown(){
        if(driver != null) {
            driver.quit();
        }
    }
}
