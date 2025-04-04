package pages.blocks;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import pages.carts.CheckoutShippingPage;
import pages.carts.ShoppingCartPage;
import tools.PageTools;

import static com.codeborne.selenide.Selenide.$;

public class MiniCart extends PageTools {

    private final By cartButton = By.xpath("//div[@data-block='minicart']");
    private final By cartCounter = By.xpath("//span[@class='counter-number']");
    private final By itemLink = By.xpath("//strong[@class='product-item-name']/a");
    private final By itemPrice = By.xpath("//span[@class='minicart-price']/span");
    private final By cartItemsQty = By.xpath("//span[@class='count']");
    private final By cartSubtotal = By.xpath("//div[@class='amount price-container']/span/span");
    private final By itemQty = By.xpath("//input[@class='item-qty cart-item-qty']");
    private final By seeDetailsLink = By.xpath("//span[@data-role='title']/span");
    private final By itemSizeValue = By.xpath("//dl/dd[1]/span");
    private final By itemColorValue = By.xpath("//dl/dd[2]/span");
    private final By viewAndEditCartLink = By.xpath("//a[@class='action viewcart']/span");
    private final By counterIcon = By.xpath("//a[@class='action showcart']/span[@class='counter qty']");
    private final By itemDetailedPrice = By.xpath("//dd[@class='values']/span/span");
    private final By itemDetailedInfo = By.xpath("//dd[@class='values']/span");
    private final By updateButton = By.xpath("//button[@title='Update']");
    private final By editItemButton = By.xpath("//a[@title='Edit item']");
    private final By removeItemButton = By.xpath("//div[@class='secondary']/a[@title='Remove item']");
    private final By proceedToCheckoutButton = By.xpath("//button[@id='top-cart-btn-checkout']");
    private final By okConfirmRemoveButton = By.xpath("//button[@class='action-primary action-accept']");
    private final By emptyCartNotification = By.xpath("//strong[@class='subtitle empty']");

    //---------------isDisplayed----------------

    @Step("Check if Empty cart notification is displayed")
    public boolean emptyCartNotificationIsDisplayed() {
        return isElementVisible(emptyCartNotification);
    }

    @Step("Check if Cart qty element is displayed")
    public boolean cartQtyElementIsDisplayed() {
        return isElementVisible(cartCounter);
    }

    //---------------------Get----------------------

    @Step("Get Cart counter value")
    public String getCartCounterValue() {
        waitForElementVisible(counterIcon);
        return getElementText(cartCounter);
    }

    @Step("Get items qty in Mini-cart")
    public String getCartItemsQty() {
        return String.valueOf(getElementsTextWithWait(cartItemsQty, 2));
    }

    @Step("Get Subtotal amount value in Mini-cart")
    public String getCartSubtotal() {
        return getElementText(cartSubtotal);
    }

    @Step("Get added item's name in Mini-cart")
    public String getItemName() {
        return getElementText(itemLink);
    }

    @Step("Get added item's price in Mini-cart")
    public String getItemPrice() {
        return getElementText(itemPrice);
    }

    @Step("Get added item's qty in Mini-cart")
    public String getItemQty() {
        return getElementAttributeValue("data-item-qty", itemQty);
    }

    @Step("Get added item size in Mini-cart")
    public String getItemSizeValue() {
        return getElementText(itemSizeValue);
    }

    @Step("Get added item color in Mini-cart")
    public String getItemColorValue() {
        return getElementText(itemColorValue);
    }

    @Step("Get added info message in empty Mini-cart")
    public String getEmptyCartMessage() {
        return getElementText(emptyCartNotification);
    }

    @Step("Get added item's name in Mini-cart by {index}")
    public String getItemNameByIndex(int index) {
        return getElementTextByIndex(itemLink, index);
    }

    @Step("Get added item's detailed info in Mini-cart")
    public String getItemDetailedInfo() {
        return getElementText(itemDetailedInfo);
    }

    @Step("Get added item's detailed price in Mini-cart")
    public String getItemDetailedPrice() {
        return getElementText(itemDetailedPrice);
    }

//    @Step("Get items qty in Mini-cart")
//    public String getCartItemsQtyWithWai(){
//        return getElementsTextWithWait(cartItemsQty, 2);
//    }

    //---------------Set/Select----------------

    @Step("Fill Qty field with {itemQty}")
    public void setQtyInput(String qty) {
        click(itemQty);
        Selenide.actions().sendKeys($(itemQty), Keys.DELETE).perform();
        clearText(itemQty);
        type(itemQty, qty);
    }

    //---------------Click----------------

    @Step("Click Proceed to Checkout button")
    public CheckoutShippingPage clickProceedToCheckoutButton() {
        click(proceedToCheckoutButton);
        return new CheckoutShippingPage();
    }

    @Step("Click Remove item button")
    public void clickRemoveItemButton() {
        click(removeItemButton);
    }

    @Step("Click Cart button in header")
    public void clickCartButton() {
        click(cartButton);
    }

    @Step("Click See Details link in Mini-cart")
    public void clickSeeDetailsLink() {
        click(seeDetailsLink);
    }

    @Step("Click View and Edit Cart link")
    public ShoppingCartPage clickViewAndEditCartLink() {
        click(viewAndEditCartLink);
        return new ShoppingCartPage();
    }

    @Step("Click Update button")
    public void clickUpdateButton() {
        click(updateButton);
        waitForElementInvisibleUntil(updateButton, 2);
    }

    @Step("Click Edit item button")
    public void clickEditItemButton() {
        click(editItemButton);
    }

    @Step("Click OK button on Confirmation popup")
    public void clickOkConfirmationButton() {
        click(okConfirmRemoveButton);
    }


}
