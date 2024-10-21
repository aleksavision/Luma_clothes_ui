package pages.carts;

import org.openqa.selenium.By;
import tools.PageTools;

public class CheckoutSuccessPage extends PageTools {

    private final By successMessage = By.xpath("//html/body/div[1]/main/div[1]/h1/span");
    private final By orderNumber = By.xpath("//div[@class='checkout-success']/p/span");

    public String getSuccessMessage(){
        return getElementText(successMessage);
    }
    public String getOrderNumber(){
        return getElementText(orderNumber);
    }

}
