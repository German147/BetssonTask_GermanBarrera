package pages;

import exceptions.ElementNotFoundException;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;

public class CartPage extends BasePage {

    private static final Logger logger = LogManager.getLogger(CartPage.class);

    private final By removerBtn = AppiumBy.androidUIAutomator("new UiSelector().text(\"REMOVER\")");

    public CartPage(AndroidDriver driver) {
        super(driver);
    }

    public boolean isProductAdded() {
        try {
            WebElement removeBtn = wait.waitForElement(removerBtn, 15);
            return removeBtn.isDisplayed();
        } catch (TimeoutException e) {
            logger.info("ElementNotFoundException is thrown");
            throw new ElementNotFoundException("Remove button is not visible: " + "locator: " + removerBtn);
        }
    }
}

