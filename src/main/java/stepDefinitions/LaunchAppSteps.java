package stepDefinitions;

import base.BaseTest;
import elementsUtils.WaitingMethods;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LaunchAppSteps extends BaseTest {

    AndroidDriver driver = getDriver();
    WaitingMethods waitingMethods = new WaitingMethods();

    @Given("Verifying the app is launched ")
    public void verifying_the_app_is_launched() {
        WebElement image = waitingMethods.waitUntilVisible(AppiumBy
                .androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(0)"), 10);
        Assert.assertTrue(image.isDisplayed(), "The app was not launched");
    }

}
