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

public class SingleProductTests extends BaseTest {

    String productName = "Juno Jacket";

    @BeforeMethod
    public void startTest() {
        start(GlobalData.mainURL);
        Actions.miniCartActions().clearCart();
        Pages.header().clickWomenJacketsMenuButton().selectSimpleProductCard(productName);
    }

    @Test(groups = {"elements"})
    @Description("Single product page is opened. All elements are displayed")
    @Severity(SeverityLevel.CRITICAL)
    public void checkElementsDisplaying() {
        Pages.productPage().mainElementsIsDisplayedSimpleAsserts();
    }

    @Test(groups = {"success", "addToCart"})
    @Description("Single product page is opened. Product is added to cart successfully")
    @Severity(SeverityLevel.CRITICAL)
    public void successAddingToCart() {
        Pages.productPage().selectSize();
        Pages.productPage().selectColor();
        Pages.productPage().clickAddToCartButton();

        assertEquals(Pages.productPage().getSuccessMessage(), GlobalData.successATCMessage(productName));
    }

    @Test(groups = {"unsuccess", "addToCart"}, dataProvider = "invalidItemQtyData", dataProviderClass = TestDataProviders.class)
    @Description("Single product page is opened. Item qty is changed to invalid. Product isn't added to cart")
    @Severity(SeverityLevel.CRITICAL)
    public void invalidItemQtyATCTest(String itemQty, String expectedError) {
        Pages.productPage().selectSize();
        Pages.productPage().selectColor();
        Pages.productPage().setQtyInput(itemQty);
        Pages.productPage().clickAddToCartButton();
        assertEquals(Pages.productPage().getQtyErrorMessage(), expectedError);
    }

    @Test(groups = {"unsuccess", "addToCart"})
    @Description("Single product card is selected. Size/color aren't selected. Product isn't added to cart. Errors are displayed")
    @Severity(SeverityLevel.NORMAL)
    public void noSelectedColorSizeATCTest() {
        Pages.productPage().clickAddToCartButton();

        assertEquals(Pages.productPage().getSizeErrorMessage(), GlobalData.requiredFieldError);
        assertEquals(Pages.productPage().getColorErrorMessage(), GlobalData.requiredFieldError);
    }


    @Test(groups = {"success", "addToCart"})
    @Description("Single product card is selected. Qty is changed. Product is added to cart successfully. The same product is displayed on Shopping cart")
    @Severity(SeverityLevel.NORMAL)
    public void checkAddedItemInCart() {
        String itemQty = "5";
        Map<String, String> singleProductData = new HashMap<>();

        Pages.productPage().selectSize();
        Pages.productPage().selectColor();
        Pages.productPage().setQtyInput(itemQty);
        Pages.productPage().clickAddToCartButton();

        singleProductData.put("Size", Pages.productPage().getSelectedSize());
        singleProductData.put("Color", Pages.productPage().getSelectedColor());
        singleProductData.put("Price", Pages.productPage().getProductPrice());

        Pages.productPage().clickShoppingCartLink();
        assertEquals(Pages.shoppingCartPage().getItemName(), productName);
        assertEquals(Pages.shoppingCartPage().getItemSize(), singleProductData.get("Size"));
        assertEquals(Pages.shoppingCartPage().getItemColor(), singleProductData.get("Color"));
        assertEquals(Pages.shoppingCartPage().getItemQty(), itemQty);
        assertEquals(Pages.shoppingCartPage().getItemPrice(), singleProductData.get("Price"));
    }


}
