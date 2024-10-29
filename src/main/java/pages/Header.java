package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import tools.PageTools;

public class Header extends PageTools {

    private final By womenMenuButton = By.xpath("//a[@id='ui-id-3']");
    private final By createAnAccountLink = By.xpath("(//a[text()='Create an Account'])[1]");
    private final By userMenuArrow = By.xpath("//button[@data-action='customer-menu-toggle'][1]");
    private final By signInLink = By.xpath("//a[contains(text(), 'Sign In')]");
    private final By sighOutLink = By.xpath("//a[contains(text(), 'Sign Out')]");
    private final By cartButton = By.xpath("//a[@class='action showcart active']");
    private final By emptyCartNotification = By.xpath("//strong[@class='subtitle empty']");
    private final By logo = By.xpath("//a[@class='logo']");

    @Step("Click Women button in Category menu")
    public void clickWomenMenuButton() {
        click(womenMenuButton);
    }
    @Step("Click Create an Account link in header")
    public void clickCreateAnAccountLink() {
        waitForElementVisible(createAnAccountLink);
        click(createAnAccountLink);
    }
    @Step("Click Sign Out link in header")
    public void clickSignOutLink(){
        waitForElementVisible(userMenuArrow);
        click(userMenuArrow);
        click(sighOutLink);
    }
    @Step("Click Sign In link in header")
    public void clickSignInLink(){
        click(signInLink);
    }
    @Step("Check if Sign Out link is displayed")
    public boolean signOutLinkIsDisplayed(){
        waitForElementVisible(userMenuArrow);
        click(userMenuArrow);
        return isElementVisible(sighOutLink);
    }
    @Step("Click Cart button in header")
    public void clickCartButton(){
        click(cartButton);
    }
    @Step("Check if Empty cart notification is displayed")
    public boolean emptyCartNotificationIsDisplayed(){
        clickCartButton();
        return isElementVisible(emptyCartNotification);
    }
    @Step("Click Logo in header")
    public Homepage clickLogo(){
        click(logo );
        return new Homepage();
    }


}
