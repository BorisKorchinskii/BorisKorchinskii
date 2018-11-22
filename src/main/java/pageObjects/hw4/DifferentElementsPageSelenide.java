package pageObjects.hw4;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import enums.Checkboxes;
import enums.Dropdowns;
import enums.Radiobuttons;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static enums.Checkboxes.*;
import static enums.Logging.*;
import static enums.Radiobuttons.*;
import static org.testng.Assert.assertTrue;

public class DifferentElementsPageSelenide {

    @FindBy(css = "[class='label-checkbox']")
    private ElementsCollection differentElementsPageCheckboxes;

    @FindBy(css = "[class='label-radio']")
    private ElementsCollection differentElementsPageRadioButtons;

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

    @FindBy(css = "[class = '.logs']")
    private ElementsCollection differentElementsPageLogsPanelLogs;

    //=============================== Actions methods ========================================

    public void selectWaterWindCheckboxes(Checkboxes... checkboxes) {
        for (Checkboxes checkbox : checkboxes) {
            differentElementsPageCheckboxes.findBy(text(checkbox.checkboxesName)).click();
        }
    }

    public void selectSelenRadioButton(Radiobuttons... radiobuttons) {
        for (Radiobuttons radiobutton : radiobuttons) {
            differentElementsPageRadioButtons.findBy(text(radiobutton.radiobuttonsType)).click();
        }
    }

    public void selectYellowFromDropdown(Dropdowns dropdowns) {
        differentElementsPageColorsDropdown.hover().click();
        differentElementsPageColorsDropdownPositions.find(text(dropdowns.dropdownsColor)).click();
    }

    public void unselectWaterWindCheckboxes(Checkboxes... checkboxes) {
        for (Checkboxes checkbox : checkboxes) {
            differentElementsPageCheckboxes.findBy(text(checkbox.checkboxesName)).click();
        }
    }

    private boolean logContainsCheckbox(Checkboxes checkbox, SelenideElement element) {
        for (SelenideElement selenideElement : differentElementsPageLogsPanelLogs) {
            if (selenideElement.has(matchText(".*" + checkbox.checkboxesName + ".*" + element.isSelected()))) {
                return true;
            }
        }
        return false;
    }

    //=============================== Elements checkers ==========================================

    public void checkIfNeededElementsVisible() {
        differentElementsPageCheckboxes.shouldHaveSize(4).shouldHave(texts(String.valueOf(WATER), String.valueOf(EARTH), String.valueOf(WIND), String.valueOf(FIRE)));
        differentElementsPageRadioButtons.shouldHaveSize(4).shouldHave(texts(String.valueOf(GOLD), String.valueOf(SILVER), String.valueOf(BRONZE), String.valueOf(SELEN)));
        differentElementsPageUIButtons.shouldHaveSize(2);
        differentElementsPageUIButtons.get(0).shouldHave(text("DEFAULT BUTTON"));
        differentElementsPageUIButtons.get(1).shouldHave(value("BUTTON"));
    }

    public void checkIfRightSectionVisible() {
        $(differentElementsPageRightSection).isDisplayed();
    }

    public void checkIfLeftSectionVisible() {
        $(differentElementsPageLeftSection).isDisplayed();
    }

    public void checkIfLogPanelContainsCheckboxStatus(Checkboxes... checkboxes) {

        for (Checkboxes element : checkboxes) {
            checkLogForCheckbox(element);
        }
    }

    private void checkLogForCheckbox(Checkboxes checkbox) {

        for (SelenideElement element : differentElementsPageCheckboxes) {
            if (element.parent().getText().equals(checkbox.checkboxesName)) {
                assertTrue(logContainsCheckbox(checkbox, element));
            }
        }
    }

    public void checkIfLogPanelContainsRadioButtonStatusText(Radiobuttons radiobuttons) {
        differentElementsPageLogsPanel.shouldBe(visible).shouldHave(text(String.valueOf(METAL) + VALUE_CHANGED_TO + radiobuttons.radiobuttonsType));
    }

    public void checkIfLogPanelContainsDropdownStatusText(Dropdowns dropdowns) {
        differentElementsPageLogsPanel.shouldBe(visible).shouldHave(text(String.valueOf(COLORS) + VALUE_CHANGED_TO + dropdowns.dropdownsColor));
    }
}



