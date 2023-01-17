package ProjectPractice.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoggedInSuccessfullyPage {
    public WebDriver driver;
    public WebDriverWait wdwait;
    WebElement logOut;

    public LoggedInSuccessfullyPage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebDriverWait getWdwait() {
        return wdwait;
    }

    public WebElement getLogOut() {
        return driver.findElement(By.linkText("Log out"));
    }



    public void clickLogOutButton(){
        this.getLogOut().click();
    }

    public String logOutButtonText(){
        return this.getLogOut().getText();
    }
}
