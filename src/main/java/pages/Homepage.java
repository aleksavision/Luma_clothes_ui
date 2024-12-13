package pages;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import pages.plp.JacketsPage;
import pages.plp.WomenPage;
import pages.userPages.RegisterPage;
import pages.userPages.LoginPage;
import tools.PageTools;

public class Homepage extends PageTools {
    @Step("Click Women button in Category menu")
    public WomenPage clickWomenMenuButton(){
        Pages.header().clickWomenMenuButton();
        return new WomenPage();
    }
    @Step("Click Create an Account link in header")
    public RegisterPage clickCreateAnAccountLink(){
        Pages.header().clickCreateAnAccountLink();
        return new RegisterPage();
    }
    @Step("Click Sign Out link in header")
    public LoginPage clickSignInLink(){
        Pages.header().clickSignInLink();
        return new LoginPage();
    }
    @Step("Check if Sign Out link is displayed")
    public boolean signOutLinkIsDisplayed(){
        return Pages.header().signOutLinkIsDisplayed();
    }
    @Step("Check if Sign It link isn't displayed")
    public boolean signInLinkNotDisplayed(){
        return !Pages.header().signInLinkIsDisplayed();
    }
    @Step("Click Women's Jackets menu button")
    public JacketsPage clickWomenJacketsMenuButton(){
        Pages.header().clickWomenJacketsMenuButton();
        return new JacketsPage();
    }
    @Step("Click Men's Jackets menu button")
    public JacketsPage clickMenJacketsMenuButton(){
        Pages.header().clickMenJacketsMenuButton();
        return new JacketsPage();
    }
    @Step("Get page URL address")
    public String getPageUrl(){
        return Selenide.webdriver().driver().url();
    }



}
