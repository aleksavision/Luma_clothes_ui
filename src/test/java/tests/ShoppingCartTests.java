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

import static com.codeborne.selenide.Selenide.sleep;
import static org.testng.Assert.assertEquals;

public class ShoppingCartTests extends BaseTest {

    @Test
    @Description("Product is added to cart successfully. Mini-cart elements are checked. Shopping cart elements are checked. Cart is updated successfully.")
    @Severity(SeverityLevel.NORMAL)
    public void checkMiniShoppingCart(){
        start(GlobalData.mainURL);
        Map<String, String> itemData = new HashMap<>();

        Pages.homepage().clickWomenJacketsMenuButton();
        Pages.jacketsPage().clickProductCardByIndex(1);
        Pages.productPage().selectSize();
        Pages.productPage().selectColor();

        itemData.put("Product name", Pages.productPage().getProductName());
        itemData.put("Product price", Pages.productPage().getProductPrice());
        itemData.put("Selected size", Pages.productPage().getSelectedSize());
        itemData.put("Selected color",Pages.productPage().getSelectedColor());
        itemData.put("Item qty", Pages.productPage().getItemQty());

        Pages.productPage().clickAddToCartButton();
        assertEquals(Pages.productPage().getSuccessMessage(),GlobalData.successATCMessage(itemData.get("Product name")));
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
        assertEquals(Pages.shoppingCartPage().getPageTitle(), "Shopping Cart");
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
        sleep(3000);
        assertEquals(Pages.shoppingCartPage().getOrderTotal(), newOrderSubtotal);
    }

    @Test
    @Description("Two different products are added to cart successfully. Mini-cart elements are checked. Qty for second item is changed. Size for first item is changed. Cart is updated successfully.")
    @Severity(SeverityLevel.NORMAL)
    public void checkShoppingCartUpdating(){
        start(GlobalData.mainURL);

        HashMap<String, String> data1 = new HashMap<>();
        Pages.homepage().clickMenJacketsMenuButton();
        Pages.jacketsPage().clickProductCardByIndex(1);
        Pages.productPage().selectSize();
        Pages.productPage().selectColor();
        data1.put("Name", Pages.productPage().getProductName());
        data1.put("Price", Pages.productPage().getProductPrice());
        data1.put("Size", Pages.productPage().getSelectedSize());
        data1.put("Color", Pages.productPage().getSelectedColor());
        data1.put("Qty", Pages.productPage().getItemQty());
        Pages.productPage().clickAddToCartButton();
        assertEquals(Pages.header().getCartCounterValue(), "1");

        HashMap<String, String> data2 = new HashMap<>();
        Pages.header().clickMenJacketsMenuButton();
        Pages.jacketsPage().clickProductCardByIndex(3);
        Pages.productPage().selectSize();
        Pages.productPage().selectColor();
        data2.put("Name", Pages.productPage().getProductName());
        data2.put("Price", Pages.productPage().getProductPrice());
        data2.put("Size", Pages.productPage().getSelectedSize());
        data2.put("Color", Pages.productPage().getSelectedColor());
        data2.put("Qty", Pages.productPage().getItemQty());
        Pages.productPage().clickAddToCartButton();
        assertEquals(Pages.header().getCartCounterValue(), "2");

        Pages.header().clickCartButton();
        assertEquals(Pages.header().getItemNameByIndex(1), data2.get("Name"));
        assertEquals(Pages.header().getItemNameByIndex(2), data1.get("Name"));

        String newItemQty = "2";
        String newItemSubtotal = "$113.98";
        String newOrderTotal = "$158.98";
        Pages.header().clickViewAndEditCartLink();
        Pages.shoppingCartPage().setItemQtyInputByIndex(2, newItemQty);
        Pages.shoppingCartPage().clickUpdateCartButton();
        assertEquals(Pages.shoppingCartPage().getItemSubtotalByIndex(2, newItemSubtotal), newItemSubtotal);
        sleep(3000);
        assertEquals(Pages.shoppingCartPage().getOrderTotal(), newOrderTotal);

        Pages.shoppingCartPage().clickEditButton(1);
        Pages.productPage().selectSizeByIndex(2);
        String newSize = Pages.productPage().getSelectedSize();
        Pages.productPage().clickUpdateCartButton();
        assertEquals(Pages.shoppingCartPage().getItemSizeValueByIndex(2), newSize);
    }







}
