import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

public class HeadlessTest extends AbsBaseTest{

    @Test
    public void headlessTest() {
        WebElement textElement = driver.findElement(
                By.id("textInput"));
        textElement.sendKeys("ОТУС" + Keys.ENTER);
        Assertions.assertEquals("ОТУС", textElement.getAttribute("value"));
    }
}
