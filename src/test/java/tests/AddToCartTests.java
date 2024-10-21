package tests;

import baseTest.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
import pages.Pages;
import testData.GlobalData;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AddToCartTests extends BaseTest {

    @Test (groups = {"success", "addToCart"})
    @Description("Random product card is selected. Product is added to cart successfully")
    @Severity(SeverityLevel.NORMAL)
    public void successRandomItemAdding(){
        start(GlobalData.mainURL);

        Pages.homepage().clickWomenMenuButton().clickTestLink().clickRandomProductCard();
        assertTrue(Pages.productPage().productImageIsDisplayed());
        assertTrue(Pages.productPage().productNameIsDisplayed());
        assertTrue(Pages.productPage().priceIsDisplayed());

        Pages.productPage().selectRandomColor();
        Pages.productPage().selectRandomSize();
        Pages.productPage().addAnyProductToCart();
        softAssert.assertTrue(Pages.productPage().getSuccessATCMessage().startsWith(GlobalData.successATCMessagePartly));
        softAssert.assertAll();
    }

    @Test (groups = {"success", "addToCart"})
    @Description("Bundle product card is selected. Product is added to cart successfully")
    @Severity(SeverityLevel.NORMAL)
    public void successBundleItemAdding(){
        start(GlobalData.mainURL);
        Pages.homepage().clickWomenMenuButton().clickTestLink().clickProductCardByIndex(0);
        assertTrue(Pages.productPage().productImageIsDisplayed());
        assertTrue(Pages.productPage().productNameIsDisplayed());
        assertTrue(Pages.productPage().priceIsDisplayed());

        Pages.productPage().clickCustomizeATCButton();
        Pages.productPage().selectBundleItem("Joust Duffle Bag +$170.00");
        Pages.productPage().clickAddToCartButton();
        softAssert.assertTrue(Pages.productPage().getSuccessATCMessage().startsWith(GlobalData.successATCMessagePartly));
        softAssert.assertAll();
    }

    @Test (groups = {"success", "addToCart"})
    @Description("Group product card is selected. Product is added to cart successfully")
    @Severity(SeverityLevel.NORMAL)
    public void successGroupItemAdding() {
        start(GlobalData.mainURL);
        Pages.homepage().clickWomenMenuButton().clickTestLink().clickProductCardByIndex(1);
        assertTrue(Pages.productPage().productImageIsDisplayed());
        assertTrue(Pages.productPage().productNameIsDisplayed());
        assertTrue(Pages.productPage().priceIsDisplayed());

        Pages.productPage().clickAddToCartButton();
        softAssert.assertTrue(Pages.productPage().getSuccessATCMessage().startsWith(GlobalData.successATCMessagePartly));
        softAssert.assertAll();
    }

    @Test (groups = {"unsuccess", "addToCart"})
    @Description("Bundle product card is selected. Bundle item isn't selected. Product isn't added to cart")
    @Severity(SeverityLevel.NORMAL)
    public void noSelectedBundleItemATCtest(){
        start(GlobalData.mainURL);
        Pages.homepage().clickWomenMenuButton().clickTestLink().clickProductCardByIndex(0);
        assertTrue(Pages.productPage().productImageIsDisplayed());
        assertTrue(Pages.productPage().productNameIsDisplayed());
        assertTrue(Pages.productPage().priceIsDisplayed());

        Pages.productPage().clickCustomizeATCButton();
        Pages.productPage().clickAddToCartButton();
        softAssert.assertEquals(Pages.productPage().getBundleItemErrorMessage(), GlobalData.requiredFieldError);
        softAssert.assertAll();
    }

    @Test (groups = {"unsuccess", "addToCart"})
    @Description("Single product card is selected. Color option isn't selected. Product isn't added to cart")
    @Severity(SeverityLevel.NORMAL)
    public void noSelectedColorATCtest() {
        start(GlobalData.mainURL);
        Pages.homepage().clickWomenMenuButton().clickTopsLink().clickRandomProductCard();
        assertTrue(Pages.productPage().productImageIsDisplayed());
        assertTrue(Pages.productPage().productNameIsDisplayed());
        assertTrue(Pages.productPage().priceIsDisplayed());
        assertTrue(Pages.productPage().colorButtonIsDisplayed());

        Pages.productPage().selectRandomSize();
        Pages.productPage().clickAddToCartButton();
        softAssert.assertEquals(Pages.productPage().getColorErrorMessage(), GlobalData.requiredFieldError);
        softAssert.assertAll();
    }
    @Test (groups = {"unsuccess", "addToCart"})
    @Description("Single product card is selected. Size option isn't selected. Product isn't added to cart")
    @Severity(SeverityLevel.NORMAL)
    public void noSelectedSizeATCtest() {
        start(GlobalData.mainURL);
        Pages.homepage().clickWomenMenuButton().clickTopsLink().clickRandomProductCard();
        assertTrue(Pages.productPage().productImageIsDisplayed());
        assertTrue(Pages.productPage().productNameIsDisplayed());
        assertTrue(Pages.productPage().priceIsDisplayed());
        assertTrue(Pages.productPage().sizeButtonIsDisplayed());

        Pages.productPage().selectRandomColor();
        Pages.productPage().clickAddToCartButton();
        softAssert.assertEquals(Pages.productPage().getSizeErrorMessage(), GlobalData.requiredFieldError);
        softAssert.assertAll();
    }
    @Test (groups = {"success", "addToCart"})
    @Description("Single product card is selected. Item qty is changed. Product is added to cart successfully")
    @Severity(SeverityLevel.NORMAL)
    public void changeItemQtyATCtest() {
        start(GlobalData.mainURL);
        String itemQty = "5";

        Pages.homepage().clickWomenMenuButton().clickTopsLink().clickRandomProductCard();
        assertTrue(Pages.productPage().productImageIsDisplayed());
        assertTrue(Pages.productPage().productNameIsDisplayed());
        assertTrue(Pages.productPage().priceIsDisplayed());
        assertTrue(Pages.productPage().qtyInputIsDisplayed());

        Pages.productPage().selectRandomSize();
        Pages.productPage().selectRandomColor();
        Pages.productPage().setQtyInput(itemQty);
        Pages.productPage().clickAddToCartButton();
        Pages.productPage().clickShoppingCartLink();
        assertEquals(Pages.shoppingCartPage().getItemQty(), itemQty);
    }
    @Test (groups = {"unsuccess", "addToCart"})
    @Description("Single product card is selected. Item qty is changed. Product is added to cart successfully")
    @Severity(SeverityLevel.NORMAL)
    public void invalidItemQtyATCtest() {
        start(GlobalData.mainURL);
        String itemQty = "10001";

        Pages.homepage().clickWomenMenuButton().clickTopsLink().clickRandomProductCard();
        assertTrue(Pages.productPage().productImageIsDisplayed());
        assertTrue(Pages.productPage().productNameIsDisplayed());
        assertTrue(Pages.productPage().priceIsDisplayed());
        assertTrue(Pages.productPage().qtyInputIsDisplayed());

        Pages.productPage().selectRandomSize();
        Pages.productPage().selectRandomColor();
        Pages.productPage().setQtyInput(itemQty);
        Pages.productPage().clickAddToCartButton();
        softAssert.assertEquals(Pages.productPage().getQtyErrorMessage(), GlobalData.overMaxQtyError);
        softAssert.assertAll();
    }


}
