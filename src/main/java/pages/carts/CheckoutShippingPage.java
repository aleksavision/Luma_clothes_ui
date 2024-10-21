package pages.carts;

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
    public void setEmailInput(String email){
        typeIntoElementInFieldset(fieldsetEmail, emailInput, email);
    }
    public void setFirstNameInput(String firstName){
        type(firstNameInput, firstName);
    }
    public void setLastNameInput(String lastName){
        type(lastNameInput, lastName);
    }
    public void setStreetAddressInput(String streetName){
        type(streetAddressInput, streetName);
    }
    public void setCityInput(String city){
        type(cityInput, city);
    }
    public void setPostalCodeInput(String postalCode){
        type(postalCodeInput, postalCode);
    }
    public void setPhoneNumberInput(String phoneNumber){
        type(phoneNumberInput, phoneNumber);
    }
    public void selectStateDropdown(String option){
        selectOption(option, stateField);
    }
    public void selectCountryDropdown(String option){
        selectOption(option, countryField);
    }
    /**
     * First shipping method (the cheapest) will be selected
     */
    public void selectShippingMethod(){
        click(shippingRadiobutton);
    }
    public CheckoutPaymentPage clickNextButton(){
        click(nextButton);
        return new CheckoutPaymentPage();
    }











}
