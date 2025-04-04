package testData;

import org.openqa.selenium.By;

import java.util.Date;

public class GlobalData {

    public static final String mainURL = "http://46.101.147.48/";

    //---------------Customer info---------------
    public static final String validEmail = "bonus@gmail.nl";
    public static final String invalidEmail = "xxx";
    public static final String firstName = "Aleksa";
    public static final String lastName = "Whitehouse";
    public static final String validPassword = "Aleksa111!";
    public static final String sevenSymbolsPassword = "Aleksa7";
    public static final String noLetterPassword = "74359682!";
    public static final String noDigitPassword = "74359682!";
    public static final String noSpecificSymbolPassword = "74359682w";

    public static final String updatingEmail() {
        long timestamp = new Date().getTime();
        return "autotest" + timestamp + "@gmail.nl";
    }

    //---------------Shipping/Billing info---------------

    public static final String streetName = "Yellow";
    public static final String cityName = "Greenville";
    public static final String validPostalCode = "21212";
    public static final String phoneNumber = "+380505005050";
    public static final String state = "Alabama";
    public static final String country = "United States";
    public static final String invalidPostalCode = "111";

    //---------------Product info---------------

    public static final String inStockInfo = "IN STOCK";
    public static final String outOfStockInfo = "OUT OF STOCK";
    public static final String invalidCouponCode = "invalid coupon";

    //---------------Info messages---------------

    public static final String successATCMessage(String productName) {
        return "You added " + productName + " to your shopping cart.";
    }

    public static final String successRegisterMessage = "Thank you for registering with Main Website Store.";
    public static final String successLogOutMessage = "You are signed out";
    public static final String successOrderCreatingTitle = "Thank you for your purchase!";

    public static final String successOrderCreatingMessage(String orderNumber) {
        return "Your order # is: " + orderNumber + ".\n" +
                "We'll email you an order confirmation with details and tracking info.\n" +
                "Continue Shopping";
    }

    public static final String requiredFieldError = "This is a required field.";
    public static final String overMaxQtyError = "The maximum you may purchase is 10000.";
    public static final String overMinQtyError = "Please enter a quantity greater than 0.";
    public static final String emptyFieldQtyError = "Please enter a valid number in this field.";
    public static final String overMaxQtyGroupError = "The requested qty exceeds the maximum qty allowed in shopping cart";
    public static final String overMinQtyGroupError = "Please specify the quantity of product(s).";
    public static final String invalidEmailError = "Please enter a valid email address (Ex: johndoe@domain.com).";
    public static final String incorrectLoginError = "The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.";
    public static final String invalidConfirmPasswordError = "Please enter the same value again.";
    public static final String tooShortPasswordError = "Minimum length of this field must be equal or greater than 8 symbols. Leading and trailing spaces will be ignored.";
    public static final String noLetterOrSymbolOrDigitPasswordError = "Minimum of different classes of characters in password is 3. Classes of characters: Lower Case, Upper Case, Digits, Special Characters.";
    public static final String emptyCartNotification = "You have no items in your shopping cart.";
    public static final String successCartUpdatingMessage = "Bundle was updated in your shopping cart.";
    public static final String notRegistredUserForWishlistErrorMessage = "You must login or register to add items to your wishlist.";

    public static final String successAddingToWishlistMessage(String productName) {
        return productName + " has been added to your Wish List. Click here to continue shopping.";
    }

    public static final String successUpdatingWishlistMessage(String productName) {
        return productName + " has been updated in your Wish List.";
    }

    public static final String successItemRemovingFromWishlistMessage(String productName) {
        return productName + " has been removed from your Wish List.";
    }

    public static final String successATCFromWishlistMessage(String productName) {
        return "1 product(s) have been added to shopping cart: \"" + productName + "\".";
    }

    public static final String wishlistEmptyInfoMessage = "You have no items in your wish list.";

    public static final String successAddingToCompareMessage(String productName) {
        return "You added product " + productName + " to the comparison list.";
    }

    public static final String successItemRemovingFromComparisonMessage(String productName) {
        return "You removed product " + productName + " from the comparison list.";
    }

    public static final String emptyCartInfoMessage = "You have no items in your shopping cart.\n" +
            "Click here to continue shopping.";
    public static final String chooseOptionWarningMessage = "You need to choose options for your item.";

    public static final String itemQtyInWishlist(String qty) {
        return "1".equals(qty) ? qty + " Item" : qty + " Item(s)";
    }

    public static final String invalidCouponCodeErrorMessage(String couponCode) {
        return "The coupon code \"" + couponCode + "\" is not valid.";
    }

    public static final String invalidPostalCodeSixDigitsError = "Provided Zip/Postal Code seems to be invalid. Example: 123456. If you believe it is the right one you can ignore this notice.";

    public static final String greetingInfo(String firstName, String lastName) {
        return "Welcome, " + firstName + " " + lastName + "!";
    }

    public static final String incorrectCaptchaError = "Incorrect CAPTCHA";
    public static final String emptyMiniCartInfoMessage = "You have no items in your shopping cart.";
    public static final String notSelectedShippingMethodError = "The shipping method is missing. Select the shipping method and try again.";

}
