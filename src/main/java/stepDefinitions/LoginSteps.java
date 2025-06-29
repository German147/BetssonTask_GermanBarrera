package stepDefinitions;

import base.BaseTest;
import elementsUtils.WaitingMethods;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginSteps extends BaseTest {

    AndroidDriver driver = getDriver();
    WaitingMethods waitingMethods = new WaitingMethods();

    @When("User enters valid {string} and {string}")
    public void user_enters_valid_username_and_password(String username, String password) {
        WebElement userField = waitingMethods.waitForElement(AppiumBy.accessibilityId("test-Usuario"), 10);
        userField.click();
        userField.sendKeys(username);
        WebElement passField = driver.findElement(AppiumBy.accessibilityId("test-Contraseña"));
        passField.sendKeys(password);
        driver.hideKeyboard();
    }

    @When("Click login")
    public void click_login() {
        WebElement loginBtn = waitingMethods.waitUntilClickable(AppiumBy.xpath("//android.widget.TextView[@text=\"LOGIN\"]"), 10);
        loginBtn.click();
    }

    @Then("User should see the products page {string}")
    public void user_should_see_the_products_page_as_assertion(String productText) {
        WebElement productTitle = waitingMethods.waitForElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"PRODUCTOS\")"), 10);
        Assert.assertEquals(productTitle.getText(), productText);

    }

    @When("User enters invalid {string} and {string}")
    public void user_enters_invalid_username_and_password(String username, String password) {
        WebElement userField = waitingMethods.waitForElement(AppiumBy.accessibilityId("test-Usuario"), 10);
        userField.click();
        userField.sendKeys(username);
        WebElement passField = driver.findElement(AppiumBy.accessibilityId("test-Contraseña"));
        passField.sendKeys(password);
        driver.hideKeyboard();
    }

    @Then("An error message should be displayed {string}")
    public void an_error_message_should_be_displayed(String msg) {
        WebElement errorMsg = waitingMethods
                .waitForElement(AppiumBy
                        .androidUIAutomator("new UiSelector().text(\"El usuario y contraseña no coinciden con ningun usuario en este servicio.\")"), 10);
        Assert.assertEquals(errorMsg.getText(), msg);
    }

    @Given("Verify the app is launched")
    public void the_app_is_launched() {
        WebElement image = waitingMethods.waitUntilVisible(AppiumBy
                .androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(0)"), 10);
        Assert.assertTrue(image.isDisplayed(), "The app was not launched");
    }
}
