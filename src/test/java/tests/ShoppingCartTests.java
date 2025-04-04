package tests;

import actions.Actions;
import baseTest.BaseTest;
import com.codeborne.selenide.Selenide;
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
import static org.testng.Assert.assertTrue;

public class ShoppingCartTests extends BaseTest {

    Map<String, String> junoJacketData = new HashMap<>();
    Map<String, String> additionalItemData = new HashMap<>();

    @BeforeMethod
    public void startTest() {
        start("http://46.101.147.48/juno-jacket.html");
        Actions.miniCartActions().clearCart();
        Pages.productPage().selectSize();
        Pages.productPage().selectColor();
        Pages.productPage().clickAddToCartButton();

    }

    @Test(groups = {"success"})
    @Description("Product is added to cart successfully. Shopping cart elements are checked.")
    @Severity(SeverityLevel.NORMAL)
    public void checkItemInShoppingCart() {
        junoJacketData.put("Name", Pages.productPage().getProductName());
        junoJacketData.put("Price", Pages.productPage().getProductPrice());

        Pages.productPage().clickShoppingCartLink();
        assertEquals(Pages.shoppingCartPage().getItemName(), junoJacketData.get("Name"));
        assertEquals(Pages.shoppingCartPage().getItemPrice(), junoJacketData.get("Price"));
        assertEquals(Pages.shoppingCartPage().getItemSubtotal(), junoJacketData.get("Price"));
        assertEquals(Pages.shoppingCartPage().getOrderSubtotal(), junoJacketData.get("Price"));
        assertEquals(Pages.shoppingCartPage().getOrderTax(), "$0.00");
        assertEquals(Pages.shoppingCartPage().getOrderTotal(), junoJacketData.get("Price"));
    }

    @Test(groups = {"success"})
    @Description("Product is added to cart successfully. Item qty is changed. Cart is updated successfully.")
    @Severity(SeverityLevel.NORMAL)
    public void checkItemQtyChanging() {
        String newItemQty = "5";
        junoJacketData.put("Price", Pages.productPage().getProductPrice());

        Pages.productPage().clickShoppingCartLink();
        Pages.shoppingCartPage().setItemQtyInput(newItemQty);
        Pages.shoppingCartPage().clickUpdateCartButton();

        assertEquals(Pages.shoppingCartPage().getItemPrice(), junoJacketData.get("Price"));
        Selenide.sleep(5000);
        assertEquals(Pages.shoppingCartPage().getItemSubtotal(), "$385.00");
        assertEquals(Pages.shoppingCartPage().getOrderSubtotal(), "$385.00");
        assertEquals(Pages.shoppingCartPage().getOrderTotal(), "$385.00");
    }

    @Test(groups = {"success"})
    @Description("Product is added to cart successfully. Item is changed on Product page. Cart is updated successfully.")
    @Severity(SeverityLevel.NORMAL)
    public void checkItemUpdating() {
        Pages.productPage().clickShoppingCartLink();
        Pages.shoppingCartPage().clickEditButton(1);
        Pages.productPage().selectSizeByIndex(3);
        Pages.productPage().selectColorByIndex(3);

        junoJacketData.put("Price", Pages.productPage().getProductPrice());
        junoJacketData.put("Size", Pages.productPage().getSelectedSize());
        junoJacketData.put("Color", Pages.productPage().getSelectedColor());

        Pages.productPage().clickUpdateCartButton();
        assertEquals(Pages.shoppingCartPage().getItemPrice(), junoJacketData.get("Price"));
        assertEquals(Pages.shoppingCartPage().getItemSubtotal(), junoJacketData.get("Price"));
        assertEquals(Pages.shoppingCartPage().getOrderSubtotal(), junoJacketData.get("Price"));
        assertEquals(Pages.shoppingCartPage().getOrderTax(), "$0.00");
        assertEquals(Pages.shoppingCartPage().getOrderTotal(), junoJacketData.get("Price"));
        assertEquals(Pages.shoppingCartPage().getItemSize(), junoJacketData.get("Size"));
        assertEquals(Pages.shoppingCartPage().getItemColor(), junoJacketData.get("Color"));
    }

    @Test(groups = {"success"})
    @Description("Product is added to cart successfully. Coupon is applied. Cart is updated successfully.")
    @Severity(SeverityLevel.NORMAL)
    public void successCouponApplying() {
        String couponCode = "discount";

        Pages.productPage().clickShoppingCartLink();
        Pages.shoppingCartPage().clickApplyDiscountCodeLink();
        Pages.shoppingCartPage().setDiscountCodeInput(couponCode);
        Pages.shoppingCartPage().clickApplyDiscountButton();

        assertTrue(Pages.shoppingCartPage().checkDiscountInfoDisplayed());
        assertEquals(Pages.shoppingCartPage().getDiscountAmount(), "-$15.40");
    }

