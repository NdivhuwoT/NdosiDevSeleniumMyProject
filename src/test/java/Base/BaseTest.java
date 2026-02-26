package Base;

import PageObjects.LoginPage;
import Utilities.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    BrowserFactory browserFactory = new BrowserFactory();
    public final String url = "https://ndosisimplifiedautomation.vercel.app/";
    public final String browserChoice = "chrome";

    public WebDriver driver;
    public LoginPage loginPage;

    @BeforeMethod
    public void setUpBrowser(){
        driver = browserFactory.startBrowser(browserChoice,url);
        loginPage = new LoginPage(driver);
    }

    @AfterMethod
    public void tearDownBrowser(){
        browserFactory.closeBrowser();
    }
}