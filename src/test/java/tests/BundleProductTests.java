package tests;

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

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class BundleProductTests extends BaseTest {

    String bundleItemOption = "Joust Duffle Bag +$170.00";

    @BeforeMethod
    public void startTest() {
        start(GlobalData.mainURL);
        Actions.miniCartActions().clearCart();
        Pages.header().clickWomenTestMenuButton().clickBundleProductCard();
        Pages.productPage().clickCustomizeATCButton();
    }

    @Test(groups = {"elements"})
    @Description("Bundle product page is opened. All elements are displayed")
    @Severity(SeverityLevel.CRITICAL)
    public void checkElementsDisplaying() {
        Pages.productPage().mainElementsIsDisplayedBundleAsserts();
    }

    @Test(groups = {"success", "addToCart"})
    @Description("Bundle product page is opened. Product is added to cart successfully")
    @Severity(SeverityLevel.CRITICAL)
    public void successAddingToCart() {

        Pages.productPage().selectBundleItem(bundleItemOption);
        Pages.productPage().clickAddToCartButton();
        assertEquals(Pages.productPage().getSuccessMessage(), GlobalData.successATCMessage(Pages.productPage().getProductName()));
    }

    @Test(groups = {"unsuccess", "addToCart"})
    @Description("Bundle product card is selected. Bundle item isn't selected. Product isn't added to cart")
    @Severity(SeverityLevel.NORMAL)
    public void noSelectedItemOption() {

        Pages.productPage().clickAddToCartButton();
        assertEquals(Pages.productPage().getBundleItemErrorMessage(), GlobalData.requiredFieldError);
    }

    @Test(groups = {"unsuccess", "addToCart"}, dataProvider = "invalidItemQtyData", dataProviderClass = TestDataProviders.class)
    @Description("Bundle product card is selected. Bundle item is selected. Item qty is changed to invalid. Product isn't added to cart")
    @Severity(SeverityLevel.NORMAL)
    public void invalidItemQtyTest(String itemQty, String expectedError) {

        Pages.productPage().selectBundleItem(bundleItemOption);
        Pages.productPage().setQtyInput(itemQty);
        Pages.productPage().clickAddToCartButton();

        assertEquals(Pages.productPage().getQtyErrorMessage(), expectedError);
    }

    @Test(groups = {"success", "addToCart"})
    @Description("Bundle product card is selected. Qty is changed. Product is added to cart successfully. The same product is displayed on Shopping cart")
    @Severity(SeverityLevel.NORMAL)
    public void checkAddedItemInCart() {
        String itemQty = "5";
        String selectedBundleItem = "1 x Joust Duffle Bag";
        Map<String, String> bundleProductData = new HashMap<>();

        Pages.productPage().selectBundleItem(bundleItemOption);
        Pages.productPage().setQtyInput(itemQty);
        Pages.productPage().clickAddToCartButton();
        assertTrue(Pages.productPage().getSelectedBundleItemName().contains(selectedBundleItem));

        bundleProductData.put("Product Name", Pages.productPage().getProductName());
        bundleProductData.put("Price", Pages.productPage().getSelectedBundleItemPrice());

        Pages.productPage().clickShoppingCartLink();
        assertEquals(Pages.shoppingCartPage().getItemName(), bundleProductData.get("Product Name"));
        assertEquals(Pages.shoppingCartPage().getItemQty(), itemQty);
        softAssert.assertEquals(Pages.shoppingCartPage().getItemPrice(), bundleProductData.get("Price"));
        softAssert.assertAll();
    }


}
