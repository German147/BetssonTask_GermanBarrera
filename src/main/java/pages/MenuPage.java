package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MenuPage extends BasePage {

    private final By closeSessionBtn = AppiumBy.androidUIAutomator("new UiSelector().text(\"CERRAR SESION\")");

    public MenuPage(AndroidDriver driver) {
        super(driver);
    }

    public HomePage tapCloseSession() {
        WebElement logOut = wait.waitForElement(closeSessionBtn, 10);
        logOut.click();
        return new HomePage(driver);
    }


}
