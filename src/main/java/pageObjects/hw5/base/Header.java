package pageObjects.hw5.base;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import enums.Users;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static enums.HeaderMenu.getHeaderCategoriesList;
import static enums.Users.PITER_CHAILOVSKII;
import static org.testng.Assert.assertTrue;

public class Header {

    @FindBy(css = ".profile-photo")
    private SelenideElement loginProfileButton;

    @FindBy(css = "[id = 'Name']")
    private SelenideElement loginField;

    @FindBy(css = "[id = 'Password']")
    private SelenideElement passwordField;

    @FindBy(css = ".login [type = 'submit']")
    private SelenideElement enterButton;

    @FindBy(css = ".profile-photo [ui = 'label']")
    private SelenideElement loggedinUserName;

    @FindBy(css = ".nav > li")
    private ElementsCollection navBarElements;

    @FindBy(css = "[class = 'dropdown open'] li")
    private ElementsCollection serviceDropdownElements;

    //=============================== Actions methods ========================================

    @Step
    public void login() {
        loginProfileButton.click();
        loginField.sendKeys(PITER_CHAILOVSKII.login);
        passwordField.sendKeys(PITER_CHAILOVSKII.password);
        enterButton.click();
    }

    @Step
    public void openDatesViaHeaderServiceMenu() {
        navBarElements.get(2).click();
        serviceDropdownElements.get(1).shouldHave(text("DATES")).click();
    }

    @Step
    public void openElementsViaHeaderServiceMenu() {
        navBarElements.get(2).click();
        serviceDropdownElements.get(6).shouldHave(text("DIFFERENT ELEMENTS")).click();
    }

    //=============================== Checks ========================================

    @Step
    public void userIsLogged(Users users) {
        loggedinUserName.shouldHave(text(users.isDisplayed));
    }

    @Step
    public void checkServiceHeaderContainsOptions() {
        navBarElements.get(2).click();
        serviceDropdownElements.shouldHaveSize(8);
        for (SelenideElement element : serviceDropdownElements) {
            $(element).isDisplayed();
        }
        for (String category : getHeaderCategoriesList()) {
            assertTrue($$(serviceDropdownElements).texts().contains(category.toUpperCase()));
        }
    }
}
