//package tests;
//
//import baseTest.BaseTest;
//import io.qameta.allure.Description;
//import io.qameta.allure.Severity;
//import io.qameta.allure.SeverityLevel;
//import org.testng.annotations.Test;
//import pages.Pages;
//import testData.GlobalData;
//
//import static org.testng.Assert.assertTrue;
//
//public class CreateOrderTests extends BaseTest {
//
//    @Test (groups = {"success", "order"})
//    @Description("Random product card is selected. Product is added to cart successfully. Order is created successfully")
//    @Severity(SeverityLevel.CRITICAL)
//    public void successCreateOrderTest(){
//        start(GlobalData.mainURL);
//        String state = "Alabama";
//        String country = "United States";
//
//        Pages.homepage().clickWomenMenuButton().clickTopsLink().clickFirstProductCard();
//        Pages.productPage().mainElementsIsDisplayedAsserts();
//
//        Pages.productPage().selectSize();
//        Pages.productPage().selectColor();
//        Pages.productPage().clickAddToCartButton();
//        softAssert.assertTrue(Pages.productPage().getSuccessATCMessage().startsWith(GlobalData.successATCMessagePartly));
//
//        Pages.productPage().clickShoppingCartLink();
//        assertTrue(Pages.shoppingCartPage().totalAmountIsDisplayed());
//
//        Pages.shoppingCartPage().clickProceedToCheckoutButton();
//        Pages.checkoutShippingPage().setEmailInput(GlobalData.validEmail);
//        Pages.checkoutShippingPage().setFirstNameInput(GlobalData.firstName);
//        Pages.checkoutShippingPage().setLastNameInput(GlobalData.lastName);
//        Pages.checkoutShippingPage().setStreetAddressInput(GlobalData.streetName);
//        Pages.checkoutShippingPage().setCityInput(GlobalData.cityName);
//        Pages.checkoutShippingPage().selectStateDropdown(state);
//        Pages.checkoutShippingPage().setPostalCodeInput(GlobalData.validPostalCode);
//        Pages.checkoutShippingPage().selectCountryDropdown(country);
//        Pages.checkoutShippingPage().setPhoneNumberInput(GlobalData.phoneNumber);
//        Pages.checkoutShippingPage().selectShippingMethod();
//        Pages.checkoutShippingPage().clickNextButton();
//        assertTrue(Pages.checkoutPaymentPage().totalAmountIsDisplayed());
//
//        Pages.checkoutPaymentPage().clickPlaceOrderButton();
//        softAssert.assertEquals(Pages.checkoutSuccessPage().getSuccessMessage(), GlobalData.successOrderCreatingMessage);
//        softAssert.assertAll();
//
//        System.out.println("Your order number is: " + Pages.checkoutSuccessPage().getOrderNumber());
//    }
//
//}
