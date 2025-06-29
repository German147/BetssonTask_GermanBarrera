package stepDefinitions;

import base.BaseTest;
import io.cucumber.java.en.Given;
import org.testng.Assert;
import pages.LaunchAppPage;

public class LaunchAppSteps extends BaseTest {

   LaunchAppPage launchAppPage = new LaunchAppPage(getDriver());

    @Given("Verify the app is launched")
    public void verify_the_app_is_launched() {
        Assert.assertTrue(launchAppPage.isAppImagePresent(), "The app was not launched");
    }

}
