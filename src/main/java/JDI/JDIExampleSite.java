package JDI;

import JDI.enums.Pages;
import JDI.enums.User;
import JDI.pages.HomePage;
import JDI.pages.MetalsAndColorsPage;
import JDI.sections.Header;
import JDI.sections.LoginForm;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JSite;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;


@JSite("https://epam.github.io/JDI/")
public class JDIExampleSite extends WebSite {

    public static HomePage homePage;
    public static Header header;
    public static LoginForm loginForm;
    public static MetalsAndColorsPage metalsAndColors;

    @Step
    public static void login(User user) {
        homePage.loginProfileButton.click();
        loginForm.loginAs(user);
    }

    @Step
    public static void checkUserIsLogged(User user) {
        Assert.assertEquals(homePage.loginName.getText(), user.getIsDisplayed());
    }

    @Step
    public static void openMetalsAndColorsFromHeader(Pages page) {
        header.metalsAndColorsLink.clickOn(page.pageName);
    }
}
