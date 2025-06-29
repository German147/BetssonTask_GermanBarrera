package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ProductPage extends BasePage {
    private final By firstProduct = AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(6)");
    private final By addToCartBtn = AppiumBy.androidUIAutomator("new UiSelector().text(\"AÑADIR A CARRITO\")");
    private final By removerBtn = AppiumBy.androidUIAutomator("new UiSelector().text(\"REMOVER\")");
    private final By cartIcon = AppiumBy.androidUIAutomator("new UiSelector().description(\"test-Carrito\")");
    private final By burgerBtn = AppiumBy.androidUIAutomator("new UiSelector().description(\"test-Menu\")");

    public ProductPage(AndroidDriver driver) {
        super(driver);
    }

    public void tapAProduct() {
        WebElement product = wait.waitForElement(firstProduct, 10);
        product.click();
    }

    public void tapAddToCart() {
        scrollUpAndClickAddToCart();
    }

    public void scrollUpAndClickAddToCart() {
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))" +
                        ".setMaxSearchSwipes(10)" +
                        ".scrollBackward()" +
                        ".scrollIntoView(new UiSelector().text(\"AÑADIR A CARRITO\"))"
        ));

        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"AÑADIR A CARRITO\")")).click();
    }


    public boolean isTappedAddToCartBtn() {
        WebElement removeBtn = wait.waitUntilVisible(removerBtn, 15);
        return removeBtn.isEnabled();
    }

    public CartPage tapOnCartIcon() {
        WebElement cart = wait.waitForElement(cartIcon, 10);
        cart.click();
        return new CartPage(driver);
    }

    public MenuPage tapBurgeButton() {
        WebElement burgerButton = wait.waitForElement(burgerBtn, 10);
        burgerButton.click();
        return new MenuPage(driver);
    }
}
