package tests;

import baseTest.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
import pages.Pages;
import testData.GlobalData;
import testData.EmailGenerator;

import java.io.IOException;

public class RegisterTests extends BaseTest {

//    @Test (groups = {"success", "register"})
    @Description("User is registered successfully. User is logged out and logged in with new creds successfully.")
    @Severity(SeverityLevel.CRITICAL)
    public void successRegisterTest() throws IOException {
        start(GlobalData.mainURL);
        String email = new EmailGenerator().generateUniqueEmail();

        Pages.homepage().clickCreateAnAccountLink();
        Pages.registerPage().allFieldsCtaAsserts();

        Pages.registerPage().setFirstNameInput(GlobalData.firstName);
        Pages.registerPage().setLastNameInput(GlobalData.lastName);
        Pages.registerPage().setEmailInput(email);
        Pages.registerPage().setPasswordInput(GlobalData.validPassword);
        Pages.registerPage().setConfirmPasswordInput(GlobalData.validPassword);
        Pages.registerPage().clickCreateAnAccountButton();
        softAssert.assertEquals(Pages.myAccountPage().getSuccessRegisterMessage(),GlobalData.successRegisterMessage);

        Pages.myAccountPage().clickSignOutLink();
        softAssert.assertEquals(Pages.successLogoutPage().getSuccessMessage(), GlobalData.successLogOutMessage);

        Pages.homepage().clickSignInLink();
        Pages.loginPage().mainElementsIsDisplayedAsserts();

        Pages.loginPage().setEmailInput(email);
        Pages.loginPage().setPasswordInput(GlobalData.validPassword);
        Pages.loginPage().clickSignInButton();
        softAssert.assertTrue(Pages.homepage().signInLinkNotDisplayed());
        softAssert.assertAll();
    }

    @Test (groups = {"unsuccess", "register"})
    @Description("Empty form is applied. User isn't registered")
    @Severity(SeverityLevel.NORMAL)
    public void emptyRegisterForm(){
        start(GlobalData.mainURL);

        Pages.homepage().clickCreateAnAccountLink();
        Pages.registerPage().allFieldsCtaAsserts();

        Pages.registerPage().clickCreateAnAccountButton();
        softAssert.assertEquals(Pages.registerPage().getFirstNameErrorMessage(), GlobalData.requiredFieldError);
        softAssert.assertEquals(Pages.registerPage().getLastNameErrorMessage(), GlobalData.requiredFieldError);
        softAssert.assertEquals(Pages.registerPage().getEmailErrorMessage(), GlobalData.requiredFieldError);
        softAssert.assertEquals(Pages.registerPage().getPasswordErrorMessage(), GlobalData.requiredFieldError);
        softAssert.assertEquals(Pages.registerPage().getConfirmPasswordErrorMessage(), GlobalData.requiredFieldError);
        softAssert.assertAll();
    }

    @Test (groups = {"unsuccess", "register"})
    @Description("Form with invalid email is applied. User isn't registered")
    @Severity(SeverityLevel.NORMAL)
    public void invalidEmail() {
        start(GlobalData.mainURL);

        Pages.homepage().clickCreateAnAccountLink();
        Pages.registerPage().allFieldsCtaAsserts();

        Pages.registerPage().setFirstNameInput(GlobalData.firstName);
        Pages.registerPage().setLastNameInput(GlobalData.lastName);
        Pages.registerPage().setEmailInput(GlobalData.invalidEmail);
        Pages.registerPage().setPasswordInput(GlobalData.validPassword);
        Pages.registerPage().setConfirmPasswordInput(GlobalData.validPassword);
        Pages.registerPage().clickCreateAnAccountButton();
        softAssert.assertEquals(Pages.registerPage().getEmailErrorMessage(), GlobalData.invalidEmailError);
        softAssert.assertAll();
    }

    @Test (groups = {"unsuccess", "register"})
    @Description("Form with invalid Confirm Password is applied. User isn't registered")
    @Severity(SeverityLevel.NORMAL)
    public void invalidConfirmPassword() throws IOException {
        start(GlobalData.mainURL);
        String email = new EmailGenerator().generateUniqueEmail();

        Pages.homepage().clickCreateAnAccountLink();
        Pages.registerPage().allFieldsCtaAsserts();

        Pages.registerPage().setFirstNameInput(GlobalData.firstName);
        Pages.registerPage().setLastNameInput(GlobalData.lastName);
        Pages.registerPage().setEmailInput(email);
        Pages.registerPage().setPasswordInput(GlobalData.validPassword);
        Pages.registerPage().setConfirmPasswordInput(GlobalData.validPassword + "1");
        Pages.registerPage().clickCreateAnAccountButton();
        softAssert.assertEquals(Pages.registerPage().getConfirmPasswordErrorMessage(), GlobalData.invalidConfirmPasswordError);
        softAssert.assertAll();
    }

