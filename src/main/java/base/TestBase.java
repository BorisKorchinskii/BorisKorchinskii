package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import static java.lang.System.currentTimeMillis;
import static java.lang.System.setOut;
import static java.lang.System.setProperty;

public class TestBase {

    protected WebDriver driver;
    private long time;

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        time = currentTimeMillis();
    }

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
    }

    @AfterClass
    public void afterClass() {
        driver.close();
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
        System.out.println("Test framework worked:" + (currentTimeMillis() - time));
    }
}
