package pages.carts;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import pages.Homepage;
import pages.ProductPage;
import tools.PageTools;

import static com.codeborne.selenide.Selenide.$;

public class ShoppingCartPage extends PageTools {

    private final By pageTitle = By.xpath("//h1/span");
    private final By proceedToCheckoutButton = By.xpath("//button[@data-role='proceed-to-checkout']");
    private final By qtyInput = By.xpath("//input[@title='Qty']");
    private final By removeItemButton = By.xpath("//a[@class='action action-delete']");
    private final By itemName = By.xpath("//td/div/strong/a");
    private final By itemSize = By.xpath("//div/dl[@class='item-options']/dd[1]");
    private final By itemColor = By.xpath("//div/dl[@class='item-options']/dd[2]");
    private final By itemPrice = By.xpath("//td[@class='col price']/span/span/span");
    private final By itemSubtotal = By.xpath("//td[@class='col subtotal']/span/span/span");
    private final By orderSubtotalValue = By.xpath("//span[@data-th='Subtotal']");
    private final By orderTaxValue = By.xpath("//td[@data-th='Tax']/span");
    private final By orderEstimatedTaxValue = By.xpath("//span[@data-th='Shipping']");
    private final By updateCartButton = By.xpath("//button[@title='Update Shopping Cart']");
    private final By orderTotalValue = By.xpath("//strong/span[@class='price']");
    private final By editButton = By.xpath("//a[@class='action action-edit']");
    private final By itemSizeValue = By.xpath("//*[@id='shopping-cart-table']/tbody/tr[1]/td[1]/div/dl/dd[1]");
    private final By itemThumbnail = By.xpath("//td[@class='col item']/a/span/span/img");
    private final By successInfoMessage = By.xpath("//div[@class='message-success success message']/div");
    private final By errorInfoMessage = By.xpath("//div[@class='message-error error message']/div");
    private final By emptyCartInfo = By.xpath("//div[@class='cart-empty']");
    private final By hereLink = By.xpath("//div[@class='cart-empty']/p/a");
    private final By discountTitle = By.xpath("//span[@class='title']");
    private final By discountAmount = By.xpath("//td/span/span[@class='price']");
    private final By applyDiscountCodeLink = By.xpath("//strong[@id='block-discount-heading']");
    private final By discountInput = By.xpath("//input[@name='coupon_code']");
    private final By applyDiscountButton = By.xpath("//button[@class='action apply primary']");
    private final By discountInputError = By.xpath("//div[@id='coupon_code-error']");
    private final By discountPageError = By.xpath("//div[@role='alert']/div/div");
    private final By countryDropdown = By.xpath("//select[@name='country_id']");
    private final By stateDropdown = By.xpath("//select[@name='region_id']");
    private final By postalCodeInput = By.xpath("//input[@name='postcode']");
    private final By tableRateRadiobutton = By.xpath("//input[@value='tablerate_bestway']");
    private final By fixedRadiobutton = By.xpath("//input[@value='flatrate_flatrate']");
    private final By shippingRateAmount = By.xpath("//span[@data-th='Shipping']");
    private final By shippingRateInfo = By.xpath("//span[@class='value']");
    private final By postalCodeInputError = By.xpath("//div[@class='message warning']/span");
    private final By estimateShippingTaxLink = By.xpath("//strong[@id='block-shipping-heading']");
    private final By discountSummaryInfo = By.xpath("//tr[@class='totals']/th");
    private final By discountSummaryAmount = By.xpath("//tr[@class='totals']/td/span/span");
    private final By shippingLoader = By.xpath("//div[@class='loading-mask']");
    private final By orderLoader = By.xpath("//div[@data-role='loader']");
    private final By additionalProductName = By.xpath("//a[@class='product-item-link']");
    private final By additionalProductPrice = By.xpath("//div[@class='price-box price-final_price']/span/span/span");
    private final By additionalAddToCartButton = By.xpath("//button[@title='Add to Cart']");


    //--------------isDisplayed---------------

    @Step("Check if Discount info is displayed in Order Summary")
    public boolean checkDiscountInfoDisplayed() {
        return isElementVisible(discountSummaryInfo);
    }

    @Step("Check if Total amount is displayed")
    public boolean totalAmountIsDisplayed() {
        waitForElementVisible(orderTotalValue);
        return isElementVisible(orderTotalValue);
    }

    @Step("Check if Discount title is displayed")
    public boolean discountTitleIsDisplayed() {
        return isElementVisible(discountTitle);
    }

    @Step("Check if Table Rate radiobutton isn't displayed")
    public boolean isTableRateNotDisplayed() {
        return !isElementVisible(tableRateRadiobutton);
    }

    //--------------Get---------------

    @Step("Get item qty")
    public String getItemQty() {
        return getElementAttributeValue("value", qtyInput);
    }

    @Step("Get item number {index} qty")
    public String getItemQtyByIndex(Integer index) {
        return getElementAttributeValueByIndex("value", index, qtyInput);
    }

    @Step("Get item name")
    public String getItemName() {
        return getElementText(itemName);
    }

    @Step("Get item size")
    public String getItemSize() {
        return getElementText(itemSizeValue);
    }

    @Step("Get item color")
    public String getItemColor() {
        return getElementText(itemColor);
    }

    @Step("Get item price")
    public String getItemPrice() {
        return getElementText(itemPrice);
    }

    @Step("Get item price by {index}")
    public String getItemPriceByIndex(int index) {
        return getElementTextByIndex(itemPrice, index);
    }

    @Step("Get item Subtotal value")
    public String getItemSubtotal() {
        $(orderTotalValue).shouldBe(Condition.appear);
        return getElementText(itemSubtotal);
    }

