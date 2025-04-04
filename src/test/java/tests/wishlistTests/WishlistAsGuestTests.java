package tests.wishlistTests;

import baseTest.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Pages;
import testData.GlobalData;

import static org.testng.Assert.assertEquals;

public class WishlistAsGuestTests extends BaseTest {

    Integer erikaShortIndex = 1;

    @BeforeMethod
    private void startTest() {
        start(GlobalData.mainURL);
        Pages.header().clickWomenShortsMenuButton();
    }

    @Test(groups = {"unsuccess"})
    @Description("User isn't logged-in. Add to Wishlist button is clicked on PLP. User is redirected to Login page. Error is displayed")
    @Severity(SeverityLevel.NORMAL)
    public void addProductToWishlistPlpAsGuest() {

        Pages.collectionPage().clickAddToWishlistButtonByIndexAsGuest(erikaShortIndex);
        assertEquals(Pages.loginPage().getErrorMessageText(), GlobalData.notRegistredUserForWishlistErrorMessage);
    }

    @Test(groups = {"unsuccess"})
    @Description("User isn't logged-in. Add to Wishlist button is clicked on PDP. User is redirected to Login page. Error is displayed")
    @Severity(SeverityLevel.NORMAL)
    public void addProductToWishlistPdpAsGuest() {

        Pages.collectionPage().clickProductCardByIndex(erikaShortIndex);
        Pages.productPage().clickAddToWishlistButtonByIndexAsGuest();
        assertEquals(Pages.loginPage().getErrorMessageText(), GlobalData.notRegistredUserForWishlistErrorMessage);
    }

}
