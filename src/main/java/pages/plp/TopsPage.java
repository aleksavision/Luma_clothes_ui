package pages.plp;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import pages.pdp.ProductPage;
import tools.PageTools;

public class TopsPage extends PageTools {

    private final By productCard = By.xpath("//div[@class='product-item-info']");

    @Step("Click first product card")
    public ProductPage clickFirstProductCard(){
        click(productCard);
        return new ProductPage();
    }



}
