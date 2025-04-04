package pages.userPages;

import actions.Actions;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import pages.Homepage;
import pages.Pages;
import tools.PageTools;

import static com.codeborne.selenide.Selenide.$;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginPage extends PageTools {

    private final By fieldset = By.tagName("fieldset");
    private final By emailInput = By.xpath(".//input[@id='email']");
    private final By passwordInput = By.xpath(".//input[@id='pass']");
    private final By signInButton = By.xpath(".//button[@name='send']");
    private final By emailLabel = By.xpath(".//label[@for='email']/span");
    private final By passwordLabel = By.xpath(".//label[@for='pass']/span");
    private final By forgetPasswordLink = By.xpath(".//a[@class='action remind']");
    private final By createAnAccountButton = By.xpath("//a[@class='action create primary']");
    private final By emailFieldError = By.xpath(".//div[@for='email']");
    private final By passwordFieldError = By.xpath(".//div[@for='pass']");
    private final By errorMessage = By.xpath("//div[@class='message-error error message']/div");

    //-------------------isDisplayed-------------------

    @Step("Check if Email label is displayed")
    public boolean emailLabelIsDisplayed() {
        return isElementInFieldsetVisible(fieldset, emailLabel);
    }

    @Step("Check if Email field is displayed")
    public boolean emailInputIsDisplayed() {
        return isElementInFieldsetVisible(fieldset, emailInput);
    }

    @Step("Check if Password label is displayed")
    public boolean passwordLabelIsDisplayed() {
        return isElementInFieldsetVisible(fieldset, passwordLabel);
    }

    @Step("Check if Password field is displayed")
    public boolean passwordInputIsDisplayed() {
        return isElementInFieldsetVisible(fieldset, passwordInput);
    }

    @Step("Check if Forget password link is displayed")
    public boolean forgetPasswordLinkIsDisplayed() {
        return isElementInFieldsetVisible(fieldset, forgetPasswordLink);
    }

    @Step("Check if Create an Account Button is displayed")
    public boolean createAnAccountButtonIsDisplayed() {
        return isElementVisible(createAnAccountButton);
    }

    @Step("Check if Login form/Sign In button/Create an account button is displayed")
    public void mainElementsIsDisplayedAsserts() {
        assertTrue(emailLabelIsDisplayed());
        assertTrue(emailInputIsDisplayed());
        assertTrue(passwordLabelIsDisplayed());
        assertTrue(passwordInputIsDisplayed());
        assertTrue(isElementInFieldsetVisible(fieldset, signInButton));
        assertTrue(createAnAccountButtonIsDisplayed());
    }

    //-------------------Get-------------------

    @Step("Get Email field error text")
    public String getEmailFieldError() {
        return getElementText(emailFieldError);
    }

    @Step("Get Password field error text")
    public String getPasswordFieldError() {
        return getElementText(passwordFieldError);
    }

    @Step("Get error info message text")
    public String getErrorMessageText() {
        return getElementText(errorMessage);
    }

    //-------------------Set/Select-------------------

    @Step("Fill Email field with {email}")
    public void setEmailInput(String email) {
        typeIntoElementInFieldset(fieldset, emailInput, email);
    }

    @Step("Fill Password field with {password}")
    public void setPasswordInput(String password) {
        typeIntoElementInFieldset(fieldset, passwordInput, password);
    }

    //-------------------Click-------------------

    @Step("Click Sign in button")
    public void clickSignInButton() {
        click(signInButton);
    }

    //-------------------Others-------------------

    @Step("Login user with email {email} and password {password}")
    public Homepage loginUser(String email, String password) {
        Actions.loginPageActions().loginUser(email, password);
        return new Homepage();
    }

    @Step("Clear Email input")
    public void clearEmailInput() {
        clearText(emailInput);
    }

    @Step("Get relevant error for case {errorMethod}")
    public String getErrorUsingMethod(String errorMethod) {
        switch (errorMethod) {
            case "getPageError":
                return Pages.loginPage().getErrorMessageText();
            case "getEmailFieldError":
                return Pages.loginPage().getEmailFieldError();
            case "getPasswordFieldError":
                return Pages.loginPage().getPasswordFieldError();
            default:
                throw new IllegalArgumentException("Unknown error method: " + errorMethod);
        }
    }






}








