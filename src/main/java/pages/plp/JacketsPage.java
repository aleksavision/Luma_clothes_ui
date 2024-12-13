package pages.plp;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import pages.pdp.ProductPage;
import pages.userPages.CompareProductsPage;
import tools.PageTools;

public class JacketsPage extends PageTools {

    private final By productCard = By.xpath("//div[@class='product-item-info']");
    private final By addToCompareButton = By.xpath("//a[@class='action tocompare']");
    private final By successMessage = By.xpath("//div[@data-ui-id='message-success']/div");
    private final By comparisonListLink = By.xpath("//div[@data-ui-id='message-success']/div/a");
    private final By productName = By.xpath("//a[@class='product-item-link']");

    @Step("Click product card by {index}")
    public ProductPage clickProductCardByIndex(int index) {
        clickElementByIndex(productCard, index);
        return new ProductPage();
    }
    @Step("Click Add to compare button by {index}")
    public void clickAddToCompareButtonByIndex(int index) {
        By locator = By.id(("(" + productCard + ")[" + index + "]"));
        moveToElement(locator);
        click(addToCompareButton);
    }
    @Step("Check success info message text")
    public String getSuccessMessage() {
        return getElementText(successMessage);
    }
    @Step("Click Comparison list link")
    public CompareProductsPage clickComparisonListLink(){
        click(comparisonListLink);
        return new CompareProductsPage();
    }
    @Step("Get product name by {index}")
    public String getItemNameByIndex(int index) {
        return getElementTextByIndex(productName, 1);
    }


}
