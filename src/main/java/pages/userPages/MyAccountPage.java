package pages.userPages;

import org.openqa.selenium.By;
import pages.Pages;
import tools.PageTools;

public class MyAccountPage extends PageTools {

    private final By successRegisterMessage = By.xpath("//div[@role='alert']/div/div");

    public String getSuccessRegisterMessage(){
        jsSetAttributeValue("display", successRegisterMessage, "none");
        return getElementText(successRegisterMessage);
    }
    public SuccessLogoutPage clickSignOutLink(){
        Pages.header().clickSignOutLink();
        return new SuccessLogoutPage();
    }

}
