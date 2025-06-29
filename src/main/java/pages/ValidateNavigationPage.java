package pages;

import exceptions.ElementNotFoundException;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;

public class ValidateNavigationPage extends BasePage {

    private final By firstProduct = AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(6)");
    private final By productText = AppiumBy.androidUIAutomator("new UiSelector().text(\"Camisa Sauce Labs Bolt\")");

    public ValidateNavigationPage(AndroidDriver driver) {
        super(driver);
    }

    public boolean isAppImagePresent() {
        LaunchAppPage launchAppPage = new LaunchAppPage(driver);
        return launchAppPage.isAppImagePresent();
    }

    public ProductPage tapOnFirsItem() {
        try {
            wait.waitForElement(firstProduct, 15);
        } catch (TimeoutException e) {
            throw new ElementNotFoundException("The product was not displayed." + "Locator: " + firstProduct);
        }
        return new ProductPage(driver);
    }

    public boolean isProductPresent() {
        WebElement text = wait.waitForElement(productText, 10);
        return text.isDisplayed();
    }

}
