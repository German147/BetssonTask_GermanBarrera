package pages;

import elementsUtils.WaitingMethods;
import io.appium.java_client.android.AndroidDriver;

public class BasePage {
    protected AndroidDriver driver;
    protected WaitingMethods wait;

    public BasePage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WaitingMethods(driver);
    }
}
