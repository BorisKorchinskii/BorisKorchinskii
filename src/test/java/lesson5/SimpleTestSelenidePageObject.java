package lesson5;

import base.SelenideTestBase;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import listeners.AllureAttachmentListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Feature("Smoke tests")
@Story("Home Page Testing")
@Listeners(AllureAttachmentListener.class)
public class SimpleTestSelenidePageObject extends SelenideTestBase {

     @Test
    public void simpleTest() {
 /*       setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");

        //2 Navigate
        homePageSelenide.openPage();

        //3 Assert Title
        homePageSelenide.checkTitle();

        //4 Login
        homePageSelenide.login(PITER_CHAILOVSKII.login, PITER_CHAILOVSKII.password);

        //5 Check main title
        homePageSelenide.checkMainText();*/
    }
}