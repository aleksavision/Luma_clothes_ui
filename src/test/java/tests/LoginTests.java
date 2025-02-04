package tests;

import baseTest.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
import pages.Pages;
import testData.GlobalData;
import testData.TestDataProviders;

import static org.testng.Assert.assertEquals;

public class LoginTests extends BaseTest {

    @Test(groups = {"success", "login"})
    @Description("Form is applied with valid data. User is logged in")
    @Severity(SeverityLevel.CRITICAL)
    public void successLoginTests(){
        start(GlobalData.mainURL);

        Pages.homepage().clickSignInLink();
        Pages.loginPage().mainElementsIsDisplayedAsserts();

        Pages.loginPage().setEmailInput(GlobalData.validEmail);
        Pages.loginPage().setPasswordInput(GlobalData.validPassword);
        Pages.loginPage().clickSignInButton();
        Pages.loginPage().setEmailInput(GlobalData.validEmail);
        Pages.loginPage().setPasswordInput(GlobalData.validPassword);
        Pages.loginPage().clickSignInButton();
        softAssert.assertTrue(Pages.header().signOutLinkIsDisplayed());
        softAssert.assertEquals(Pages.header().getGreetingInfo(), GlobalData.greetingInfo(GlobalData.firstName, GlobalData.lastName));
        softAssert.assertAll();
    }

    @Test(groups = {"unsuccess", "login"}, dataProvider = "invalidLoginData", dataProviderClass = TestDataProviders.class)
    @Description("Form is applied with invalid data. User isn't logged in. Error is displayed")
    @Severity(SeverityLevel.CRITICAL)
    public void unsuccessLoginTests(String email, String password, String expectedError, String errorMethod) {
        start(GlobalData.mainURL);

        Pages.homepage().clickSignInLink();
        Pages.loginPage().mainElementsIsDisplayedAsserts();

        Pages.loginPage().setEmailInput(email);
        Pages.loginPage().setPasswordInput(password);
        Pages.loginPage().clickSignInButton();
        assertEquals(getErrorUsingMethod(errorMethod), expectedError);
    }





    private String getErrorUsingMethod(String errorMethod) {
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
