package pages;

import elementsUtils.WaitingMethods;
import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BasePage {


    protected AndroidDriver driver;
    protected WaitingMethods wait;

    public BasePage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WaitingMethods(driver);
    }

}
