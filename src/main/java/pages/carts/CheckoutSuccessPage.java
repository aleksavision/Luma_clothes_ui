package pages.carts;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import tools.PageTools;

public class CheckoutSuccessPage extends PageTools {

    private final By successMessage = By.xpath("//html/body/div[1]/main/div[1]/h1/span");
    private final By orderNumber = By.xpath("//div[@class='checkout-success']/p/span");

    @Step("Check success message text")
    public String getSuccessMessage(){
        return getElementText(successMessage);
    }
    @Step("Check created order number")
    public String getOrderNumber(){
        return getElementText(orderNumber);
    }

}
