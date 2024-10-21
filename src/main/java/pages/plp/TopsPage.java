package pages.plp;

import org.openqa.selenium.By;
import pages.pdp.ProductPage;
import tools.PageTools;

public class TopsPage extends PageTools {

    private final By productCard = By.xpath("//div[@class='product-item-info']");

    public ProductPage clickRandomProductCard(){
        clickRandomElement(productCard);
        return new ProductPage();
    }



}
