import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

public class HeadlessTest extends AbsBaseTest{

    @Test
    public void headlessTest() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        WebElement textElement = driver.findElement(
                By.id("textInput"));
        textElement.sendKeys("ОТУС" + Keys.ENTER);
        Assertions.assertEquals("ОТУС", textElement.getAttribute("value"));
    }
}
