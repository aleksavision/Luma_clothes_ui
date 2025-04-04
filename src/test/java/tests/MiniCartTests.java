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

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertEquals;

public class MiniCartTests extends BaseTest {

    Map<String, String> junoJacketData = new HashMap<>();

    @BeforeMethod
    public void startTest() {
        start("http://46.101.147.48/juno-jacket.html");

        Pages.productPage().selectSize();
        Pages.productPage().selectColor();
        Pages.productPage().clickAddToCartButton();

        assertEquals(Pages.miniCart().getCartCounterValue(), "1");

        Pages.miniCart().clickCartButton();
    }

    @Test
    @Description("Product is added to cart successfully. The same product is displayed in Mini-cart")
    @Severity(SeverityLevel.NORMAL)
    public void checkItemInMiniCart() {
        junoJacketData.put("Name", Pages.productPage().getProductName());
        junoJacketData.put("Price", Pages.productPage().getProductPrice());
        junoJacketData.put("Size", Pages.productPage().getSelectedSize());
        junoJacketData.put("Color", Pages.productPage().getSelectedColor());

        assertEquals(Pages.miniCart().getCartItemsQty(), "1");
        assertEquals(Pages.miniCart().getCartSubtotal(), junoJacketData.get("Price"));
        assertEquals(Pages.miniCart().getItemName(), junoJacketData.get("Name"));

        Pages.miniCart().clickSeeDetailsLink();
        assertEquals(Pages.miniCart().getItemSizeValue(), junoJacketData.get("Size"));
        assertEquals(Pages.miniCart().getItemColorValue(), junoJacketData.get("Color"));
    }

    @Test
    @Description("Product is added to cart successfully. Product is removed from Mini-cart. Mini-cart is empty")
    @Severity(SeverityLevel.NORMAL)
    public void checkMiniCart() {
        Actions.miniCartActions().clearCart();
        assertEquals(Pages.miniCart().getEmptyCartMessage(), GlobalData.emptyMiniCartInfoMessage);
    }

    @Test
    @Description("Product is added to cart successfully. Product is changed from Mini-cart. Updated item is displayed in Mini-cart.")
    @Severity(SeverityLevel.NORMAL)
    public void checkMiniCartUpdating() {
        Pages.miniCart().clickEditItemButton();
        Pages.productPage().selectSizeByIndex(3);
        Pages.productPage().selectColorByIndex(3);

        junoJacketData.put("Name", Pages.productPage().getProductName());
        junoJacketData.put("Price", Pages.productPage().getProductPrice());
        junoJacketData.put("Size", Pages.productPage().getSelectedSize());
        junoJacketData.put("Color", Pages.productPage().getSelectedColor());

        Pages.productPage().clickUpdateCartButton();
        Pages.miniCart().clickCartButton();
        assertEquals(Pages.miniCart().getCartSubtotal(), junoJacketData.get("Price"));
        assertEquals(Pages.miniCart().getItemName(), junoJacketData.get("Name"));

        Pages.miniCart().clickSeeDetailsLink();
        assertEquals(Pages.miniCart().getItemSizeValue(), junoJacketData.get("Size"));
        assertEquals(Pages.miniCart().getItemColorValue(), junoJacketData.get("Color"));
    }


}
