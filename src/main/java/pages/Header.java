package pages;

import org.openqa.selenium.By;
import tools.PageTools;

public class Header extends PageTools {

    private final By womenMenuButton = By.xpath("//a[@id='ui-id-3']");
    private final By createAnAccountLink = By.xpath("//a[text()='Create an Account']");
    private final By userMenuArrow = By.xpath("//button[@data-action='customer-menu-toggle'][1]");
    private final By signInLink = By.xpath("//a[contains(text(), 'Sign In')]");
    private final By sighOutLink = By.xpath("//a[contains(text(), 'Sign Out')]");


    public void clickWomenMenuButton() {
        click(womenMenuButton);
    }
    public void clickCreateAnAccountLink() {
        click(createAnAccountLink);
    }
    public void clickSignOutLink(){
        click(userMenuArrow);
        click(sighOutLink);
    }
    public void clickSignInLink(){
        click(signInLink);
    }
    public boolean signOutLinkIsDisplayed(){
        click(userMenuArrow);
        return isElementVisible(sighOutLink);
    }



}
