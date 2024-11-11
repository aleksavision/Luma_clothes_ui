package tests;

import baseTest.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
import pages.Pages;
import testData.GlobalData;

import static org.testng.Assert.assertEquals;

public class GroupProductAtcTests extends BaseTest {

    @Test(groups = {"success", "addToCart"})
    @Description("Group product card is selected. Product is added to cart successfully")
    @Severity(SeverityLevel.NORMAL)
    public void successGroupItemAdding() {
        start(GlobalData.mainURL);
        Pages.homepage().clickWomenMenuButton().clickTestLink().clickGroupProductCard();
        Pages.productPage().mainElementsIsDisplayedAsserts();

        Pages.productPage().clickAddToCartButton();
        softAssert.assertTrue(Pages.productPage().getSuccessATCMessage().startsWith(GlobalData.successATCMessagePartly));
        softAssert.assertAll();
    }

    @Test(groups = {"success", "addToCart"})
    @Description("Group product card is selected. Product is added to cart successfully")
    @Severity(SeverityLevel.NORMAL)
    public void changeItemQtyATCTest() {
        start(GlobalData.mainURL);
        String itemQty = "11";
        Pages.homepage().clickWomenMenuButton().clickTestLink().clickGroupProductCard();
        Pages.productPage().mainElementsIsDisplayedAsserts();

        Pages.productPage().setQtyInputGroupItem(1, itemQty);
        Pages.productPage().setQtyInputGroupItem(2, itemQty);
        Pages.productPage().setQtyInputGroupItem(3, itemQty);
        Pages.productPage().clickAddToCartButton();
        Pages.productPage().clickShoppingCartLink();
        assertEquals(Pages.shoppingCartPage().getItemByIndexQty(1), itemQty);
        assertEquals(Pages.shoppingCartPage().getItemByIndexQty(2), itemQty);
        assertEquals(Pages.shoppingCartPage().getItemByIndexQty(3), itemQty);
    }

    @Test(groups = {"success", "addToCart"})
    @Description("Group product card is selected. Product is added to cart successfully")
    @Severity(SeverityLevel.NORMAL)
    public void invalidOverMaxItemQtyATCTest() {
        start(GlobalData.mainURL);
        String itemQty = "10001";
        Pages.homepage().clickWomenMenuButton().clickTestLink().clickGroupProductCard();
        Pages.productPage().mainElementsIsDisplayedAsserts();

        Pages.productPage().setQtyInputGroupItem(1, itemQty);
        Pages.productPage().clickAddToCartButton();
        softAssert.assertEquals(Pages.productPage().getPageError(), GlobalData.overMaxQtyGroupError);
        softAssert.assertAll();
    }
}
