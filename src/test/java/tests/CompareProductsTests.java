package tests;

import actions.Actions;
import baseTest.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Pages;
import testData.GlobalData;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CompareProductsTests extends BaseTest {

    Map<String, String> erikaShortData = new HashMap<>();
    Integer erikaShortIndex = 1;

    @BeforeMethod
    public void startTest() {
        start("http://46.101.147.48/catalog/product_compare");
        Actions.compareProductsPageActions().clearComparisonList();
        Pages.header().clickWomenShortsMenuButton();
        erikaShortData.put("Name", Pages.collectionPage().getItemNameByIndex(erikaShortIndex));
        erikaShortData.put("Price", Pages.collectionPage().getItemPriceByIndex(erikaShortIndex));
    }

    @Test(groups = {"elements"})
    @Description("Product is added to Comparison list from PLP successfully. Elements are displayed on Compare Products page")
    @Severity(SeverityLevel.NORMAL)
    public void checkMainElementsDisplaying() {
        Pages.collectionPage().clickAddToCompareButtonByIndex(erikaShortIndex);
        Pages.collectionPage().clickComparisonListLink();

        assertTrue(Pages.compareProductsPage().isItemNameDisplayed());
        assertTrue(Pages.compareProductsPage().isItemPriceDisplayed());
        assertTrue(Pages.compareProductsPage().isItemDescDisplayed());
        assertTrue(Pages.compareProductsPage().isAddToCartButtonDisplayed());
    }

    @Test(groups = {"success"})
    @Description("Product is added to Comparison list from PLP successfully. The same product is displayed on Compare Products page")
    @Severity(SeverityLevel.NORMAL)
    public void addItemToComparisonListFromPLP() {
        Pages.collectionPage().clickAddToCompareButtonByIndex(erikaShortIndex);
        assertEquals(Pages.collectionPage().getSuccessMessage(), GlobalData.successAddingToCompareMessage(erikaShortData.get("Name")));

        Pages.collectionPage().clickComparisonListLink();
        assertEquals(Pages.compareProductsPage().getItemNameByIndex(erikaShortIndex), erikaShortData.get("Name"));
        assertEquals(Pages.compareProductsPage().getItemPriceByIndex(erikaShortIndex), erikaShortData.get("Price"));
    }

    @Test(groups = {"success"})
    @Description("Product is added to Comparison list from PDP successfully. The same product is displayed on Compare Products page")
    @Severity(SeverityLevel.NORMAL)
    public void addItemToComparisonListFromPDP() {
        Pages.collectionPage().clickProductCardByIndex(erikaShortIndex);
        erikaShortData.put("SKU", Pages.productPage().getProductSku());
        Pages.productPage().clickAddToCompareButton();
        assertEquals(Pages.productPage().getSuccessMessage(), GlobalData.successAddingToCompareMessage(erikaShortData.get("Name")));

        Pages.productPage().clickComparisonListLink();
        assertEquals(Pages.compareProductsPage().getItemNameByIndex(erikaShortIndex), erikaShortData.get("Name"));
        assertEquals(Pages.compareProductsPage().getItemPriceByIndex(erikaShortIndex), erikaShortData.get("Price"));
        assertEquals(Pages.compareProductsPage().getItemSkuByIndex(erikaShortIndex), erikaShortData.get("SKU"));
    }

    @Test(groups = {"success"})
    @Description("Product is added to Comparison list from PlP successfully. Product is added to Cart successfully.")
    @Severity(SeverityLevel.NORMAL)
    public void addToCartFromComparisonList() {
        Pages.collectionPage().clickAddToCompareButtonByIndex(erikaShortIndex);
        assertEquals(Pages.productPage().getSuccessMessage(), GlobalData.successAddingToCompareMessage(erikaShortData.get("Name")));

        Pages.collectionPage().clickComparisonListLink();
        Pages.compareProductsPage().clickAddToCartButton();
        assertEquals(Pages.productPage().getWarningMessageText(), GlobalData.chooseOptionWarningMessage);

        Pages.productPage().selectSize();
        Pages.productPage().selectColor();
        Pages.productPage().clickAddToCartButton();
        assertEquals(Pages.productPage().getSuccessMessage(), GlobalData.successATCMessage(erikaShortData.get("Name")));
    }


}
