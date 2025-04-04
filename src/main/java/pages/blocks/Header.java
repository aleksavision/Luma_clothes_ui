package pages.blocks;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import pages.Homepage;
import pages.Pages;
import pages.CollectionPage;
import pages.userPages.LoginPage;
import pages.userPages.SuccessLogoutPage;
import tools.PageTools;

public class Header extends PageTools {

    private final By womenMenuButton = By.xpath("//a[@id='ui-id-3']");
    private final By menMenuButton = By.xpath("//a[@id='ui-id-4']");
    private final By createAnAccountLink = By.xpath("//div[@class='panel header']/ul/li/a[text()='Create an Account']");
    private final By userMenuArrow = By.xpath("//div[@class='panel header']/ul/li/span/button");
    private final By signInLink = By.xpath("//a[contains(text(), 'Sign In')]");
    private final By sighOutLink = By.xpath("//a[contains(text(), 'Sign Out')]");
    private final By logo = By.xpath("//a[@class='logo']");
    private final By womenTopsMenuButton = By.xpath("//a[@id='ui-id-9']");
    private final By menTopsMenuButton = By.xpath("//a[@id='ui-id-18']");
    private final By womenTestMenuButton = By.xpath("//a[@id='ui-id-11']");
    private final By womenJacketsMenuButton = By.xpath("//a[@id='ui-id-12']");
    private final By menJacketsMenuButton = By.xpath("//a[@id='ui-id-20']");
    private final By womenBottomsMenuButton = By.xpath("//a[@id='ui-id-10']");
    private final By womenShortsMenuButton = By.xpath("//a[@id='ui-id-17']");
    private final By greetingInfo = By.xpath("//div[@class='panel header']/ul/li/span[@class='logged-in']");
    private final By comparisonListItemQty = By.xpath("//a[@class='action compare']/span");

    //-------------------isDisplayed-------------------

    @Step("Check if Sign Out link is displayed")
    public boolean signOutLinkIsDisplayed() {
        clickUserMenuArrow();
        return isElementVisible(sighOutLink);
    }

    @Step("Check if Sign In link is displayed")
    public boolean signInLinkIsDisplayed() {
        clickUserMenuArrow();
        return isElementVisible(signInLink);
    }

    @Step("Check if Sign It link isn't displayed")
    public boolean signInLinkNotDisplayed() {
        return !Pages.header().signInLinkIsDisplayed();
    }

    @Step("Check if item qty in Comparison list is displayed")
    public boolean itemQtyInComparisonListIsDisplayed() {
        return isElementVisible(comparisonListItemQty);
    }

    //-------------------Get-------------------

    @Step("Get greeting info text for logged-in user")
    public String getGreetingInfo() {
        return getElementText(greetingInfo);
    }

    //-------------------Click-------------------

    @Step("Click Women button in Category menu")
    public void clickWomenMenuButton() {
        click(womenMenuButton);
    }

    @Step("Click Create an Account link in header")
    public void clickCreateAnAccountLink() {
        waitForElementClickable(createAnAccountLink);
        click(createAnAccountLink);
    }

    @Step("Click Sign Out link in header")
    public SuccessLogoutPage clickSignOutLink() {
        clickUserMenuArrow();
        click(sighOutLink);
        return new SuccessLogoutPage();
    }

    @Step("Click Sign In link in header")
    public LoginPage clickSignInLink() {
        click(signInLink);
        return new LoginPage();
    }

    @Step("Click Logo in header")
    public Homepage clickLogo() {
        click(logo);
        return new Homepage();
    }

    @Step("Click Women's Jackets menu button")
    public CollectionPage clickWomenJacketsMenuButton() {
        moveToElement(womenMenuButton);
        moveToElement(womenTopsMenuButton);
        moveToElement(womenJacketsMenuButton);
        click(womenJacketsMenuButton);
        return new CollectionPage();
    }

    @Step("Click Women's Test button in Category menu")
    public CollectionPage clickWomenTestMenuButton() {
        moveToElement(womenMenuButton);
        moveToElement(womenTestMenuButton);
        click(womenTestMenuButton);
        return new CollectionPage();
    }

    @Step("Click Women's Tops button in Category menu")
    public CollectionPage clickWomenTopsMenuButton() {
        moveToElement(womenMenuButton);
        moveToElement(womenTopsMenuButton);
        click(womenTopsMenuButton);
        return new CollectionPage();
    }

    @Step("Click Men's Jackets menu button")
    public CollectionPage clickMenJacketsMenuButton() {
        moveToElement(menMenuButton);
        moveToElement(menTopsMenuButton);
        moveToElement(menJacketsMenuButton);
        click(menJacketsMenuButton);
        return new CollectionPage();
    }

    @Step("Click Women's Shorts menu button")
    public CollectionPage clickWomenShortsMenuButton() {
        moveToElement(womenMenuButton);
        moveToElement(womenBottomsMenuButton);
        moveToElement(womenShortsMenuButton);
        click(womenShortsMenuButton);
        return new CollectionPage();
    }

    private void clickUserMenuArrow() {
        waitForElementEnabled(userMenuArrow);
        click(userMenuArrow);
    }


}
