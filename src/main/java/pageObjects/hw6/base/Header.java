package pageObjects.hw6.base;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;
import static enums.Users.PITER_CHAILOVSKII;
import static org.testng.Assert.assertTrue;

public class Header {

    private int iconsSize = 4;
    private int iconTextsSize = 4;

    @FindBy(css = ".profile-photo")
    private SelenideElement loginProfileButton;

    @FindBy(css = "[id = 'Name']")
    private SelenideElement loginField;

    @FindBy(css = "[id = 'Password']")
    private SelenideElement passwordField;

    @FindBy(css = ".login [type = 'submit']")
    private SelenideElement enterButton;

    @FindBy(css = ".nav > li")
    private ElementsCollection navBarElements;

    @FindBy(css = "ul.dropdown-menu a")
    private ElementsCollection serviceDropdown;

    @FindBy(css = "ul.dropdown-menu a")
    private ElementsCollection serviceDropdownElements;

    @FindBy(css = ".benefit-icon")
    private ElementsCollection icons;

    @FindBy(css = ".benefit-txt")
    private ElementsCollection iconTexts;

    @FindBy(css = "h3.main-title")
    private SelenideElement mainTitle;

    @FindBy(css = ".main-txt")
    private SelenideElement mainText;

    public Header() {
        page(this);
    }

    //=============================== Actions methods ========================================

    @Step
    @When("I login as user \"([^\"]*)\"$")
    public void loginAsUser(String name) {
        loginProfileButton.click();
        loginField.sendKeys(PITER_CHAILOVSKII.login);
        passwordField.sendKeys(PITER_CHAILOVSKII.password);
        enterButton.click();
    }

    @Step
    @When("I login as user \"(.+)\" with password \"(.+)\"$")
    public void login(String name, String password) {
        loginProfileButton.click();
        loginField.sendKeys(name);
        passwordField.sendKeys(password);
        enterButton.click();
    }

    @Step
    @When("I click on \"(.*)\" button in Header")
    public void headerClick(String name) {
        for (SelenideElement element : navBarElements) {
            if (element.text().equals(name.toUpperCase())) {
                element.click();
                break;
            }
        }
    }

    @Step
    @And("I click on \"(.*)\" button in Service dropdown")
    public void openPageFromService(String name) {
        for (SelenideElement element : serviceDropdown) {
            if (element.text().equals(name.toUpperCase())) {
                element.click();
                break;
            }
        }
    }

    //=============================== Elements Checkers ========================================

    @Step
    @Then("The username (.+ .+) is displayed in the right-top side of the screen")
    public void checkUsername(String username) {
        loginProfileButton.shouldHave(text(username));
    }

    @Step
    @And("Home page interface contains all needed elements")
    public void checkHomePageInterface() {
        icons.shouldHaveSize(iconsSize);
        iconTexts.shouldHaveSize(iconTextsSize);
        mainTitle.shouldBe(visible);
        mainText.shouldBe(visible);
    }

    @Step
    @And("Service dropdown contains options:")
    public void checkServiceDropdownContains(List<String> serviceElements) {
        headerClick(JDI.enums.HeaderMenu.SERVICE.name());
        for (String element : serviceElements) {
            assertTrue(serviceDropdownElements.texts().contains(element.toUpperCase()));
        }
    }
}
