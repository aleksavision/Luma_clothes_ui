package tests.checkoutTests;

import actions.Actions;
import baseTest.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.Pages;
import testData.GlobalData;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class PaymentCheckoutTests extends BaseTest {

    @BeforeTest
    public void startTest() {
        start("http://46.101.147.48/erika-running-short.html");
        Actions.productPageActions().addSingleProductToCart();
        Pages.miniCart().clickCartButton();
        Pages.miniCart().clickProceedToCheckoutButton();
        Actions.checkoutShippingPageActions().fillShippingForm(GlobalData.validEmail, GlobalData.firstName, GlobalData.lastName,
                GlobalData.streetName, GlobalData.cityName, GlobalData.state, GlobalData.validPostalCode, GlobalData.phoneNumber);
        Pages.checkoutShippingPage().selectShippingMethod();
        Pages.checkoutShippingPage().clickNextButton();
    }

    @Test(groups = {"success"})
    @Description("Product is added to Cart. User proceeds to Checkout Payment page. Correct Shipping info is displayed in Ship To sidebar section")
    @Severity(SeverityLevel.NORMAL)
    public void checkShippingInfoInShipToSection() {
        assertTrue(Pages.checkoutPaymentPage().getShipToInfoBoxText().contains(GlobalData.firstName));
        assertTrue(Pages.checkoutPaymentPage().getShipToInfoBoxText().contains(GlobalData.lastName));
        assertTrue(Pages.checkoutPaymentPage().getShipToInfoBoxText().contains(GlobalData.streetName));
        assertTrue(Pages.checkoutPaymentPage().getShipToInfoBoxText().contains(GlobalData.cityName));
        assertTrue(Pages.checkoutPaymentPage().getShipToInfoBoxText().contains(GlobalData.state));
        assertTrue(Pages.checkoutPaymentPage().getShipToInfoBoxText().contains(GlobalData.validPostalCode));
        assertTrue(Pages.checkoutPaymentPage().getShipToInfoBoxText().contains(GlobalData.phoneNumber));
    }

    @Test(groups = {"success"})
    @Description("Product is added to Cart. User proceeds to Checkout Payment page. Correct Billing address is displayed in Ship To sidebar section")
    @Severity(SeverityLevel.NORMAL)
    public void checkBillingShippingAddress() {
        assertTrue(Pages.checkoutPaymentPage().getBillingAddressText().contains(GlobalData.firstName));
        assertTrue(Pages.checkoutPaymentPage().getBillingAddressText().contains(GlobalData.lastName));
        assertTrue(Pages.checkoutPaymentPage().getBillingAddressText().contains(GlobalData.streetName));
        assertTrue(Pages.checkoutPaymentPage().getBillingAddressText().contains(GlobalData.cityName));
        assertTrue(Pages.checkoutPaymentPage().getBillingAddressText().contains(GlobalData.state));
        assertTrue(Pages.checkoutPaymentPage().getBillingAddressText().contains(GlobalData.validPostalCode));
        assertTrue(Pages.checkoutPaymentPage().getBillingAddressText().contains("United States"));
        assertTrue(Pages.checkoutPaymentPage().getBillingAddressText().contains(GlobalData.phoneNumber));
    }

    @Test(groups = {"success", "order"})
    @Description("Product is added to Cart. User proceeds to Checkout Payment page. Order is placed successfully. User proceeds to Homepage")
    @Severity(SeverityLevel.CRITICAL)
    public void successCreateOrderTest() {

        Pages.checkoutPaymentPage().clickPlaceOrderButton();
        assertEquals(Pages.checkoutSuccessPage().getSuccessMessage(), GlobalData.successOrderCreatingTitle);
        assertEquals(Pages.checkoutSuccessPage().getSuccessMessageText(), GlobalData.successOrderCreatingMessage(Pages.checkoutSuccessPage().getOrderNumber()));

        Pages.checkoutSuccessPage().clickContinueShoppingButton();
        assertEquals(Pages.homepage().getPageUrl(), GlobalData.mainURL);
    }


}
