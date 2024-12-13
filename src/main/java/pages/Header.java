package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import pages.carts.ShoppingCartPage;
import pages.plp.JacketsPage;
import pages.plp.ShortsPage;
import tools.PageTools;

import java.awt.event.WindowEvent;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class Header extends PageTools {

    private final By womenMenuButton = By.xpath("//a[@id='ui-id-3']");
    private final By menMenuButton = By.xpath("//a[@id='ui-id-4']");
    private final By createAnAccountLink = By.xpath("//div[@class='panel header']/ul/li/a[text()='Create an Account']");
    private final By userMenuArrow = By.xpath("//div[@class='panel header']/ul/li/span/button");
    private final By signInLink = By.xpath("//a[contains(text(), 'Sign In')]");
    private final By sighOutLink = By.xpath("//a[contains(text(), 'Sign Out')]");
    private final By cartButton = By.xpath("//div[@data-block='minicart']");
    private final By emptyCartNotification = By.xpath("//strong[@class='subtitle empty']");
    private final By logo = By.xpath("//a[@class='logo']");
    private final By womenTopsMenuButton = By.xpath("//a[@id='ui-id-9']");
    private final By menTopsMenuButton = By.xpath("//a[@id='ui-id-18']");
    private final By womenJacketsMenuButton = By.xpath("//a[@id='ui-id-12']");
    private final By menJacketsMenuButton = By.xpath("//a[@id='ui-id-20']");
    private final By cartCounter = By.xpath("//span[@class='counter-number']");
    private final By womenBottomsMenuButton = By.xpath("//a[@id='ui-id-10']");
    private final By womenShortsMenuButton = By.xpath("//a[@id='ui-id-17']");
    private final By greetingInfo = By.xpath("//div[@class='panel header']/ul/li/span[@class='logged-in']");

    //Mini-cart elements
    private final By itemLink = By.xpath("//strong[@class='product-item-name']/a");
    private final By itemPrice = By.xpath("//span[@class='minicart-price']/span");
    private final By cartItemsQty = By.xpath("//span[@class='count']");
    private final By cartSubtotal = By.xpath("//div[@class='amount price-container']/span/span");
    private final By itemQty = By.xpath("//input[@class='item-qty cart-item-qty']");
    private final By seeDetailsLink = By.xpath("//span[@data-role='title']/span");
    private final By itemSizeValue = By.xpath("//dl/dd[1]/span");
    private final By itemColorValue = By.xpath("//dl/dd[2]/span");
    private final By viewAndEditCartLink = By.xpath("//a[@class='action viewcart']/span");
    private final By counterIcon = By.xpath("//a[@class='action showcart']/span[@class='counter qty']");
    private final By itemDetailedPrice = By.xpath("//dd[@class='values']/span/span");
    private final By itemDetailedInfo = By.xpath("//dd[@class='values']/span");
    private final By updateButton = By.xpath("//button[@title='Update']");
    private final By editItemButton = By.xpath("//a[@title='Edit item']");
    private final By removeItemButton = By.xpath("//a[@title='Remove item']");
    private final By okConfirmRemoveButton = By.xpath("//button[@class='action-primary action-accept']");


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
        return isElementVisible(emptyCartNotification);
    }
    @Step("Click Logo in header")
    public Homepage clickLogo(){
        click(logo);
        return new Homepage();
    }
    @Step("Click Women's Jackets menu button")
    public JacketsPage clickWomenJacketsMenuButton(){
        moveToElement(womenMenuButton);
        moveToElement(womenTopsMenuButton);
        moveToElement(womenJacketsMenuButton);
        click(womenJacketsMenuButton);
        return new JacketsPage();
    }
    @Step("Click Men's Jackets menu button")
    public JacketsPage clickMenJacketsMenuButton(){
        moveToElement(menMenuButton);
        moveToElement(menTopsMenuButton);
        moveToElement(menJacketsMenuButton);
        click(menJacketsMenuButton);
        return new JacketsPage();
    }
    @Step("Click Women's Shorts menu button")
    public ShortsPage clickWomenShortsMenuButton(){
        moveToElement(womenMenuButton);
        moveToElement(womenBottomsMenuButton);
        moveToElement(womenShortsMenuButton);
        click(womenShortsMenuButton);
        return new ShortsPage();
    }
    @Step("Get Cart counter value")
    public String getCartCounterValue(){
        waitForElementVisible(counterIcon);
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
    @Step("Get added item's price in Mini-cart")
    public String getItemPrice(){
        return getElementText(itemPrice);
    }
   @Step("Get added item's qty in Mini-cart")
   public String getItemQty(){
       return getElementAttributeValue("data-item-qty", itemQty);
   }
   @Step("Click See Details link in Mini-cart")
   public void clickSeeDetailsLink(){
        click(seeDetailsLink);
   }
   @Step("Get added item size in Mini-cart")
   public String getItemSizeValue(){
        return getElementText(itemSizeValue);
    }
    @Step("Get added item color in Mini-cart")
    public String getItemColorValue(){
        return getElementText(itemColorValue);
    }
    @Step("Click View and Edit Cart link")
    public ShoppingCartPage clickViewAndEditCartLink(){
       click(viewAndEditCartLink);
       return new ShoppingCartPage();
    }
    @Step("Get added item's name in Mini-cart by {index}")
    public String getItemNameByIndex(int index) {
        return getElementTextByIndex(itemLink, index);
    }
    @Step("Get added item's detailed info in Mini-cart")
    public String getItemDetailedInfo() {
        return getElementText(itemDetailedInfo);
    }
    @Step("Get added item's detailed price in Mini-cart")
    public String getItemDetailedPrice() {
        return getElementText(itemDetailedPrice);
    }
    @Step("Fill Qty field with {itemQty}")
    public void setQtyInput(String qty) {
        click(itemQty);
        Selenide.actions().sendKeys($(itemQty), Keys.DELETE).perform();
        clearText(itemQty);
        type(itemQty, qty);
    }
    @Step("Click Update button")
    public void clickUpdateButton(){
        click(updateButton);
        waitForElementInvisibleUntil(updateButton, 2);
    }
    @Step("Click Edit item button")
    public void clickEditItemButton(){
        click(editItemButton);
    }
    @Step("Click OK button on Confirmation popup")
    public void clickOkConfirmationButton(){
        click(okConfirmRemoveButton);
    }
    @Step("Clear the cart")
    public void clearCart(){
        while(!emptyCartNotificationIsDisplayed()){
           click(removeItemButton);
           clickOkConfirmationButton();
           getElementsTextWithWait(cartItemsQty, 2);
        }
    }
    @Step("Get greeting info text for logged-in user")
    public String getGreetingInfo(){
        return getElementText(greetingInfo);
    }






    private void clickUserMenuArrow(){
        waitForElementEnabled(userMenuArrow);
        click(userMenuArrow);
    }


}