    @Test(groups = {"unsuccess"})
    @Description("Product is added to cart successfully. Coupon with empty field isn't applied. Error is displayed")
    @Severity(SeverityLevel.NORMAL)
    public void emptyCouponApplying() {

        Pages.productPage().clickShoppingCartLink();
        Pages.shoppingCartPage().clickApplyDiscountCodeLink();
        Pages.shoppingCartPage().clickApplyDiscountButton();

        assertEquals(Pages.shoppingCartPage().getDiscountInputError(), GlobalData.requiredFieldError);
    }

    @Test(groups = {"unsuccess"})
    @Description("Product is added to cart successfully. Invalid coupon isn't applied. Error is displayed")
    @Severity(SeverityLevel.NORMAL)
    public void invalidCouponApplying() {
        String couponCode = "discount";

        Pages.productPage().clickShoppingCartLink();
        Pages.shoppingCartPage().clickApplyDiscountCodeLink();
        Pages.shoppingCartPage().setDiscountCodeInput(couponCode + "1");
        Pages.shoppingCartPage().clickApplyDiscountButton();

        assertEquals(Pages.shoppingCartPage().getDiscountPageError(), GlobalData.invalidCouponCodeErrorMessage(couponCode + "1"));
    }

    @Test(groups = {"success"})
    @Description("Product is added to cart successfully. Tax and Total are estimated with the USA location successfully")
    @Severity(SeverityLevel.NORMAL)
    public void checkEstimationWithUsa() {
        Pages.productPage().clickShoppingCartLink();
        Pages.shoppingCartPage().clickEstimateShippingTaxLink();
        Pages.shoppingCartPage().selectCountryDropdown("United States");
        Pages.shoppingCartPage().selectStateDropdown("Florida");
        Pages.shoppingCartPage().setPostalCodeInput("10021");
        assertEquals(Pages.shoppingCartPage().getOrderTax(), "$0.00");

        Pages.shoppingCartPage().selectTableRateRadiobutton();
        assertEquals(Pages.shoppingCartPage().getOrderTotal(), "$77.00");

        Pages.shoppingCartPage().selectFixedRadioButton();
        assertEquals(Pages.shoppingCartPage().getEstimatedOrderTax(), "$5.00");
        assertEquals(Pages.shoppingCartPage().getOrderTotal(), "$82.00");
    }

    @Test(groups = {"success"})
    @Description("Product is added to cart successfully. Tax and Total are estimated with the Romania location successfully")
    @Severity(SeverityLevel.NORMAL)
    public void checkEstimationWithRomania() {
        Pages.productPage().clickShoppingCartLink();
        Pages.shoppingCartPage().clickEstimateShippingTaxLink();
        Pages.shoppingCartPage().selectCountryDropdown("Romania");
        Pages.shoppingCartPage().selectStateDropdown("Braşov");
        Pages.shoppingCartPage().setPostalCodeInput("500008");
        assertEquals(Pages.shoppingCartPage().getEstimatedOrderTax(), "$5.00");
        assertEquals(Pages.shoppingCartPage().getOrderTotal(), "$82.00");
        assertTrue(Pages.shoppingCartPage().isTableRateNotDisplayed());
    }

    @Test
    @Description("Product is added to cart successfully. Mini-cart elements are checked. Shopping cart elements are checked. Cart is updated successfully.")
    @Severity(SeverityLevel.NORMAL)
    public void checkMiniShoppingCart() {
        startTest();
        Pages.productPage().clickShoppingCartLink();
        additionalItemData.put("Name", Pages.shoppingCartPage().getAdditionalProductName());
        additionalItemData.put("Price", Pages.shoppingCartPage().getAdditionalProductPrice());

        Pages.shoppingCartPage().clickAdditionalAddToCartButton();
        assertEquals(Pages.shoppingCartPage().getItemNameByIndex(2), additionalItemData.get("Name"));
        assertEquals(Pages.shoppingCartPage().getItemPriceByIndex(2), additionalItemData.get("Price"));
        assertEquals(Pages.shoppingCartPage().getItemSubtotalByIndex(2, additionalItemData.get("Name")), additionalItemData.get("Price"));
    }

}
