package base;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

    protected static AndroidDriver driver;

    public void initializeDriver() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("platformName", "Android");
        caps.setCapability("appium:automationName", "UiAutomator2");
        caps.setCapability("appium:deviceName", "Android Device");
        caps.setCapability("appium:app", "C://Users//germa//Downloads//Android.SauceLabs.Mobile.Sample.app.2.7.1.apk");
        caps.setCapability("appium:appActivity", "com.swaglabsmobileapp.MainActivity");
        caps.setCapability("appium:appWaitActivity", "com.swaglabsmobileapp.MainActivity");
        caps.setCapability("appium:autoGrantPermissions", true);
        caps.setCapability("appium:newCommandTimeout", 300);

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), caps);
    }

    public void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

    public static AndroidDriver getDriver() {
        return driver;
    }
}
