package base;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static java.lang.System.currentTimeMillis;
import static java.lang.System.setProperty;

public class TestBaseForObjectTestHW4 {

    private long time;

    @BeforeSuite
    public void beforeSuite() {
        setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
        Configuration.pageLoadStrategy = "normal";
        time = currentTimeMillis();
    }

    @AfterSuite
    public void afterClass() {
        System.out.println("Test framework worked:" + (currentTimeMillis() - time));
    }
}
