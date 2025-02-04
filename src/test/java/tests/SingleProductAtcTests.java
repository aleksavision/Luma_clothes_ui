package tests;

import baseTest.BaseTest;
import com.codeborne.selenide.Selenide;
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
import static org.testng.Assert.assertTrue;

public class SingleProductAtcTests extends BaseTest {

    @Test (groups = {"success", "addToCart"})
    @Description("Two different items are added to compare from PLP and PDP successfully. One item is removed, one item is added to cart successfully. Cart is cleared successfully")
    @Severity(SeverityLevel.NORMAL)
    public void successATCFromComparisonTest(){
        start(GlobalData.mainURL);

        Pages.homepage().clickMenJacketsMenuButton();
        Pages.jacketsPage().clickAddToCompareButtonByIndex(1);
        assertEquals(Pages.productPage().getSuccessMessage(), GlobalData.successAddingToCompareMessage(Pages.jacketsPage().getItemNameByIndex(1)));

        Pages.jacketsPage().clickProductCardByIndex(1);
        Pages.productPage().mainElementsIsDisplayedAsserts();

        Map<String, String> jackshirtItemData = new HashMap<>();
        jackshirtItemData.put("Name", Pages.productPage().getProductName());
        jackshirtItemData.put("Price", Pages.productPage().getProductPrice());
        jackshirtItemData.put("SKU", Pages.productPage().getProductSku());

        Pages.homepage().clickMenJacketsMenuButton().clickProductCardByIndex(2);
        Pages.productPage().mainElementsIsDisplayedAsserts();
        Map<String, String> windJacketItemData = new HashMap<>();
        windJacketItemData.put("Name", Pages.productPage().getProductName());
        windJacketItemData.put("Price", Pages.productPage().getProductPrice());
        windJacketItemData.put("SKU", Pages.productPage().getProductSku());

        Pages.productPage().clickAddToCompareButton();
        assertEquals(Pages.productPage().getSuccessMessage(), GlobalData.successAddingToCompareMessage(windJacketItemData.get("Name")));

        Pages.productPage().clickComparisonListLink();
        assertEquals(Pages.compareProductsPage().getItemNameByIndex(1), windJacketItemData.get("Name"));
        assertEquals(Pages.compareProductsPage().getItemPriceByIndex(1), windJacketItemData.get("Price"));
        assertEquals(Pages.compareProductsPage().getItemSkuByIndex(1), windJacketItemData.get("SKU"));
        assertTrue(Pages.compareProductsPage().isItemDescDisplayed(), "Product description for " + windJacketItemData.get("Name") + " isn't displayed");

        assertEquals(Pages.compareProductsPage().getItemNameByIndex(2), jackshirtItemData.get("Name"));
        assertEquals(Pages.compareProductsPage().getItemPriceByIndex(2), jackshirtItemData.get("Price"));
        assertEquals(Pages.compareProductsPage().getItemSkuByIndex(2), jackshirtItemData.get("SKU"));

        Pages.compareProductsPage().clickRemoveItemButton();
        Pages.header().clickOkConfirmationButton();
        assertEquals(Pages.compareProductsPage().getSuccessMessage(), GlobalData.successItemRemovingFromComparisonMessage(windJacketItemData.get("Name")));
        assertTrue(Pages.compareProductsPage().isItemDescDisplayed(), "Product description for " + windJacketItemData.get("Name") + " isn't displayed");

        Pages.compareProductsPage().clickAddToCartButton();
        assertEquals(Pages.productPage().getWarningMessageText(), GlobalData.chooseOptionWarningMessage);

        Pages.productPage().selectSizeByIndex(2);
        Pages.productPage().selectColor();
        jackshirtItemData.put("Size", Pages.productPage().getSelectedSize());
        jackshirtItemData.put("Color", Pages.productPage().getSelectedColor());
        jackshirtItemData.put("Qty", Pages.productPage().getItemQty());
        Pages.productPage().clickAddToCartButton();
        assertEquals(Pages.productPage().getSuccessMessage(), GlobalData.successATCMessage(jackshirtItemData.get("Name")));

        Pages.productPage().clickShoppingCartLink();
        assertEquals(Pages.shoppingCartPage().getItemName(), jackshirtItemData.get("Name"));
        assertEquals(Pages.shoppingCartPage().getItemPrice(), jackshirtItemData.get("Price"));
        assertEquals(Pages.shoppingCartPage().getItemSubtotal(), jackshirtItemData.get("Price"));
        assertEquals(Pages.shoppingCartPage().getItemSize(), jackshirtItemData.get("Size"));
        assertEquals(Pages.shoppingCartPage().getItemColor(), jackshirtItemData.get("Color"));
        assertEquals(Pages.shoppingCartPage().getItemQty(), jackshirtItemData.get("Qty"));

        Pages.shoppingCartPage().clickRemoveItemButton();
        assertEquals(Pages.shoppingCartPage().getEmptyCartInfoText(), GlobalData.emptyCartInfoMessage);

        Pages.shoppingCartPage().clickHereLink();
        assertEquals(Pages.homepage().getPageUrl(), GlobalData.mainURL);
    }

