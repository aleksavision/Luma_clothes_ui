package actions;

import pages.Pages;

public class ProductPageActions {

    public void addSingleProductToCart(){
        Pages.productPage().selectSize();
        Pages.productPage().selectColor();
        Pages.productPage().clickAddToCartButton();
        Pages.productPage().waitForSuccessMessage();
    }

}
