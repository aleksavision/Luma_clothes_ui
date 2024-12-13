package pages.plp;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import pages.carts.ShoppingCartPage;
import pages.pdp.ProductPage;
import tools.PageTools;

public class TopsPage extends PageTools {

    private final By productCard = By.xpath("//div[@class='product-item-info']");
    private final By productName = By.xpath("//a[@class='product-item-link']");
    private final By successMessage = By.xpath("//div[@data-ui-id='message-success']/div");
    private final By productPrice = By.xpath("//span[@class='price-wrapper ']/span");
    private final By ratingRate = By.xpath("//div[@class='rating-result']/span/span");
    private final By reviewsQty = By.xpath("//a[@class='action view']");
    private final By shoppingCartLink = By.xpath("//div[@data-ui-id='message-success']/div/a");
    private final By addToCartButton = By.xpath("//button[@title='Add to Cart']");

    @Step("Click product card by {index}")
    public ProductPage clickProductCardByIndex(int index){
        clickElementByIndex(productCard, index);
        return new ProductPage();
    }
    @Step("Check success info message text")
    public String getSuccessMessage() {
        return getElementText(successMessage);
    }
    @Step("Get item name by {index}")
    public String getItemNameByIndex(int index){
        return getElementTextByIndex(productName, index);
    }
    @Step("Get item price by {index}")
    public String getItemPriceByIndex(int index){
        return getElementTextByIndex(productPrice, index);
    }
    @Step("Get item rating rate by {index}")
    public String getItemRatingRateByIndex(int index){
        return getElementTextByIndex(ratingRate, index);
    }
    @Step("Get item Reviews qty by {index}")
    public String getItemReviewsQtyByIndex(int index){
        return getElementTextByIndex(reviewsQty, index);
    }
    @Step("Select size/color for item by {index}")
    public void selectItemOptionByIndex(int itemIndex, String value){
        By locator = By.xpath("(//div[@class='product-item-info'])[" + itemIndex + "]/div/div[3]/div/div/div[@aria-label='" + value +"']");
        click(locator);
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
}