    @Test (groups = {"success", "addToCart"})
    @Description("User is logged in. The same single product is added from PLP/PDP. Invalid options error is checked. Product is added successfully. Discount and Shipping rate are checked")
    @Severity(SeverityLevel.NORMAL)
    public void successATCAsUserTest() {
        start(GlobalData.mainURL);

        Pages.homepage().clickSignInLink();
        Pages.loginPage().setEmailInput(GlobalData.validEmail);
        Pages.loginPage().setPasswordInput(GlobalData.validPassword);
        Pages.loginPage().clickSignInButton();
        Selenide.sleep(2000);
        Pages.header().clickCartButton();
        Pages.header().clearCart();

        String size = "XL";
        String color = "Purple";
        Pages.homepage().clickWomenMenuButton().clickTopsLink();
        Map<String, String> itemData = new HashMap<>();
        itemData.put("Name", Pages.topsPage().getItemNameByIndex(2));
        itemData.put("Rating", Pages.topsPage().getItemRatingRateByIndex(2));
        itemData.put("Reviews", Pages.topsPage().getItemReviewsQtyByIndex(2));
        itemData.put("Price", Pages.topsPage().getItemPriceByIndex(2));
        Pages.topsPage().selectItemOptionByIndex(2, size);
        Pages.topsPage().selectItemOptionByIndex(2, color);
        Pages.topsPage().clickAddToCartButtonByIndex(2);
        assertEquals(Pages.topsPage().getSuccessMessage(), GlobalData.successATCMessage(itemData.get("Name")));

        Pages.topsPage().clickShoppingCartLink();
        assertEquals(Pages.shoppingCartPage().getItemName(), itemData.get("Name"));
        assertEquals(Pages.shoppingCartPage().getItemPrice(), itemData.get("Price"));
        assertEquals(Pages.shoppingCartPage().getItemSubtotal(), itemData.get("Price"));
        assertEquals(Pages.shoppingCartPage().getItemSize(), size);
        assertEquals(Pages.shoppingCartPage().getItemColor(), color);
        assertTrue(!Pages.shoppingCartPage().discountTitleIsDisplayed());

        Pages.homepage().clickWomenMenuButton().clickTopsLink().clickProductCardByIndex(2);
        Pages.productPage().mainElementsIsDisplayedAsserts();
        Pages.productPage().selectColor();
        Pages.productPage().clickAddToCartButton();
        assertEquals(Pages.productPage().getSizeErrorMessage(), GlobalData.requiredFieldError);

        Pages.productPage().selectColor();
        Pages.productPage().selectSizeByIndex(5);
        Pages.productPage().clickAddToCartButton();
        assertEquals(Pages.productPage().getColorErrorMessage(), GlobalData.requiredFieldError);

        Pages.productPage().selectColorByIndex(2);
        Pages.productPage().setQtyInput("5");
        Pages.productPage().clickAddToCartButton();
        assertEquals(Pages.productPage().getSuccessMessage(), GlobalData.successATCMessage(Pages.productPage().getProductName()));
        assertEquals(Pages.productPage().getProductName(), itemData.get("Name"));
        assertEquals(Pages.productPage().getProductPrice(), itemData.get("Price"));
        assertEquals(Pages.productPage().getRatingRateValue() + "%", itemData.get("Rating"));
        assertEquals(Pages.productPage().getReviewsValue() + " Reviews", itemData.get("Reviews"));
        assertEquals(Pages.productPage().getSelectedSize(), size);
        assertEquals(Pages.productPage().getSelectedColor(), color);

        Pages.productPage().clickShoppingCartLink();
        assertEquals(Pages.shoppingCartPage().getItemQty(), "6");
        assertEquals(Pages.shoppingCartPage().getDiscountAmount(), "-$40.80");

        Pages.shoppingCartPage().clickApplyDiscountCodeLink();
        Pages.shoppingCartPage().clickApplyDiscountButton();
        assertEquals(Pages.shoppingCartPage().getDiscountInputError(), GlobalData.requiredFieldError);

        Pages.shoppingCartPage().setDiscountCodeInput(GlobalData.invalidCouponCode);
        Pages.shoppingCartPage().clickApplyDiscountButton();
        assertEquals(Pages.shoppingCartPage().getErrorInfoMessage(), GlobalData.invalidCouponCodeErrorMessage(GlobalData.invalidCouponCode));

//        can't finish assert because of the lack of data
//        Pages.shoppingCartPage().setDiscountCodeInput(GlobalData.validCouponCode);
//        Pages.shoppingCartPage().clickApplyDiscountButton();

        Pages.shoppingCartPage().clickEstimateShippingTaxLink();
        Pages.shoppingCartPage().selectTableRateRadiobutton();
        assertEquals(Pages.shoppingCartPage().getOrderSubtotal(), "$204.00");
        assertEquals(Pages.shoppingCartPage().getShippingRateInfo(),"(Best Way - Table Rate)");
        assertEquals(Pages.shoppingCartPage().getShippingRateAmount(), "$0.00");
        assertEquals(Pages.shoppingCartPage().getOrderTotal(), "$163.20");

        Pages.shoppingCartPage().selectCountryDropdown("Romania");
        Pages.shoppingCartPage().selectStateDropdown("Braşov");
        Pages.shoppingCartPage().setPostalCodeInput("00000");
        assertEquals(Pages.shoppingCartPage().getPostalCodeInputError(), GlobalData.invalidPostalCodeSixDigitsError);

        Pages.shoppingCartPage().setPostalCodeInput("500008");
        assertEquals(Pages.shoppingCartPage().getOrderSubtotal(), "$204.00");
        assertEquals(Pages.shoppingCartPage().getShippingRateInfo(),"(Flat Rate - Fixed)");
        assertEquals(Pages.shoppingCartPage().getShippingRateAmount(), "$30.00");
        assertEquals(Pages.shoppingCartPage().getOrderTotal(), "$193.20");
    }
    @Test(groups = {"unsuccess", "addToCart"}, dataProvider = "invalidItemQtyData", dataProviderClass = TestDataProviders.class)
    @Description("Single product card is selected. Item qty is changed to invalid. Product isn't added to cart. Error is displayed")
    @Severity(SeverityLevel.NORMAL)
    public void invalidItemQtyATCTest(String itemQty, String expectedError) {
        start(GlobalData.mainURL);

        Pages.homepage().clickWomenMenuButton().clickTopsLink().clickProductCardByIndex(5);
        Pages.productPage().mainElementsIsDisplayedAsserts();

        Pages.productPage().selectSize();
        Pages.productPage().selectColor();
        Pages.productPage().setQtyInput(itemQty);
        Pages.productPage().clickAddToCartButton();
        assertEquals(Pages.productPage().getQtyErrorMessage(), expectedError);
    }

}
