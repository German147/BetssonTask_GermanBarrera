package stepDefinitions;

import base.BaseTest;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.HomePage;
import pages.MenuPage;
import pages.ProductPage;

public class LogoutSteps extends BaseTest {

    ProductPage productPage = new ProductPage(getDriver());

    @When("The user opens the menu")
    public void the_user_opens_the_menu() {
        productPage.tapBurgerButton();
    }

    @When("The user taps the logout option")
    public void the_user_taps_the_logout_option() {
        MenuPage menuPage = new MenuPage(getDriver());
        menuPage.tapCloseSession();
    }

    @Then("The login screen should be displayed again")
    public void the_login_screen_should_be_displayed_again() {
        HomePage homePage = new HomePage(getDriver());
        Assert.assertTrue(homePage.isLoginBtnPresent(), "The logout was not successful");
    }

}
