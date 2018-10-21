package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;
import pageObjects.HomePage;

import java.util.concurrent.TimeUnit;

import static java.lang.System.currentTimeMillis;
import static java.lang.System.setProperty;

public class TestBaseForObjectTestHW3 {

    protected static WebDriver driver;
    protected HomePage homePage;
    private long time;

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        time = currentTimeMillis();
    }

    @BeforeMethod
    public void beforeMethod() {
        homePage = PageFactory.initElements(driver, HomePage.class);
    }

    @AfterSuite
    public void afterClass() {
        driver.close();
        System.out.println("Test framework worked:" + (currentTimeMillis() - time));
    }
}