    //    @Step("Get item Subtotal value by {index}")
//    public String getItemSubtotalByIndex(int index) {
//        waitForElementUntilByIndex(itemSubtotal, index, 5);
//        return getElementTextByIndex(itemSubtotal, index);
//    }

    @Step("Get item Subtotal value by {name}")
    public String getItemSubtotalByIndex(int index, String itemName) {
        $(orderTotalValue).shouldBe(Condition.appear);
        if (getItemNameByIndex(index).equals(itemName)) {
            return getElementTextByIndex(itemSubtotal, index);
        }
        return null;
    }

    @Step("Get order Subtotal value")
    public String getOrderSubtotal() {
        return getElementText(orderSubtotalValue);
    }

    @Step("Get order Tax value")
    public String getOrderTax() {
        waitForElementInvisibleUntil(shippingLoader, 3);
        return getElementText(orderTaxValue);
    }

    @Step("Get order Estimated Tax value")
    public String getEstimatedOrderTax() {
        waitForElementEnabled(orderEstimatedTaxValue);
        waitForElementInvisibleUntil(orderLoader, 5);
        return getElementText(orderEstimatedTaxValue);
    }

    @Step("Get added item size by {index}")
    public String getItemSizeValueByIndex(int index) {
        return getElementTextByIndex(itemSizeValue, index);
    }

    @Step("Get page title")
    public String getPageTitle() {
        return getElementText(pageTitle);
    }

    @Step("Get success info message text")
    public String getSuccessInfoMessage() {
        return getElementText(successInfoMessage);
    }

    @Step("Get item name by {index}")
    public String getItemNameByIndex(int index) {
        return getElementTextByIndex(itemName, index);
    }

    @Step("Get empty cart info message")
    public String getEmptyCartInfoText() {
        return getElementText(emptyCartInfo);
    }

    @Step("Get discount amount value")
    public String getDiscountAmount() {
        return getElementText(discountAmount);
    }

    @Step("Get error info message text")
    public String getErrorInfoMessage() {
        return getElementText(errorInfoMessage);
    }

    @Step("Get Discount input error text")
    public String getDiscountInputError() {
        return getElementText(discountInputError);
    }

    @Step("Get Discount page error text")
    public String getDiscountPageError() {
        return getElementText(discountPageError);
    }

    @Step("Get Shipping rate info text")
    public String getShippingRateInfo() {
        return getElementText(shippingRateInfo);
    }

    @Step("Get Shipping rate amount")
    public String getShippingRateAmount() {
        return getElementText(shippingRateAmount);
    }

    @Step("Get order Total value")
    public String getOrderTotal() {
        waitForElementInvisibleUntil(shippingLoader, 5);
//        $(orderTotalValue).shouldBe(Condition.appear);
        return getElementText(orderTotalValue);
    }

    @Step("Get Postal code input error")
    public String getPostalCodeInputError() {
        return getElementText(postalCodeInputError);
    }

    @Step("Get additional product name")
    public String getAdditionalProductName() {
        return getElementText(additionalProductName);
    }

    @Step("Get additional product price")
    public String getAdditionalProductPrice() {
        return getElementText(additionalProductPrice);
    }

    //--------------Click---------------

    @Step("Click Remove item button")
    public void clickRemoveItemButton() {
        click(removeItemButton);
    }

    @Step("Click Proceed to Checkout button")
    public CheckoutShippingPage clickProceedToCheckoutButton() {
        click(proceedToCheckoutButton);
        return new CheckoutShippingPage();
    }

    @Step("Click Estimate Shipping and Tax link")
    public void clickEstimateShippingTaxLink() {
        click(estimateShippingTaxLink);
    }

    @Step("Click Update Shopping Cart button")
    public void clickUpdateCartButton() {
        click(updateCartButton);
    }

    @Step("Click Edit button by {index}")
    public ProductPage clickEditButton(int index) {
        clickElementByIndex(editButton, index);
        return new ProductPage();
    }

    @Step("Click here link")
    public Homepage clickHereLink() {
        click(hereLink);
        return new Homepage();
    }

    @Step("Click Apply discount button")
    public void clickApplyDiscountButton() {
        click(applyDiscountButton);
    }

    @Step("Click Apply discount code link")
    public void clickApplyDiscountCodeLink() {
        click(applyDiscountCodeLink);
    }

    @Step("Click Add to Cart button for additional item")
    public void clickAdditionalAddToCartButton() {
        click(additionalAddToCartButton);
    }

    //--------------Set/Select---------------

    @Step("Set new item qty")
    public void setItemQtyInput(String qty) {
        jsType(qty, qtyInput);
    }

    @Step("Set new item {qty} by {index}")
    public void setItemQtyInputByIndex(int index, String qty) {
        jsTypeByIndex(qty, index, qtyInput);
    }

    @Step("Set Discount code input with {couponCode}")
    public void setDiscountCodeInput(String couponCode) {
        type(discountInput, couponCode);
    }

    @Step("Select Best way - Table Rate shipping input")
    public void selectTableRateRadiobutton() {
        click(tableRateRadiobutton);
    }

    @Step("Select Flat Rate - fixed shipping input")
    public void selectFixedRadioButton() {
        click(fixedRadiobutton);
    }

    @Step("Select {option} in State dropdown")
    public void selectStateDropdown(String option) {
        selectOption(option, stateDropdown);
    }

    @Step("Select {option} in Country dropdown")
    public void selectCountryDropdown(String option) {
        selectOption(option, countryDropdown);
    }

    @Step("Set Postal code field with {postalCode}")
    public void setPostalCodeInput(String postalCode) {
        clearText(postalCodeInput);
    }
}
