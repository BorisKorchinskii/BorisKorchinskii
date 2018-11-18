package JDI.base;

import JDI.JDIExampleSite;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.testng.testRunner.TestNGBase;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static JDI.JDIExampleSite.homePage;
import static com.epam.jdi.uitests.core.settings.JDISettings.logger;
import static java.lang.System.setProperty;

public class SubmitFormBase extends TestNGBase {
    @BeforeSuite(alwaysRun = true)
    public static void setUp() {
        WebSite.init(JDIExampleSite.class);
        setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        logger.info("Tests started");
    }

    @AfterSuite
    public void afterSuite() {
        homePage.getDriver().close();
        logger.info("Tests run finished");
    }
}

