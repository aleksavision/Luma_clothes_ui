package tests.checkoutTests;

import actions.Actions;
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

public class ShippingCheckoutTests extends BaseTest {

    @BeforeMethod
    public void startTest() {
        start("http://46.101.147.48/erika-running-short.html");
        Actions.productPageActions().addSingleProductToCart();
        Pages.miniCart().clickCartButton();
        Pages.miniCart().clickProceedToCheckoutButton();
    }

    @Test(groups = {"elements"})
    @Description("Product is added to Cart. User is redirected to Checkout Shipping page. Elements are displayed successfully.")
    @Severity(SeverityLevel.CRITICAL)
    public void checkMainElementsDisplaying() {
        assertTrue(Pages.checkoutShippingPage().checkEmailInputIsDisplayed());
        assertTrue(Pages.checkoutShippingPage().checkFirstNameInputIsDisplayed());
        assertTrue(Pages.checkoutShippingPage().checkLastNameInputIsDisplayed());
        assertTrue(Pages.checkoutShippingPage().checkStreetAddressInputIsDisplayed());
        assertTrue(Pages.checkoutShippingPage().checkCityInputIsDisplayed());
        assertTrue(Pages.checkoutShippingPage().checkStateDropdownIsDisplayed());
        assertTrue(Pages.checkoutShippingPage().checkCountryDropdownIsDisplayed());
        assertTrue(Pages.checkoutShippingPage().checkPostalCodeInputIsDisplayed());
        assertTrue(Pages.checkoutShippingPage().checkPhoneNumberInputIsDisplayed());
        assertTrue(Pages.checkoutShippingPage().checkShippingMethodButtonIsDisplayed());
        assertTrue(Pages.checkoutShippingPage().checkNextButtonIsDisplayed());
    }

    @Test(groups = {"unsuccess"}, dataProvider = "invalidShippingData", dataProviderClass = TestDataProviders.class)
    @Description("Product is added to Cart. User is redirected to Checkout Shipping page. Shipping form is applied with invalid data. Error is displayed")
    @Severity(SeverityLevel.NORMAL)
    public void checkFormApplyingWithInvalidData(String email, String firstName, String lastName, String streetAddress,
                                                 String city, String state, String postalCode, String phoneNumber,
                                                 Object errorMethod, String expectedError) {
        Actions.checkoutShippingPageActions().fillShippingForm(email, firstName, lastName, streetAddress,
                city, state, postalCode, phoneNumber);
        Pages.checkoutShippingPage().selectShippingMethod();
        Pages.checkoutShippingPage().clickNextButton();
        Pages.checkoutShippingPage().getErrorMessages(errorMethod, expectedError);

    }

    @Test(groups = {"unsuccess"})
    @Description("Product is added to Cart. User is redirected to Checkout Shipping page. Country isn't selected. Error is displayed.")
    @Severity(SeverityLevel.NORMAL)
    public void checkFormApplyingWithoutSelectedCountry() {
        Pages.checkoutShippingPage().selectCountryDropdown("");
        assertEquals(Pages.checkoutShippingPage().getCountryFieldError(), GlobalData.requiredFieldError);
    }

    @Test(groups = {"unsuccess"})
    @Description("Product is added to Cart. User is redirected to Checkout Shipping page. Shipping method isn't selected. Error is displayed.")
    @Severity(SeverityLevel.NORMAL)
    public void checkFormApplyingWithNoSelectedShippingMethod() {
        Pages.checkoutShippingPage().clickNextButton();
        assertEquals(Pages.checkoutShippingPage().getShippingMethodFieldError(), GlobalData.notSelectedShippingMethodError);
    }

    @Test(groups = {"success"})
    @Description("Product is added to Cart. User is redirected to Checkout Shipping page. Shipping form is applied with valid data successfully")
    @Severity(SeverityLevel.NORMAL)
    public void checkFormApplyingWithValidData() {
        Actions.checkoutShippingPageActions().fillShippingForm(GlobalData.validEmail, GlobalData.firstName, GlobalData.lastName,
                GlobalData.streetName, GlobalData.cityName, GlobalData.state, GlobalData.validPostalCode,
                GlobalData.phoneNumber);
        Pages.checkoutShippingPage().selectShippingMethod();
        Pages.checkoutShippingPage().clickNextButton();
        assertEquals(Pages.checkoutPaymentPage().getPageTitle(), "Review & Payments");
    }


}
