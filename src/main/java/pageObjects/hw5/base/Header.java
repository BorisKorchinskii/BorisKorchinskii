package pageObjects.hw5.base;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import enums.Users;
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


    public void login() {
        loginProfileButton.click();
        loginField.sendKeys(PITER_CHAILOVSKII.login);
        passwordField.sendKeys(PITER_CHAILOVSKII.password);
        enterButton.click();
    }


    public void openDatesViaHeaderServiceMenu() {
        navBarElements.get(2).click();
        serviceDropdownElements.get(1).shouldHave(text("DATES")).click();
    }


    public void openElementsViaHeaderServiceMenu() {
        navBarElements.get(2).click();
        serviceDropdownElements.get(6).shouldHave(text("DIFFERENT ELEMENTS")).click();
    }

    //=============================== Checks ========================================


    public void userIsLogged(Users users) {
        loggedinUserName.shouldHave(text(users.name));
    }

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
