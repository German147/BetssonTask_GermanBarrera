package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

    private final By loginBtn = AppiumBy.androidUIAutomator("new UiSelector().text(\"LOGIN\")");

    public HomePage(AndroidDriver driver) {
        super(driver);
    }

    public boolean isLoginBtnPresent() {
        WebElement loginButton = wait.waitForElement(loginBtn, 10);
        return loginButton.isDisplayed();
    }
}

