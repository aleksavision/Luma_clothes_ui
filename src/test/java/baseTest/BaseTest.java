package baseTest;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;

import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;
import tools.BrowserFactory;
import tools.InfoLogger;

public class BaseTest extends BrowserFactory {

    protected SoftAssert softAssert;

    private final ThreadLocal<String> URL = new ThreadLocal<>();
    private final ThreadLocal<String> browserName = new ThreadLocal<>();
    private final ThreadLocal<Boolean> headless = new ThreadLocal<>();
    private final ThreadLocal<Boolean> holdBrowserOpen = new ThreadLocal<>();

    @BeforeTest
    public void setUpDriver(){
        browserName.set(System.getProperty("browserName", "chrome"));
        headless.set(Boolean.parseBoolean("headless"));
        holdBrowserOpen.set((Boolean.parseBoolean("holdBrowserOpen")));

        setUpBrowser(browserName.get(), headless.get(), holdBrowserOpen.get());
    }

    //install in test
    @Step("{url} is opened in browser")
    protected void start(String url) {
        URL.set(url);
        openBrowser();
        setTools();
    }
    private void setTools(){
        softAssert = new SoftAssert();
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }
    private void openBrowser(){
        String urlAddress = URL.get();
        if (urlAddress != null) {
            Selenide.open(urlAddress);
            WebDriverRunner.getWebDriver().manage().window().maximize();
        } else {
            InfoLogger.logInfo("URL is not set. Please use setUrl() method to set the URL before opening the browser.");
        }
    }
    @AfterMethod
    protected void  cleanWebsiteData(){
        Selenide.clearBrowserLocalStorage();
        Selenide.clearBrowserCookies();
    }
    @AfterTest
    protected void closeBrowser(ITestContext context) {
        WebDriverRunner.closeWebDriver();
    }
}


