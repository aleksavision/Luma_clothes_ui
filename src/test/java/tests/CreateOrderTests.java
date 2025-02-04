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

        Pages.productPage().selectSizeByIndex(2);
        Pages.productPage().selectColor();
        Pages.productPage().clickAddToCartButton();
        assertEquals(Pages.productPage().getSuccessMessage(), GlobalData.successATCMessage(Pages.productPage().getProductName()));

        Map<String, String> itemData = new HashMap<>();
        itemData.put("Name", Pages.productPage().getProductName());
        itemData.put("Size", Pages.productPage().getSelectedSize());
        itemData.put("Color", Pages.productPage().getSelectedColor());
        itemData.put("Price", Pages.productPage().getProductPrice());

        Pages.productPage().clickShoppingCartLink();
        assertEquals(Pages.shoppingCartPage().getItemPrice(), itemData.get("Price"));
        assertEquals(Pages.shoppingCartPage().getItemSubtotal(), itemData.get("Price"));

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
        assertEquals(Pages.checkoutShippingPage().getItemNameByIndex(1), itemData.get("Name"));
        assertEquals(Pages.checkoutShippingPage().getItemPriceByIndex(1), itemData.get("Price"));
        Pages.checkoutShippingPage().clickViewDetailsLink();
        assertEquals(Pages.checkoutShippingPage().getItemSizeByIndex(1), itemData.get("Size"));
        assertEquals(Pages.checkoutShippingPage().getItemColorByIndex(1), itemData.get("Color"));

        Pages.checkoutShippingPage().clickNextButton();
        assertEquals(Pages.checkoutPaymentPage().getOrderTotal(), "$39.00");
        assertEquals(Pages.checkoutPaymentPage().getItemNameByIndex(1), itemData.get("Name"));
        assertEquals(Pages.checkoutPaymentPage().getItemPriceByIndex(1), itemData.get("Price"));
        Pages.checkoutPaymentPage().clickViewDetailsLink();
        softAssert.assertEquals(Pages.checkoutPaymentPage().getItemSizeByIndex(1), itemData.get("Size"));
        softAssert.assertEquals(Pages.checkoutPaymentPage().getItemColorByIndex(1), itemData.get("Color"));
        softAssert.assertTrue(Pages.checkoutPaymentPage().getShipToInfoBoxText().contains(GlobalData.firstName));
        softAssert.assertTrue(Pages.checkoutPaymentPage().getShipToInfoBoxText().contains(GlobalData.lastName));
        softAssert.assertTrue(Pages.checkoutPaymentPage().getShipToInfoBoxText().contains(GlobalData.streetName));
        softAssert.assertTrue(Pages.checkoutPaymentPage().getShipToInfoBoxText().contains(GlobalData.cityName));
        softAssert.assertTrue(Pages.checkoutPaymentPage().getShipToInfoBoxText().contains(GlobalData.state));
        softAssert.assertTrue(Pages.checkoutPaymentPage().getShipToInfoBoxText().contains(GlobalData.validPostalCode));
        softAssert.assertTrue(Pages.checkoutPaymentPage().getShipToInfoBoxText().contains(GlobalData.country));
        softAssert.assertTrue(Pages.checkoutPaymentPage().getShipToInfoBoxText().contains(GlobalData.phoneNumber));
        softAssert.assertEquals(Pages.checkoutPaymentPage().getShippingMethodInfoBox(), selectedShippingMethod);
        softAssert.assertAll();

        Pages.checkoutPaymentPage().clickPlaceOrderButton();
        assertEquals(Pages.checkoutSuccessPage().getSuccessMessage(), GlobalData.successOrderCreatingTitle);
        assertEquals(Pages.checkoutSuccessPage().getSuccessMessageText(), GlobalData.successOrderCreatingMessage(Pages.checkoutSuccessPage().getOrderNumber()));

        Pages.checkoutSuccessPage().clickContinueShoppingButton();
        assertEquals(Pages.homepage().getPageUrl(), GlobalData.mainURL);
    }

}
