package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import pages.carts.ShoppingCartPage;
import pages.userPages.CompareProductsPage;
import pages.userPages.LoginPage;
import pages.userPages.MyWishListPage;
import tools.PageTools;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ProductPage extends PageTools {

    private final By addToCartButton = By.xpath("//button[contains(@id, 'addtocart')]");
    private final By shoppingCartLink = By.xpath("//a[text()='shopping cart']");
    private final By sizeButton = By.xpath("//div[contains(@class, 'swatch-option text')]");
    private final By colorButton = By.xpath("//div[contains(@class, 'swatch-option color')]");
    private final By priceInfo = By.xpath("//div[@class='product-info-price']/div/span/span/span/span");
    private final By minPriceInfo = By.xpath("//span[@data-price-type='minPrice']//span[@class='price']");
    private final By maxPriceInfo = By.xpath("//span[@data-price-type='maxPrice']//span[@class='price']");
    private final By groupItemPrice = By.xpath("//span[@class='price-wrapper ']/span");
    private final By stockInfo = By.xpath("//div[@title='Availability']/span");
    private final By productName = By.xpath("//span[@itemprop='name']");
    private final By successMessage = By.xpath("//div[@data-ui-id='message-success']/div");
    private final By comparisonListLink = By.xpath("//div[@data-ui-id='message-success']/div/a");
    private final By productImage = By.xpath("//img[@class='fotorama__img']");
    private final By customizeATCButton = By.xpath("//button[@id='bundle-slide']");
    private final By bundleItemsDropdown = By.xpath("//select[@id='bundle-option-15']");
    private final By selectedBundleItemOption = By.xpath("//div[@data-container='options']/div");
    private final By bundleItemErrorMessage = By.xpath("//div[@for='bundle-option-15']");
    private final By colorErrorMessage = By.xpath("(//div[@class='mage-error'])[2]");
    private final By sizeErrorMessage = By.xpath("//div[@class='mage-error']");
    private final By qtyInput = By.xpath("//input[@name='qty']");
    private final By qtyErrorMessage = By.xpath("//div[@for='qty']");
    private final By qtyInputGroupItem = By.xpath("//input[@title='Qty']");
    private final By pageErrorMessage = By.xpath("//div[@role='alert']/div/div");
    private final By updateCartButton = By.xpath("//button[@title='Update Cart']");
    private final By selectedSize = By.xpath("//div[@attribute-code='size']/span[2]");
    private final By selectedColor = By.xpath("//div[@attribute-code='color']/span[2]");
    private final By selectedBundleItemName = By.xpath("//div[@data-container='options']/div");
    private final By selectedBundleItemPrice = By.xpath("//span[@*='finalPrice']/span[@class='price']");
    private final By addToWishlistButton = By.xpath("//a[@class='action towishlist']");
    private final By addToCompareButton = By.xpath("//div[@class='product-addto-links']/a[@class='action tocompare']");
    private final By groupItemName = By.xpath("//td/strong[@class='product-item-name']");
    private final By qtyInputErrorGroupItem = By.xpath("//div[@class='mage-error']");
    private final By sku = By.xpath("//div[@itemprop='sku']");
    private final By warningMessage = By.xpath("//div[@class='message-notice notice message']/div");
    private final By ratingRate = By.xpath("//div[@class='rating-result']/span/span/span");
    private final By reviewsQty = By.xpath("//a[@class='action view']/span");

    //-----------------isDisplayed-----------------

    @Step("Check if Size button is displayed")
    public boolean sizeButtonIsDisplayed() {
        return isElementVisible(sizeButton);
    }

    @Step("Check if Color button is displayed")
    public boolean colorButtonIsDisplayed() {
        return isElementVisible(colorButton);
    }

    @Step("Check if price/prices is displayed")
    public boolean priceIsDisplayed() {
        if ($(minPriceInfo).isDisplayed()) {
            return isElementVisible(minPriceInfo, maxPriceInfo);
        } else {
            if ($(groupItemPrice).isDisplayed()) {
                return isElementVisible(By.id((groupItemPrice + "[1]")), By.id((groupItemPrice + "[2]")), By.id((groupItemPrice + "[3]")));
            }
        }
        return isElementVisible(priceInfo);
    }

    @Step("Check if Product name is displayed")
    public boolean productNameIsDisplayed() {
        return isElementVisible(productName);
    }

    @Step("Check if Bundle items dropdown is displayed")
    public boolean bundleItemsDropdownIsDisplayed() {
        return isElementVisible(bundleItemsDropdown);
    }

    @Step("Check if product image is displayed")
    public boolean productImageIsDisplayed() {
        waitForElementVisible(productImage);
        return isElementVisible(productImage);
    }

    @Step("Check if Customize and Add to Cart button is displayed")
    public boolean customizeATCButtonIsDisplayed() {
        return isElementVisible(customizeATCButton);
    }

    @Step("Check if image/name/price/size/color/qty field are displayed on Simple product page")
    public void mainElementsIsDisplayedSimpleAsserts() {
        assertTrue(productImageIsDisplayed());
        assertTrue(productNameIsDisplayed());
        assertTrue(priceIsDisplayed());
        assertTrue(sizeButtonIsDisplayed());
        assertTrue(colorButtonIsDisplayed());
        assertTrue(qtyInputIsDisplayed());
    }

    @Step("Check if image/name/price/item option dropdown/qty field are displayed on Bundle product page")
    public void mainElementsIsDisplayedBundleAsserts() {
        assertTrue(productImageIsDisplayed());
        assertTrue(productNameIsDisplayed());
        assertTrue(priceIsDisplayed());
        waitForElementVisible(qtyInput);
        bundleItemsDropdownIsDisplayed();
        assertTrue(qtyInputIsDisplayed());
    }

    @Step("Check if image/name/price/item option dropdown/qty field are displayed on Group product page")
    public void mainElementsIsDisplayedGroupAsserts() {
        assertTrue(productImageIsDisplayed());
        assertTrue(productNameIsDisplayed());
        assertEquals($$(groupItemName).size(), 3);
        assertEquals($$(groupItemPrice).size(), 3);
        assertEquals($$(qtyInputGroupItem).size(), 3);
    }

    //-----------------Set/Select-----------------

    @Step("Set Qty field with {itemQty}")
    public void setQtyInput(String itemQty) {
        jsType(itemQty, qtyInput);
    }

    @Step("Set Qty field for group number {index} with {itemQty}")
    public void setQtyInputGroupItem(Integer index, String itemQty) {
        By locator = By.id(("(" + qtyInputGroupItem + ")[" + index + "]"));
        jsType(itemQty, locator);
    }

    @Step("Select first color option")
    public void selectColor() {
        click(colorButton);
    }

    @Step("Select color by {index}")
    public void selectColorByIndex(int index) {
        clickElementByIndex(colorButton, index);
    }

    @Step("Select {option} in Bundle item dropdown")
    public void selectBundleItem(String option) {
        selectOption(option, bundleItemsDropdown);
    }

    @Step("Select size by {index}")
    public void selectSizeByIndex(int index) {
        clickElementByIndex(sizeButton, index);
    }

    //-----------------Click-----------------

    @Step("Select first size option")
    public void selectSize() {
        click(sizeButton);
    }

    @Step("Click Add to Cart button")
    public void clickAddToCartButton() {
        click(addToCartButton);
        waitForElementEnabled(addToCartButton);
    }

    @Step("Click Shopping Cart link")
    public ShoppingCartPage clickShoppingCartLink() {
        click(shoppingCartLink);
        return new ShoppingCartPage();
    }

    @Step("Click Customize and Add to Cart button")
    public void clickCustomizeATCButton() {
        click(customizeATCButton);
    }

    @Step("Click Update cart button")
    public ShoppingCartPage clickUpdateCartButton() {
        click(updateCartButton);
        return new ShoppingCartPage();
    }

    @Step("Click Add to Wishlist button as logged-in user")
    public MyWishListPage clickAddToWishlistButtonAsUser() {
        click(addToWishlistButton);
        return new MyWishListPage();
    }

    @Step("Click Add to wishlist button as guest user")
    public LoginPage clickAddToWishlistButtonByIndexAsGuest() {
        click(addToWishlistButton);
        return new LoginPage();
    }

    @Step("Click Add to Wishlist button as guest")
    public LoginPage clickAddToWishlistButtonAsGuest() {
        click(addToWishlistButton);
        return new LoginPage();
    }

    @Step("Click Add to Compare button")
    public void clickAddToCompareButton() {
        click(addToCompareButton);
    }

    @Step("Click Comparison list link")
    public CompareProductsPage clickComparisonListLink() {
        click(comparisonListLink);
        return new CompareProductsPage();
    }

    //-----------------Get-----------------

    @Step("Get Stock info message text")
    public String getStockInfo() {
        return getElementText(stockInfo);
    }

    @Step("Get success info message text")
    public String getSuccessMessage() {
        return getElementText(successMessage);
    }

    @Step("Get error message text if Bundle item isn't selected")
    public String getBundleItemErrorMessage() {
        return getElementText(bundleItemErrorMessage);
    }

    @Step("Get error message text if Color option isn't selected")
    public String getColorErrorMessage() {
        return getElementText(colorErrorMessage);
    }

    @Step("Get error message text if Size option isn't selected")
    public String getSizeErrorMessage() {
        return getElementText(sizeErrorMessage);
    }

    @Step("Check if Qty field is displayed")
    public boolean qtyInputIsDisplayed() {
        return isElementVisible(qtyInput);
    }

    @Step("Get error message text if Qty field is filled with invalid data")
    public String getQtyErrorMessage() {
        return getElementText(qtyErrorMessage);
    }

    @Step("Get page error text")
    public String getPageError() {
        return getElementText(pageErrorMessage);
    }

    @Step("Get Product name text")
    public String getProductName() {
        return getElementText(productName);
    }

    @Step("Get Product price value")
    public String getProductPrice() {
        return getElementText(priceInfo);
    }

    @Step("Get Product SKU value")
    public String getProductSku() {
        return getElementText(sku);
    }

    @Step("Get item qty value")
    public String getItemQty() {
        return getElementAttributeValue("value", qtyInput);
    }

    @Step("Get selected Size value")
    public String getSelectedSize() {
        return getElementText(selectedSize);
    }

    @Step("Get selected Color value")
    public String getSelectedColor() {
        return getElementText(selectedColor);
    }

    @Step("Get selected Bundle item name")
    public String getSelectedBundleItemName() {
        scrollToPlaceElementInCenter(selectedBundleItemName);
        return getElementText(selectedBundleItemOption);
    }

    @Step("Get selected Bundle item price")
    public String getSelectedBundleItemPrice() {
        return getElementText(selectedBundleItemPrice);
    }

    @Step("Get group item name by {index}")
    public String getGroupItemName(int index) {
        return getElementTextByIndex(groupItemName, index);
    }

    @Step("Get group item price by {index}")
    public String getGroupItemPrice(int index) {
        return getElementTextByIndex(groupItemPrice, index);
    }

    @Step("Get group item qty by {index}")
    public String getGroupItemQty(int index) {
        return getElementAttributeValueByIndex("value", index, qtyInputGroupItem);
    }

    @Step("Get error text for group item Qty input")
    public String getInputError() {
        return getElementText(qtyInputErrorGroupItem);
    }

    @Step("Get warning info message text")
    public String getWarningMessageText() {
        return getElementText(warningMessage);
    }

    @Step("Get item rating rate value")
    public String getRatingRateValue() {
        return getElementText(ratingRate);
    }

    @Step("Get item Reviews value")
    public String getReviewsValue() {
        return getElementText(reviewsQty);
    }

    //-----------------Others-----------------

    @Step("Wait the Success info message displaying")
    public void waitForSuccessMessage() {
        waitForElementVisible(successMessage);
    }

    @Step("Get relevant error for case {errorMethod}")
    public String getErrorUsingMethod(String errorMethod) {
        switch (errorMethod) {
            case "getPageError":
                return Pages.productPage().getPageError();
            case "getInputError":
                return Pages.productPage().getInputError();
            default:
                throw new IllegalArgumentException("Unknown error method: " + errorMethod);
        }
    }

}
