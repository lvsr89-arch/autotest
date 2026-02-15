import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class KioskTest {
    WebDriver driver;
    String baseUrl = System.getenv("URL");

    @BeforeAll
    public static void init(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void beforeEach(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--kiosk");
        driver = new ChromeDriver(options);
        driver.get(baseUrl);
    }

    @AfterEach
    public void teardown(){
       if(driver != null) {
           driver.quit();
       }
    }

    @Test
    public void btnClick() throws InterruptedException {
        WebElement btn = driver.findElement(By.id("openModalBtn"));
        btn.click();
        WebElement modal = driver.findElement(By.className("modal-content"));
        Assertions.assertTrue(modal.isDisplayed());
    }
}
