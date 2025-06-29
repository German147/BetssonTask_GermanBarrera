package pages;

import exceptions.ElementNotClickableException;
import exceptions.LoginFailedException;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    private final By usernameField = AppiumBy.accessibilityId("test-Usuario");
    private final By passwordField = AppiumBy.accessibilityId("test-Contraseña");
    private final By loginButton = AppiumBy.xpath("//android.widget.TextView[@text=\"LOGIN\"]");
    private final By errorMessage = AppiumBy
            .androidUIAutomator("new UiSelector().text(\"El usuario y contraseña no coinciden con ningun usuario en este servicio.\")");
    private final By productPageText = AppiumBy.androidUIAutomator("new UiSelector().text(\"PRODUCTOS\")");

    public LoginPage(AndroidDriver driver) {
        super(driver);
    }

    public boolean isAppLaunched() {
        WebElement image = wait.waitUntilVisible(AppiumBy
                .androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(0)"), 10);
        return image.isDisplayed();
    }

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
        try {
            WebElement loginBtn = wait.waitUntilClickable(loginButton, 10);
            loginBtn.click();
        } catch (TimeoutException e) {
            throw new ElementNotClickableException("Login button was not clicked." + "Locator: " + loginButton);
        }
    }

    public String errorMessageVisible() {
        WebElement msg = wait.waitUntilVisible(errorMessage, 15);
        return msg.getText();
    }

    public void clickLoginButton() {
        tapLoginButton();
    }

    public String productPageText() {
        try {
            WebElement productText = wait.waitUntilVisible(productPageText, 15);
            return productText.getText();
        } catch (TimeoutException e) {
            throw new LoginFailedException("Login was not executed");
        }
    }
}
