package stepDefinitions;

import base.BaseTest;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.CartPage;
import pages.ProductPage;

public class AddProductToCart extends BaseTest {

    ProductPage productPage = new ProductPage(getDriver());

    @When("The user taps on the first product")
    public void the_user_taps_on_the_first_product() {
        productPage.tapAProduct();
    }

    @When("Adds the product to the cart")
    public void adds_the_product_to_the_cart() {
        productPage.tapAddToCart();
        Assert.assertTrue(productPage.isTappedAddToCartBtn(), "The add to cart button was not tapped");
    }

    @Then("The cart should contain the added product")
    public void the_cart_should_contain_the_added_product() {
        CartPage cartPage = new CartPage(driver);
        Assert.assertTrue(cartPage.isProductAdded(), "The product was not added to cart");
    }

}
