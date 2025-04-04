package actions;

import pages.Pages;
import testData.GlobalData;

public class LoginPageActions{

    public void loginUser(String email, String password){
        String user = (email != null) ? email : GlobalData.validEmail;
        String pass = (password != null) ? password : GlobalData.validPassword;

        Pages.loginPage().setEmailInput(user);
        Pages.loginPage().setPasswordInput(pass);
        Pages.loginPage().clickSignInButton();
    }

}

