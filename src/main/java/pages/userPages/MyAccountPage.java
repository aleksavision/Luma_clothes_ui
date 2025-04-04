package pages.userPages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import pages.Pages;
import tools.PageTools;

public class MyAccountPage extends PageTools {

    private final By successRegisterMessage = By.xpath("//div[@role='alert']/div/div");

    @Step("Check success registration message text")
    public String getSuccessRegisterMessage() {
        jsSetAttributeValue("display", successRegisterMessage, "none");
        return getElementText(successRegisterMessage);
    }

}
