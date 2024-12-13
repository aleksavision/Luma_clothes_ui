package pages.carts;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import tools.PageTools;


import static com.codeborne.selenide.Selenide.*;

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
        click(shippingMethodButton);
    }
    @Step("Click the  Next button")
    public CheckoutPaymentPage clickNextButton(){
        click(nextButton);
        return new CheckoutPaymentPage();
    }
    @Step("Open Order Summary info")
    public void clickOpenOrderSummaryButton(){
        if("block items-in-cart".equals(getElementAttributeValue("class", orderSummaryDropdown))){
            click(openOrderSummaryButton);
        }
    }
    @Step("Click View Details link")
    public void clickViewDetailsLink(){
        click(viewDetailsLink);
    }
    @Step("Get item name by {index}")
    public String getItemNameByIndex(int index){
        waitForElementVisible(itemName);
        return getElementTextByIndex(itemName, index);
    }
    @Step("Get item price by {index}")
    public String getItemPriceByIndex(int index){
        return getElementTextByIndex(itemPrice, index);
    }
    @Step("Get item size by {index}")
    public String getItemSizeByIndex(int index){
        return getElementTextByIndex(itemSize, index);
    }
    @Step("Get item color by {index}")
    public String getItemColorByIndex(int index){
        return getElementTextByIndex(itemColor, 1);
    }
    @Step("Get selected Shipping method")
    public String getSelectedShippingMethod(){
        String value = executeJavaScript("return arguments[0].getAttribute('checked');", $(shippingMethodButton));
        if(("tablerate_bestway").equals(value)){
            return getElementText(bestWayLabel) + " - " + getElementText(tableRateLabel);
        } if (("flatrate_flatrate").equals(value)){
            return getElementText(flatRateLabel) + " - " + getElementText(fixedLabel);
        } else return "Shipping method isn't selected";
    }












}
