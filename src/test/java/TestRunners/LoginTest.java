package TestRunners;

import Base.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(dataProvider = "ValidCred")
    public void LoginWithValidCredential(String email, String password) {

        loginPage.clickLoginButton();
        loginPage.enterEmailAddress(email);
        loginPage.enterPassword(password);
        loginPage.clickSubmitButton();
    }

    @Test(dataProvider = "invalidCred")
    public void LoginWithInvalidCredential(String email, String password) {

        loginPage.clickLoginButton();
        loginPage.enterEmailAddress(email);
        loginPage.enterPassword(password);
        loginPage.clickSubmitButton();
        loginPage.alertMessage("Invalid credentials. Please try again.");
    }

    @DataProvider
    public Object[][] validCred() {
        return new Object[][]{
                {"ndivhuwo.tshiedza@gmail.com", "P@ssword"}
        };
    }
    public Object[][] invalidCred() {
        return new Object[][]{
                {"testuser@gmail.com", "WrongPassword"}
        };
    }

}