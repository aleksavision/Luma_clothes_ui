package pages.carts;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import pages.Homepage;
import pages.pdp.ProductPage;
import tools.PageTools;

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
    private final By countryDropdown = By.xpath("//select[@name='country_id']");
    private final By stateDropdown = By.xpath("//select[@name='region_id']");
    private final By postalCodeInput = By.xpath("//input[@name='postcode']");
    private final By tableRateRadiobutton = By.xpath("//input[@value='tablerate_bestway']");
    private final By fixedRadiobutton = By.xpath("//input[@value='flatrate_flatrate']");
    private final By shippingRateAmount = By.xpath("//span[@data-th='Shipping']");
    private final By shippingRateInfo = By.xpath("//span[@class='value']");
    private final By postalCodeInputError = By.xpath("//div[@class='message warning']/span");
    private final By estimateShippingTaxLink = By.xpath("//strong[@id='block-shipping-heading']");


    @Step("Click Proceed to Checkout button")
    public CheckoutShippingPage clickProceedToCheckoutButton(){
        click(proceedToCheckoutButton);
        return new CheckoutShippingPage();
    }
    @Step("Click Estimate Shipping and Tax link")
    public void clickEstimateShippingTaxLink(){
        click(estimateShippingTaxLink);
    }
    @Step("Check if Total amount is displayed")
    public boolean totalAmountIsDisplayed(){
        waitForElementVisible(orderTotalValue);
        return isElementVisible(orderTotalValue);
    }
    @Step("Get item qty")
    public String getItemQty(){
        return getElementAttributeValue("value", qtyInput);
    }
    @Step("Get item number {index} qty")
    public String getItemQtyByIndex(Integer index){
        return getElementAttributeValueByIndex("value",index,  qtyInput);
    }
    @Step("Click Remove item button")
    public void clickRemoveItemButton(){
        click(removeItemButton);
    }
    @Step("Get item name")
    public String getItemName(){
        return getElementText(itemName);
    }
    @Step("Get item size")
    public String getItemSize(){
        return getElementText(itemSizeValue);
    }
    @Step("Get item color")
    public String getItemColor(){
        return getElementText(itemColor);
    }
    @Step("Get item price")
    public String getItemPrice(){
        return getElementText(itemPrice);
    }
    @Step("Get item price by {index}")
    public String getItemPriceByIndex(int index){
        return getElementTextByIndex(itemPrice, index);
    }
    @Step("Get item Subtotal value")
    public String getItemSubtotal(){
        return getElementText(itemSubtotal);
    }
    @Step("Get item Subtotal value by {index}")
    public String getItemSubtotalByIndex(int index, String text) {
        waitForElementHasUntilByIndex(itemSubtotal, index, text,3);
        return getElementTextByIndex(itemSubtotal, index);
    }
    @Step("Get order Subtotal value")
    public String getOrderSubtotal(){
        return getElementText(orderSubtotalValue);
    }
    @Step("Get order Tax value")
    public String getOrderTax(){
        return getElementText(orderTaxValue);
    }
    @Step("Set new item qty")
    public void setItemQtyInput(String qty){
        jsType(qty, qtyInput);
    }
    @Step("Click Update Shopping Cart button")
    public void clickUpdateCartButton(){
        click(updateCartButton);
    }
    @Step("Get order Total value")
    public String getOrderTotal(){
        return getElementText(orderTotalValue);
    }
    @Step("Set new item {qty} by {index}")
    public void setItemQtyInputByIndex(int index, String qty) {
        jsTypeByIndex(qty, index, qtyInput);
    }
    @Step("Click Edit button by {index}")
    public ProductPage clickEditButton(int index){
        clickElementByIndex(editButton, index);
        return new ProductPage();
    }
    @Step("Get added item size by {index}")
    public String getItemSizeValueByIndex(int index){
        return getElementTextByIndex(itemSizeValue, index);
    }
    @Step("Get page title")
    public String getPageTitle(){
        return getElementText(pageTitle);
    }
    @Step("Get success info message text")
    public String getSuccessInfoMessage(){
        return getElementText(successInfoMessage);
    }
    @Step("Get item name by {index}")
    public String getItemNameByIndex(int index){
        return getElementTextByIndex(itemName, index);
    }
    @Step("Get empty cart info message")
    public String getEmptyCartInfoText(){
        return getElementText(emptyCartInfo);
    }
    @Step("Click here link")
    public Homepage clickHereLink(){
        click(hereLink);
        return new Homepage();
    }
    @Step("Check if Discount title is displayed")
    public boolean discountTitleIsDisplayed(){
        return isElementVisible(discountTitle);
    }
    @Step("Get discount amount value")
    public String getDiscountAmount(){
        return getElementText(discountAmount);
    }
    @Step("Get error info message text")
    public String getErrorInfoMessage(){
        return getElementText(errorInfoMessage);
    }
    @Step("Get Discount input error text")
    public String getDiscountInputError(){
        return getElementText(discountInputError);
    }
    @Step("Click Apply discount button")
    public void clickApplyDiscountButton(){
        click(applyDiscountButton);
    }
    @Step("Click Apply discount code link")
    public void clickApplyDiscountCodeLink(){
        click(applyDiscountCodeLink);
    }
    @Step("Set Discount code input with {couponCode}")
    public void setDiscountCodeInput(String couponCode){
        type(discountInput, couponCode);
    }
    @Step("Select Best way - Table Rate shipping input")
    public void selectTableRateRadiobutton(){
        click(tableRateRadiobutton);
    }
    @Step("Select Flat Rate - fixed shipping input")
    public void selectFixedRadiobutton(){
        click(fixedRadiobutton);
    }
    @Step("Get Shipping rate info text")
    public String getShippingRateInfo(){
        return getElementText(shippingRateInfo);
    }
    @Step("Get Shipping rate amount")
    public String getShippingRateAmount(){
        return getElementText(shippingRateAmount);
    }
    @Step("Select {option} in State dropdown")
    public void selectStateDropdown(String option){
        selectOption(option, stateDropdown);
    }
    @Step("Select {option} in Country dropdown")
    public void selectCountryDropdown(String option){
        selectOption(option, countryDropdown);
    }
    @Step("Fill Postal code field with {postalCode}")
    public void setPostalCodeInput(String postalCode){
        clearText(postalCodeInput);
        type(postalCodeInput, postalCode);
    }
    @Step("Get Postal code input error")
    public String getPostalCodeInputError(){
        return getElementText(postalCodeInputError);
    }
}
