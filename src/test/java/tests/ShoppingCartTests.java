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

public class ShoppingCartTests extends BaseTest {

    @Test
    @Description("Product is added to cart successfully. Mini-cart elements are checked. Shopping cart elements are checked. Cart is updated successfully.")
    @Severity(SeverityLevel.NORMAL)
    public void checkMiniShoppingCart(){
        start(GlobalData.mainURL);
        Map<String, String> itemData = new HashMap<>();

        Pages.homepage().clickJacketsMenuButton();
        Pages.jacketsPage().clickFirstProductCard();
        Pages.productPage().selectSize();
        Pages.productPage().selectColor();

        itemData.put("Product name", Pages.productPage().getProductName());
        itemData.put("Product price", Pages.productPage().getProductPrice());
        itemData.put("Selected size", Pages.productPage().getSelectedSize());
        itemData.put("Selected color",Pages.productPage().getSelectedColor());
        itemData.put("Item qty", Pages.productPage().getItemQty());

        Pages.productPage().clickAddToCartButton();
        softAssert.assertTrue(Pages.productPage().getSuccessATCMessage().startsWith(GlobalData.successATCMessagePartly));
        assertEquals(Pages.header().getCartCounterValue(), "1");

        Pages.header().clickCartButton();
        assertEquals(Pages.header().getCartItemsQty(), itemData.get("Item qty"));
        assertEquals(Pages.header().getCartSubtotal(), itemData.get("Product price"));
        assertEquals(Pages.header().getItemName(), itemData.get("Product name"));
        assertEquals(Pages.header().getItemQty(), itemData.get("Item qty"));

        Pages.header().clickSeeDetailsLink();
        assertEquals(Pages.header().getItemSizeValue(), itemData.get("Selected size"));
        assertEquals(Pages.header().getItemColorValue(), itemData.get("Selected color"));

        String orderTax = "$0.00";
        Pages.header().clickViewAndEditCartLink();
        assertEquals(Pages.shoppingCartPage().getItemName(), itemData.get("Product name"));
        assertEquals(Pages.shoppingCartPage().getItemSize(), itemData.get("Selected size"));
        assertEquals(Pages.shoppingCartPage().getItemColor(), itemData.get("Selected color"));
        assertEquals(Pages.shoppingCartPage().getItemPrice(), itemData.get("Product price"));
        assertEquals(Pages.shoppingCartPage().getItemSubtotal(), itemData.get("Product price"));
        assertEquals(Pages.shoppingCartPage().getOrderSubtotal(), itemData.get("Product price"));
        assertEquals(Pages.shoppingCartPage().getOrderTax(), orderTax);

        String newItemQty = "2";
        String newOrderSubtotal = "$154.00";
        Pages.shoppingCartPage().setItemQtyInput(newItemQty);
        Pages.shoppingCartPage().clickUpdateCartButton();
        assertEquals(Pages.shoppingCartPage().getOrderTotal(), newOrderSubtotal);












    }

}
