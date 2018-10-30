package pageObjects;

import base.TestBaseForObjectTestHW4;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import enums.Checkboxes;
import enums.Dropdowns;
import enums.Radiobuttons;
import enums.Users;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.assertEquals;

public class HomePageSelenide extends TestBaseForObjectTestHW4 {

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

    @FindBy(css = "[class = 'sidebar-menu'] > [index = '3']")
    private SelenideElement serviceSubCategoryLeftElement;

    @FindBy(css = "[class = 'sub'] li")
    private ElementsCollection serviceSubCategoryLeftElements;

    @FindBy(css = ".benefit-icon")
    private ElementsCollection benefitIconsImages;

    @FindBy(css = "div.benefit-icon + span")
    private ElementsCollection benefitIconsText;

    @FindBy(css = "h3.main-title.text-center")
    private SelenideElement textOnMainTitle;

    @FindBy(css = "p.main-txt")
    private SelenideElement titleContainingText;

    @FindBy(css = "[id = 'iframe']")
    private SelenideElement iFrame;

    @FindBy(xpath = "//*[@id='epam_logo']")
    private SelenideElement epamLogoIniFrame;

    @FindBy(css = "[class='text-center'] a")
    private SelenideElement jdiSubheader;

    @FindBy(css = ".mCustomScrollBox")
    private SelenideElement leftSection;

    @FindBy(css = "footer")
    private SelenideElement footer;

    @FindBy(css = "[class = 'label-checkbox']")
    private List<SelenideElement> differentElementsPageCheckboxes;

    @FindBy(css = "[class = 'label-radio']")
    private List<SelenideElement> differentElementsPageRadioButtons;

    @FindBy(css = "[class = 'colors']")
    private SelenideElement differentElementsPageColorsDropdown;

    @FindBy(css = "select[class='uui-form-element'] option")
    private ElementsCollection differentElementsPageColorsDropdownPositions;

    @FindBy(css = "[class = 'uui-button']")
    private ElementsCollection differentElementsPageUIButtons;

    @FindBy(css = "[class = 'right-fix-panel']")
    private SelenideElement differentElementsPageRightSection;

    @FindBy(css = "[class = 'mCSB_vertical']")
    private SelenideElement differentElementsPageLeftSection;

    @FindBy(css = "[class = 'panel-body-list logs']")
    private SelenideElement differentElementsPageLogsPanel;

    @FindBy(css = "[class='label-checkbox'] > input")
    private List<SelenideElement> differentElementsPageCheckboxesStatus;

    //=============================== Actions methods ========================================

    public void navigateToPage(String navigateTo) {
        Selenide.open(navigateTo);
    }

    public void login(String name, String pass) {
        loginProfileButton.click();
        loginField.sendKeys(name);
        passwordField.sendKeys(pass);
        enterButton.click();
    }

    public void userIsLogged(Users users) {
        loggedinUserName.shouldHave(text(users.isDisplayed));
    }

    public void openDifferentElementsPageViaHeaderServiceMenu() {
        navBarElements.get(2).click();
        serviceDropdownElements.get(6).shouldHave(text("DIFFERENT ELEMENTS")).click();
    }

    public void selectDifferentElementsPageWaterWindCheckboxes(Checkboxes... checkboxes) {
        for (Checkboxes checkbox : checkboxes) {
            $$(differentElementsPageCheckboxes).findBy(text(checkbox.checkboxesName)).click();
        }
    }

    public void selectDifferentElementsSelenRadioButton(Radiobuttons... radiobuttons) {
        for (Radiobuttons radiobutton : radiobuttons) {
            $$(differentElementsPageRadioButtons).findBy(text(radiobutton.radiobuttonsType)).click();
        }
    }

    public void selectifferentElementsYellowFromDropdown(Dropdowns dropdowns) {
        differentElementsPageColorsDropdown.hover().click();
        differentElementsPageColorsDropdownPositions.find(text(dropdowns.dropdownsColor)).click();
    }

    public void unselectDifferentElementsPageWaterWindCheckboxes(Checkboxes... checkboxes) {
        for (Checkboxes checkbox : checkboxes) {
            $$(differentElementsPageCheckboxes).findBy(text(checkbox.checkboxesName)).click();
        }
    }

    //=============================== Elements checkers ==========================================

    public void checkIfTitleIsVisible() {
        assertEquals(getWebDriver().getTitle(), "Home Page");
    }

