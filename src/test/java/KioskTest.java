import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class KioskTest extends AbsBaseTest{

    @Test
    public void btnClick() {
        WebElement btn = driver.findElement(By.id("openModalBtn"));
        btn.click();
        WebElement modal = driver.findElement(By.className("modal-content"));
        Assertions.assertTrue(modal.isDisplayed());
    }
}
