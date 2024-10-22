package pages.plp;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import pages.pdp.ProductPage;
import tools.PageTools;

import java.util.List;

import static com.codeborne.selenide.Selenide.$$;

public class TestPage extends PageTools {
    private final By productCard = By.xpath("//div[@class='product-item-info']");

    @Step("Click Bundle product card")
    public ProductPage clickBundleProductCard(){
        clickElement(getProductCardIndex(0));
        return new ProductPage();
    }
    @Step("Click Group product card")
    public ProductPage clickGroupProductCard(){
        clickElement(getProductCardIndex(1));
        return new ProductPage();
    }
    @Step("Click Single product card")
    public ProductPage clickSingleProductCard(){
        clickElement(getProductCardIndex(2));
        return new ProductPage();
    }
    @Step("Click product card by index {index}")
    private SelenideElement getProductCardIndex(Integer index){
        List<SelenideElement> items = $$(productCard).stream().toList();
        return items.get(index);
    }
}
