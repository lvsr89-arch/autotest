import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class FullscreenCheckTest extends AbsBaseTest {


    @Test
    public void fullScreenTest() {
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        WebElement formName = driver.findElement(
                By.id("name"));
        formName.sendKeys(testName + Keys.ENTER);
        Assertions.assertEquals(testName, formName.getAttribute("value"));

        WebElement formEmail = driver.findElement(
                By.id("email"));
        formEmail.sendKeys(testEmail + Keys.ENTER);
        Assertions.assertEquals(testEmail, formEmail.getAttribute("value"));

        WebElement buttonSubmit = driver.findElement(
                By.xpath("//button[@type='submit']"));
        buttonSubmit.click();

        WebElement checkMessage = driver.findElement(
                By.id ("messageBox"));
        String message = checkMessage.getText();
        Assertions.assertTrue(message.contains(testEmail));
        Assertions.assertTrue(message.contains(testName));
    }
}