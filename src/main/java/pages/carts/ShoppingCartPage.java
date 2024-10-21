package pages.carts;

import org.openqa.selenium.By;
import tools.PageTools;

public class ShoppingCartPage extends PageTools {

    private final By proceedToCheckoutButton = By.xpath("//button[@data-role='proceed-to-checkout']");
    private final By totalAmount = By.xpath("//strong/span[@class='price']");
    private final By qtyInput = By.xpath("//input[@title='Qty']");

    public CheckoutShippingPage clickProceedToCheckoutButton(){
        click(proceedToCheckoutButton);
        return new CheckoutShippingPage();
    }
    public boolean totalAmountIsDisplayed(){
        waitForElementVisible(totalAmount);
        return isElementVisible(totalAmount);
    }
    public String getItemQty(){
        return getElementAttributeValue("value", qtyInput);
    }

}
