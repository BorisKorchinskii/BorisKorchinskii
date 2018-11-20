package pageObjects.hw5;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.actions;
import static enums.Logging.*;

public class DatesPageSelenide {

    @FindBy(css = "[class = 'panel-body-list logs'] li")
    private ElementsCollection differentElementsPageLogsPanel;

    @FindBy(css = ".ui-slider")
    private SelenideElement slider;

    @FindBy(xpath = "//div[@class='ui-slider-range ui-widget-header ui-corner-all']/preceding-sibling::a")
    private SelenideElement leftSideRange;

    @FindBy(css = "div[class*='ui-slider-range'] + a")
    private SelenideElement rightSideRange;

    //=============================== Actions methods ========================================


    private double getStep() {
        return (double) slider.getSize().getWidth() / 100;
    }


    private void moveHandle(SelenideElement slider, double position) {
        double currentHandlePosition = Double.parseDouble(slider.text());
        double handleOffset = (position - currentHandlePosition > 0) ? (position - currentHandlePosition) * getStep() : (position - currentHandlePosition - 1) * getStep();
        actions().dragAndDropBy(slider.toWebElement(), (int) handleOffset, 0).build().perform();
    }

    @Step
    public void setSlidersPositions(double leftHandle, double rightHandle) {
        if (leftSideRange.getLocation().x == rightSideRange.getLocation().x && rightSideRange.getLocation().x == 1156) {
            moveHandle(leftSideRange, leftHandle);
            moveHandle(rightSideRange, rightHandle);
        } else {
            moveHandle(rightSideRange, rightHandle);
            moveHandle(leftSideRange, leftHandle);
        }
    }

    //=============================== Elements checkers ==========================================

    @Step
    public void checkIfHandlesSetTo(int from, int to) {
        differentElementsPageLogsPanel.findBy(text(FROM + (String.valueOf(from)))).shouldHave(text(R2FROM + String.valueOf(from) + CLICKED));
        differentElementsPageLogsPanel.findBy(text(TO + (String.valueOf(to)))).shouldHave(text(R2TO + String.valueOf(to) + CLICKED));
    }
}



