package stepDefinitions;

import base.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.LoginPage;
import pages.ValidateNavigationPage;

public class ValidateNavigationSteps extends BaseTest {

    ValidateNavigationPage validateNavigationPage = new ValidateNavigationPage(getDriver());
    LoginPage loginPage = new LoginPage(driver);

    @Given("The app is launched")
    public void the_app_is_launched() {
        Assert.assertTrue(validateNavigationPage.isAppImagePresent(), "The app is not running");
    }

    @When("The user logs in with {string} and {string}")
    public void the_user_logs_in_with_and(String userName, String password) {
        loginPage.enterUsername(userName);
        loginPage.enterPassword(password);
        driver.hideKeyboard();
        loginPage.clickLoginButton();
    }

    @Then("The Products page should be displayed")
    public void the_products_page_should_be_displayed() {
        Assert.assertEquals(loginPage.productPageText(), "PRODUCTOS");
    }

    @Then("Tap on the first product")
    public void tap_on_the_first_product() {
        validateNavigationPage.tapOnFirsItem();
       Assert.assertTrue(validateNavigationPage.isProductPresent(),"The product is not displayed");
    }

}
