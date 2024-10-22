package pages.carts;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import tools.PageTools;

public class CheckoutPaymentPage extends PageTools {

    private final By placeOrderButton = By.xpath("//button[@class='action primary checkout']");
    private final By totalAmount = By.xpath("//strong/span[@class='price']");

    @Step("Click Place Order button")
    public CheckoutSuccessPage clickPlaceOrderButton(){
        click(placeOrderButton);
        return new CheckoutSuccessPage();
    }
    @Step("Check if Total amount is displayed")
    public boolean totalAmountIsDisplayed(){
        waitForElementVisible(totalAmount);
        return isElementVisible(totalAmount );
    }

}
