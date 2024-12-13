package pages.userPages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import pages.pdp.ProductPage;
import tools.PageTools;

public class CompareProductsPage extends PageTools {

    private final By itemName = By.xpath("//strong/a");
    private final By itemPrice = By.xpath("//span[@class='price']");
    private final By addToCartButton = By.xpath("//button[@class='action tocart primary']");
    private final By itemSku = By.xpath("//*[@id='product-comparison']/tbody[2]/tr[1]/td/div");
    private final By itemDescription = By.xpath("//*[@id='product-comparison']/tbody[2]/tr[2]/td/div");
    private final By removeItemButton = By.xpath("//a[@class='action delete']");
    private final By successMessage = By.xpath("//div[@data-ui-id='message-success']/div");


    @Step("Get item name by {index}")
    public String getItemNameByIndex(int index){
        return getElementTextByIndex(itemName, index);
    }
    @Step("Get item price by {index}")
    public String getItemPriceByIndex(int index){
        return getElementTextByIndex(itemPrice, index);
    }
    @Step("Get item SKU by {index}")
    public String getItemSkuByIndex(int index){
        return getElementTextByIndex(itemSku, index);
    }
    @Step("Check if item description is displayed by {index}")
    public boolean isItemDescDisplayed(){
        return isElementVisible(itemDescription);
    }
    @Step("Click Add to Cart button")
    public ProductPage clickAddToCartButton(){
         click(addToCartButton);
         return new ProductPage();
    }
    @Step("Click Remove item button")
    public void clickRemoveItemButton(){
        click(removeItemButton);
    }
    @Step("Check success info message text")
    public String getSuccessMessage() {
        return getElementText(successMessage);
    }


}
