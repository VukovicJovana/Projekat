package ProjectPractice.Base;

import ProjectPractice.Pages.LoggedInSuccessfullyPage;
import ProjectPractice.Pages.PracticePage;
import ProjectPractice.Pages.SideBarPage;
import ProjectPractice.Pages.TestLogInPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BasePage {
    public WebDriver driver;
    public WebDriverWait wdwait;
    public SideBarPage sidebarPage;
    public PracticePage practicePage;
    public TestLogInPage testLogInPage;
    public LoggedInSuccessfullyPage loggedInSuccessfull;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(15));
        sidebarPage = new SideBarPage(driver, wdwait);
        practicePage = new PracticePage(driver, wdwait);
        testLogInPage = new TestLogInPage(driver, wdwait);
        loggedInSuccessfull = new LoggedInSuccessfullyPage(driver, wdwait);
    }

    @AfterClass
    public void tearDown() {
//       /* driver.manage().deleteAllCookies();
//        driver.close();
//        driver.quit();*/
    }
}
