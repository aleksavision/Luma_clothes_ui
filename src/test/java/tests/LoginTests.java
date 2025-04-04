package tests;

import baseTest.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Pages;
import testData.GlobalData;
import testData.TestDataProviders;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTests extends BaseTest {

    @BeforeMethod
    private void startTest() {
        start(GlobalData.mainURL);
        Pages.header().clickSignInLink();
    }

    @Test(groups = {"elements"})
    @Description("All form elements are displayed")
    @Severity(SeverityLevel.NORMAL)
    public void elementsAreDisplayed() {
        startTest();
        Pages.loginPage().mainElementsIsDisplayedAsserts();
    }

    @Test(groups = {"success", "login"})
    @Description("Form is applied with valid data. User is logged in")
    @Severity(SeverityLevel.CRITICAL)
    public void successLoginTests() {
        startTest();

        Pages.loginPage().loginUser(null, null);
        assertTrue(Pages.header().signOutLinkIsDisplayed());
        assertEquals(Pages.header().getGreetingInfo(), GlobalData.greetingInfo(GlobalData.firstName, GlobalData.lastName));
    }

    @Test(groups = {"unsuccess", "login"}, dataProvider = "invalidLoginData", dataProviderClass = TestDataProviders.class)
    @Description("Form is applied with invalid data. User isn't logged in. Error is displayed")
    @Severity(SeverityLevel.CRITICAL)
    public void unsuccessLoginTests(String email, String password, String expectedError, String errorMethod) {
        startTest();

        Pages.loginPage().loginUser(email, password);
        assertEquals(Pages.loginPage().getErrorUsingMethod(errorMethod), expectedError);
    }

}
