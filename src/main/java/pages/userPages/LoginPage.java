package pages.userPages;

import org.openqa.selenium.By;
import pages.Homepage;
import tools.PageTools;

public class LoginPage extends PageTools {

    private final By fieldset = By.tagName("fieldset");
    private final By emailInput = By.id("email");
    private final By passwordInput = By.id("pass");
    private final By signInButton = By.xpath("//button[@name='send']");
    private final By emailLabel = By.xpath(".//label[@for='email']/span");
    private final By passwordLabel = By.xpath(".//label[@for='pass']/span");
    private final By forgetPasswordLink = By.xpath(".//a[@class='action remind']");
    private final By createAnAccountButton = By.xpath("//a[@class='action create primary']");

    public void setEmailInput(String email){
        typeIntoElementInFieldset(fieldset, emailInput, email);
    }
    public void setPasswordInput(String password){
        typeIntoElementInFieldset(fieldset, passwordInput, password);
    }
    public Homepage clickSignInButton(){
        click(signInButton);
        return new Homepage();
    }
    public boolean emailLabelIsDisplayed(){
        return isElementInFieldsetVisible(fieldset, emailLabel);
    }
    public boolean passwordLabelIsDisplayed(){
        return isElementInFieldsetVisible(fieldset, passwordLabel);
    }
    public boolean forgetPasswordLinkIsDisplayed(){
        return isElementInFieldsetVisible(fieldset, forgetPasswordLink);
    }
    public boolean createAnAccountButtonIsDisplayed(){
        return isElementVisible(createAnAccountButton);
    }

}
