package pages.userPages;

import org.openqa.selenium.By;
import pages.Pages;
import tools.PageTools;

import static org.testng.Assert.assertTrue;
import static pages.Pages.homepage;

public class RegisterPage extends PageTools {

    private final By fieldsetPersonalInfo = By.xpath("//fieldset[@class='fieldset create info']");
    private final By fieldsetSignInInfo = By.xpath("//fieldset[@class='fieldset create account']");
    private final By firstNameInput = By.id("firstname");
    private final By lastNameInput = By.id("lastname");
    private final By emailInput = By.id("email_address");
    private final By passwordInput = By.id("password");
    private final By confirmPasswordInput = By.id("password-confirmation");
    private final By createAnAccountButton = By.xpath("//button[@class='action submit primary']");
    private final By firstNameLabel = By.xpath(".//label[@for='firstname']/span");
    private final By lastNameLabel = By.xpath(".//label[@for='lastname']/span");
    private final By newsletterLabel = By.xpath(".//label[@for='is_subscribed']/span");
    private final By emailLabel = By.xpath(".//label[@for='email_address']/span");
    private final By passwordLabel = By.xpath(".//label[@for='password']/span");
    private final By confirmPasswordLabel = By.xpath(".//label[@for='password-confirmation']/span");
    private final By firstNameErrorMessage = By.xpath("//div[@for='firstname']");
    private final By lastNameErrorMessage = By.xpath("//div[@for='lastname']");
    private final By emailErrorMessage = By.xpath("//div[@for='email_address']");
    private final By passwordErrorMessage = By.xpath("//div[@for='password']");
    private final By confirmPasswordErrorMessage = By.xpath("//div[@for='password-confirmation']");

    public void setFirstNameInput(String firstName){
        typeIntoElementInFieldset(fieldsetPersonalInfo, firstNameInput, firstName);
    }
    public void setLastNameInput(String lastName){
        typeIntoElementInFieldset(fieldsetPersonalInfo, lastNameInput, lastName);
    }
    public void setEmailInput(String email){
        typeIntoElementInFieldset(fieldsetSignInInfo, emailInput, email);
    }
    public void setPasswordInput(String password){
        typeIntoElementInFieldset(fieldsetSignInInfo, passwordInput, password);
    }
    public void setConfirmPasswordInput(String password){
        typeIntoElementInFieldset(fieldsetSignInInfo, confirmPasswordInput, password);
    }
    public MyAccountPage clickCreateAnAccountButton(){
        click(createAnAccountButton);
        return new MyAccountPage();
    }
    public boolean firstNameLabelIsDisplayed(){
        return isElementInFieldsetVisible(fieldsetPersonalInfo, firstNameLabel);
    }
    public boolean lastNameLabelIsDisplayed(){
        return isElementInFieldsetVisible(fieldsetPersonalInfo, lastNameLabel);
    }
    public boolean newsletterLabelIsDisplayed(){
        return isElementInFieldsetVisible(fieldsetPersonalInfo, newsletterLabel);
    }
    public boolean emailLabelIsDisplayed(){
        return isElementInFieldsetVisible(fieldsetSignInInfo, emailLabel);
    }
    public boolean passwordLabelIsDisplayed(){
        return isElementInFieldsetVisible(fieldsetSignInInfo, passwordLabel);
    }
    public boolean confirmPasswordLabelIsDisplayed(){
        return isElementInFieldsetVisible(fieldsetSignInInfo, confirmPasswordLabel);
    }
    public boolean createAnAccountButtonIsDisplayed(){
        return isElementVisible(createAnAccountButton);
    }
    public String getFirstNameErrorMessage(){
        return getElementText(firstNameErrorMessage);
    }
    public String getLastNameErrorMessage(){
        return getElementText(lastNameErrorMessage);
    }
    public String getEmailErrorMessage(){
        return getElementText(emailErrorMessage);
    }
    public String getPasswordErrorMessage(){
        return getElementText(passwordErrorMessage);
    }
    public String getConfirmPasswordErrorMessage(){
        return getElementText(confirmPasswordErrorMessage);
    }
    public void allFieldsCtaAsserts(){
        assertTrue(Pages.registerPage().firstNameLabelIsDisplayed());
        assertTrue(Pages.registerPage().lastNameLabelIsDisplayed());
        assertTrue(Pages.registerPage().newsletterLabelIsDisplayed());
        assertTrue(Pages.registerPage().emailLabelIsDisplayed());
        assertTrue(Pages.registerPage().passwordLabelIsDisplayed());
        assertTrue(Pages.registerPage().confirmPasswordLabelIsDisplayed());
        assertTrue(Pages.registerPage().createAnAccountButtonIsDisplayed());
    }


}
