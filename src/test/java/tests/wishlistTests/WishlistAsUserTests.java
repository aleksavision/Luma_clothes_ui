package tests.wishlistTests;

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
import static org.testng.Assert.assertTrue;

public class WishlistAsUserTests extends BaseTest {

    Map<String, String> erikaShortData = new HashMap<>();
    Integer erikaShortIndex = 1;

    @BeforeMethod
    private void startTest() {
        start("http://46.101.147.48/wishlist/");
        Pages.loginPage().setEmailInput(GlobalData.validEmail);
        Pages.loginPage().setPasswordInput(GlobalData.validPassword);
        Pages.loginPage().clickSignInButton();
        Actions.wishListPageActions().clearWishlist();
        Pages.header().clickWomenShortsMenuButton();
        erikaShortData.put("Name", Pages.collectionPage().getItemNameByIndex(erikaShortIndex));
        erikaShortData.put("Price", Pages.collectionPage().getItemPriceByIndex(erikaShortIndex));
    }

    @Test(groups = {"elements"})
    @Description("User is logged-in. Product is added to Wishlist from PLP successfully. Elements are displayed on Wishlist page")
    @Severity(SeverityLevel.NORMAL)
    public void checkMainElementsDisplaying() {
        Pages.collectionPage().clickAddToWishlistButtonByIndexAsUser(erikaShortIndex);

        assertTrue(Pages.myWishListPage().isProductImageDisplayed());
        assertTrue(Pages.myWishListPage().isProductNameDisplayed());
        assertTrue(Pages.myWishListPage().isProductPriceDisplayed());
        assertTrue(Pages.myWishListPage().isAddToCartButtonDisplayed(1));
        assertTrue(Pages.myWishListPage().isUpdateWishlistButtonDisplayed());
        assertTrue(Pages.myWishListPage().isAddAllToCartButtonDisplayed());
    }

    @Test(groups = {"success"})
    @Description("User is logged-in. Product is added to Wishlist from PLP successfully. Product is checked on Wishlist page")
    @Severity(SeverityLevel.NORMAL)
    public void addProductToWishlistPlpAsUser() {

        Pages.collectionPage().clickAddToWishlistButtonByIndexAsUser(erikaShortIndex);

        assertEquals(Pages.myWishListPage().getItemsQty(), "1 Item");
        assertEquals(Pages.collectionPage().getSuccessMessage(), GlobalData.successAddingToWishlistMessage(erikaShortData.get("Name")));
        assertEquals(Pages.myWishListPage().getItemName(erikaShortIndex), erikaShortData.get("Name"));

    }

    @Test(groups = {"success"})
    @Description("User is logged-in. Product is added to Wishlist from PDP successfully. Product is checked on Wishlist page")
    @Severity(SeverityLevel.NORMAL)
    public void addProductToWishlistPdpAsUser() {

        Pages.collectionPage().clickProductCardByIndex(erikaShortIndex).clickAddToWishlistButtonAsUser();

        assertEquals(Pages.myWishListPage().getItemsQty(), "1 Item");
        assertEquals(Pages.collectionPage().getSuccessMessage(), GlobalData.successAddingToWishlistMessage(erikaShortData.get("Name")));
        assertEquals(Pages.myWishListPage().getItemName(erikaShortIndex), erikaShortData.get("Name"));

    }

    @Test(groups = {"success"})
    @Description("Logged-in user added product to Wishlist from PLP. Item qty is changed successfully.")
    @Severity(SeverityLevel.NORMAL)
    public void changeItemQty() {

        Pages.collectionPage().clickProductCardByIndex(erikaShortIndex).clickAddToWishlistButtonAsUser();
        Pages.myWishListPage().setItemQtyInput(erikaShortIndex, "5");
        Pages.myWishListPage().clickUpdateWishlistButton();

        assertEquals(Pages.myWishListPage().getSuccessMessageText(), GlobalData.successUpdatingWishlistMessage(erikaShortData.get("Name")));
    }

    @Test(groups = {"success"})
    @Description("User is logged-in. Product is added to Wishlist from PLP. Product is added to cart successfully.")
    @Severity(SeverityLevel.NORMAL)
    public void addProductFromWishlistToCart() {

        Pages.collectionPage().clickProductCardByIndex(erikaShortIndex).clickAddToWishlistButtonAsUser();
        Pages.myWishListPage().clickAddToCartButtonByIndex(erikaShortIndex);
        assertEquals(Pages.productPage().getWarningMessageText(), GlobalData.chooseOptionWarningMessage);
        assertEquals(Pages.productPage().getProductName(), erikaShortData.get("Name"));
        assertEquals(Pages.productPage().getProductPrice(), erikaShortData.get("Price"));

        Pages.productPage().selectSize();
        Pages.productPage().selectColor();
        Pages.productPage().clickAddToCartButton();
        assertEquals(Pages.myWishListPage().getSuccessMessageText(), GlobalData.successATCMessage(erikaShortData.get("Name")));
    }


}
