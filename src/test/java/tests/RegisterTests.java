package tests;

import baseTest.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
import pages.Pages;
import testData.GlobalData;
import testData.EmailGenerator;
import testData.TestDataProviders;

import java.io.IOException;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class RegisterTests extends BaseTest {

    @Test (groups = {"success", "register"})
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
        assertEquals(Pages.myAccountPage().getSuccessRegisterMessage(),GlobalData.successRegisterMessage);

        Pages.myAccountPage().clickSignOutLink();
        assertEquals(Pages.successLogoutPage().getSuccessMessage(), GlobalData.successLogOutMessage);

        Pages.homepage().clickSignInLink();
        Pages.loginPage().mainElementsIsDisplayedAsserts();

        Pages.loginPage().setEmailInput(email);
        Pages.loginPage().setPasswordInput(GlobalData.validPassword);
        Pages.loginPage().clickSignInButton();
        assertTrue(Pages.homepage().signInLinkNotDisplayed());
        assertEquals(Pages.header().getGreetingInfo(), GlobalData.greetingInfo(GlobalData.firstName, GlobalData.lastName));
    }

    @Test (groups = {"unsuccess", "register"}, dataProvider = "invalidRegisterData", dataProviderClass = TestDataProviders.class)
    @Description("Form is filled with invalid data. User isn't registered. Error is displayed")
    @Severity(SeverityLevel.NORMAL)
    public void invalidRegisterTests(String firstName, String lastName, String email, String password, String confirmPass, String expectedError, String errorMethod){
        start(GlobalData.mainURL);

        Pages.homepage().clickCreateAnAccountLink();
        Pages.registerPage().allFieldsCtaAsserts();

        Pages.registerPage().setFirstNameInput(firstName);
        Pages.registerPage().setLastNameInput(lastName);
        Pages.registerPage().setEmailInput(email);
        Pages.registerPage().setPasswordInput(password);
        Pages.registerPage().setConfirmPasswordInput(confirmPass);
        Pages.registerPage().clickCreateAnAccountButton();

        assertEquals(getErrorUsingMethod(errorMethod), expectedError);
    }





    private String getErrorUsingMethod(String errorMethod) {
        switch (errorMethod) {
            case "getFirstNameFieldError":
                return Pages.registerPage().getFirstNameErrorMessage();
            case "getLastNameFieldError":
                return Pages.registerPage().getLastNameErrorMessage();
            case "getEmailFieldError":
                return Pages.registerPage().getEmailErrorMessage();
            case "getPasswordFieldError":
                return Pages.registerPage().getPasswordErrorMessage();
            case "getConfirmPasswordFieldError":
                return Pages.registerPage().getConfirmPasswordErrorMessage();
            default:
                throw new IllegalArgumentException("Unknown error method: " + errorMethod);
        }
    }



}
