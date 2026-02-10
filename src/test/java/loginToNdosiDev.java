import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class loginToNdosiDev {

    WebDriver driver;

    @Test
    public void loginWithValidDetails() throws InterruptedException {

        driver = new ChromeDriver();
        driver.get("https://ndosisimplifiedautomation.vercel.app");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("/html/body/div/div/nav/div[1]/div[3]/button/span[2]")).click();
        driver.findElement(By.id("login-email")).sendKeys("ndivhuwo.tshiedza@gmail.com");
        driver.findElement(By.id("login-password")).sendKeys("P@ssword");
        driver.findElement(By.id("login-submit")).click();
        Thread.sleep(3000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        String actualMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/main/section/div[1]/h2"))).getText();
        String expectedMessage = "Welcome back";
        Assert.assertTrue(actualMessage.contains(expectedMessage),"You are not logged in");

    }

}
