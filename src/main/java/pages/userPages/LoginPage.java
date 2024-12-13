package pages.userPages;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import pages.Homepage;
import tools.PageTools;

import static com.codeborne.selenide.Selenide.$;
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
    private final By reloadCaptchaButton = By.xpath(".//div[@class='control captcha-image']/button");
    private final By captchaInput = By.xpath( ".//input[@name='captcha[user_login]']");

    @Step ("Fill Email field with {email}")
    public void setEmailInput(String email){
        typeIntoElementInFieldset(fieldset, emailInput, email);
    }
    @Step ("Fill Password field with {password}")
    public void setPasswordInput(String password){
        typeIntoElementInFieldset(fieldset, passwordInput, password);
    }
    @Step ("Click Sign in button")
    public Homepage clickSignInButton(){
        click(signInButton);
        return new Homepage();
    }
    @Step ("Click Sign in button")
    public MyWishListPage clickSignInButtonToWishlist(){
        click(signInButton);
        return new MyWishListPage();
    }
    @Step ("Check if Email label is displayed")
    public boolean emailLabelIsDisplayed(){
        return isElementInFieldsetVisible(fieldset, emailLabel);
    }
    @Step ("Check if Email field is displayed")
    public boolean emailInputIsDisplayed(){
        return isElementInFieldsetVisible(fieldset, emailInput);
    }
    @Step ("Check if Password label is displayed")
    public boolean passwordLabelIsDisplayed(){
        return isElementInFieldsetVisible(fieldset, passwordLabel);
    }
    @Step ("Check if Password field is displayed")
    public boolean passwordInputIsDisplayed(){
        return isElementInFieldsetVisible(fieldset, passwordInput);
    }
    @Step ("Check if Forget password link is displayed")
    public boolean forgetPasswordLinkIsDisplayed(){
        return isElementInFieldsetVisible(fieldset, forgetPasswordLink);
    }
    @Step("Check if Create an Account Button is displayed")
    public boolean createAnAccountButtonIsDisplayed(){
        return isElementVisible(createAnAccountButton);
    }
    @Step("Check Email field error text")
    public String getEmailFieldError(){
        return getElementText(emailFieldError);
    }
    @Step("Check Password field error text")
    public String getPasswordFieldError(){
        return getElementText(passwordFieldError);
    }
    @Step("Check if Login form/Sign In button/Create an account button is displayed")
    public void mainElementsIsDisplayedAsserts(){
        assertTrue(emailLabelIsDisplayed());
        assertTrue(emailInputIsDisplayed());
        assertTrue(passwordLabelIsDisplayed());
        assertTrue(passwordInputIsDisplayed());
        assertTrue(isElementInFieldsetVisible(fieldset, signInButton));
        assertTrue(createAnAccountButtonIsDisplayed());
    }
    @Step("Get error info message text")
    public String getErrorMessageText(){
        return getElementText(errorMessage);
    }
    @Step("Clear Email input")
    public void clearEmailInput(){
       clearText(emailInput);
    }
}
