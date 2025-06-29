package elementsUtils;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitingMethods {

    private final AppiumDriver driver;

    public WaitingMethods(AppiumDriver driver) {
        this.driver = driver;
    }

    public WebElement waitForElement(By locator, int duration) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public WebElement waitUntilClickable(By locator, int duration) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public WebElement waitUntilVisible(By locator, int duration) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
