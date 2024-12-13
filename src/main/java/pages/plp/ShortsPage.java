package pages.plp;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import pages.userPages.MyWishListPage;
import tools.PageTools;

public class ShortsPage extends PageTools {

    private final By addToWishlistButton = By.xpath("//a[@class='action towishlist']");
    private final By productCard = By.xpath("//div[@class='product-item-info']");
    private final By productName = By.xpath("//a[@class='product-item-link']");
    private final By productPrice = By.xpath("//span[@class='price-wrapper ']/span");

    @Step("Click Add to wishlist button by {index} as logged-in user")
    public MyWishListPage clickAddToWishlistButtonByIndexAsUser(int index) {
        By locator = By.id(("(" + productCard + ")[" + index + "]"));
        moveToElement(locator);
        click(addToWishlistButton);
        return new MyWishListPage();
    }
    @Step("Get item name by {index}")
    public String getItemNameByIndex(int index){
        return getElementTextByIndex(productName, index);
    }
    @Step("Get item price by {index}")
    public String getItemPriceByIndex(int index){
        return getElementTextByIndex(productPrice, index);
    }

}
