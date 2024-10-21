package pages;

import pages.carts.CheckoutPaymentPage;
import pages.carts.CheckoutShippingPage;
import pages.carts.CheckoutSuccessPage;
import pages.carts.ShoppingCartPage;
import pages.pdp.ProductPage;
import pages.plp.TopsPage;
import pages.plp.WomenPage;
import pages.userPages.LoginPage;
import pages.userPages.MyAccountPage;
import pages.userPages.RegisterPage;
import pages.userPages.SuccessLogoutPage;

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
    private static TopsPage topsPage;
    private static WomenPage womenPage;

    public static Homepage homepage(){
        if(homepage == null){
            homepage = new Homepage();
        }
        return homepage;
    }
    public static Header header(){
        if(header == null){
            header = new Header();
        }
        return header;
    }
    public static CheckoutPaymentPage checkoutPaymentPage(){
        if(checkoutPaymentPage == null){
            checkoutPaymentPage = new CheckoutPaymentPage();
        }
        return checkoutPaymentPage;
    }
    public static CheckoutShippingPage checkoutShippingPage(){
        if(checkoutShippingPage == null){
            checkoutShippingPage = new CheckoutShippingPage();
        }
        return checkoutShippingPage;
    }
    public static CheckoutSuccessPage checkoutSuccessPage(){
        if(checkoutSuccessPage == null){
            checkoutSuccessPage = new CheckoutSuccessPage();
        }
        return checkoutSuccessPage;
    }
    public static LoginPage loginPage(){
        if(loginPage == null){
            loginPage = new LoginPage();
        }
        return loginPage;
    }
    public static MyAccountPage myAccountPage(){
        if(myAccountPage == null){
            myAccountPage = new MyAccountPage();
        }
        return myAccountPage;
    }
    public static ProductPage productPage(){
        if(productPage == null){
            productPage = new ProductPage();
        }
        return productPage;
    }
    public static RegisterPage registerPage(){
        if(registerPage == null){
            registerPage = new RegisterPage();
        }
        return registerPage;
    }
    public static ShoppingCartPage shoppingCartPage(){
        if(shoppingCartPage == null){
            shoppingCartPage = new ShoppingCartPage();
        }
        return shoppingCartPage;
    }
    public static SuccessLogoutPage successLogoutPage(){
        if(successLogoutPage == null){
            successLogoutPage = new SuccessLogoutPage();
        }
        return successLogoutPage;
    }
    public static TopsPage topsPage(){
        if(topsPage == null){
            topsPage = new TopsPage();
        }
        return topsPage;
    }
    public static WomenPage womenPage(){
        if(womenPage == null){
            womenPage = new WomenPage();
        }
        return womenPage;
    }

}
