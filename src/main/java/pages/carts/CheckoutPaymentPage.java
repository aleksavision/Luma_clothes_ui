package pages.carts;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import tools.PageTools;

public class CheckoutPaymentPage extends PageTools {

    private final By placeOrderButton = By.xpath("//button[@class='action primary checkout']");
    private final By totalAmount = By.xpath("//strong/span[@class='price']");
    private final By orderTotalValue = By.xpath("//strong/span[@class='price']");
    private final By openOrderSummaryButton = By.xpath("//div[@class='title']");
    private final By itemName = By.xpath("//strong[@class='product-item-name']");
    private final By itemQty = By.xpath("//span[@class='value']");
    private final By itemPrice = By.xpath("//span[@class='cart-price']/span");
    private final By viewDetailsLink = By.xpath("//span[@data-role='title']");
    private final By itemSize = By.xpath("//dd[@class='values'][1]");
    private final By itemColor = By.xpath("//dd[@class='values'][2]");
    private final By shipToInfoBox = By.xpath("//div[@class='ship-to']/div[@class='shipping-information-content']");
    private final By shippingMethodInfoBox = By.xpath("//div[@class='shipping-information-content']/span[@class='value']");

    @Step("Click Place Order button")
    public CheckoutSuccessPage clickPlaceOrderButton(){
        click(placeOrderButton);
        return new CheckoutSuccessPage();
    }
    @Step("Check if Total amount is displayed")
    public boolean totalAmountIsDisplayed(){
        waitForElementVisible(totalAmount);
        return isElementVisible(totalAmount);
    }
    @Step("Get order Total value")
    public String getOrderTotal(){
        return getElementText(orderTotalValue);
    }
    @Step("Click View Details link")
    public void clickViewDetailsLink(){
        click(viewDetailsLink);
    }
    @Step("Get item name by {index}")
    public String getItemNameByIndex(int index){
//        waitForElementVisibleUntil(itemName, 5);
        return  getElementTextByIndex(itemName, index);
    }
    @Step("Get item price by {index}")
    public String getItemPriceByIndex(int index){
        return  getElementTextByIndex(itemPrice, index);
    }
    @Step("Get item size by {index}")
    public String getItemSizeByIndex(int index){
        return  getElementTextByIndex(itemSize, index);
    }
    @Step("Get item color by {index}")
    public String getItemColorByIndex(int index){
        return  getElementTextByIndex(itemColor, index);
    }
    @Step("Get Ship To info text")
    public String getShipToInfoBoxText(){
        return getElementText(shipToInfoBox);
    }
    @Step("Get Shipping Method info text")
    public String getShippingMethodInfoBox(){
        return getElementText(shippingMethodInfoBox);
    }


}
