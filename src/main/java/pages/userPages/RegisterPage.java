package pages.userPages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import tools.PageTools;

import static org.testng.Assert.assertTrue;

public class RegisterPage extends PageTools {

    private final By fieldsetPersonalInfo = By.xpath("//fieldset[@class='fieldset create info']");
    private final By fieldsetSignInInfo = By.xpath("//fieldset[@class='fieldset create account']");
    private final By firstNameInput = By.xpath(".//input[@name='firstname']");
    private final By lastNameInput = By.xpath(".//input[@name='lastname']");
    private final By emailInput = By.xpath(".//input[@name='email']");
    private final By passwordInput = By.xpath(".//input[@name='password']");
    private final By confirmPasswordInput = By.xpath(".//input[@name='password_confirmation']");
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

    //actions
    @Step("Fill First Name field with {firstName}")
    public void setFirstNameInput(String firstName){
        typeIntoElementInFieldset(fieldsetPersonalInfo, firstNameInput, firstName);
    }
    @Step("Fill Last Name field with {lastName}")
    public void setLastNameInput(String lastName){
        typeIntoElementInFieldset(fieldsetPersonalInfo, lastNameInput, lastName);
    }
    @Step("Fill Email field with {email}")
    public void setEmailInput(String email){
        typeIntoElementInFieldset(fieldsetSignInInfo, emailInput, email);
    }
    @Step("Fill Password field with {password}")
    public void setPasswordInput(String password){
        typeIntoElementInFieldset(fieldsetSignInInfo, passwordInput, password);
    }
    @Step("Fill Confirm Password field with {password}")
    public void setConfirmPasswordInput(String password){
        typeIntoElementInFieldset(fieldsetSignInInfo, confirmPasswordInput, password);
    }
    @Step("Click Create an Account button")
    public MyAccountPage clickCreateAnAccountButton(){
        click(createAnAccountButton);
        return new MyAccountPage();
    }
    @Step("Check if First Name label is displayed")
    public boolean firstNameLabelIsDisplayed(){
        return isElementInFieldsetVisible(fieldsetPersonalInfo, firstNameLabel);
    }
    @Step("Check if Last Name label is displayed")
    public boolean lastNameLabelIsDisplayed(){
        return isElementInFieldsetVisible(fieldsetPersonalInfo, lastNameLabel);
    }
    @Step("Check if Newsletter label is displayed")
    public boolean newsletterLabelIsDisplayed(){
        return isElementInFieldsetVisible(fieldsetPersonalInfo, newsletterLabel);
    }
    @Step("Check if Email label is displayed")
    public boolean emailLabelIsDisplayed(){
        return isElementInFieldsetVisible(fieldsetSignInInfo, emailLabel);
    }
    @Step("Check if Password label is displayed")
    public boolean passwordLabelIsDisplayed(){
        return isElementInFieldsetVisible(fieldsetSignInInfo, passwordLabel);
    }
    @Step("Check if Confirm Password label is displayed")
    public boolean confirmPasswordLabelIsDisplayed(){
        return isElementInFieldsetVisible(fieldsetSignInInfo, confirmPasswordLabel);
    }
    @Step("Check if Create an Account button is displayed")
    public boolean createAnAccountButtonIsDisplayed(){
        return isElementVisible(createAnAccountButton);
    }
    @Step("Check error message text for First Name field")
    public String getFirstNameErrorMessage(){
        return getElementText(firstNameErrorMessage);
    }
    @Step("Check error message text for Last Name field")
    public String getLastNameErrorMessage(){
        return getElementText(lastNameErrorMessage);
    }
    @Step("Check error message text for Email field")
    public String getEmailErrorMessage(){
        return getElementText(emailErrorMessage);
    }
    @Step("Check error message text for Password field")
    public String getPasswordErrorMessage(){
        return getElementText(passwordErrorMessage);
    }
    @Step("Check error message text for Confirm Password field")
    public String getConfirmPasswordErrorMessage(){
        return getElementText(confirmPasswordErrorMessage);
    }
    @Step("Check if First Name/Last Name/Email/Password/Confirm Password fields and labels and Create an Account button are displayed")
    public void allFieldsCtaAsserts(){
        assertTrue(firstNameLabelIsDisplayed());
        assertTrue(lastNameLabelIsDisplayed());
        assertTrue(newsletterLabelIsDisplayed());
        assertTrue(emailLabelIsDisplayed());
        assertTrue(passwordLabelIsDisplayed());
        assertTrue(confirmPasswordLabelIsDisplayed());
        assertTrue(createAnAccountButtonIsDisplayed());
        assertTrue(isElementInFieldsetVisible(fieldsetPersonalInfo, firstNameInput));
        assertTrue(isElementInFieldsetVisible(fieldsetPersonalInfo, lastNameInput));
        assertTrue(isElementInFieldsetVisible(fieldsetSignInInfo, emailInput));
        assertTrue(isElementInFieldsetVisible(fieldsetSignInInfo, passwordInput));
        assertTrue(isElementInFieldsetVisible(fieldsetSignInInfo, confirmPasswordInput));
    }


}
