package tests;

import actions.Actions;
import baseTest.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Pages;
import testData.GlobalData;
import utils.EmailGenerator;
import testData.TestDataProviders;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class RegisterTests extends BaseTest {

    @BeforeMethod
    private void startTest() {
        start(GlobalData.mainURL);
        Pages.header().clickCreateAnAccountLink();
    }

    @Test(groups = {"elements"})
    @Description("All elements are displayed on Register page")
    @Severity(SeverityLevel.NORMAL)
    public void elementsAreDisplayed() {
        startTest();
        Pages.registerPage().allFieldsCtaAsserts();
    }

    @Test(groups = {"success", "register"})
    @Description("User is registered successfully")
    @Severity(SeverityLevel.CRITICAL)
    public void successRegisterTest() {
        startTest();
        String generatedEmail = EmailGenerator.generateRandomEmail();

        Actions.registerPageActions().registerUser(null, null, generatedEmail, null, null);
        assertEquals(Pages.myAccountPage().getSuccessRegisterMessage(), GlobalData.successRegisterMessage);

        Pages.header().clickSignOutLink();
        assertEquals(Pages.successLogoutPage().getSuccessMessage(), GlobalData.successLogOutMessage);
    }

    @Test(groups = {"unsuccess", "register"}, dataProvider = "invalidRegisterData", dataProviderClass = TestDataProviders.class)
    @Description("Form is filled with invalid data. User isn't registered. Error is displayed")
    @Severity(SeverityLevel.NORMAL)
    public void invalidRegisterTests(String firstName, String lastName, String email, String password, String confirmPassword, String expectedError, Object errorMethods) {
        startTest();

        Actions.registerPageActions().registerUser(firstName, lastName, email, password, confirmPassword);
        Pages.registerPage().getErrorMessages(errorMethods, expectedError);
    }

    @Test(groups = {"success", "register"})
    @Description("User is registered successfully. User is logged out and logged in with new creds successfully.")
    @Severity(SeverityLevel.CRITICAL)
    public void successRegisterLoginTest() {
        startTest();
        String generatedEmail = EmailGenerator.generateRandomEmail();

        Actions.registerPageActions().registerUser(null, null, generatedEmail, null, null);
        assertEquals(Pages.myAccountPage().getSuccessRegisterMessage(), GlobalData.successRegisterMessage);

        Pages.header().clickSignOutLink();
        assertEquals(Pages.successLogoutPage().getSuccessMessage(), GlobalData.successLogOutMessage);

        Pages.header().clickSignInLink();
        Pages.loginPage().loginUser(generatedEmail, null);
        assertTrue(Pages.header().signInLinkNotDisplayed());
        assertEquals(Pages.header().getGreetingInfo(), GlobalData.greetingInfo(GlobalData.firstName, GlobalData.lastName));
    }


}
