package pages.carts;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import pages.Pages;
import tools.PageTools;


import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.assertEquals;

public class CheckoutShippingPage extends PageTools {

    private final By fieldsetEmail = By.id("customer-email-fieldset");
    private final By fieldsetHidden = By.className("hidden-fields");
    private final By emailInput = By.xpath(".//input[@name='username']");
    private final By firstNameInput = By.xpath("//input[@name='firstname']");
    private final By lastNameInput = By.xpath("//input[@name='lastname']");
    private final By streetAddressInput = By.xpath("//input[@name='street[0]']");
    private final By cityInput = By.xpath("//input[@name='city']");
    private final By postalCodeInput = By.xpath("//input[@name='postcode']");
    private final By phoneNumberInput = By.xpath("//input[@name='telephone']");
    private final By stateField = By.xpath("//select[@name='region_id']");
    private final By countryField = By.xpath("//select[@name='country_id']");
    private final By shippingMethodButton = By.xpath("//input[@class='radio']");
    private final By nextButton = By.xpath("//button[@class='button action continue primary']");
    private final By openOrderSummaryButton = By.xpath("//div[@class='title']");
    private final By orderSummaryDropdown = By.xpath("//div[contains(@class,'block items-in-cart')]");
    private final By itemName = By.xpath("//strong[@class='product-item-name']");
    private final By itemQty = By.xpath("//span[@class='value']");
    private final By itemPrice = By.xpath("//span[@class='cart-price']/span");
    private final By viewDetailsLink = By.xpath("//span[@data-role='title']");
    private final By itemSize = By.xpath("//dd[@class='values'][1]");
    private final By itemColor = By.xpath("//dd[@class='values'][2]");
    private final By tableRateLabel = By.xpath("//td[@id='label_method_bestway_tablerate']");
    private final By bestWayLabel = By.xpath("//td[@id='label_carrier_bestway_tablerate']");
    private final By fixedLabel = By.xpath("//td[@id='label_method_flatrate_flatrate']");
    private final By flatRateLabel = By.xpath("//td[@id='label_carrier_flatrate_flatrate']");
    private final By logo = By.xpath("//a[@class='logo']");
    private final By emailError = By.xpath(".//div[@for='customer-email']");
    private final By firstNameError = By.xpath("//input[@name='firstname']/following-sibling::div/span");
    private final By lastNameError = By.xpath("//input[@name='lastname']/following-sibling::div/span");
    private final By streetError = By.xpath("//input[@name='street[0]']/following-sibling::div/span");
    private final By cityError = By.xpath("//input[@name='city']/following-sibling::div/span");
    private final By postalCodeError = By.xpath("//input[@name='postcode']/following-sibling::div/span");
    private final By stateError = By.xpath("//select[@name='region_id']/following-sibling::div/span");
    private final By phoneError = By.xpath("//div[@class='field-tooltip toggle']/following-sibling::div/span");
    private final By countryError = By.xpath("//select[@name='country_id']/following-sibling::div/span");
    private final By shippingMethodError = By.xpath("//div[@role='alert']/span");

    //-------------isDisplayed--------------

    @Step("Check if Email field is displayed")
    public boolean checkEmailInputIsDisplayed() {
        waitForElementVisibleUntil(nextButton, 5);
//        sleep(5000);
        return isElementInFieldsetVisible(fieldsetEmail, emailInput);
    }

    @Step("Check if First name field is displayed")
    public boolean checkFirstNameInputIsDisplayed() {
        return isElementVisible(firstNameInput);
    }

    @Step("Check if Last name field is displayed")
    public boolean checkLastNameInputIsDisplayed() {
        return isElementVisible(lastNameInput);
    }

    @Step("Check if Street address field is displayed")
    public boolean checkStreetAddressInputIsDisplayed() {
        return isElementVisible(streetAddressInput);
    }

    @Step("Check if City field is displayed")
    public boolean checkCityInputIsDisplayed() {
        return isElementVisible(cityInput);
    }

    @Step("Check if State dropdown is displayed")
    public boolean checkStateDropdownIsDisplayed() {
        return isElementVisible(stateField);
    }

    @Step("Check if Country dropdown is displayed")
    public boolean checkCountryDropdownIsDisplayed() {
        return isElementVisible(countryField);
    }

    @Step("Check if Postal code field is displayed")
    public boolean checkPostalCodeInputIsDisplayed() {
        return isElementVisible(postalCodeInput);
    }

    @Step("Check if Phone number field is displayed")
    public boolean checkPhoneNumberInputIsDisplayed() {
        return isElementVisible(phoneNumberInput);
    }

    @Step("Check if Shipping radiobutton is displayed")
    public boolean checkShippingMethodButtonIsDisplayed() {
        return isElementVisible(shippingMethodButton);
    }

    @Step("Check if Next button is displayed")
    public boolean checkNextButtonIsDisplayed() {
        return isElementVisible(nextButton);
    }

    //-------------Get--------------

    @Step("Get Email field error text")
    public String getEmailFieldError() {
        return getElementFieldsetText(fieldsetEmail, emailError);
    }

    @Step("Get First Name field error text")
    public String getFirstNameFieldError() {
        return getElementText(firstNameError);
    }

    @Step("Get Last Name field error text")
    public String getLastNameFieldError() {
        return getElementText(lastNameError);
    }

    @Step("Get Street field error text")
    public String getStreetFieldError() {
        return getElementText(streetError);
    }

