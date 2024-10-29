//package tests;
//
//import baseTest.BaseTest;
//import org.testng.annotations.Test;
//import pages.Pages;
//import testData.GlobalData;
//
//public class ZeroTest extends BaseTest {
//
//    @Test (groups = "1")
//    public void checkProductName() {
//        start(GlobalData.mainURL);
//
//        Pages.homepage().clickWomenMenuButton().clickTestLink().clickSingleProductCard();
//        Pages.productPage().selectColor();
//        Pages.productPage().setQtyInput("3");
//        Pages.productPage().clickAddToCartButton();
//        softAssert.assertTrue(Pages.productPage().productNameIsDisplayed());
//        softAssert.assertAll();
//    }
//    @Test (groups = "2")
//    public void checkProductName1() {
//        start(GlobalData.mainURL);
//
//        Pages.homepage().clickWomenMenuButton().clickTestLink().clickSingleProductCard();
//        Pages.productPage().selectColor();
//        Pages.productPage().setQtyInput("3");
//        Pages.productPage().clickAddToCartButton();
//        softAssert.assertTrue(Pages.productPage().productNameIsDisplayed());
//        softAssert.assertAll();
//    }
//}
