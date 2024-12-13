package pages.plp;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import pages.pdp.ProductPage;
import pages.userPages.MyWishListPage;
import tools.PageTools;

public class TestPage extends PageTools {
    private final By productCard = By.xpath("//div[@class='product-item-info']");

    @Step("Click Bundle product card")
    public ProductPage clickBundleProductCard(){
        clickElementByIndex(productCard, 1);
        return new ProductPage();
    }
    @Step("Click Group product card")
    public ProductPage clickGroupProductCard(){
        clickElementByIndex(productCard, 2);
        return new ProductPage();
    }
    @Step("Click Single product card")
    public ProductPage clickSingleProductCard(){
        clickElementByIndex(productCard, 3);
        return new ProductPage();
    }
}
