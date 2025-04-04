package pages;

import pages.blocks.Header;
import pages.blocks.MiniCart;
import pages.carts.CheckoutPaymentPage;
import pages.carts.CheckoutShippingPage;
import pages.carts.CheckoutSuccessPage;
import pages.carts.ShoppingCartPage;
import pages.userPages.*;

public class Pages {

    private static Homepage homepage;
    private static Header header;
    private static CheckoutPaymentPage checkoutPaymentPage;
    private static CheckoutShippingPage checkoutShippingPage;
    private static CheckoutSuccessPage checkoutSuccessPage;
    private static LoginPage loginPage;
    private static MyAccountPage myAccountPage;
    private static ProductPage productPage;
    private static RegisterPage registerPage;
    private static ShoppingCartPage shoppingCartPage;
    private static SuccessLogoutPage successLogoutPage;
    private static CollectionPage collectionPage;
    private static MyWishListPage myWishListPage;
    private static CompareProductsPage compareProductsPage;
    private static MiniCart miniCart;


    public static Homepage homepage() {
        if (homepage == null) {
            homepage = new Homepage();
        }
        return homepage;
    }

    public static MiniCart miniCart() {
        if (miniCart == null) {
            miniCart = new MiniCart();
        }
        return miniCart;
    }

    public static CollectionPage collectionPage() {
        if (collectionPage == null) {
            collectionPage = new CollectionPage();
        }
        return collectionPage;
    }

    public static Header header() {
        if (header == null) {
            header = new Header();
        }
        return header;
    }

    public static CheckoutPaymentPage checkoutPaymentPage() {
        if (checkoutPaymentPage == null) {
            checkoutPaymentPage = new CheckoutPaymentPage();
        }
        return checkoutPaymentPage;
    }

    public static CheckoutShippingPage checkoutShippingPage() {
        if (checkoutShippingPage == null) {
            checkoutShippingPage = new CheckoutShippingPage();
        }
        return checkoutShippingPage;
    }

    public static CheckoutSuccessPage checkoutSuccessPage() {
        if (checkoutSuccessPage == null) {
            checkoutSuccessPage = new CheckoutSuccessPage();
        }
        return checkoutSuccessPage;
    }

    public static LoginPage loginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage();
        }
        return loginPage;
    }

    public static MyAccountPage myAccountPage() {
        if (myAccountPage == null) {
            myAccountPage = new MyAccountPage();
        }
        return myAccountPage;
    }

    public static ProductPage productPage() {
        if (productPage == null) {
            productPage = new ProductPage();
        }
        return productPage;
    }

    public static RegisterPage registerPage() {
        if (registerPage == null) {
            registerPage = new RegisterPage();
        }
        return registerPage;
    }

    public static ShoppingCartPage shoppingCartPage() {
        if (shoppingCartPage == null) {
            shoppingCartPage = new ShoppingCartPage();
        }
        return shoppingCartPage;
    }

    public static SuccessLogoutPage successLogoutPage() {
        if (successLogoutPage == null) {
            successLogoutPage = new SuccessLogoutPage();
        }
        return successLogoutPage;
    }

    public static MyWishListPage myWishListPage() {
        if (myWishListPage == null) {
            myWishListPage = new MyWishListPage();
        }
        return myWishListPage;
    }

    public static CompareProductsPage compareProductsPage() {
        if (compareProductsPage == null) {
            compareProductsPage = new CompareProductsPage();
        }
        return compareProductsPage;
    }


}
