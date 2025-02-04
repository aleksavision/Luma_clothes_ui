package tests;

import baseTest.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
import pages.Pages;
import testData.GlobalData;
import testData.TestDataProviders;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertEquals;

public class BundleProductAtcTests extends BaseTest {

    @Test(groups = {"success", "addToCart"})
    @Description("Bundle product card is selected. Product is added to cart successfully. Mini-cart is checked. Item qty is changed successfully")
    @Severity(SeverityLevel.NORMAL)
    public void successBundleItemAddingQtyChanging() {
        start(GlobalData.mainURL);
        Pages.homepage().clickWomenMenuButton().clickTestLink().clickBundleProductCard();
        Pages.productPage().mainElementsIsDisplayedAsserts();

        String bundleItemName = "Joust Duffle Bag +$170.00";
        String newItemQty = "3";
        Pages.productPage().clickCustomizeATCButton();
        Pages.productPage().selectBundleItem(bundleItemName);
        Pages.productPage().setQtyInput(newItemQty);
        Pages.productPage().clickAddToCartButton();
        assertEquals(Pages.productPage().getSuccessMessage(),GlobalData.successATCMessage(Pages.productPage().getProductName()));

        Map<String, String> itemData = new HashMap<>();
        itemData.put("Product name", Pages.productPage().getProductName());
        itemData.put("Bundle name", Pages.productPage().getSelectedBundleItemName());
        itemData.put("Price", "170.00");
        itemData.put("Qty", Pages.productPage().getItemQty());

        Pages.header().clickCartButton();
        Pages.header().clickSeeDetailsLink();
        assertEquals(Pages.header().getItemQty(), newItemQty);
        assertEquals(Pages.header().getItemName(), itemData.get("Product name"));
        softAssert.assertEquals(Pages.header().getItemPrice(), itemData.get("Price"));
        softAssert.assertEquals(Pages.header().getItemDetailedInfo(),itemData.get("Bundle name") + " " + itemData.get("Price"));
        softAssert.assertEquals(Pages.header().getCartSubtotal(), "$510.00");

        String updatedItemQty = "5";
        Pages.header().setQtyInput(updatedItemQty);
        Pages.header().clickUpdateButton();
        softAssert.assertEquals(Pages.header().getItemPrice(), itemData.get("Price"));
        softAssert.assertEquals(Pages.header().getItemQty(), updatedItemQty);
        softAssert.assertEquals(Pages.header().getCartSubtotal(), "$850.00");
        softAssert.assertAll();
    }

    @Test(groups = {"success", "addToCart"})
    @Description("Bundle product card isn't selected. Bundle item is selected and added to cart. Item selection is changed from Mini-cart successfully")
    @Severity(SeverityLevel.NORMAL)
    public void errorSuccessItemAddingSelectionChanging() {
        start(GlobalData.mainURL);
        Pages.homepage().clickWomenMenuButton().clickTestLink().clickBundleProductCard();
        Pages.productPage().mainElementsIsDisplayedAsserts();

        Pages.productPage().clickCustomizeATCButton();
        Pages.productPage().clickAddToCartButton();
        assertEquals(Pages.productPage().getBundleItemErrorMessage(), GlobalData.requiredFieldError);

        String bundleItemName = "Strive Shoulder Pack +$160.00";
        Pages.productPage().selectBundleItem(bundleItemName);
        Pages.productPage().clickAddToCartButton();
        assertEquals(Pages.productPage().getSuccessMessage(),GlobalData.successATCMessage(Pages.productPage().getProductName()));

        HashMap<String, String> shoulderPackItemData = new HashMap<>();
        shoulderPackItemData.put("Name", Pages.productPage().getSelectedBundleItemName());
        shoulderPackItemData.put("Price", Pages.productPage().getSelectedBundleItemPrice());

        Pages.header().clickCartButton();
        Pages.header().clickSeeDetailsLink();
        softAssert.assertEquals(Pages.header().getItemDetailedPrice(), shoulderPackItemData.get("Price"));
        softAssert.assertTrue(Pages.header().getItemDetailedInfo().contains(shoulderPackItemData.get("Name")));

        Pages.header().clickEditItemButton();
        Pages.productPage().selectBundleItem("Rival Field Messenger +$225.00");

        HashMap<String, String> messengerItemData = new HashMap<>();
        messengerItemData.put("Name", Pages.productPage().getSelectedBundleItemName());
        messengerItemData.put("Price", Pages.productPage().getSelectedBundleItemPrice());
        Pages.productPage().clickUpdateCartButton();

        assertEquals(Pages.shoppingCartPage().getSuccessInfoMessage(), GlobalData.successCartUpdatingMessage);
        softAssert.assertEquals(Pages.shoppingCartPage().getItemSubtotal(), messengerItemData.get("Price"));
        softAssert.assertEquals(Pages.shoppingCartPage().getOrderSubtotal(), messengerItemData.get("Price"));
        softAssert.assertEquals(Pages.shoppingCartPage().getOrderTotal(), messengerItemData.get("Price"));
        softAssert.assertAll();
    }

    @Test(groups = {"unsuccess", "addToCart"}, dataProvider = "invalidItemQtyData", dataProviderClass = TestDataProviders.class)
    @Description("Bundle product card is selected. Bundle item is selected. Item qty is changed to invalid. Product isn't added to cart")
    @Severity(SeverityLevel.NORMAL)
    public void invalidItemQtyATCTest(String itemQty, String expectedError) {
        start(GlobalData.mainURL);

        Pages.homepage().clickWomenMenuButton().clickTestLink().clickBundleProductCard();
        Pages.productPage().mainElementsIsDisplayedAsserts();

        Pages.productPage().clickCustomizeATCButton();
        Pages.productPage().selectBundleItem("Rival Field Messenger +$225.00");
        Pages.productPage().setQtyInput(itemQty);
        Pages.productPage().clickAddToCartButton();

        assertEquals(Pages.productPage().getQtyErrorMessage(), expectedError);
    }
}
