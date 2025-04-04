package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import pages.carts.ShoppingCartPage;
import pages.userPages.CompareProductsPage;
import pages.userPages.LoginPage;
import pages.userPages.MyWishListPage;
import tools.PageTools;

import static com.codeborne.selenide.Selenide.$$;

public class CollectionPage extends PageTools {
    private final By topsLink = By.xpath("//a[text()='Tops']");
    private final By bottomsLink = By.xpath("//a[text()='Bottoms']");
    private final By testLink = By.xpath("//a[text()='Test']");
    private final By productCard = By.xpath("//div[@class='product-item-info']");
    private final By productName = By.xpath("//a[@class='product-item-link']");
    private final By productPrice = By.xpath("//span[@class='price-wrapper ']/span");
    private final By ratingRate = By.xpath("//div[@class='rating-result']/span/span");
    private final By reviewsQty = By.xpath("//a[@class='action view']");
    private final By successMessage = By.xpath("//div[@data-ui-id='message-success']/div");
    private final By comparisonListLink = By.xpath("//div[@data-ui-id='message-success']/div/a");
    private final By shoppingCartLink = By.xpath("//div[@data-ui-id='message-success']/div/a");
    private final By addToWishlistButton = By.xpath("//a[@class='action towishlist']");
    private final By addToCompareButton = By.xpath("//a[@class='action tocompare']");
    private final By addToCartButton = By.xpath("//button[@title='Add to Cart']");

    //--------------isDisplayed--------------


    //--------------Get--------------

    @Step("Get item name by {index}")
    public String getItemNameByIndex(int index) {
        return getElementTextByIndex(productName, index);
    }

    @Step("Get item price by {index}")
    public String getItemPriceByIndex(int index) {
        return getElementTextByIndex(productPrice, index);
    }

    @Step("Get item rating rate by {index}")
    public String getItemRatingRateByIndex(int index) {
        return getElementTextByIndex(ratingRate, index);
    }

    @Step("Get item Reviews qty by {index}")
    public String getItemReviewsQtyByIndex(int index) {
        return getElementTextByIndex(reviewsQty, index);
    }

    @Step("Get success info message text")
    public String getSuccessMessage() {
        return getElementText(successMessage);
    }

    //----------------Click----------------

    @Step("Click product card by {index}")
    public ProductPage clickProductCardByIndex(int index) {
        clickElementByIndex(productCard, index);
        return new ProductPage();
    }

    @Step("Click Add to Cart button by {index}")
    public void clickAddToCartButtonByIndex(int index) {
        By locator = By.id(("(" + productCard + ")[" + index + "]"));
        moveToElement(locator);
        clickElementByIndex(addToCartButton, index);
    }

    @Step("Click Shopping Cart link")
    public ShoppingCartPage clickShoppingCartLink() {
        click(shoppingCartLink);
        return new ShoppingCartPage();
    }

    @Step("Click Bundle product card")
    public ProductPage clickBundleProductCard() {
        clickElementByIndex(productCard, 1);
        return new ProductPage();
    }

    @Step("Click Group product card")
    public ProductPage clickGroupProductCard() {
        clickElementByIndex(productCard, 2);
        return new ProductPage();
    }

    @Step("Click Single product card")
    public ProductPage clickSingleProductCard() {
        clickElementByIndex(productCard, 3);
        return new ProductPage();
    }

    @Step("Click Add to compare button by {index}")
    public void clickAddToCompareButtonByIndex(int index) {
        By locator = By.id(("(" + productCard + ")[" + index + "]"));
        moveToElement(locator);
        click(addToCompareButton);
    }

    @Step("Click Comparison list link")
    public CompareProductsPage clickComparisonListLink() {
        click(comparisonListLink);
        return new CompareProductsPage();
    }

    @Step("Click Add to wishlist button by {index} as logged-in user")
    public MyWishListPage clickAddToWishlistButtonByIndexAsUser(int index) {
        By locator = By.id(("(" + productCard + ")[" + index + "]"));
        moveToElement(locator);
        click(addToWishlistButton);
        return new MyWishListPage();
    }

    @Step("Click Add to wishlist button by {index} as guest user")
    public LoginPage clickAddToWishlistButtonByIndexAsGuest(int index) {
        By locator = By.id(("(" + productCard + ")[" + index + "]"));
        moveToElement(locator);
        click(addToWishlistButton);
        return new LoginPage();
    }

    //----------------Set/Select----------------

    @Step("Select size/color for item by {index}")
    public void selectItemOptionByIndex(int itemIndex, String value) {
        By locator = By.xpath("(//div[@class='product-item-info'])[" + itemIndex + "]/div/div[3]/div/div/div[@aria-label='" + value + "']");
        click(locator);
    }

    @Step("Select simple product card")
    public ProductPage selectSimpleProductCard(String singleItemName) {
        $$(productName).findBy(Condition.text(singleItemName)).click();
        return new ProductPage();
    }

}
