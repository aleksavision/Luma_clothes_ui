//package tests;
//
//import baseTest.BaseTest;
//import io.qameta.allure.Description;
//import io.qameta.allure.Severity;
//import io.qameta.allure.SeverityLevel;
//import org.testng.annotations.Test;
//import pages.Pages;
//import testData.GlobalData;
//
//import static org.testng.Assert.assertEquals;
//
//public class SingleProductAtcTests extends BaseTest {
//
//    @Test (groups = {"success", "addToCart"})
//    @Description("Single product card is selected. Color and Size are selected. Product is added to cart successfully")
//    @Severity(SeverityLevel.NORMAL)
//    public void successATCTest(){
//        start(GlobalData.mainURL);
//
//        Pages.homepage().clickWomenMenuButton().clickTopsLink().clickFirstProductCard();
//        Pages.productPage().mainElementsIsDisplayedAsserts();
//
//        Pages.productPage().selectSize();
//        Pages.productPage().selectColor();
//        Pages.productPage().clickAddToCartButton();
//        softAssert.assertTrue(Pages.productPage().getSuccessATCMessage().startsWith(GlobalData.successATCMessagePartly));
//        softAssert.assertAll();
//    }
//
//    @Test (groups = {"unsuccess", "addToCart"})
//    @Description("Single product card is selected. Color option isn't selected. Product isn't added to cart")
//    @Severity(SeverityLevel.NORMAL)
//    public void noSelectedColorATCTest() {
//        start(GlobalData.mainURL);
//        Pages.homepage().clickWomenMenuButton().clickTopsLink().clickFirstProductCard();
//        Pages.productPage().mainElementsIsDisplayedAsserts();
//
//        Pages.productPage().selectSize();
//        Pages.productPage().clickAddToCartButton();
//        softAssert.assertEquals(Pages.productPage().getColorErrorMessage(), GlobalData.requiredFieldError);
//        softAssert.assertAll();
//    }
//    @Test (groups = {"unsuccess", "addToCart"})
//    @Description("Single product card is selected. Size option isn't selected. Product isn't added to cart")
//    @Severity(SeverityLevel.NORMAL)
//    public void noSelectedSizeATCTest() {
//        start(GlobalData.mainURL);
//        Pages.homepage().clickWomenMenuButton().clickTopsLink().clickFirstProductCard();
//        Pages.productPage().mainElementsIsDisplayedAsserts();
//
//        Pages.productPage().selectColor();
//        Pages.productPage().clickAddToCartButton();
//        softAssert.assertEquals(Pages.productPage().getSizeErrorMessage(), GlobalData.requiredFieldError);
//        softAssert.assertAll();
//    }
//    @Test (groups = {"success", "addToCart"})
//    @Description("Single product card is selected. Item qty is changed. Product is added to cart successfully")
//    @Severity(SeverityLevel.NORMAL)
//    public void changeItemQtyATCTest() {
//        start(GlobalData.mainURL);
//        String itemQty = "5";
//
//        Pages.homepage().clickWomenMenuButton().clickTopsLink().clickFirstProductCard();
//        Pages.productPage().mainElementsIsDisplayedAsserts();;
//
//        Pages.productPage().selectSize();
//        Pages.productPage().selectColor();
//        Pages.productPage().setQtyInput(itemQty);
//        Pages.productPage().clickAddToCartButton();
//        Pages.productPage().clickShoppingCartLink();
//        assertEquals(Pages.shoppingCartPage().getItemQty(), itemQty);
//    }
//    @Test (groups = {"unsuccess", "addToCart"})
//    @Description("Single product card is selected. Item qty is changed. Product isn't added to cart. Error is displayed")
//    @Severity(SeverityLevel.NORMAL)
//    public void invalidOverMaxItemQtyATCTest() {
//        start(GlobalData.mainURL);
//        String itemQty = "10001";
//
//        Pages.homepage().clickWomenMenuButton().clickTopsLink().clickFirstProductCard();
//        Pages.productPage().mainElementsIsDisplayedAsserts();
//
//        Pages.productPage().selectSize();
//        Pages.productPage().selectColor();
//        Pages.productPage().setQtyInput(itemQty);
//        Pages.productPage().clickAddToCartButton();
//        softAssert.assertEquals(Pages.productPage().getQtyErrorMessage(), GlobalData.overMaxQtyError);
//        softAssert.assertAll();
//    }
//    @Test (groups = {"unsuccess", "addToCart"})
//    @Description("Single product card is selected. Item qty is changed. Product isn't added to cart. Error is displayed")
//    @Severity(SeverityLevel.NORMAL)
//    public void invalidOverMinItemQtyATCTest() {
//        start(GlobalData.mainURL);
//        String itemQty = "0";
//
//        Pages.homepage().clickWomenMenuButton().clickTopsLink().clickFirstProductCard();
//        Pages.productPage().mainElementsIsDisplayedAsserts();
//
//        Pages.productPage().selectSize();
//        Pages.productPage().selectColor();
//        Pages.productPage().setQtyInput(itemQty);
//        Pages.productPage().clickAddToCartButton();
//        softAssert.assertEquals(Pages.productPage().getQtyErrorMessage(), GlobalData.overMinQtyError);
//        softAssert.assertAll();
//    }
//
//
//
//}
