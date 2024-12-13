package pages.userPages;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import tools.PageTools;

import static com.codeborne.selenide.Selenide.$;

public class MyWishListPage extends PageTools {
    private final By productName = By.xpath("//div/strong/a[@class='product-item-link']");
    private final By productPrice = By.xpath("//span[@class='price-wrapper ']/span");
    private final By seeDetailsTooltip = By.xpath("//span[@class='action details tooltip toggle']");
    private final By addAllToCartButton = By.xpath("//button[@class='action tocart']");
    private final By successMessage = By.xpath("//div[@class='message-success success message']/div");
    private final By emptyInfoMessage = By.xpath("//div[@class='message info empty']/span");
    private final By removeItemButton = By.xpath("//a[@data-role='remove']");
    private final By listQty = By.xpath("//span[@class='toolbar-number']");

    //Options Details elements
    private final By groupItemName = By.xpath("//dt[@class='label']");
    private final By groupItemQty = By.xpath("//dd[@class='values']");


    @Step("Click Add All to Cart button")
    public void clickAddAllToCartButton(){
        click(addAllToCartButton);
    }
    @Step("Get item name by {index}")
    public String getItemName(int index){
        return getElementTextByIndex(productName, index);
    }
    @Step("Get item price by {index}")
    public String getItemPrice(int index){
        return getElementTextByIndex(productPrice, index);
    }
    @Step("Open Options Details for item by {index}")
    public void openOptionsDetailsForItemByIndex(int index){
        By locator = By.id(("(" + seeDetailsTooltip + ")[" + index + "]"));
        scrollToPlaceElementInCenter(locator);
        moveToElement(locator);
    }
    @Step("Get Group item name by {index} from Options Details")
    public String getGroupItemNameByIndex(int index){
        return getElementTextByIndex(groupItemName, index);
    }
    @Step("Get Group item qty by {index} from Options Details")
    public String getGroupItemQtyByIndex(int index){
        return getElementTextByIndex(groupItemQty, index);
    }
    @Step("Get success info message text")
    public String getSuccessMessageText(){
        return getElementText(successMessage);
    }
    @Step("Get empty info message text")
    public String getEmptyMessageText(){
        return getElementText(emptyInfoMessage);
    }
    @Step("Click Remove item button by {index}")
    public void clickRemoveItemButtonByIndex(int index){
        By locator1 = By.id(("(" + productName + ")[" + index + "]"));
        By locator2 = By.id(("(" + removeItemButton + ")[" + index + "]"));
        moveToElement(locator1);
        click(locator2);
    }
    @Step("Get items qty in Wishlist")
    public String getItemsQty(){
        return getElementText(listQty);
    }

}
