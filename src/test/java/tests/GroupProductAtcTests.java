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

import static com.codeborne.selenide.Selenide.sleep;
import static org.testng.Assert.assertEquals;

public class GroupProductAtcTests extends BaseTest {

    @Test(groups = {"success", "addToCart"})
    @Description("Group product card is selected. Product is added to cart wishlist and cart successfully. Product is updated successfully")
    @Severity(SeverityLevel.NORMAL)
    public void successGroupItemAdding() {
        start(GlobalData.mainURL);

        Pages.homepage().clickWomenMenuButton().clickTestLink().clickGroupProductCard();
        Pages.productPage().mainElementsIsDisplayedAsserts();

        Map<String, String> data1 = new HashMap<>();
        data1.put("Product name", Pages.productPage().getProductName());
        data1.put("Item name 1", Pages.productPage().getGroupItemName(1));
        data1.put("Item name 2", Pages.productPage().getGroupItemName(2));
        data1.put("Item name 3", Pages.productPage().getGroupItemName(3));
        data1.put("Item price 1", Pages.productPage().getGroupItemPrice(1));
        data1.put("Item price 2", Pages.productPage().getGroupItemPrice(2));
        data1.put("Item price 3", Pages.productPage().getGroupItemPrice(3));
        data1.put("Item qty 1", Pages.productPage().getGroupItemQty(1));
        data1.put("Item qty 2", Pages.productPage().getGroupItemQty(2));
        data1.put("Item qty 3", Pages.productPage().getGroupItemQty(3));
        data1.put("Order total", "$104.00");

        Pages.productPage().clickAddToWishlistButtonAsGuest();
        assertEquals(Pages.loginPage().getErrorMessageText(), GlobalData.notRegistredUserForWishlistErrorMessage);

        Pages.loginPage().setEmailInput(GlobalData.validEmail);
        Pages.loginPage().setPasswordInput(GlobalData.validPassword);
        Pages.loginPage().clickSignInButtonToWishlist();
        assertEquals(Pages.myWishListPage().getSuccessMessageText(), GlobalData.successAddingToWishlistMessage(data1.get("Product name")));
        assertEquals(Pages.myWishListPage().getItemName(1), data1.get("Product name"));
        assertEquals(Pages.myWishListPage().getItemPrice(1), data1.get("Order total"));
        Pages.myWishListPage().openOptionsDetailsForItemByIndex(1);
        assertEquals(Pages.myWishListPage().getGroupItemNameByIndex(1), data1.get("Item name 1"));
        assertEquals(Pages.myWishListPage().getGroupItemNameByIndex(2), data1.get("Item name 2"));
        assertEquals(Pages.myWishListPage().getGroupItemNameByIndex(3), data1.get("Item name 3"));
        assertEquals(Pages.myWishListPage().getGroupItemQtyByIndex(1), data1.get("Item qty 1"));
        assertEquals(Pages.myWishListPage().getGroupItemQtyByIndex(2), data1.get("Item qty 2"));
        assertEquals(Pages.myWishListPage().getGroupItemQtyByIndex(3), data1.get("Item qty 3"));
        Pages.header().clickCartButton();
        Pages.header().clearCart();

        Pages.header().clickWomenShortsMenuButton();
        Map<String, String> data2 = new HashMap<>();
        data2.put("Name", Pages.shortsPage().getItemNameByIndex(1));
        data2.put("Price", Pages.shortsPage().getItemPriceByIndex(1));

        Pages.shortsPage().clickAddToWishlistButtonByIndexAsUser(1);
        assertEquals(Pages.myWishListPage().getSuccessMessageText(), GlobalData.successAddingToWishlistMessage(data2.get("Name")));

        assertEquals(Pages.myWishListPage().getItemName(2), data2.get("Name"));
        assertEquals(Pages.myWishListPage().getItemPrice(2), data2.get("Price"));

        Pages.myWishListPage().clickRemoveItemButtonByIndex(2);
        assertEquals(Pages.myWishListPage().getSuccessMessageText(), GlobalData.successItemRemovingFromWishlistMessage(data2.get("Name")));
        assertEquals(Pages.myWishListPage().getItemsQty(), GlobalData.itemQtyInWishlist("1"));

        Pages.myWishListPage().clickAddAllToCartButton();
        assertEquals(Pages.myWishListPage().getSuccessMessageText(), GlobalData.successATCFromWishlistMessage(data1.get("Product name")));
        assertEquals(Pages.myWishListPage().getEmptyMessageText(), GlobalData.wishlistEmptyInfoMessage);

        Pages.header().clickCartButton();
        Pages.header().clickViewAndEditCartLink();
        assertEquals(Pages.shoppingCartPage().getItemNameByIndex(1), data1.get("Item name 1"));
        assertEquals(Pages.shoppingCartPage().getItemNameByIndex(2), data1.get("Item name 2"));
        assertEquals(Pages.shoppingCartPage().getItemNameByIndex(3), data1.get("Item name 3"));
        assertEquals(Pages.shoppingCartPage().getItemQtyByIndex(1), data1.get("Item qty 1"));
        assertEquals(Pages.shoppingCartPage().getItemQtyByIndex(2), data1.get("Item qty 2"));
        assertEquals(Pages.shoppingCartPage().getItemQtyByIndex(3), data1.get("Item qty 3"));
        assertEquals(Pages.shoppingCartPage().getItemPriceByIndex(1), data1.get("Item price 1"));
        assertEquals(Pages.shoppingCartPage().getItemPriceByIndex(2), data1.get("Item price 2"));
        assertEquals(Pages.shoppingCartPage().getItemPriceByIndex(3), data1.get("Item price 3"));
        assertEquals(Pages.shoppingCartPage().getItemSubtotalByIndex(1, data1.get("Item price 1")), data1.get("Item price 1"));
        assertEquals(Pages.shoppingCartPage().getItemSubtotalByIndex(2, data1.get("Item price 2")), data1.get("Item price 2"));
        assertEquals(Pages.shoppingCartPage().getItemSubtotalByIndex(3, data1.get("Item price 3")), data1.get("Item price 3"));
        sleep(3000);
        assertEquals(Pages.shoppingCartPage().getOrderTotal(), data1.get("Order total"));

        Pages.shoppingCartPage().setItemQtyInputByIndex(1, "2");
        Pages.shoppingCartPage().setItemQtyInputByIndex(2, "5");
        Pages.shoppingCartPage().setItemQtyInputByIndex(3, "10");
        Pages.shoppingCartPage().clickUpdateCartButton();
        assertEquals(Pages.shoppingCartPage().getItemPriceByIndex(1), data1.get("Item price 1"));
        assertEquals(Pages.shoppingCartPage().getItemPriceByIndex(2), data1.get("Item price 2"));
        assertEquals(Pages.shoppingCartPage().getItemPriceByIndex(3), data1.get("Item price 3"));
        assertEquals(Pages.shoppingCartPage().getItemQtyByIndex(1), "2");
        assertEquals(Pages.shoppingCartPage().getItemQtyByIndex(2), "5");
        assertEquals(Pages.shoppingCartPage().getItemQtyByIndex(3), "10");
        assertEquals(Pages.shoppingCartPage().getItemSubtotalByIndex(1, "$64.00"), "$64.00");
        assertEquals(Pages.shoppingCartPage().getItemSubtotalByIndex(2, "$170.00"), "$170.00");
        assertEquals(Pages.shoppingCartPage().getItemSubtotalByIndex(3, "$380.00"), "$380.00");
        sleep(3000);
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