    @Step("Get City Name field error text")
    public String getCityFieldError() {
        return getElementText(cityError);
    }

    @Step("Get State field error text")
    public String getStateFieldError() {
        return getElementText(stateError);
    }

    @Step("Get Postal Code field error text")
    public String getPostalCodeFieldError() {
        return getElementText(postalCodeError);
    }

    @Step("Get Country field error text")
    public String getCountryFieldError() {
        return getElementText(countryError);
    }

    @Step("Get Phone Number field error text")
    public String getPhoneNumberFieldError() {
        return getElementText(phoneError);
    }

    @Step("Get Shipping method field error text")
    public String getShippingMethodFieldError() {
        return getElementText(shippingMethodError);
    }

    @Step("Get item name by {index}")
    public String getItemNameByIndex(int index) {
        waitForElementVisible(itemName);
        return getElementTextByIndex(itemName, index);
    }

    @Step("Get item price by {index}")
    public String getItemPriceByIndex(int index) {
        return getElementTextByIndex(itemPrice, index);
    }

    @Step("Get item size by {index}")
    public String getItemSizeByIndex(int index) {
        return getElementTextByIndex(itemSize, index);
    }

    @Step("Get item color by {index}")
    public String getItemColorByIndex(int index) {
        return getElementTextByIndex(itemColor, 1);
    }

    @Step("Get selected Shipping method")
    public String getSelectedShippingMethod() {
        String value = executeJavaScript("return arguments[0].getAttribute('checked');", $(shippingMethodButton));
        if (("tablerate_bestway").equals(value)) {
            return getElementText(bestWayLabel) + " - " + getElementText(tableRateLabel);
        }
        if (("flatrate_flatrate").equals(value)) {
            return getElementText(flatRateLabel) + " - " + getElementText(fixedLabel);
        } else return "Shipping method isn't selected";
    }

    //-------------Click/Select--------------

    @Step("Select {option} in State dropdown")
    public void selectStateDropdown(String option) {
        selectOption(option, stateField);
    }

    @Step("Select {option} in Country dropdown")
    public void selectCountryDropdown(String option) {
        selectOption(option, countryField);
    }

    /**
     * First shipping method (the cheapest) will be selected
     */
    @Step("Select the first (the cheapest one) shipping method")
    public void selectShippingMethod() {
        click(shippingMethodButton);
    }

    @Step("Click the  Next button")
    public CheckoutPaymentPage clickNextButton() {
        click(nextButton);
        return new CheckoutPaymentPage();
    }

    @Step("Click View Details link")
    public void clickViewDetailsLink() {
        click(viewDetailsLink);
    }

    //-------------Set--------------

    @Step("Fill Email field with {email} ")
    public void setEmailInput(String email) {
        typeIntoElementInFieldset(fieldsetEmail, emailInput, email);
    }

    @Step("Fill First Name field with {firstName}")
    public void setFirstNameInput(String firstName) {
        type(firstNameInput, firstName);
    }

    @Step("Fill Last Name field with {lastName}")
    public void setLastNameInput(String lastName) {
        type(lastNameInput, lastName);
    }

    @Step("Fill Street Address field with {streetName}")
    public void setStreetAddressInput(String streetName) {
        type(streetAddressInput, streetName);
    }

    @Step("Fill City field with {city}")
    public void setCityInput(String city) {
        type(cityInput, city);
    }

    @Step("Fill Postal Code field with {postalCode}")
    public void setPostalCodeInput(String postalCode) {
        type(postalCodeInput, postalCode);
    }

    @Step("Fill Phone Number field with {phoneNumber}")
    public void setPhoneNumberInput(String phoneNumber) {
        type(phoneNumberInput, phoneNumber);
    }

    @Step("Open Order Summary info")
    public void clickOpenOrderSummaryButton() {
        if ("block items-in-cart".equals(getElementAttributeValue("class", orderSummaryDropdown))) {
            click(openOrderSummaryButton);
        }
    }

    //-------------Others--------------

    @Step("Get error messages from different fields")
    public void getErrorMessages(Object errorMethod, String expectedError) {
        // Если errorMethods - это строка, проверяем одну ошибку
        if (errorMethod instanceof String) {
            assertEquals(getErrorUsingMethod((String) errorMethod), expectedError);
        }
        // Если errorMethods - это массив строк, проверяем несколько ошибок для пустых полей
        else if (errorMethod instanceof String[]) {
            String[] methods = (String[]) errorMethod;
            for (String method : methods) {
                assertEquals(getErrorUsingMethod(method), expectedError);
            }
        }
    }

    private String getErrorUsingMethod(String errorMethod) {
        switch (errorMethod) {
            case "getEmailFieldError", "getEmailFieldInvalidError":
                return getEmailFieldError();
            case "getFirstNameFieldError":
                return getFirstNameFieldError();
            case "getLastNameFieldError":
                return getLastNameFieldError();
            case "getStreetAddressFieldError":
                return getStreetFieldError();
            case "getCityFieldError":
                return getCityFieldError();
            case "getStateFieldError":
                return getStateFieldError();
            case "getPostalCodeFieldError":
                return getPostalCodeFieldError();
            case "getPhoneNumberFieldError":
                return getPhoneNumberFieldError();
            default:
                throw new IllegalArgumentException("Unknown error method: " + errorMethod);
        }
    }


}
