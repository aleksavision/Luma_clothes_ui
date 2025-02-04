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

public class GroupProductAtcTests extends BaseTest {

    @Test(groups = {"success", "addToCart"})
    @Description("Group product card is selected. Product is added to cart wishlist and cart successfully. Product is updated successfully")
    @Severity(SeverityLevel.NORMAL)
    public void successGroupItemAdding() {
        start(GlobalData.mainURL);

        Pages.homepage().clickWomenMenuButton().clickTestLink().clickGroupProductCard();
        Pages.productPage().mainElementsIsDisplayedAsserts();

        Map<String, String> groupItemData = new HashMap<>();
        groupItemData.put("Product name", Pages.productPage().getProductName());
        groupItemData.put("Pack name", Pages.productPage().getGroupItemName(1));
        groupItemData.put("Bag name", Pages.productPage().getGroupItemName(2));
        groupItemData.put("Backpack name", Pages.productPage().getGroupItemName(3));
        groupItemData.put("Pack price", Pages.productPage().getGroupItemPrice(1));
        groupItemData.put("Bag price", Pages.productPage().getGroupItemPrice(2));
        groupItemData.put("Backpack price", Pages.productPage().getGroupItemPrice(3));
        groupItemData.put("Pack qty", Pages.productPage().getGroupItemQty(1));
        groupItemData.put("Bag qty", Pages.productPage().getGroupItemQty(2));
        groupItemData.put("Backpack qty", Pages.productPage().getGroupItemQty(3));
        groupItemData.put("Order total", "$104.00");

        Pages.productPage().clickAddToWishlistButtonAsGuest();
        assertEquals(Pages.loginPage().getErrorMessageText(), GlobalData.notRegistredUserForWishlistErrorMessage);

        Pages.loginPage().setEmailInput(GlobalData.validEmail);
        Pages.loginPage().setPasswordInput(GlobalData.validPassword);
        Pages.loginPage().clickSignInButtonToWishlist();
        assertEquals(Pages.myWishListPage().getSuccessMessageText(), GlobalData.successAddingToWishlistMessage(groupItemData.get("Product name")));
        assertEquals(Pages.myWishListPage().getItemName(1), groupItemData.get("Product name"));
        assertEquals(Pages.myWishListPage().getItemPrice(1), groupItemData.get("Order total"));
        Pages.myWishListPage().openOptionsDetailsForItemByIndex(1);
        assertEquals(Pages.myWishListPage().getGroupItemNameByIndex(1), groupItemData.get("Pack name"));
        assertEquals(Pages.myWishListPage().getGroupItemNameByIndex(2), groupItemData.get("Bag name"));
        assertEquals(Pages.myWishListPage().getGroupItemNameByIndex(3), groupItemData.get("Backpack name"));
        assertEquals(Pages.myWishListPage().getGroupItemQtyByIndex(1), groupItemData.get("Pack qty"));
        assertEquals(Pages.myWishListPage().getGroupItemQtyByIndex(2), groupItemData.get("Bag qty"));
        assertEquals(Pages.myWishListPage().getGroupItemQtyByIndex(3), groupItemData.get("Backpack qty"));
        Pages.header().clickCartButton();
        Pages.header().clearCart();

        Pages.header().clickWomenShortsMenuButton();
        Map<String, String> shortItemData = new HashMap<>();
        shortItemData.put("Name", Pages.shortsPage().getItemNameByIndex(1));
        shortItemData.put("Price", Pages.shortsPage().getItemPriceByIndex(1));

        Pages.shortsPage().clickAddToWishlistButtonByIndexAsUser(1);
        assertEquals(Pages.myWishListPage().getSuccessMessageText(), GlobalData.successAddingToWishlistMessage(shortItemData.get("Name")));

        assertEquals(Pages.myWishListPage().getItemName(2), shortItemData.get("Name"));
        assertEquals(Pages.myWishListPage().getItemPrice(2), shortItemData.get("Price"));

        Pages.myWishListPage().clickRemoveItemButtonByIndex(2);
        assertEquals(Pages.myWishListPage().getSuccessMessageText(), GlobalData.successItemRemovingFromWishlistMessage(shortItemData.get("Name")));
        assertEquals(Pages.myWishListPage().getItemsQty(), GlobalData.itemQtyInWishlist("1"));

        Pages.myWishListPage().clickAddAllToCartButton();
        assertEquals(Pages.myWishListPage().getSuccessMessageText(), GlobalData.successATCFromWishlistMessage(groupItemData.get("Product name")));
        assertEquals(Pages.myWishListPage().getEmptyMessageText(), GlobalData.wishlistEmptyInfoMessage);

        Pages.header().clickCartButton();
        Pages.header().clickViewAndEditCartLink();
        assertEquals(Pages.shoppingCartPage().getItemNameByIndex(1), groupItemData.get("Pack name"));
        assertEquals(Pages.shoppingCartPage().getItemNameByIndex(2), groupItemData.get("Bag name"));
        assertEquals(Pages.shoppingCartPage().getItemNameByIndex(3), groupItemData.get("Backpack name"));
        assertEquals(Pages.shoppingCartPage().getItemQtyByIndex(1), groupItemData.get("Pack qty"));
        assertEquals(Pages.shoppingCartPage().getItemQtyByIndex(2), groupItemData.get("Bag qty"));
        assertEquals(Pages.shoppingCartPage().getItemQtyByIndex(3), groupItemData.get("Backpack qty"));
        assertEquals(Pages.shoppingCartPage().getItemPriceByIndex(1), groupItemData.get("Pack price"));
        assertEquals(Pages.shoppingCartPage().getItemPriceByIndex(2), groupItemData.get("Bag price"));
        assertEquals(Pages.shoppingCartPage().getItemPriceByIndex(3), groupItemData.get("Backpack price"));
        assertEquals(Pages.shoppingCartPage().getItemSubtotalByIndex(1, groupItemData.get("Pack name")), groupItemData.get("Pack price"));
        assertEquals(Pages.shoppingCartPage().getItemSubtotalByIndex(2, groupItemData.get("Bag name")), groupItemData.get("Bag price"));
        assertEquals(Pages.shoppingCartPage().getItemSubtotalByIndex(3, groupItemData.get("Backpack name")), groupItemData.get("Backpack price"));
        assertEquals(Pages.shoppingCartPage().getOrderTotal(), groupItemData.get("Order total"));

        Pages.shoppingCartPage().setItemQtyInputByIndex(1, "2");
        Pages.shoppingCartPage().setItemQtyInputByIndex(2, "5");
        Pages.shoppingCartPage().setItemQtyInputByIndex(3, "10");
        Pages.shoppingCartPage().clickUpdateCartButton();
        assertEquals(Pages.shoppingCartPage().getItemPriceByIndex(1), groupItemData.get("Pack price"));
        assertEquals(Pages.shoppingCartPage().getItemPriceByIndex(2), groupItemData.get("Bag price"));
        assertEquals(Pages.shoppingCartPage().getItemPriceByIndex(3), groupItemData.get("Backpack price"));
        assertEquals(Pages.shoppingCartPage().getItemQtyByIndex(1), "2");
        assertEquals(Pages.shoppingCartPage().getItemQtyByIndex(2), "5");
        assertEquals(Pages.shoppingCartPage().getItemQtyByIndex(3), "10");
        assertEquals(Pages.shoppingCartPage().getItemSubtotalByIndex(1, groupItemData.get("Pack name")), "$64.00");
        assertEquals(Pages.shoppingCartPage().getItemSubtotalByIndex(2, groupItemData.get("Bag name")), "$170.00");
        assertEquals(Pages.shoppingCartPage().getItemSubtotalByIndex(3, groupItemData.get("Backpack name")), "$380.00");
        assertEquals(Pages.shoppingCartPage().getOrderTotal(), "$504.00");
    }

    @Test(groups = {"success", "addToCart"}, dataProvider = "invalidGroupItemQtyData", dataProviderClass = TestDataProviders.class)
    @Description("Group product card is selected. Product is added to cart successfully")
    @Severity(SeverityLevel.NORMAL)
    public void invalidItemQtyATCTest(String itemQty, String expectedError, String errorMethod) {
        start(GlobalData.mainURL);
        Pages.homepage().clickWomenMenuButton().clickTestLink().clickGroupProductCard();
        Pages.productPage().mainElementsIsDisplayedAsserts();

        Pages.productPage().setQtyInputGroupItem(1, itemQty);
        Pages.productPage().setQtyInputGroupItem(2, itemQty);
        Pages.productPage().setQtyInputGroupItem(3, itemQty);
        Pages.productPage().clickAddToCartButton();
        assertEquals(getErrorUsingMethod(errorMethod), expectedError);
    }





    private String getErrorUsingMethod(String errorMethod) {
        switch (errorMethod) {
            case "getPageError":
                return Pages.productPage().getPageError();
            case "getInputError":
                return Pages.productPage().getInputError();
            default:
                throw new IllegalArgumentException("Unknown error method: " + errorMethod);
        }
    }
}
