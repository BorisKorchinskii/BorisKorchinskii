package pageObjects.hw6.base;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import cucumber.api.java.en.And;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.textsInAnyOrder;
import static com.codeborne.selenide.Selenide.page;

public class LeftSection {

    @FindBy(css = "a[ui='label']")
    private SelenideElement serviceSubCategoryLeftElement;

    @FindBy(css = "[class = 'sub'] a")
    private ElementsCollection serviceSubCategoryLeftElements;

    public LeftSection() {
        page(this);
    }

    //=============================== Checks ========================================

    @Step
    @And("Service dropdown in left section contains options:")
    public void checkServiceLeftDropdownContains(List<String> serviceElements) {
        serviceSubCategoryLeftElement.click();
        serviceSubCategoryLeftElements.shouldHave(textsInAnyOrder(serviceElements));
    }
}
