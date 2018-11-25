package pageObjects.hw6;

import com.codeborne.selenide.Selenide;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.qameta.allure.Step;
import pageObjects.hw4.base.Header;
import pageObjects.hw4.base.LeftSection;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static enums.WebLinks.HOME_PAGE;
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
    @Given("I am on \"(.*)\"")
    public void navigateToPage(String title) {
        Selenide.open(HOME_PAGE.navigateTo);
    }

    @Step
    @Then("The browser title is \"(.+ .+)\"")
    public void checkIfTitleIsVisible(String title) {
        assertEquals(getWebDriver().getTitle(), title);
    }

}



