package pages.userPages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import pages.ProductPage;
import tools.PageTools;

public class CompareProductsPage extends PageTools {

    private final By itemName = By.xpath("//td[@data-th='Product']/strong/a");
    private final By itemPrice = By.xpath("//span[@class='price-wrapper ']/span");
    private final By addToCartButton = By.xpath("//button[@class='action tocart primary']");
    private final By itemSku = By.xpath("//*[@id='product-comparison']/tbody[2]/tr[1]/td/div");
    private final By itemDescription = By.xpath("//*[@id='product-comparison']/tbody[2]/tr[2]/td/div");
    private final By removeItemButton = By.xpath("//td[@class='cell remove product hidden-print']/a");
    private final By successMessage = By.xpath("//div[@data-ui-id='message-success']/div");
    private final By emptyListMessage = By.xpath("//div[@class='message info empty']/div");
    private final By okConfirmRemoveButton = By.xpath("//button[@class='action-primary action-accept']");

    //--------------isDisplayed--------------

    @Step("Check if item description is displayed")
    public boolean isItemDescDisplayed() {
        return isElementVisible(itemDescription);
    }

    @Step("Check if Empty list message is displayed")
    public boolean isEmptyListMessageDisplayed() {
        return isElementVisible(emptyListMessage);
    }

    @Step("Check success info message text")
    public String getSuccessMessage() {
        return getElementText(successMessage);
    }

    @Step("Check if item name is displayed")
    public boolean isItemNameDisplayed() {
        return isElementVisible(itemName);
    }

    @Step("Check if item price is displayed")
    public boolean isItemPriceDisplayed() {
        return isElementVisible(itemPrice);
    }

    @Step("Check if Add to Cart button is displayed")
    public boolean isAddToCartButtonDisplayed() {
        return isElementVisible(addToCartButton);
    }

    //--------------Get--------------

    @Step("Get item name by {index}")
    public String getItemNameByIndex(int index) {
        return getElementTextByIndex(itemName, index);
    }

    @Step("Get item price by {index}")
    public String getItemPriceByIndex(int index) {
        return getElementTextByIndex(itemPrice, index);
    }

    @Step("Get item SKU by {index}")
    public String getItemSkuByIndex(int index) {
        return getElementTextByIndex(itemSku, index);
    }

    //--------------Click--------------

    @Step("Click Remove item button")
    public void clickRemoveItemButton() {
        click(removeItemButton);
    }

    @Step("Click Add to Cart button")
    public ProductPage clickAddToCartButton() {
        click(addToCartButton);
        return new ProductPage();
    }

    @Step("Click OK button on Confirmation popup")
    public void clickOkConfirmationButton() {
        click(okConfirmRemoveButton);
    }


}
