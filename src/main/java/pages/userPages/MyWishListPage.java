package pages.userPages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import pages.ProductPage;
import tools.PageTools;

import static com.codeborne.selenide.Selenide.$;
import static org.testng.Assert.assertTrue;

public class MyWishListPage extends PageTools {
    private final By productName = By.xpath("//div/strong/a[@class='product-item-link']");
    private final By productPrice = By.xpath("//span[@class='price-wrapper ']/span");
    private final By productImage = By.xpath("//img[@class='product-image-photo']");
    private final By addToCartButton = By.xpath("//button[@data-role='tocart']");
    private final By seeDetailsTooltip = By.xpath("//span[@class='action details tooltip toggle']");
    private final By addAllToCartButton = By.xpath("//button[@class='action tocart']");
    private final By successMessage = By.xpath("//div[@class='message-success success message']/div");
    private final By emptyInfoMessage = By.xpath("//div[@class='message info empty']/span");
    private final By removeItemButton = By.xpath("//a[@data-role='remove']");
    private final By listQty = By.xpath("//span[@class='toolbar-number']");
    private final By updateWishlistButton = By.xpath("//button[@class='action update']");
    private final By itemQtyInput = By.xpath("//input[@data-role='qty']");
    //Options Details elements
    private final By groupItemName = By.xpath("//dt[@class='label']");
    private final By groupItemQty = By.xpath("//dd[@class='values']");

    //--------------Element is Displayed---------------

    @Step("Check if Empty info message is displayed")
    public boolean isEmptyInfoMessageDisplayed() {
        return isElementVisible(emptyInfoMessage);
    }

    @Step("Check if product name is displayed")
    public boolean isProductNameDisplayed() {
        return isElementVisible(productName);
    }

    @Step("Check if product image is displayed")
    public boolean isProductImageDisplayed() {
        return isElementVisible(productImage);
    }

    @Step("Check if product price is displayed")
    public boolean isProductPriceDisplayed() {
        return isElementVisible(productPrice);
    }

    @Step("Check if Add to Cart button is displayed")
    public boolean isAddToCartButtonDisplayed(int index) {
        openItemDetailsForItemByIndex(index);
        return isElementVisible(addToCartButton);
    }

    @Step("Check if Update Wishlist button is displayed")
    public boolean isUpdateWishlistButtonDisplayed() {
        return isElementVisible(updateWishlistButton);
    }

    @Step("Check if Add All to Cart button is displayed")
    public boolean isAddAllToCartButtonDisplayed() {
        return isElementVisible(addAllToCartButton);
    }

    //--------------Get---------------
    @Step("Get item name by {index}")
    public String getItemName(int index) {
        return getElementTextByIndex(productName, index);
    }

    @Step("Get item price by {index}")
    public String getItemPrice(int index) {
        return getElementTextByIndex(productPrice, index);
    }

    @Step("Get Group item name by {index} from Options Details")
    public String getGroupItemNameByIndex(int index) {
        return getElementTextByIndex(groupItemName, index);
    }

    @Step("Get Group item qty by {index} from Options Details")
    public String getGroupItemQtyByIndex(int index) {
        return getElementTextByIndex(groupItemQty, index);
    }

    @Step("Get success info message text")
    public String getSuccessMessageText() {
        return getElementText(successMessage);
    }

    @Step("Get empty info message text")
    public String getEmptyMessageText() {
        return getElementText(emptyInfoMessage);
    }

    @Step("Get items qty in Wishlist")
    public String getItemsQty() {
        return getElementText(listQty);
    }

    //--------------Click---------------

    @Step("Click Add All to Cart button")
    public void clickAddAllToCartButton() {
        click(addAllToCartButton);
    }

    @Step("Click Update Wishlist button")
    public void clickUpdateWishlistButton() {
        click(updateWishlistButton);
    }

    @Step("Click Remove item button by {index}")
    public void clickRemoveItemButtonByIndex(int index) {
        openItemDetailsForItemByIndex(index);
        click(removeItemButton);
    }

    @Step("Click Add to Cart item button by {index}")
    public ProductPage clickAddToCartButtonByIndex(int index) {
        openItemDetailsForItemByIndex(index);
        click(addToCartButton);
        return new ProductPage();
    }

    //--------------Other---------------

    @Step("Set qty input with {qty}")
    public void openItemDetailsForItemByIndex(int index) {
        By locator = By.id(("(" + productPrice + ")[" + index + "]"));
        scrollToPlaceElementInCenter(locator);
        moveToElement(locator);
    }

    @Step("Open Options Details for item by {index}")
    public void openOptionsDetailsForItemByIndex(int index) {
        By locator = By.id(("(" + seeDetailsTooltip + ")[" + index + "]"));
        scrollToPlaceElementInCenter(locator);
        moveToElement(locator);
    }

    @Step("Set qty input with {qty}")
    public void setItemQtyInput(int index, String qty) {
        openItemDetailsForItemByIndex(index);
        jsType(qty, itemQtyInput);
        click(listQty);
    }


}
