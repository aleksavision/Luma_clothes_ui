package tests;

import baseTest.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
import pages.Pages;
import testData.GlobalData;

import static org.testng.Assert.assertEquals;

public class BundleProductAtcTests extends BaseTest {

    @Test(groups = {"success", "addToCart"})
    @Description("Bundle product card is selected. Product is added to cart successfully")
    @Severity(SeverityLevel.NORMAL)
    public void successBundleItemAdding() {
        start(GlobalData.mainURL);
        Pages.homepage().clickWomenMenuButton().clickTestLink().clickBundleProductCard();
        Pages.productPage().mainElementsIsDisplayedAsserts();

        Pages.productPage().clickCustomizeATCButton();
        Pages.productPage().selectBundleItem("Joust Duffle Bag +$170.00");
        Pages.productPage().clickAddToCartButton();
        softAssert.assertTrue(Pages.productPage().getSuccessATCMessage().startsWith(GlobalData.successATCMessagePartly));
        softAssert.assertAll();
    }

    @Test(groups = {"unsuccess", "addToCart"})
    @Description("Bundle product card is selected. Bundle item isn't selected. Product isn't added to cart")
    @Severity(SeverityLevel.NORMAL)
    public void noSelectedBundleItemATCtest() {
        start(GlobalData.mainURL);
        Pages.homepage().clickWomenMenuButton().clickTestLink().clickBundleProductCard();
        Pages.productPage().mainElementsIsDisplayedAsserts();

        Pages.productPage().clickCustomizeATCButton();
        Pages.productPage().clickAddToCartButton();
        softAssert.assertEquals(Pages.productPage().getBundleItemErrorMessage(), GlobalData.requiredFieldError);
        softAssert.assertAll();
    }

    @Test(groups = {"success", "addToCart"})
    @Description("Bundle product card is selected. Bundle item is selected. Item qty is changed. Product is added to cart successfully")
    @Severity(SeverityLevel.NORMAL)
    public void changeItemQtyATCTest() {
        start(GlobalData.mainURL);
        String itemQty = "7";
        Pages.homepage().clickWomenMenuButton().clickTestLink().clickBundleProductCard();
        Pages.productPage().mainElementsIsDisplayedAsserts();

        Pages.productPage().clickCustomizeATCButton();
        Pages.productPage().selectBundleItem("Strive Shoulder Pack +$160.00");
        Pages.productPage().setQtyInput(itemQty);
        Pages.productPage().clickAddToCartButton();
        Pages.productPage().clickShoppingCartLink();
        assertEquals(Pages.shoppingCartPage().getItemQty(), itemQty);
    }
    @Test(groups = {"unsuccess", "addToCart"})
    @Description("Bundle product card is selected. Bundle item is selected. Item qty is changed. Product is added to cart successfully")
    @Severity(SeverityLevel.NORMAL)
    public void invalidOverMaxItemQtyATCTest() {
        start(GlobalData.mainURL);
        String itemQty = "10001";
        Pages.homepage().clickWomenMenuButton().clickTestLink().clickBundleProductCard();
        Pages.productPage().mainElementsIsDisplayedAsserts();

        Pages.productPage().clickCustomizeATCButton();
        Pages.productPage().selectBundleItem("Rival Field Messenger +$225.00");
        Pages.productPage().setQtyInput(itemQty);
        Pages.productPage().clickAddToCartButton();
        assertEquals(Pages.productPage().getQtyErrorMessage(), GlobalData.overMaxQtyError);
    }
    @Test(groups = {"unsuccess", "addToCart"})
    @Description("Bundle product card is selected. Bundle item is selected. Item qty is changed. Product is added to cart successfully")
    @Severity(SeverityLevel.NORMAL)
    public void invalidOverMinItemQtyATCTest() {
        start(GlobalData.mainURL);
        String itemQty = "0";
        Pages.homepage().clickWomenMenuButton().clickTestLink().clickBundleProductCard();
        Pages.productPage().mainElementsIsDisplayedAsserts();

        Pages.productPage().clickCustomizeATCButton();
        Pages.productPage().selectBundleItem("Rival Field Messenger +$225.00");
        Pages.productPage().setQtyInput(itemQty);
        Pages.productPage().clickAddToCartButton();
        assertEquals(Pages.productPage().getQtyErrorMessage(), GlobalData.overMinQtyError);
    }
}
