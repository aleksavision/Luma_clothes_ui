//package tests;
//
//import baseTest.BaseTest;
//import io.qameta.allure.Description;
//import io.qameta.allure.Severity;
//import io.qameta.allure.SeverityLevel;
//import org.testng.annotations.Test;
//import pages.Pages;
//import testData.GlobalData;
//
//import static org.testng.Assert.assertTrue;
//
//public class LoginTests extends BaseTest {
//
//    @Test(groups = {"success", "login"})
//    @Description("Form is applied with valid data. User is logged in")
//    @Severity(SeverityLevel.CRITICAL)
//    public void successLogin(){
//        start(GlobalData.mainURL);
//
//        Pages.homepage().clickSignInLink();
//        Pages.loginPage().mainElementsIsDisplayedAsserts();
//
//        Pages.loginPage().setEmailInput(GlobalData.validEmail);
//        Pages.loginPage().setPasswordInput(GlobalData.validPassword);
//        Pages.loginPage().clickSignInButton();
//        assertTrue(Pages.header().signOutLinkIsDisplayed());
//    }
//
//    @Test(groups = {"unsuccess", "login"})
//    @Description("Empty form is applied. User isn't logged in. Errors are displayed")
//    @Severity(SeverityLevel.CRITICAL)
//    public void emptyFormTest(){
//        start(GlobalData.mainURL);
//
//        Pages.homepage().clickSignInLink();
//        Pages.loginPage().clickSignInButton();
//        softAssert.assertEquals(Pages.loginPage().getEmailFieldError(), GlobalData.requiredFieldError);
//        softAssert.assertEquals(Pages.loginPage().getPasswordFieldError(), GlobalData.requiredFieldError);
//    }
//}
