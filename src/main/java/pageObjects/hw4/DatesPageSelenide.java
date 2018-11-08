package pageObjects.hw4;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.actions;
import static enums.Logging.*;

public class DatesPageSelenide {

    @FindBy(css = "[class = 'panel-body-list logs'] li")
    private ElementsCollection differentElementsPageLogsPanel;

    @FindBy(css = ".ui-slider-handle")
    private ElementsCollection sliderHandle;

    @FindBy(css = ".ui-slider")
    private SelenideElement slider;

    //=============================== Actions methods ========================================

    public void setSlidersPositions(int from, int to) {
        double sliderWidth = slider.getSize().getWidth();
        double sliderHandleWidth = sliderHandle.get(0).getSize().getWidth();
        double xCoord = slider.getLocation().getX();
        double fromX = sliderHandle.get(0).getLocation().getX() + sliderHandleWidth / 2;
        double toX = sliderHandle.get(1).getLocation().getX() + sliderHandleWidth / 2;
        double newPositionFroX = xCoord - fromX + from * sliderWidth / 100;
        double newPositionToX = xCoord - toX + to * sliderWidth / 100;
        if (newPositionToX <= fromX) {
            actions().moveToElement(slider).dragAndDropBy(sliderHandle.get(0), (int) Math.ceil(newPositionFroX), 0)
                    .dragAndDropBy(sliderHandle.get(1), (int) Math.ceil(newPositionToX), 0).perform();
        } else {
            actions().moveToElement(slider).dragAndDropBy(sliderHandle.get(1), (int) Math.ceil(newPositionToX), 0)
                    .dragAndDropBy(sliderHandle.get(0), (int) Math.ceil(newPositionFroX), 0).perform();
        }
    }

    //=============================== Elements checkers ==========================================

    public void checkIfHandlesSetTo(int from, int to) {
        differentElementsPageLogsPanel.findBy(text(FROM + (String.valueOf(from)))).shouldHave(text(R2FROM + String.valueOf(from) + CLICKED));
        differentElementsPageLogsPanel.findBy(text(TO + (String.valueOf(to)))).shouldHave(text(R2TO + String.valueOf(to) + CLICKED));
    }
}



