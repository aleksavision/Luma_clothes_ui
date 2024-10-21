package testData;

import java.util.Date;

public class GlobalData{

    public static final String mainURL = "http://46.101.147.48/";

    //Customer info
    public static final String validEmail = "bonus@gmail.nl";
    public static final String invalidEmail = "xxx";
    public static final String firstName = "Aleksa";
    public static final String lastName = "Whitehouse";
    public static final String validPassword = "Aleksa111!";
    public static final String sevenSymbolsPassword = "1234567";
    public static final String noLetterPassword = "74359682!";
    public static final String noDigitPassword = "74359682!";
    public static final String noSpecificSymbolPassword = "74359682w";
    public static final String updatingEmail(){
         long timestamp = new Date().getTime();
         return "autotest" + timestamp + "@gmail.nl";
    }

    //Shipping info
    public static final String streetName = "Yellow";
    public static final String cityName = "Greenville";
    public static final String validPostalCode = "21212";
    public static final String phoneNumber = "+380505005050";

    //Product info
    public static final String inStockInfo = "IN STOCK";
    public static final String outOfStockInfo = "OUT OF STOCK";

    //Info messages
    public static final String successATCMessagePartly = "You added";
    public static final String successRegisterMessage = "Thank you 888for registering with Main Website Store.";
    public static final String successLogOutMessage = "You are signed out";
    public static final String successOrderCreatingMessage = "Thank you for your purchase!";
    public static final String requiredFieldError = "This is a required field.";
    public static final String overMaxQtyError = "The maximum you may purchase is 10000.";
    public static final String invalidEmailError = "Please enter a valid email address (Ex: johndoe@domain.com).";
    public static final String invalidConfirmPasswordError = "Please enter the same value again.";
    public static final String tooShortPasswordError = "Minimum length of this field must be equal or greater than 8 symbols. Leading and trailing spaces will be ignored.";
    public static final String noLetterOrSymbolOrDigitPasswordError = "Minimum of different classes of characters in password is 3. Classes of characters: Lower Case, Upper Case, Digits, Special Characters.";

}
