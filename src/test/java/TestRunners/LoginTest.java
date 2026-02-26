package TestRunners;

import Base.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(dataProvider = "getData")
    public void LoginWithValidCredential(String email, String password) {

        loginPage.clickLoginButton();
        loginPage.enterEmailAddress(email);
        loginPage.enterPassword(password);
        loginPage.clickSubmitButton();
    }

    @DataProvider
    public Object[][] getData() {
        return new Object[][]{
                {"ndivhuwo.tshiedza@gmail.com", "P@ssword"}
        };
    }

}