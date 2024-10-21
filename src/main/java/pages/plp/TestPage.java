package pages.plp;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import pages.pdp.ProductPage;
import tools.PageTools;

import java.util.List;

import static com.codeborne.selenide.Selenide.$$;

public class TestPage extends PageTools {
    private final By productCard = By.xpath("//div[@class='product-item-info']");

    public ProductPage clickRandomProductCard(){
        clickRandomElement(productCard);
        return new ProductPage();
    }

    /**
     *
     * @param index
     * @return from 0 to 2
     */
    public ProductPage clickProductCardByIndex(int index){
        List<SelenideElement> items = $$(productCard).stream().toList();
        clickElement(items.get(index));
        return new ProductPage();
    }
}
