import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

public class HeadlessTest {
    WebDriver driver;
    String baseUrl = System.getenv("URL");

    @BeforeAll
    public static void init(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void beforeEach(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver();
        driver.get(baseUrl);
    }

    @AfterEach
    public void teardown(){
       if(driver != null) {
           driver.quit();
       }
    }

    @Test
    public void headlessTest() throws InterruptedException {
        WebElement textElement = driver.findElement(
                By.id("textInput"));
        textElement.sendKeys("ОТУС" + Keys.ENTER);
        Assertions.assertEquals("ОТУС", textElement.getAttribute("value"));
    }
}
