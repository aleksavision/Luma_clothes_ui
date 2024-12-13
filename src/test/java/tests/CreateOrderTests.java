package tests;

import baseTest.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
import pages.Pages;
import testData.GlobalData;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static testData.GlobalData.country;

public class CreateOrderTests extends BaseTest {

    @Test (groups = {"success", "order"})
    @Description("Random product card is selected. Product is added to cart successfully. Order is created successfully")
    @Severity(SeverityLevel.CRITICAL)
    public void successCreateOrderTest(){
        start(GlobalData.mainURL);

        Pages.homepage().clickWomenMenuButton().clickTopsLink().clickProductCardByIndex(1);
        Pages.productPage().mainElementsIsDisplayedAsserts();

        Pages.productPage().selectSize();
        Pages.productPage().selectColor();
        Pages.productPage().clickAddToCartButton();
        assertEquals(Pages.productPage().getSuccessMessage(), GlobalData.successATCMessage(Pages.productPage().getProductName()));

        Map<String, String> data = new HashMap<>();
        data.put("Name", Pages.productPage().getProductName());
        data.put("Size", Pages.productPage().getSelectedSize());
        data.put("Color", Pages.productPage().getSelectedColor());
        data.put("Price", Pages.productPage().getProductPrice());

        Pages.productPage().clickShoppingCartLink();
        assertEquals(Pages.shoppingCartPage().getItemPrice(), data.get("Price"));
        assertEquals(Pages.shoppingCartPage().getItemSubtotal(), data.get("Price"));

        Pages.shoppingCartPage().clickProceedToCheckoutButton();

        Pages.checkoutShippingPage().setEmailInput(GlobalData.validEmail);
        Pages.checkoutShippingPage().setFirstNameInput(GlobalData.firstName);
        Pages.checkoutShippingPage().setLastNameInput(GlobalData.lastName);
        Pages.checkoutShippingPage().setStreetAddressInput(GlobalData.streetName);
        Pages.checkoutShippingPage().setCityInput(GlobalData.cityName);
        Pages.checkoutShippingPage().selectStateDropdown(GlobalData.state);
        Pages.checkoutShippingPage().setPostalCodeInput(GlobalData.validPostalCode);
        Pages.checkoutShippingPage().selectCountryDropdown(country);
        Pages.checkoutShippingPage().setPhoneNumberInput(GlobalData.phoneNumber);
        Pages.checkoutShippingPage().selectShippingMethod();
        String selectedShippingMethod = Pages.checkoutShippingPage().getSelectedShippingMethod();

        Pages.checkoutShippingPage().clickOpenOrderSummaryButton();
        assertEquals(Pages.checkoutShippingPage().getItemNameByIndex(1), data.get("Name"));
        assertEquals(Pages.checkoutShippingPage().getItemPriceByIndex(1), data.get("Price"));
        Pages.checkoutShippingPage().clickViewDetailsLink();
        assertEquals(Pages.checkoutShippingPage().getItemSizeByIndex(1), data.get("Size"));
        assertEquals(Pages.checkoutShippingPage().getItemColorByIndex(1), data.get("Color"));

        Pages.checkoutShippingPage().clickNextButton();
        assertEquals(Pages.checkoutPaymentPage().getOrderTotal(), "$39.00");
        assertEquals(Pages.checkoutPaymentPage().getItemNameByIndex(1), data.get("Name"));
        assertEquals(Pages.checkoutPaymentPage().getItemPriceByIndex(1), data.get("Price"));
        Pages.checkoutPaymentPage().clickViewDetailsLink();
        assertEquals(Pages.checkoutPaymentPage().getItemSizeByIndex(1), data.get("Size"));
        assertEquals(Pages.checkoutPaymentPage().getItemColorByIndex(1), data.get("Color"));
        assertTrue(Pages.checkoutPaymentPage().getShipToInfoBoxText().contains(GlobalData.firstName));
        assertTrue(Pages.checkoutPaymentPage().getShipToInfoBoxText().contains(GlobalData.lastName));
        assertTrue(Pages.checkoutPaymentPage().getShipToInfoBoxText().contains(GlobalData.streetName));
        assertTrue(Pages.checkoutPaymentPage().getShipToInfoBoxText().contains(GlobalData.cityName));
        assertTrue(Pages.checkoutPaymentPage().getShipToInfoBoxText().contains(GlobalData.state));
        assertTrue(Pages.checkoutPaymentPage().getShipToInfoBoxText().contains(GlobalData.validPostalCode));
        assertTrue(Pages.checkoutPaymentPage().getShipToInfoBoxText().contains(GlobalData.country));
        assertTrue(Pages.checkoutPaymentPage().getShipToInfoBoxText().contains(GlobalData.phoneNumber));
        assertEquals(Pages.checkoutPaymentPage().getShippingMethodInfoBox(), selectedShippingMethod);

        Pages.checkoutPaymentPage().clickPlaceOrderButton();
        assertEquals(Pages.checkoutSuccessPage().getSuccessMessage(), GlobalData.successOrderCreatingTitle);
        assertEquals(Pages.checkoutSuccessPage().getSuccessMessageText(), GlobalData.successOrderCreatingMessage(Pages.checkoutSuccessPage().getOrderNumber()));

        Pages.checkoutSuccessPage().clickContinueShoppingButton();
        assertEquals(Pages.homepage().getPageUrl(), GlobalData.mainURL);
    }

}
