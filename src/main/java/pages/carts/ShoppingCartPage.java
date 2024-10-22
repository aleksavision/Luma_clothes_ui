package pages.carts;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import pages.Pages;
import tools.PageTools;

public class ShoppingCartPage extends PageTools {

    private final By proceedToCheckoutButton = By.xpath("//button[@data-role='proceed-to-checkout']");
    private final By totalAmount = By.xpath("//strong/span[@class='price']");
    private final By qtyInput = By.xpath("//input[@title='Qty']");
    private final By removeItemButton = By.xpath("//a[@class='action action-delete']");

    @Step("Click Proceed to Checkout button")
    public CheckoutShippingPage clickProceedToCheckoutButton(){
        click(proceedToCheckoutButton);
        return new CheckoutShippingPage();
    }
    @Step("Check if Total amount is displayed")
    public boolean totalAmountIsDisplayed(){
        waitForElementVisible(totalAmount);
        return isElementVisible(totalAmount);
    }
    @Step("Check item qty")
    public String getItemQty(){
        return getElementAttributeValue("value", qtyInput);
    }
    /**
     *
     * @param index Starts from 1
     */
    @Step("Check item number {index} qty")
    public String getAnyItemQty(Integer index){
        By locator = By.id(("(" + qtyInput + ")[" + index + "]"));
        return getElementAttributeValue("value", locator);
    }
    @Step("Click Remove item button")
    public void clickRemoveItemButton(){
        click(removeItemButton);
    }

}
