package ProjectPractice.Tests;

import ProjectPractice.Base.BasePage;
import ProjectPractice.Pages.TestLogInPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Locale;

public class LogInTest extends BasePage {

    @BeforeMethod
    public void setUpPage() {
        driver.manage().window().maximize();
        driver.navigate().to("https://practicetestautomation.com/");
    }

    @Test(priority = 10)
    public void test() {
        String expextedText = "HOME";
        Assert.assertEquals(sidebarPage.getHomeText(), expextedText);
    }

    @Test(priority = 20)
    public void goToLogInPage() {
        sidebarPage.clickPractice();
        practicePage.clickTestLogIn();
    }

    @Test(priority = 30)
    public void userCanLogIn() {
        goToLogInPage();
        String ValidUsername = "student";
        String ValidPass = "Password123";

        testLogInPage.inputUserName(ValidUsername);
        testLogInPage.inputPassword(ValidPass);
        testLogInPage.clickSubmitButton();

        String logout = "Log out";
        Assert.assertEquals(loggedInSuccessfull.logOutButtonText(), logout);
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://practicetestautomation.com/logged-in-successfully/";
        Assert.assertEquals(actualUrl, expectedUrl);

        wdwait.until(ExpectedConditions.visibilityOf(loggedInSuccessfull.getLogOut()));
        loggedInSuccessfull.clickLogOutButton();

    }

    @Test(priority = 40)
    public void VerifyThatUserCanNotLogInWithInvalidUsername() {
        goToLogInPage();
        String InvalidUsername = "invalid";
        String ValidPass = "Password123";

        testLogInPage.inputUserName(InvalidUsername);
        testLogInPage.inputPassword(ValidPass);
        testLogInPage.clickSubmitButton();

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://practicetestautomation.com/practice-test-login/";


        Assert.assertEquals(actualUrl, expectedUrl);
        Assert.assertTrue(testLogInPage.getSubmit().isDisplayed());

    }

    @Test(priority = 50)
    public void VerifyThatUserCanNotLogInWithInvalidPassword() {
        goToLogInPage();
        String ValidUsername = "student";
        String InvalidPass = "PasswordInvalid";


        testLogInPage.inputUserName(ValidUsername);
        testLogInPage.inputPassword(InvalidPass);
        testLogInPage.clickSubmitButton();

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://practicetestautomation.com/practice-test-login/";

        Assert.assertEquals(actualUrl, expectedUrl);
        Assert.assertTrue(testLogInPage.getSubmit().isDisplayed());
    }

    @Test(priority = 60)
    public void VerifyThatUserCanNotLogInWithoutUsername() {
        goToLogInPage();
        String ValidPass = "Password123";

        testLogInPage.inputPassword(ValidPass);
        testLogInPage.clickSubmitButton();

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://practicetestautomation.com/practice-test-login/";

        Assert.assertEquals(actualUrl, expectedUrl);
        Assert.assertTrue(testLogInPage.getSubmit().isDisplayed());
    }

    @Test(priority = 70)
    public void VerifyThatUserCanNotLogInWithoutPassword() {
        goToLogInPage();
        String ValidUsername = "student";
        testLogInPage.inputUserName(ValidUsername);
        testLogInPage.clickSubmitButton();

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://practicetestautomation.com/practice-test-login/";

        Assert.assertEquals(actualUrl, expectedUrl);
        Assert.assertTrue(testLogInPage.getSubmit().isDisplayed());
    }

    @Test(priority = 80)
    public void VerifyThatUserCanNotLogInWithoutCredentials() {
        goToLogInPage();
        testLogInPage.clickSubmitButton();

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://practicetestautomation.com/practice-test-login/";

        Assert.assertEquals(actualUrl, expectedUrl);
        Assert.assertTrue(testLogInPage.getSubmit().isDisplayed());
    }
}
