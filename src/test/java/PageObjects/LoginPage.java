package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[text()='Login']")
    WebElement loginButton;

    @FindBy(id = "login-email")
    WebElement loginEmailField;

    @FindBy(id = "login-password")
    WebElement loginPasswordField;

    @FindBy(id = "login-submit")
    WebElement loginSubmitButton;

    public void clickLoginButton(){
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();
    }

    public void enterEmailAddress(String email){
        wait.until(ExpectedConditions.visibilityOf(loginEmailField));
        loginEmailField.sendKeys(email);
    }

    public void enterPassword(String password){
        wait.until(ExpectedConditions.visibilityOf(loginPasswordField));
        loginPasswordField.sendKeys(password);
    }

    public void clickSubmitButton(){
        wait.until(ExpectedConditions.elementToBeClickable(loginSubmitButton));
        loginSubmitButton.click();
    }
}
