package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CartPage extends BasePage {

    private final By removerBtn = AppiumBy.androidUIAutomator("new UiSelector().text(\"REMOVER\")");

    public CartPage(AndroidDriver driver) {
        super(driver);
    }

    public boolean isProductAdded() {
        WebElement removeBtn = wait.waitForElement(removerBtn, 15);
        return  removeBtn.isDisplayed();
    }
}

