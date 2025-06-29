package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import elementsUtils.WaitingMethods;

public class LoginPage {

    private AppiumDriver driver;
    private WaitingMethods wait;

    public LoginPage(AppiumDriver driver) {
        this.driver = driver;
        this.wait = new WaitingMethods(driver); // updated to receive driver
    }

    // Locators
    private final By usernameField = AppiumBy.accessibilityId("test-Usuario");
    private final By passwordField = AppiumBy.accessibilityId("test-Contraseña");
    private final By loginButton = AppiumBy.xpath("//android.widget.TextView[@text=\"LOGIN\"]");
    private final By errorMessage = AppiumBy.xpath("//android.widget.TextView[contains(@text, 'Username and password')]");

    // Actions
    public void enterUsername(String username) {
        WebElement user = wait.waitUntilVisible(usernameField, 10);
        user.clear();
        user.sendKeys(username);
    }

    public void enterPassword(String password) {
        WebElement pass = wait.waitUntilVisible(passwordField, 10);
        pass.clear();
        pass.sendKeys(password);
    }

    public void tapLoginButton() {
        driver.hideKeyboard();
        WebElement loginBtn = wait.waitUntilClickable(loginButton, 10);
        loginBtn.click();
    }

    public void loginWith(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        tapLoginButton();
    }

    public boolean isErrorMessageDisplayed() {
        return wait.waitUntilVisible(errorMessage, 10).isDisplayed();
    }

    public void assertErrorMessageVisible(String outcomeMsg) {
        WebElement error = wait.waitUntilVisible(errorMessage, 10);
        Assert.assertTrue(error.isDisplayed(), outcomeMsg);
    }
}
