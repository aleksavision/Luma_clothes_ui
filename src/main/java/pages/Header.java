package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import pages.carts.ShoppingCartPage;
import tools.PageTools;


public class Header extends PageTools {

    private final By womenMenuButton = By.xpath("//a[@id='ui-id-3']");
    private final By createAnAccountLink = By.xpath("//div[@class='panel header']/ul/li/a[text()='Create an Account']");
    private final By userMenuArrow = By.xpath("//div[@class='panel header']/ul/li/span/button");
    private final By signInLink = By.xpath("//a[contains(text(), 'Sign In')]");
    private final By sighOutLink = By.xpath("//a[contains(text(), 'Sign Out')]");
    private final By cartButton = By.xpath("//div[@data-block='minicart']");
    private final By emptyCartNotification = By.xpath("//strong[@class='subtitle empty']");
    private final By logo = By.xpath("//a[@class='logo']");
    private final By topsMenuButton = By.xpath("//a[@id='ui-id-9']");
    private final By jacketsMenuButton = By.xpath("//a[@id='ui-id-12']");
    private final By cartCounter = By.xpath("//span[@class='counter-number']");
    //Mini-cart elements
    private final By itemLink = By.xpath("//strong[@class='product-item-name']/a");
    private final By cartItemsQty = By.xpath("//span[@class='count']");
    private final By cartSubtotal = By.xpath("//div[@class='amount price-container']/span/span");
    private final By itemQty = By.xpath("//input[@class='item-qty cart-item-qty']");
    private final By seeDetailsLink = By.xpath("//span[@data-role='title']/span");
    private final By itemSizeValue = By.xpath("//dl/dd[1]/span");
    private final By itemColorValue = By.xpath("//dl/dd[2]/span");
    private final By viewAndEditCartLink = By.xpath("//a[@class='action viewcart']/span");


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
    public void clickSignOutLink(){
        clickUserMenuArrow();
        click(sighOutLink);
    }
    @Step("Click Sign In link in header")
    public void clickSignInLink(){
        click(signInLink);
    }

    @Step("Check if Sign Out link is displayed")
    public boolean signOutLinkIsDisplayed(){
        clickUserMenuArrow();
        return isElementVisible(sighOutLink);
    }
    @Step("Check if Sign In link is displayed")
    public boolean signInLinkIsDisplayed(){
        clickUserMenuArrow();
        return isElementVisible(signInLink);
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
        click(logo);
        return new Homepage();
    }
    @Step("Click Jackets menu button")
    public void clickJacketsMenuButton(){
        moveToElement(womenMenuButton);
        moveToElement(topsMenuButton);
        moveToElement(jacketsMenuButton);
        click(jacketsMenuButton);
    }
    @Step("Get Cart counter value")
    public String getCartCounterValue(){
        return getElementText(cartCounter);
    }
    @Step("Get added items qty in Mini-cart")
    public String getCartItemsQty(){
        return getElementText(cartItemsQty);
    }
   @Step("Get Subtotal amount value in Mini-cart")
    public String getCartSubtotal(){
        return getElementText(cartSubtotal);
   }
   @Step("Get added item's name in Mini-cart")
   public String getItemName(){
        return getElementText(itemLink);
   }
   @Step("Get added item's name in Mini-cart")
   public String getItemQty(){
       return getElementAttributeValue("data-item-qty", itemQty);
   }
   @Step("Click See Details link in Mini-cart")
   public void clickSeeDetailsLink(){
        click(seeDetailsLink);
   }
   @Step("Get added item size")
   public String getItemSizeValue(){
        return getElementText(itemSizeValue);
    }
    @Step("Get added item color")
    public String getItemColorValue(){
        return getElementText(itemColorValue);
    }
    @Step("Click View and Edit Cart link")
    public ShoppingCartPage clickViewAndEditCartLink(){
       click(viewAndEditCartLink);
       return new ShoppingCartPage();
    }



    private void clickUserMenuArrow(){
        waitForElementEnabled(userMenuArrow);
        click(userMenuArrow);
    }


}
