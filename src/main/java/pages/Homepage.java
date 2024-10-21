package pages;

import pages.plp.WomenPage;
import pages.userPages.RegisterPage;
import pages.userPages.LoginPage;
import tools.PageTools;

public class Homepage extends PageTools {

    public WomenPage clickWomenMenuButton(){
        Pages.header().clickWomenMenuButton();
        return new WomenPage();
    }
    public RegisterPage clickCreateAnAccountLink(){
        Pages.header().clickCreateAnAccountLink();
        return new RegisterPage();
    }
    public LoginPage clickSignInLink(){
        Pages.header().clickSignInLink();
        return new LoginPage();
    }
    public boolean signOutLinkIsDisplayed(){
        return Pages.header().signOutLinkIsDisplayed();
    }


}
