package pages.userPages;

import org.openqa.selenium.By;
import tools.PageTools;

public class SuccessLogoutPage extends PageTools {

    private final By successMessage = By.xpath("//span[@class='base']");

    public String getSuccessMessage(){
        return getElementText(successMessage);
    }





    //http://46.101.147.48/customer/account/logoutSuccess/
}
