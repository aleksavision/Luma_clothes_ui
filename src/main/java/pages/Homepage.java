package pages;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import tools.PageTools;

public class Homepage extends PageTools {

    @Step("Get page URL address")
    public String getPageUrl() {
        return Selenide.webdriver().driver().url();
    }

}
