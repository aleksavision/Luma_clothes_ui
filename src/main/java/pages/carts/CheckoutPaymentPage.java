package pages.carts;

import org.openqa.selenium.By;
import tools.PageTools;

public class CheckoutPaymentPage extends PageTools {

    private final By placeOrderButton = By.xpath("//button[@class='action primary checkout']");
    private final By totalAmount = By.xpath("//strong/span[@class='price']");

    public CheckoutSuccessPage clickPlaceOrderButton(){
        click(placeOrderButton);
        return new CheckoutSuccessPage();
    }
    public boolean totalAmountIsDisplayed(){
        waitForElementVisible(totalAmount);
        return isElementVisible(totalAmount );
    }

}
