package pages;

import exceptions.ScreenNotDisplayedException;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

    private static final Logger logger = LogManager.getLogger(HomePage.class);

    private final By loginBtn = AppiumBy.androidUIAutomator("new UiSelector().text(\"LOGIN\")");

    public HomePage(AndroidDriver driver) {
        super(driver);
    }

    public boolean isLoginBtnPresent() {
        logger.info("isLoginBtnPresent() is being executing");
        try {
            WebElement loginButton = wait.waitForElement(loginBtn, 10);
            return loginButton.isDisplayed();
        } catch (TimeoutException e) {
            logger.error("ScreenNotDisplayedException was executed");
            throw new ScreenNotDisplayedException("Home Screen is not displayed." + "Locator used: " + loginBtn);
        }
    }
}

