package pages.carts;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import tools.PageTools;

import static com.codeborne.selenide.Selenide.sleep;

public class ShoppingCartPage extends PageTools {

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
    private final By ggg = By.xpath("//tr[@class='grand totals']");


    @Step("Click Proceed to Checkout button")
    public CheckoutShippingPage clickProceedToCheckoutButton(){
        click(proceedToCheckoutButton);
        return new CheckoutShippingPage();
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
    /**
     *
     * @param index Starts from 1
     */
    @Step("Get item number {index} qty")
    public String getItemByIndexQty(Integer index){
        By locator = By.id(("(" + qtyInput + ")[" + index + "]"));
        return getElementAttributeValue("value", locator);
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
        return getElementText(itemSize);
    }
    @Step("Get item color")
    public String getItemColor(){
        return getElementText(itemColor);
    }
    @Step("Get item price")
    public String getItemPrice(){
        return getElementText(itemPrice);
    }
    @Step("Get item Subtotal value")
    public String getItemSubtotal(){
        return getElementText(itemSubtotal);
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
        sleep(3000);
        return getElementText(orderTotalValue);
    }


}
