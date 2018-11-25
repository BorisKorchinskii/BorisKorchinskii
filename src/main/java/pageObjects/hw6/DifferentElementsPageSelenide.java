package pageObjects.hw6;

import JDI.enums.HeaderMenu;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import enums.Checkboxes;
import enums.Dropdowns;
import enums.Radiobuttons;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.page;
import static enums.HeaderMenu.HEADER_DIFFERENT_ELEMENTS;
import static org.testng.Assert.assertTrue;

public class DifferentElementsPageSelenide {

    private int uiButtonsSize = 2;

    @FindBy(css = ".label-checkbox input")
    private ElementsCollection differentElementsPageCheckboxes;

    @FindBy(css = ".label-radio input")
    private ElementsCollection differentElementsPageRadioButtons;

    @FindBy(css = "select")
    private SelenideElement differentElementsPageSelectDropdown;

    @FindBy(css = "[class = 'uui-button']")
    private ElementsCollection differentElementsPageUIButtons;

    @FindBy(css = ".right-fix-panel")
    private SelenideElement differentElementsPageRightSection;

    @FindBy(css = "[name='navigation-sidebar']")
    private SelenideElement differentElementsPageLeftSection;

    @FindBy(css = ".logs li")
    private ElementsCollection differentElementsPageLogsPanel;

    @FindBy(css = "ul.dropdown-menu a")
    private ElementsCollection serviceDropdown;

    @FindBy(css = ".nav > li")
    private ElementsCollection navBarElements;

    public DifferentElementsPageSelenide() {
        page(this);
    }

    //=============================== Actions methods ========================================

    @Step
    @Given("I am on the Different Elements page")
    public void openDiffElements() {
        headerClick(HeaderMenu.SERVICE.name());
        openPageFromService(HEADER_DIFFERENT_ELEMENTS.name);
    }

    @Step
    @When("I (.*) checkboxes:")
    public void selectCheckboxes(String isSelected, List<String> checkbox) {
        boolean state = "select".equals(isSelected);
        for (String element : checkbox) {
            selectCheckbox(state, element);
        }
    }

    @Step
    @When("I select (.*) radio")
    public void selectRadio(String radio) {
        for (SelenideElement element : differentElementsPageRadioButtons) {
            if (element.parent().getText().equals(radio))
                element.click();
        }
    }

    @Step
    @When("I select (.*) in dropdown")
    public void selectInDropdown(String dropdownColor) {
        differentElementsPageSelectDropdown.selectOption(dropdownColor);
    }

    //=============================== Elements checkers ==========================================

    @Step
    @Then("Different elements page interface contains all needed elements")
    public void checkDiffElementsPageInterface() {
        differentElementsPageCheckboxes.shouldHaveSize(Checkboxes.size);
        for (SelenideElement element : differentElementsPageCheckboxes) {
            element.shouldHave(type("checkbox"));
        }
        differentElementsPageRadioButtons.shouldHaveSize(Radiobuttons.size);
        for (SelenideElement element : differentElementsPageRadioButtons) {
            element.shouldHave(type("radio"));
        }
        differentElementsPageSelectDropdown.shouldBe(visible);
        differentElementsPageUIButtons.shouldHaveSize(uiButtonsSize);
        for (SelenideElement element : differentElementsPageUIButtons) {
            element.shouldBe(visible);
        }
    }

    @Step
    @And("There is Right Section")
    public void checkRightSectionExists() {
        differentElementsPageRightSection.shouldBe(visible);
    }

    @Step
    @And("There is Left Section")
    public void checkLeftSectionExists() {
        differentElementsPageLeftSection.shouldBe(visible);
    }

    @Step
    @Then("There is a log row for:")
    public void checkLogCheckboxes(List<String> checkboxes) {
        for (String element : checkboxes) {
            checkLogCheckbox(element);
        }
    }

    @Step
    @Then("There is a log row for radio (.*)")
    public void checkLogRadios(String radioName) {
        for (SelenideElement element : differentElementsPageRadioButtons) {
            if (element.parent().getText().equals(radioName))
                assertTrue(logContainsRadio(radioName, element));
        }
    }

    @Step
    @Then("There is a log row for dropdown (.*)")
    public void checkLogDropdown(String dropdownColor) {
        assertTrue(logContainsDropdown(dropdownColor));
    }

    public void headerClick(String name) {
        for (SelenideElement element : navBarElements) {
            if (element.text().equals(name.toUpperCase())) {
                element.click();
                break;
            }
        }
    }

    public void openPageFromService(String name) {
        for (SelenideElement element : serviceDropdown) {
            if (element.text().equals(name)) {
                element.click();
                break;
            }
        }
    }

    private void selectCheckbox(boolean state, String checkbox) {
        for (SelenideElement element : differentElementsPageCheckboxes) {
            if (element.parent().getText().equals(checkbox))
                element.setSelected(state);
        }
    }

    private boolean logContainsCheckbox(String checkboxName, SelenideElement element) {
        for (SelenideElement logElement : differentElementsPageLogsPanel) {
            if (logElement.has(matchText(".*" + checkboxName + ".*" + element.isSelected()))) {
                return true;
            }
        }
        return false;
    }

    private void checkLogCheckbox(String checkboxName) {
        for (SelenideElement element : differentElementsPageCheckboxes) {
            if (element.parent().getText().equals(checkboxName))
                assertTrue(logContainsCheckbox(checkboxName, element));
        }
    }

    private boolean logContainsRadio(String name, SelenideElement element) {
        for (SelenideElement logElement : differentElementsPageLogsPanel) {
            if (logElement.has(matchText(".*" + element.name() + ".*" + name))) {
                return true;
            }
        }
        return false;
    }

    private boolean logContainsDropdown(String dropdownColorName) {
        for (SelenideElement logElement : differentElementsPageLogsPanel) {
            if (logElement.has(matchText(".*" + Dropdowns.category + ".*" + differentElementsPageSelectDropdown.getSelectedText())) &&
                    dropdownColorName.equals(differentElementsPageSelectDropdown.getSelectedText())) {
                return true;
            }
        }
        return false;
    }
}



