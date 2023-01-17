package ProjectPractice.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestLogInPage {
    public WebDriver driver;
    public WebDriverWait wdwait;
    WebElement username;
    WebElement password;
    WebElement submit;
    WebElement errorMessage;

    public TestLogInPage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebDriverWait getWdwait() {
        return wdwait;
    }

    public WebElement getUsername() {
        return driver.findElement(By.id("username"));
    }

    public WebElement getErrorMessage() {
        return driver.findElement(By.id("error"));
    }

    public WebElement getPassword() {
        return driver.findElement(By.id("password"));
    }

    public WebElement getSubmit() {
        return driver.findElement(By.id("submit"));
    }


    public void inputUserName(String username) {
        this.getUsername().clear();
        this.getUsername().sendKeys(username);
    }

    public void inputPassword(String pasword) {
        this.getPassword().clear();
        this.getPassword().sendKeys(pasword);
    }

    public void clickSubmitButton() {
        this.getSubmit().click();
    }

    public String textErrorMessage() {
        return this.errorMessage.getText();
    }
}
