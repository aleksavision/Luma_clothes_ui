package actions;

import io.qameta.allure.Step;
import pages.Pages;

public class WishListPageActions {

    @Step("Remove all items in Wishlist")
    public void clearWishlist() {
        while (!Pages.myWishListPage().isEmptyInfoMessageDisplayed()){
            Pages.myWishListPage().clickRemoveItemButtonByIndex(1);
        }
    }

}
