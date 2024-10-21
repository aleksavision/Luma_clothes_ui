package actions;

public class Actions {

    private static HomePageActions homePageActions;
    private static CheckoutPaymentPageActions checkoutPaymentPageActions;
    private static CheckoutShippingPageActions checkoutShippingPageActions;
    private static CheckoutSuccessPageActions checkoutSuccessPageActions;
    private static LoginPageActions loginPageActions;
    private static MyAccountPageActions myAccountPageActions;
    private static ProductPageActions productPageActions;
    private static RegisterPageActions registerPageActions;
    private static ShoppingCartPageActions shoppingCartPageActions;
    private static SuccessLogoutPageActions successLogoutPageActions;
    private static TopsPageActions topsPageActions;
    private static WomenPageActions womenPageActions;

    public HomePageActions homePageActions(){
        if(homePageActions == null){
            homePageActions = new HomePageActions();
        }
        return homePageActions;
    }

    public static CheckoutPaymentPageActions getCheckoutPaymentPageActions() {
        if(checkoutPaymentPageActions == null){
            checkoutPaymentPageActions = new CheckoutPaymentPageActions();
        }
        return checkoutPaymentPageActions;
    }
    public CheckoutShippingPageActions checkoutShippingPageActions(){
        if(checkoutShippingPageActions == null){
            checkoutShippingPageActions = new CheckoutShippingPageActions();
        }
        return checkoutShippingPageActions;
    }

    public CheckoutSuccessPageActions checkoutSuccessPageActions(){
        if(checkoutSuccessPageActions == null){
            checkoutSuccessPageActions = new CheckoutSuccessPageActions();
        }
        return checkoutSuccessPageActions;
    }
    public LoginPageActions loginPageActions(){
        if(loginPageActions == null){
            loginPageActions = new LoginPageActions();
        }
        return loginPageActions;
    }
    public MyAccountPageActions myAccountPageActions(){
        if(myAccountPageActions == null){
            myAccountPageActions = new MyAccountPageActions();
        }
        return myAccountPageActions;
    }
    public ProductPageActions productPageActions(){
        if(productPageActions == null){
            productPageActions = new ProductPageActions();
        }
        return productPageActions;
    }
    public RegisterPageActions registerPageActions(){
        if(registerPageActions == null){
            registerPageActions = new RegisterPageActions();
        }
        return registerPageActions;
    }
    public ShoppingCartPageActions shoppingCartPageActions(){
        if(shoppingCartPageActions == null){
            shoppingCartPageActions = new ShoppingCartPageActions();
        }
        return shoppingCartPageActions;
    }
    public SuccessLogoutPageActions successLogoutPageActions(){
        if(successLogoutPageActions == null){
            successLogoutPageActions = new SuccessLogoutPageActions();
        }
        return successLogoutPageActions;
    }
    public TopsPageActions topsPageActions(){
        if(topsPageActions == null){
            topsPageActions = new TopsPageActions();
        }
        return topsPageActions;
    }
    public WomenPageActions womenPageActions(){
        if(womenPageActions == null){
            womenPageActions = new WomenPageActions();
        }
        return womenPageActions;
    }




}
