package pages.plp;

import org.openqa.selenium.By;
import tools.PageTools;

public class WomenPage extends PageTools {

    private final By topsLink = By.xpath("//a[text()='Tops']");
    private final By bottomsLink = By.xpath("//a[text()='Bottoms']");
    private final By testLink = By.xpath("//a[text()='Test']");

    public TopsPage clickTopsLink() {
        click(topsLink);
        return new TopsPage();
    }

    public TestPage clickTestLink() {
        click(testLink);
        return new TestPage();
    }
}
