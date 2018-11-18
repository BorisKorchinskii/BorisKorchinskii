package JDI;

import JDI.pages.HomePage;
import JDI.pages.MetalsAndColorsPage;
import JDI.sections.Header;
import JDI.sections.LoginForm;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JSite;
import JDI.enums.Pages;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;

import static JDI.enums.User.PITER_CHAILOVSKII;

@JSite("https://epam.github.io/JDI/")
public class JDIExampleSite extends WebSite {

    public static HomePage homePage;
    public static Header header;
    public static LoginForm loginForm;
    public static MetalsAndColorsPage metalsAndColors;

    @Step // Working
    public static void login() {
        homePage.loginProfileButton.click();
        loginForm.name.setValue(PITER_CHAILOVSKII.login);
        loginForm.password.setValue(PITER_CHAILOVSKII.password);
        loginForm.enter.click();
    }

    @Step // Working
    public static void checkUserIsLogged() {
        Assert.assertEquals(homePage.loginName.getText(), PITER_CHAILOVSKII.isDisplayed);
    }

    @Step // Working
    public static void openMetalsAndColorsFromHeader(Pages page) {
        header.metalsAndColorsLink.clickOn(page.pageName);
    }
}
