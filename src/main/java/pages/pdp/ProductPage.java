package pages.pdp;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import pages.Pages;
import pages.carts.ShoppingCartPage;
import tools.PageTools;

import java.util.List;
import java.util.Random;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ProductPage extends PageTools {

    private final By addToCartButton = By.xpath("//button[contains(@id, 'addtocart')]");
    private final By shoppingCartLink = By.xpath("//a[text()='shopping cart']");
    private final By sizeButton = By.xpath("//div[@class='swatch-option text']");
    private final By colorButton = By.xpath("//div[@class='swatch-option color']");
    private final By priceInfo = By.xpath("//span[@itemprop='offers']//span[@class='price']");
    private final By minPriceInfo = By.xpath("//span[@data-price-type='minPrice']//span[@class='price']");
    private final By maxPriceInfo = By.xpath("//span[@data-price-type='maxPrice']//span[@class='price']");
    private final By groupPrice = By.xpath("//span[@class='price']");
    private final By stockInfo = By.xpath("//div[@title='Availability']/span");
    private final By productName = By.xpath("//span[@itemprop='name']");
    private final By successATCMessage = By.xpath("//div[@data-ui-id='message-success']/div");
    private final By productImage = By.xpath("//img[@class='fotorama__img']");
    private final By customizeATCButton = By.xpath("//button[@id='bundle-slide']");
    private final By bundleItemsDropdown = By.xpath("//select[@id='bundle-option-15']");
    private final By bundleItemOption = By.xpath("//option");
    private final By bundleItemErrorMessage = By.xpath("//div[@for='bundle-option-15']");
    private final By colorErrorMessage = By.xpath("//div[@class='mage-error']");
    private final By sizeErrorMessage = By.xpath("//div[@class='mage-error']");
    private final By qtyInput = By.xpath("//input[@name='qty']");
    private final By qtyErrorMessage = By.xpath("//div[@for='qty']");

    public void selectRandomSize() {
        if (sizeButtonIsDisplayed()) {
            clickRandomElement(sizeButton);
        }
    }
    public void selectRandomColor() {
        if (colorButtonIsDisplayed()) {
            clickRandomElement(colorButton);
        }
    }
    public void clickAddToCartButton() {
        click(addToCartButton);
    }
    public ShoppingCartPage clickShoppingCartLink() {
        click(shoppingCartLink);
        return new ShoppingCartPage();
    }
    public String getStockInfo() {
        return getElementText(stockInfo);
    }

    public boolean sizeButtonIsDisplayed() {
        return isElementVisible(sizeButton);
    }

    public boolean colorButtonIsDisplayed() {
        return isElementVisible(colorButton);
    }

    public boolean priceIsDisplayed() {
        if ($(minPriceInfo).isDisplayed()) {
            return isElementVisible(minPriceInfo, maxPriceInfo);
        } else {
            if ($(groupPrice).isDisplayed()) {
                return isElementVisible(groupPrice);
            }
        }
        return isElementVisible(priceInfo);
    }

    public boolean productNameIsDisplayed() {
        return isElementVisible(productName);
    }

    public String getSuccessATCMessage() {
        return getElementText(successATCMessage);
    }

    public boolean productImageIsDisplayed() {
        waitForElementVisible(productImage);
        return isElementVisible(productImage);
    }

    public void selectRandomBundleItem() {
        selectRandomOption(bundleItemsDropdown, bundleItemOption, "Choose a selection...");
    }
    public void selectBundleItem(String option){
        selectOption(option, bundleItemsDropdown);
    }

    public void clickCustomizeATCButton() {
        click(customizeATCButton);
    }

    public boolean customizeATCButtonIsDisplayed() {
        return isElementVisible(customizeATCButton);
    }

    public String getBundleItemErrorMessage() {
        return getElementText(bundleItemErrorMessage);
    }

    public String getColorErrorMessage() {
        return getElementText(colorErrorMessage);
    }

    public String getSizeErrorMessage() {
        return getElementText(sizeErrorMessage);
    }

    public void setQtyInput(String itemQty) {
        jsType(itemQty, qtyInput);
    }

    public boolean qtyInputIsDisplayed() {
        return isElementVisible(qtyInput);
    }

    public String getQtyErrorMessage() {
        return getElementText(qtyErrorMessage);
    }

    public void addAnyProductToCart() {
    if(customizeATCButtonIsDisplayed()){
        clickCustomizeATCButton();
        selectRandomBundleItem();
        clickAddToCartButton();
    }
    clickAddToCartButton();
}




}