    public void checkServiceHeaderContainsOptions() {
        navBarElements.get(2).click();
        serviceDropdownElements.shouldHaveSize(8);
        for (SelenideElement element : serviceDropdownElements) {
            $(element).isDisplayed();
        }
        serviceDropdownElements.get(0).shouldHave(text("SUPPORT"));
        serviceDropdownElements.get(1).shouldHave(text("DATES"));
        serviceDropdownElements.get(2).shouldHave(text("COMPLEX TABLE"));
        serviceDropdownElements.get(3).shouldHave(text("SIMPLE TABLE"));
        serviceDropdownElements.get(4).shouldHave(text("USER TABLE"));
        serviceDropdownElements.get(5).shouldHave(text("TABLE WITH PAGES"));
        serviceDropdownElements.get(6).shouldHave(text("DIFFERENT ELEMENTS"));
        serviceDropdownElements.get(7).shouldHave(text("PERFORMANCE"));
    }

    public void checkServiceSubCatergoryLeftSectionContainsOptions() {
        serviceSubCategoryLeftElement.click();
        serviceSubCategoryLeftElements.shouldHaveSize(8);
        for (SelenideElement element : serviceSubCategoryLeftElements) {
            $(element).isDisplayed();
        }
        serviceSubCategoryLeftElements.get(0).shouldHave(text("Support"));
        serviceSubCategoryLeftElements.get(1).shouldHave(text("Dates"));
        serviceSubCategoryLeftElements.get(2).shouldHave(text("Complex Table"));
        serviceSubCategoryLeftElements.get(3).shouldHave(text("Simple Table"));
        serviceSubCategoryLeftElements.get(4).shouldHave(text("User Table"));
        serviceSubCategoryLeftElements.get(5).shouldHave(text("Table with pages"));
        serviceSubCategoryLeftElements.get(6).shouldHave(text("Different elements"));
        serviceSubCategoryLeftElements.get(7).shouldHave(text("Performance"));
    }

    public void checkOnDifferentElementsPageNeededElementsVisible() {
        $$(differentElementsPageCheckboxes)
                .shouldHaveSize(4)
                .shouldHave(texts("Water", "Earth", "Wind", "Fire"));
        $$(differentElementsPageRadioButtons)
                .shouldHaveSize(4)
                .shouldHave(texts("Gold", "Silver", "Bronze", "Selen"));
        differentElementsPageUIButtons.shouldHaveSize(2);
        differentElementsPageUIButtons.get(0)
                .shouldHave(text("DEFAULT BUTTON"));
        differentElementsPageUIButtons.get(1)
                .shouldHave(value("BUTTON"));
    }

    public void checkIfDifferentElementsPageRightSectionVisible() {
        differentElementsPageRightSection.isDisplayed();
    }

    public void checkIfDifferentElementsPageLeftSectionVisible() {
        differentElementsPageLeftSection.isDisplayed();
    }

    public void checkIfDifferentElementsPageLogPannelContainsCheckboxStatusText(Checkboxes... checkboxes) {
        for (Checkboxes checkbox : checkboxes) {
            if ($$(differentElementsPageCheckboxesStatus).get(checkbox.checkboxesPosition)
                    .isSelected()) {
                $(differentElementsPageLogsPanel)
                        .shouldBe(visible)
                        .shouldHave(text(checkbox.checkboxesName + ": condition changed to true"));
            }
        }
    }

    public void checkIfDifferentElementsPageLogPannelContainsRadioButtonStatusText(Radiobuttons radiobuttons) {
        $(differentElementsPageLogsPanel)
                .shouldBe(visible)
                .shouldHave(text("metal: value changed to " + radiobuttons.radiobuttonsType));
    }


    public void checkIfDifferentElementsPageLogPannelContainsDropdownStatusText(Dropdowns dropdowns) {
        $(differentElementsPageLogsPanel)
                .shouldBe(visible)
                .shouldHave(text("Colors: value changed to " + dropdowns.dropdownsColor));
    }

    public void checkIfDifferentElementsPageLogPannelContainsUnselectedCheckboxStatusText(Checkboxes... checkboxes) {
        for (Checkboxes checkbox : checkboxes) {
            if ($$(differentElementsPageCheckboxesStatus).get(checkbox.checkboxesPosition)
                    .is(not(selected))) {
                $(differentElementsPageLogsPanel)
                        .shouldBe(visible)
                        .shouldHave(text(checkbox.checkboxesName + ": condition changed to false"));
            }
        }
    }
}



