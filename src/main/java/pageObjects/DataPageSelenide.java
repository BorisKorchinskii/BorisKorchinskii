package pageObjects;

import base.TestBaseForObjectTestHW4;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import enums.Logging;
import enums.Sliders;
import enums.Users;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static enums.Logging.FROM;
import static enums.Logging.TO;

public class DataPageSelenide extends TestBaseForObjectTestHW4 {

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

    @FindBy(css = "[class = 'panel-body-list logs'] li")
    private ElementsCollection differentElementsPageLogsPanel;

    @FindBy(css = ".ui-slider-handle")
    private ElementsCollection slider;


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

    public void openViaHeaderServiceMenu() {
        navBarElements.get(2).click();
        serviceDropdownElements.get(1).shouldHave(text("DATES")).click();
    }

    public void dragAndDropHandles0to100(Sliders xOffset, Sliders yOffset) {
        Sliders zero = Sliders.ZERO;
        Sliders hundred = Sliders.HUNDRED;
        actions().dragAndDropBy($(slider.get(0)), zero.getxOffset(), zero.getyOffset()).perform();
        actions().dragAndDropBy($(slider.get(1)), hundred.getxOffset(), hundred.getyOffset()).perform();
    }

    public void dragAndDropHandles0to0(Sliders xOffset, Sliders yOffset) {
        Sliders zero = Sliders.ZERO;
        actions().dragAndDropBy($(slider.get(0)), zero.getxOffset(), zero.getyOffset()).perform();
        actions().dragAndDropBy($(slider.get(1)), zero.getxOffset(), zero.getyOffset()).perform();
    }

    public void dragAndDropHandles100to100(Sliders xOffset, Sliders yOffset) {
        Sliders hundred = Sliders.HUNDRED;
        actions().dragAndDropBy($(slider.get(0)), hundred.getxOffset(), hundred.getyOffset()).perform();
        actions().dragAndDropBy($(slider.get(1)), hundred.getxOffset(), hundred.getyOffset()).perform();
    }

    public void dragAndDropHandles30to70(Sliders xOffset, Sliders yOffset) {
        Sliders thirty = Sliders.THIRTY;
        Sliders seventy = Sliders.SEVENTY;
        actions().dragAndDropBy($(slider.get(0)), thirty.getxOffset(), thirty.getyOffset()).perform();
        actions().dragAndDropBy($(slider.get(1)), seventy.getxOffset(), seventy.getyOffset()).perform();
    }

    //=============================== Elements checkers ==========================================

    public void checkIfHandlesSet0to100() {
        $$(differentElementsPageLogsPanel).get(1).shouldHave(text(FROM + String.valueOf(Logging.ZERO)));
        $$(differentElementsPageLogsPanel).get(0).shouldHave(text(TO + String.valueOf(Logging.HUNDRED)));
    }

    public void checkIfHandlesSet0to0() {
        $$(differentElementsPageLogsPanel).get(1).shouldHave(text(FROM + String.valueOf(Logging.ZERO)));
        $$(differentElementsPageLogsPanel).get(0).shouldHave(text(TO + String.valueOf(Logging.ZERO)));
    }

    public void checkIfHandlesSet100to100() {
        $$(differentElementsPageLogsPanel).get(1).shouldHave(text(TO + String.valueOf(Logging.HUNDRED)));
        $$(differentElementsPageLogsPanel).get(0).shouldHave(text(TO + String.valueOf(Logging.HUNDRED)));
    }

    public void checkIfHandlesSet30to70() {
        $$(differentElementsPageLogsPanel).get(1).shouldHave(text(FROM + String.valueOf(Logging.THIRTY)));
        $$(differentElementsPageLogsPanel).get(0).shouldHave(text(TO + String.valueOf(Logging.SEVENTY)));
    }
}



