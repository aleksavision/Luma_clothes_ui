package testData;

import org.testng.annotations.DataProvider;
import pages.Pages;

import java.io.IOException;

public class TestDataProviders {

    @DataProvider(name = "invalidItemQtyData")
    public Object[][] provideInvalidItemQtyData() {
        return new Object[][]{
                {"10001", GlobalData.overMaxQtyError},
                {"0", GlobalData.overMinQtyError}
        };
    }
    @DataProvider(name = "invalidGroupItemQtyData")
    public Object[][] provideInvalidGroupItemQtyData() {
        return new Object[][]{
                {"10001", "The requested qty exceeds the maximum qty allowed in shopping cart", "getPageError"},
                {"0", "Please specify the quantity of product(s).", "getInputError"}
        };
    }

    @DataProvider(name = "invalidLoginData")
    public Object[][] provideInvalidLoginData() throws IOException {
        String email = new EmailGenerator().generateUniqueEmail();
        return new Object[][]{
                {"", "", GlobalData.requiredFieldError, "getEmailFieldError"},
                {"", "", GlobalData.requiredFieldError, "getPasswordFieldError"},
                {GlobalData.invalidEmail, "", GlobalData.invalidEmailError, "getEmailFieldError"},
                {GlobalData.validEmail, "000", GlobalData.incorrectCaptchaError, "getPageError"},
                {email, GlobalData.validPassword, GlobalData.incorrectLoginError, "getPageError"}
        };
    }

    @DataProvider(name = "invalidRegisterData")
    public Object[][] provideInvalidRegisterData() throws IOException {
        String email = new EmailGenerator().generateUniqueEmail();
        return new Object[][]{
                {"", "", "", "", "", GlobalData.requiredFieldError, new String[]{
                        "getFirstNameFieldError", "getLastNameFieldError", "getEmailFieldError",
                        "getPasswordFieldError", "getConfirmPasswordFieldError"}
                },
                {GlobalData.firstName, GlobalData.lastName, GlobalData.invalidEmail, GlobalData.validPassword, GlobalData.validPassword, GlobalData.invalidEmailError, "getEmailFieldError"},
                {GlobalData.firstName, GlobalData.lastName, email, GlobalData.validPassword, GlobalData.validPassword + "1", GlobalData.invalidConfirmPasswordError, "getConfirmPasswordFieldError"},
                {GlobalData.firstName, GlobalData.lastName, email, GlobalData.sevenSymbolsPassword, GlobalData.sevenSymbolsPassword, GlobalData.tooShortPasswordError, "getPasswordFieldError"},
                {GlobalData.firstName, GlobalData.lastName, email, GlobalData.noLetterPassword, GlobalData.noLetterPassword, GlobalData.noLetterOrSymbolOrDigitPasswordError, "getPasswordFieldError"},
                {GlobalData.firstName, GlobalData.lastName, email, GlobalData.noDigitPassword, GlobalData.noDigitPassword, GlobalData.noLetterOrSymbolOrDigitPasswordError, "getPasswordFieldError"},
                {GlobalData.firstName, GlobalData.lastName, email, GlobalData.noSpecificSymbolPassword, GlobalData.noSpecificSymbolPassword, GlobalData.noLetterOrSymbolOrDigitPasswordError, "getPasswordFieldError"},
        };

    }



}
