package actions;

import com.codeborne.selenide.Selenide;
import pages.Pages;

public class CompareProductsPageActions {

    public void clearComparisonList() {
        while (Pages.header().itemQtyInComparisonListIsDisplayed()) {
            Pages.compareProductsPage().clickRemoveItemButton();
            Pages.compareProductsPage().clickOkConfirmationButton();
        }
    }

}
