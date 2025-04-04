package actions;

import io.qameta.allure.Step;
import pages.Pages;

public class MiniCartActions {

    @Step("Remove all items in cart one be one")
    public void clearCart() {
        while (Pages.miniCart().cartQtyElementIsDisplayed()) {
            Pages.miniCart().clickRemoveItemButton();
            Pages.miniCart().clickOkConfirmationButton();
            Pages.miniCart().getCartItemsQty();
        }
    }

}
