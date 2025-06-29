package pages;

import exceptions.ElementNotFoundException;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;

public class MenuPage extends BasePage {

    private final By closeSessionBtn = AppiumBy.androidUIAutomator("new UiSelector().text(\"CERRAR SESION\")");

    public MenuPage(AndroidDriver driver) {
        super(driver);
    }

    public HomePage tapCloseSession() {
        try {
            WebElement logOut = wait.waitForElement(closeSessionBtn, 10);
            logOut.click();
        } catch (TimeoutException e) {
            throw new ElementNotFoundException("Close session button was not clicked." + "Locator: " + closeSessionBtn);
        }

        return new HomePage(driver);
    }


}