    @Test (groups = {"unsuccess", "register"})
    @Description("Password with 7 or less symbols is entered. Form is applied. User isn't registered")
    @Severity(SeverityLevel.NORMAL)
    public void tooShortPassword() throws IOException {
        start(GlobalData.mainURL);
        String email = new EmailGenerator().generateUniqueEmail();

        Pages.homepage().clickCreateAnAccountLink();
        Pages.registerPage().allFieldsCtaAsserts();

        Pages.registerPage().setFirstNameInput(GlobalData.firstName);
        Pages.registerPage().setLastNameInput(GlobalData.lastName);
        Pages.registerPage().setEmailInput(email);
        Pages.registerPage().setPasswordInput(GlobalData.sevenSymbolsPassword);
        Pages.registerPage().setConfirmPasswordInput(GlobalData.sevenSymbolsPassword);
        Pages.registerPage().clickCreateAnAccountButton();
        softAssert.assertEquals(Pages.registerPage().getPasswordErrorMessage(), GlobalData.tooShortPasswordError);
        softAssert.assertAll();
    }

    @Test (groups = {"unsuccess", "register"})
    @Description("Password with no letter is entered. Form is applied. User isn't registered")
    @Severity(SeverityLevel.NORMAL)
    public void noLetterPassword() throws IOException {
        start(GlobalData.mainURL);
        String email = new EmailGenerator().generateUniqueEmail();

        Pages.homepage().clickCreateAnAccountLink();
        Pages.registerPage().allFieldsCtaAsserts();

        Pages.registerPage().setFirstNameInput(GlobalData.firstName);
        Pages.registerPage().setLastNameInput(GlobalData.lastName);
        Pages.registerPage().setEmailInput(email);
        Pages.registerPage().setPasswordInput(GlobalData.noLetterPassword);
        Pages.registerPage().setConfirmPasswordInput(GlobalData.noLetterPassword);
        Pages.registerPage().clickCreateAnAccountButton();
        softAssert.assertEquals(Pages.registerPage().getPasswordErrorMessage(), GlobalData.noLetterOrSymbolOrDigitPasswordError);
        softAssert.assertAll();
    }

    @Test (groups = {"unsuccess", "register"})
    @Description("Password with no digit is entered. Form is applied. User isn't registered")
    @Severity(SeverityLevel.NORMAL)
    public void noDigitPassword() throws IOException {
        start(GlobalData.mainURL);
        String email = new EmailGenerator().generateUniqueEmail();

        Pages.homepage().clickCreateAnAccountLink();
        Pages.registerPage().allFieldsCtaAsserts();

        Pages.registerPage().setFirstNameInput(GlobalData.firstName);
        Pages.registerPage().setLastNameInput(GlobalData.lastName);
        Pages.registerPage().setEmailInput(email);
        Pages.registerPage().setPasswordInput(GlobalData.noDigitPassword);
        Pages.registerPage().setConfirmPasswordInput(GlobalData.noDigitPassword);
        Pages.registerPage().clickCreateAnAccountButton();
        softAssert.assertEquals(Pages.registerPage().getPasswordErrorMessage(), GlobalData.noLetterOrSymbolOrDigitPasswordError);
        softAssert.assertAll();
    }

    @Test (groups = {"unsuccess", "register"})
    @Description("Password with no letter is entered. Form is applied. User isn't registered")
    @Severity(SeverityLevel.NORMAL)
    public void noSpecificSymbolPassword() throws IOException {
        start(GlobalData.mainURL);
        String email = new EmailGenerator().generateUniqueEmail();

        Pages.homepage().clickCreateAnAccountLink();
        Pages.registerPage().allFieldsCtaAsserts();

        Pages.registerPage().setFirstNameInput(GlobalData.firstName);
        Pages.registerPage().setLastNameInput(GlobalData.lastName);
        Pages.registerPage().setEmailInput(email);
        Pages.registerPage().setPasswordInput(GlobalData.noSpecificSymbolPassword);
        Pages.registerPage().setConfirmPasswordInput(GlobalData.noSpecificSymbolPassword);
        Pages.registerPage().clickCreateAnAccountButton();
        softAssert.assertEquals(Pages.registerPage().getPasswordErrorMessage(), GlobalData.noLetterOrSymbolOrDigitPasswordError);
        softAssert.assertAll();
    }


}
