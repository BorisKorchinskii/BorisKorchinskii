package pageObjects.hw5;

import com.codeborne.selenide.Selenide;
import enums.Users;
import io.qameta.allure.Step;
import pageObjects.hw4.base.Header;
import pageObjects.hw4.base.LeftSection;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static enums.WebLinks.INDEX_PAGE;
import static org.testng.Assert.assertEquals;

public class HomePageSelenide {

    private Header header;
    private LeftSection leftSection;

    public HomePageSelenide() {
        header = Selenide.page(Header.class);
        leftSection = Selenide.page(LeftSection.class);
    }

    //=============================== Actions methods ========================================

    @Step
    public void navigateToPage() {
        Selenide.open(INDEX_PAGE.navigateTo);
    }

    @Step
    public void checkIfTitleIsVisible() {
        assertEquals(getWebDriver().getTitle(), "Home Page");
    }

    @Step
    public void login() {
        header.login();
    }

    @Step
    public void openDatesViaHeaderServiceMenu() {
        header.openDatesViaHeaderServiceMenu();
    }


    public void openElementsViaHeaderServiceMenu() {
        header.openElementsViaHeaderServiceMenu();
    }

    //=============================== Elements Checks ========================================

    @Step
    public void userIsLogged(Users users) {
        header.userIsLogged(Users.PITER_CHAILOVSKII);
    }


    public void checkServiceHeaderContainsOptions() {
        header.checkServiceHeaderContainsOptions();
    }


    public void checkServiceSubCategoryLeftSectionContainsOptions() {
        leftSection.checkServiceSubCategoryLeftSectionContainsOptions();
    }
}



