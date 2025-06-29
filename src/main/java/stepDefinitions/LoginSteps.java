package stepDefinitions;

import base.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.LoginPage;

public class LoginSteps extends BaseTest {

    LoginPage loginPage = new LoginPage(getDriver());

    @Given("Verifying the app is launched")
    public void verifying_the_app_is_launched() {
        loginPage = new LoginPage(getDriver());
        Assert.assertTrue(loginPage.isAppLaunched(), "The app was not launched.");
    }

    @When("User enters valid {string} and {string}")
    public void user_enters_valid_username_and_password(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @When("User enters invalid {string} and {string}")
    public void user_enters_invalid_username_and_password(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @And("Click login")
    public void click_login() {
        loginPage.clickLoginButton();
    }

    @Then("User should see the products page {string}")
    public void user_should_see_the_products_page(String outcome) {
        Assert.assertEquals(loginPage.productPageText(), outcome);
    }

    @Then("An error message should be displayed {string}")
    public void an_error_message_should_be_displayed(String outcome) {
        Assert.assertEquals(loginPage.errorMessageVisible(), outcome);
    }
}
