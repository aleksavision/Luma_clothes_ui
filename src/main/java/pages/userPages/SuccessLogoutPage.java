package pages.userPages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import tools.PageTools;

public class SuccessLogoutPage extends PageTools {

    private final By successMessage = By.xpath("//span[@class='base']");

    @Step("Check success logout message text")
    public String getSuccessMessage() {
        return getElementText(successMessage);
    }


    //http://46.101.147.48/customer/account/logoutSuccess/
}
