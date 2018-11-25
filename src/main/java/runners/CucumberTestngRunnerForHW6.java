package runners;

import com.codeborne.selenide.Configuration;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;

import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;

@CucumberOptions(features = "src/test/java/hw6", glue = {"src/java/pageObjects/hw6", "pageObjects"})
public class CucumberTestngRunnerForHW6 extends AbstractTestNGCucumberTests {

    @BeforeSuite
    public void beforeSuite() {
        Configuration.browser = "chrome";
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        closeWebDriver();
    }
}