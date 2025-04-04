package testData;

import io.qameta.allure.Step;
import org.testng.annotations.DataProvider;
import pages.Pages;
import utils.EmailGenerator;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class TestDataProviders {

    @DataProvider(name = "invalidItemQtyData")
    public Object[][] provideInvalidItemQtyData() {
        return new Object[][]{
                {"10001", GlobalData.overMaxQtyError},
                {"0", GlobalData.overMinQtyError},
                {" ", GlobalData.emptyFieldQtyError}
        };
    }

    @DataProvider(name = "invalidGroupItemQtyData")
    public Object[][] provideInvalidGroupItemQtyData() {
        return new Object[][]{
                {"10001", "getPageError", "The requested qty exceeds the maximum qty allowed in shopping cart"},
                {"0", "getInputError", "Please specify the quantity of product(s)."}
        };
    }

    @DataProvider(name = "validGroupItemQtyDataChanging")
    public Object[][] provideValidGroupItemQtyData() {
        return new Object[][]{
                {"1", "0", "0", "You added Kate's product-group to your shopping cart."},
                {"0", "1", "0", "You added Kate's product-group to your shopping cart."},
                {"0", "0", "1", "You added Kate's product-group to your shopping cart."},
                {"1", "1", "1", "You added Kate's product-group to your shopping cart."},
        };
    }

    @DataProvider(name = "invalidLoginData")
    public Object[][] provideInvalidLoginData() throws IOException {
        String email = new EmailGenerator().generateRandomEmail();
        return new Object[][]{
                {"", "", GlobalData.requiredFieldError, "getEmailFieldError"},
                {"", "", GlobalData.requiredFieldError, "getPasswordFieldError"},
                {GlobalData.invalidEmail, "", GlobalData.invalidEmailError, "getEmailFieldError"},
                {GlobalData.validEmail, "000", GlobalData.incorrectLoginError, "getPageError"},
                {email, GlobalData.validPassword, GlobalData.incorrectLoginError, "getPageError"}
        };
    }

    @DataProvider(name = "invalidRegisterData")
    public Object[][] provideInvalidRegisterData() throws IOException {
        String email = new EmailGenerator().generateRandomEmail();
        return new Object[][]{
                {"", "", "", "", "", GlobalData.requiredFieldError, (Object) new String[]{
                        "getFirstNameFieldError", "getLastNameFieldError", "getEmailFieldError",
                        "getPasswordFieldError", "getConfirmPasswordFieldError"}
                },
                {GlobalData.firstName, GlobalData.lastName, GlobalData.invalidEmail, GlobalData.validPassword, GlobalData.validPassword, GlobalData.invalidEmailError, "getEmailFieldError"},
                {GlobalData.firstName, GlobalData.lastName, email, GlobalData.validPassword, "Aleksa000", GlobalData.invalidConfirmPasswordError, "getConfirmPasswordFieldError"},
                {GlobalData.firstName, GlobalData.lastName, email, GlobalData.sevenSymbolsPassword, GlobalData.sevenSymbolsPassword, GlobalData.tooShortPasswordError, "getPasswordFieldError"},
                {GlobalData.firstName, GlobalData.lastName, email, GlobalData.noLetterPassword, GlobalData.noLetterPassword, GlobalData.noLetterOrSymbolOrDigitPasswordError, "getPasswordFieldError"},
                {GlobalData.firstName, GlobalData.lastName, email, GlobalData.noDigitPassword, GlobalData.noDigitPassword, GlobalData.noLetterOrSymbolOrDigitPasswordError, "getPasswordFieldError"},
                {GlobalData.firstName, GlobalData.lastName, email, GlobalData.noSpecificSymbolPassword, GlobalData.noSpecificSymbolPassword, GlobalData.noLetterOrSymbolOrDigitPasswordError, "getPasswordFieldError"},
        };

    }

    @DataProvider(name = "invalidShippingData")
    public Object[][] provideInvalidShippingData() {
        return new Object[][]{
                {"", "", "", "", "", "Please select a region, state or province.", "", "", (Object) new String[]{
                        "getEmailFieldError", "getFirstNameFieldError", "getLastNameFieldError", "getStreetAddressFieldError",
                        "getCityFieldError", "getStateFieldError", "getPostalCodeFieldError",
                        "getPhoneNumberFieldError"}, GlobalData.requiredFieldError
                },
                {GlobalData.invalidEmailError, GlobalData.firstName, GlobalData.lastName, GlobalData.streetName,
                        GlobalData.cityName, GlobalData.state, GlobalData.validPostalCode,
                        GlobalData.phoneNumber, "getEmailFieldInvalidError", GlobalData.invalidEmailError},
        };
    }


}
