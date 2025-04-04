package actions;

import pages.userPages.MyWishListPage;

public class Actions {

    private static CheckoutShippingPageActions checkoutShippingPageActions;
    private static LoginPageActions loginPageActions;
    private static ProductPageActions productPageActions;
    private static RegisterPageActions registerPageActions;
    private static MiniCartActions miniCartActions;
    private static WishListPageActions wishListPageActions;
    private static CompareProductsPageActions compareProductsPageActions;

    public static MiniCartActions miniCartActions() {
        if (miniCartActions == null) {
            miniCartActions = new MiniCartActions();
        }
        return miniCartActions;
    }

    public static CompareProductsPageActions compareProductsPageActions() {
        if (compareProductsPageActions == null) {
            compareProductsPageActions = new CompareProductsPageActions();
        }
        return compareProductsPageActions;
    }

    public static CheckoutShippingPageActions checkoutShippingPageActions() {
        if (checkoutShippingPageActions == null) {
            checkoutShippingPageActions = new CheckoutShippingPageActions();
        }
        return checkoutShippingPageActions;
    }

    public static LoginPageActions loginPageActions() {
        if (loginPageActions == null) {
            loginPageActions = new LoginPageActions();
        }
        return loginPageActions;
    }

    public static ProductPageActions productPageActions() {
        if (productPageActions == null) {
            productPageActions = new ProductPageActions();
        }
        return productPageActions;
    }

    public static RegisterPageActions registerPageActions() {
        if (registerPageActions == null) {
            registerPageActions = new RegisterPageActions();
        }
        return registerPageActions;
    }

    public static WishListPageActions wishListPageActions() {
        if (wishListPageActions == null) {
            wishListPageActions = new WishListPageActions();
        }
        return wishListPageActions;
    }


}
