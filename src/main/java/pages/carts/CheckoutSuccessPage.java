package pages.carts;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import pages.Homepage;
import tools.PageTools;

public class CheckoutSuccessPage extends PageTools {

    private final By successMessageTitle = By.xpath("//html/body/div[1]/main/div[1]/h1/span");
    private final By successMessageText = By.xpath("//div[@class='checkout-success']");
    private final By orderNumber = By.xpath("//div[@class='checkout-success']/p/span");
    private final By continueShoppingButton = By.xpath("//a[@class='action primary continue']");

    @Step("Check success message text")
    public String getSuccessMessage() {
        return getElementText(successMessageTitle);
    }

    @Step("Check success message text")
    public String getSuccessMessageText() {
        return getElementText(successMessageText);
    }

    @Step("Check created order number")
    public String getOrderNumber() {
        return getElementText(orderNumber);
    }

    @Step("Click Continue Shopping button")
    public Homepage clickContinueShoppingButton() {
        click(continueShoppingButton);
        return new Homepage();
    }

}
