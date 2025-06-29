package pages;

import exceptions.ScreenNotDisplayedException;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;

public class LaunchAppPage extends BasePage {

    private final By appImage = AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(0)");

    public LaunchAppPage(AndroidDriver driver) {
        super(driver);
    }

    public boolean isAppImagePresent() {
        try {
            WebElement image = wait.waitUntilVisible(appImage, 15);
            return image.isDisplayed();
        } catch (TimeoutException e) {
            throw new ScreenNotDisplayedException("App was not launched." + "Locator: " + appImage);
        }
    }


}
