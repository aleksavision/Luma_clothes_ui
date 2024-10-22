package pages.pdp;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import pages.Pages;
import pages.carts.ShoppingCartPage;
import testData.GlobalData;
import tools.PageTools;

import java.util.List;
import java.util.Random;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ProductPage extends PageTools {

    private final By addToCartButton = By.xpath("//button[contains(@id, 'addtocart')]");
    private final By shoppingCartLink = By.xpath("//a[text()='shopping cart']");
    private final By sizeButton = By.xpath("//div[@class='swatch-option text']");
    private final By colorButton = By.xpath("//div[@class='swatch-option color']");
    private final By priceInfo = By.xpath("//span[@itemprop='offers']//span[@class='price']");
    private final By minPriceInfo = By.xpath("//span[@data-price-type='minPrice']//span[@class='price']");
    private final By maxPriceInfo = By.xpath("//span[@data-price-type='maxPrice']//span[@class='price']");
    private final By groupPrice = By.xpath("//span[@class='price-wrapper ']/span");
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
    private final By qtyInputGroupItem = By.xpath("//input[@title='Qty']");
    private final By pageErrorMessage = By.xpath("//div[@role='alert']/div/div");

    //actions
    @Step("Select first size option")
    public void selectSize() {
            click(sizeButton);
    }
    @Step("Select first color option")
    public void selectColor() {
            click(colorButton);
    }
    @Step("Click Add to Cart button")
    public void clickAddToCartButton() {
        click(addToCartButton);
    }
    @Step("Click Shopping Cart link")
    public ShoppingCartPage clickShoppingCartLink() {
        click(shoppingCartLink);
        return new ShoppingCartPage();
    }
    @Step("Check Stock info message text")
    public String getStockInfo() {
        return getElementText(stockInfo);
    }
    @Step("Check if Size button is displayed")
    public boolean sizeButtonIsDisplayed() {
        return isElementVisible(sizeButton);
    }
    @Step("Check if Color button is displayed")
    public boolean colorButtonIsDisplayed() {
        return isElementVisible(colorButton);
    }
    @Step("Check if price/prices is displayed")
    public boolean priceIsDisplayed() {
        if ($(minPriceInfo).isDisplayed()) {
            return isElementVisible(minPriceInfo, maxPriceInfo);
        } else {
            if ($(groupPrice).isDisplayed()){
                return isElementVisible(By.id((groupPrice + "[1]")), By.id((groupPrice + "[2]")), By.id((groupPrice + "[3]")));
            }
        }
        return isElementVisible(priceInfo);
    }
    @Step("Check if Product name is displayed")
    public boolean productNameIsDisplayed() {
        return isElementVisible(productName);
    }
    @Step("Check success adding to cart message text")
    public String getSuccessATCMessage() {
        return getElementText(successATCMessage);
    }
    @Step("Check if product image is displayed")
    public boolean productImageIsDisplayed() {
        waitForElementVisible(productImage);
        return isElementVisible(productImage);
    }
    @Step("Select {option} in Bundle item dropdown")
    public void selectBundleItem(String option){
        selectOption(option, bundleItemsDropdown);
    }
    @Step("Click Customize and Add to Cart button")
    public void clickCustomizeATCButton() {
        click(customizeATCButton);
    }
    @Step("Check if Customize and Add to Cart button is displayed")
    public boolean customizeATCButtonIsDisplayed() {
        return isElementVisible(customizeATCButton);
    }
    @Step("Check error message text if Bundle item isn't selected")
    public String getBundleItemErrorMessage() {
        return getElementText(bundleItemErrorMessage);
    }
    @Step("Check error message text if Color option isn't selected")
    public String getColorErrorMessage() {
        return getElementText(colorErrorMessage);
    }
    @Step("Check error message text if Size option isn't selected")
    public String getSizeErrorMessage() {
        return getElementText(sizeErrorMessage);
    }
    @Step("Fill Qty field with {itemQty}")
    public void setQtyInput(String itemQty) {
        jsType(itemQty, qtyInput);
    }
    @Step("Check if Qty field is displayed")
    public boolean qtyInputIsDisplayed() {
        return isElementVisible(qtyInput);
    }
    @Step("Check error message text if Qty field is filled with invalid data")
    public String getQtyErrorMessage() {
        return getElementText(qtyErrorMessage);
    }
    @Step("Check if Product image/name/price/size/color buttons are displayed")
    public void mainElementsIsDisplayedAsserts(){
        assertTrue(productImageIsDisplayed());
        assertTrue(productNameIsDisplayed());
        assertTrue(priceIsDisplayed());
        if(sizeButtonIsDisplayed()){
        assertTrue(sizeButtonIsDisplayed());
        } else System.out.println("This product doesn't have size selection");
        if(colorButtonIsDisplayed()){
        assertTrue(colorButtonIsDisplayed());} else System.out.println("This product doesn't have color selection");
    }
    /**
     *
     * @param index Started from 1
     */
    @Step("Fill Qty field for group number {index} with {itemQty}")
    public void setQtyInputGroupItem(Integer index, String itemQty){
        By locator = By.id(("(" + qtyInputGroupItem + ")[" + index + "]"));
        jsType(itemQty, locator);
    }
    @Step("Check page error text")
    public String getPageError(){
        return getElementText(pageErrorMessage );
    }






}
