package pages.carts;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import tools.PageTools;

public class CheckoutShippingPage extends PageTools {
    private final By fieldsetEmail = By.id("customer-email-fieldset");
    private final By fieldsetHidden = By.className("hidden-fields");
    private final By emailInput = By.className("input-text");
    private final By firstNameInput = By.xpath("//input[@name='firstname']");
    private final By lastNameInput = By.xpath("//input[@name='lastname']");
    private final By streetAddressInput = By.xpath("//input[@name='street[0]']");
    private final By cityInput = By.xpath("//input[@name='city']");
    private final By postalCodeInput = By.xpath("//input[@name='postcode']");
    private final By phoneNumberInput = By.xpath("//input[@name='telephone']");
    private final By stateField = By.xpath("//select[@name='region_id']");
    private final By countryField = By.xpath("//select[@name='country_id']");
    private final By shippingRadiobutton = By.xpath("//input[@class='radio']");
    private final By nextButton = By.xpath("//button[@class='button action continue primary']");

    //actions
    @Step("Fill Email field with {email} ")
    public void setEmailInput(String email){
        typeIntoElementInFieldset(fieldsetEmail, emailInput, email);
    }
    @Step("Fill First Name field with {firstName}")
    public void setFirstNameInput(String firstName){
        type(firstNameInput, firstName);
    }
    @Step("Fill Last Name field with {lastName}")
    public void setLastNameInput(String lastName){
        type(lastNameInput, lastName);
    }
    @Step("Fill Street Address field with {streetName}")
    public void setStreetAddressInput(String streetName){
        type(streetAddressInput, streetName);
    }
    @Step("Fill City field with {city}")
    public void setCityInput(String city){
        type(cityInput, city);
    }
    @Step("Fill Postal Code field with {postalCode}")
    public void setPostalCodeInput(String postalCode){
        type(postalCodeInput, postalCode);
    }
    @Step("Fill Phone Number field with {phoneNumber}")
    public void setPhoneNumberInput(String phoneNumber){
        type(phoneNumberInput, phoneNumber);
    }
    @Step("Select {option} in State dropdown")
    public void selectStateDropdown(String option){
        selectOption(option, stateField);
    }
    @Step("Select {option} in Country dropdown")
    public void selectCountryDropdown(String option){
        selectOption(option, countryField);
    }
    /**
     * First shipping method (the cheapest) will be selected
     */
    @Step("Select the first (the cheapest one) shipping method")
    public void selectShippingMethod(){
        click(shippingRadiobutton);
    }
    @Step("Click the  Next button")
    public CheckoutPaymentPage clickNextButton(){
        click(nextButton);
        return new CheckoutPaymentPage();
    }











}
