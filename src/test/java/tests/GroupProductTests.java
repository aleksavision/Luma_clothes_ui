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

public class GroupProductTests extends BaseTest {

    @BeforeMethod
    public void startTest() {
        start(GlobalData.mainURL);
        Actions.miniCartActions().clearCart();
        Pages.header().clickWomenTestMenuButton().clickGroupProductCard();
    }

    @Test(groups = {"elements"})
    @Description("Group product page is opened. All elements are displayed")
    @Severity(SeverityLevel.CRITICAL)
    public void checkElementsDisplaying() {
        Pages.productPage().mainElementsIsDisplayedGroupAsserts();
    }

    @Test(groups = {"unsuccess", "addToCart"}, dataProvider = "invalidGroupItemQtyData", dataProviderClass = TestDataProviders.class)
    @Description("Group product card is selected. Qty field is filled with invalid data. Product isn't added to cart. Error is displayed")
    @Severity(SeverityLevel.NORMAL)
    public void invalidItemQtyTest(String itemQty, String errorMethod, String expectedError) {
        Pages.productPage().setQtyInputGroupItem(1, itemQty);
        Pages.productPage().setQtyInputGroupItem(2, itemQty);
        Pages.productPage().setQtyInputGroupItem(3, itemQty);
        Pages.productPage().clickAddToCartButton();
        assertEquals(Pages.productPage().getErrorUsingMethod(errorMethod), expectedError);
    }

    @Test(groups = {"success", "addToCart"}, dataProvider = "validGroupItemQtyDataChanging", dataProviderClass = TestDataProviders.class)
    @Description("Group product card is selected. Items qty is changed. Product is added to cart successfully")
    @Severity(SeverityLevel.NORMAL)
    public void successAddingToCart(String packItemQty, String bagItemQty, String backpackItemQty, String expectedMessage) {
        Pages.productPage().setQtyInputGroupItem(1, packItemQty);
        Pages.productPage().setQtyInputGroupItem(2, bagItemQty);
        Pages.productPage().setQtyInputGroupItem(3, backpackItemQty);
        Pages.productPage().clickAddToCartButton();
        assertEquals(Pages.productPage().getSuccessMessage(), expectedMessage);
    }

    @Test(groups = {"success", "addToCart"})
    @Description("Group product card is selected. Qty is changed. Product is added to cart successfully. The same product is displayed on Shopping cart")
    @Severity(SeverityLevel.NORMAL)
    public void checkAddedItemInCart() {
        String packItemQty = "5";
        String bagItemQty = "11";
        String backpackItemQty = "100";
        Map<String, String> groupProductData = new HashMap<>();

        Pages.productPage().setQtyInputGroupItem(1, packItemQty);
        Pages.productPage().setQtyInputGroupItem(2, bagItemQty);
        Pages.productPage().setQtyInputGroupItem(3, backpackItemQty);
        Pages.productPage().clickAddToCartButton();

        groupProductData.put("Pack name", Pages.productPage().getGroupItemName(1));
        groupProductData.put("Bag name", Pages.productPage().getGroupItemName(2));
        groupProductData.put("Backpack name", Pages.productPage().getGroupItemName(3));
        groupProductData.put("Pack price", Pages.productPage().getGroupItemPrice(1));
        groupProductData.put("Bag price", Pages.productPage().getGroupItemPrice(2));
        groupProductData.put("Backpack price", Pages.productPage().getGroupItemPrice(3));

        Pages.productPage().clickShoppingCartLink();
        assertEquals(Pages.shoppingCartPage().getItemNameByIndex(1), groupProductData.get("Pack name"));
        assertEquals(Pages.shoppingCartPage().getItemNameByIndex(2), groupProductData.get("Bag name"));
        assertEquals(Pages.shoppingCartPage().getItemNameByIndex(3), groupProductData.get("Backpack name"))
        ;
        assertEquals(Pages.shoppingCartPage().getItemPriceByIndex(1), groupProductData.get("Pack price"));
        assertEquals(Pages.shoppingCartPage().getItemPriceByIndex(2), groupProductData.get("Bag price"));
        assertEquals(Pages.shoppingCartPage().getItemPriceByIndex(3), groupProductData.get("Backpack price"));

        assertEquals(Pages.shoppingCartPage().getItemQtyByIndex(1), packItemQty);
        assertEquals(Pages.shoppingCartPage().getItemQtyByIndex(2), bagItemQty);
        assertEquals(Pages.shoppingCartPage().getItemQtyByIndex(3), backpackItemQty);
    }

}
