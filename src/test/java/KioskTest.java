import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;

public class KioskTest extends AbsBaseTest{

    @Override
    protected ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--kiosk");
        return options;
    }


    @Test
    public void btnClick() {
        WebElement btn = driver.findElement(By.id("openModalBtn"));
        btn.click();
        WebElement modal = driver.findElement(By.className("modal-content"));
        Assertions.assertTrue(modal.isDisplayed());
    }
}
