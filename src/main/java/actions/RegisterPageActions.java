package actions;

import pages.Pages;
import pages.userPages.MyAccountPage;
import testData.GlobalData;
import utils.EmailGenerator;

public class RegisterPageActions {

    public MyAccountPage registerUser(String firstName, String lastName, String email, String password, String confirmPassword) {
        String first = (firstName != null) ? firstName : GlobalData.firstName;
        String last = (lastName != null) ? lastName : GlobalData.lastName;
        String user = (email != null) ? email : EmailGenerator.generateRandomEmail();
        String pass = (password != null) ? password : GlobalData.validPassword;
        String confirmPass = (confirmPassword != null) ? confirmPassword : GlobalData.validPassword;

        Pages.registerPage().setFirstNameInput(first);
        Pages.registerPage().setLastNameInput(last);
        Pages.registerPage().setEmailInput(user);
        Pages.registerPage().setPasswordInput(pass);
        Pages.registerPage().setConfirmPasswordInput(confirmPass);

        Pages.registerPage().clickCreateAnAccountButton();
        return new MyAccountPage();
    }


}
