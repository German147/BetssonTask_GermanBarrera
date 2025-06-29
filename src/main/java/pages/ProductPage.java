package pages;

import exceptions.ElementNotFoundException;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;

public class ProductPage extends BasePage {
    private final By firstProduct = AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(6)");
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
        try {
            driver.findElement(AppiumBy.androidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true))" +
                            ".setMaxSearchSwipes(10)" +
                            ".scrollBackward()" +
                            ".scrollIntoView(new UiSelector().text(\"AÑADIR A CARRITO\"))"
            ));
        } catch (TimeoutException e) {
            throw new ElementNotFoundException("The app was not scrolled up.");
        }

        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"AÑADIR A CARRITO\")")).click();
    }

    public boolean isTappedAddToCartBtn() {
        WebElement removeBtn = wait.waitUntilVisible(removerBtn, 15);
        return removeBtn.isEnabled();
    }

    public MenuPage tapBurgerButton() {
        WebElement burgerButton = wait.waitForElement(burgerBtn, 10);
        burgerButton.click();
        return new MenuPage(driver);
    }
}
