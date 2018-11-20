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

    @Step("Open JDI test page")
    public void navigateToPage() {
        Selenide.open(INDEX_PAGE.navigateTo);
    }

    @Step("Assert Browser title  is visible")
    public void checkIfTitleIsVisible() {
        assertEquals(getWebDriver().getTitle(), "Home Page");
    }

    @Step("Perform login")
    public void login() {
        header.login();
    }

    @Step ("Click on the \"Service\" subcategory in the header")
    public void openDatesViaHeaderServiceMenu() {
        header.openDatesViaHeaderServiceMenu();
    }

    @Step ("Click on the \"Elements\" subcategory in the header")
    public void openElementsViaHeaderServiceMenu() {
        header.openElementsViaHeaderServiceMenu();
    }

    //=============================== Elements Checks ========================================

    @Step("Check if user is logged")
    public void userIsLogged(Users users) {
        header.userIsLogged(Users.PITER_CHAILOVSKII);
    }

    @Step("Check if header \"Service\" drop down contains correct options")
    public void checkServiceHeaderContainsOptions() {
        header.checkServiceHeaderContainsOptions();
    }

    @Step("Check if left panel \"Service\" drop down contains correct options")
    public void checkServiceSubCategoryLeftSectionContainsOptions() {
        leftSection.checkServiceSubCategoryLeftSectionContainsOptions();
    }
}



