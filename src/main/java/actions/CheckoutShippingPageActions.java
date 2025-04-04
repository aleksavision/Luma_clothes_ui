package actions;

import pages.Pages;

public class CheckoutShippingPageActions {


    public void fillShippingForm(String email, String firstName, String lastName, String streetAddress, String city, String state,
                                 String postalCode, String phoneNumber) {
        Pages.checkoutShippingPage().setEmailInput(email);
        Pages.checkoutShippingPage().setFirstNameInput(firstName);
        Pages.checkoutShippingPage().setLastNameInput(lastName);
        Pages.checkoutShippingPage().setStreetAddressInput(streetAddress);
        Pages.checkoutShippingPage().setCityInput(city);
        Pages.checkoutShippingPage().selectStateDropdown(state);
        Pages.checkoutShippingPage().setPostalCodeInput(postalCode);
        Pages.checkoutShippingPage().setPhoneNumberInput(phoneNumber);
    }

}
