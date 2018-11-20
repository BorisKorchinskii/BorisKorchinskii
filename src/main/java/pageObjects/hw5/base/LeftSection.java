package pageObjects.hw5.base;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static enums.LeftSectionMenu.getLeftSectionCategoriesList;
import static org.testng.Assert.assertTrue;

public class LeftSection {

    @FindBy(css = "[class = 'sidebar-menu'] > [index = '3']")
    private SelenideElement serviceSubCategoryLeftElement;

    @FindBy(css = "[class = 'sub'] li")
    private ElementsCollection serviceSubCategoryLeftElements;

    //=============================== Checks ========================================

    public void checkServiceSubCategoryLeftSectionContainsOptions() {
        serviceSubCategoryLeftElement.click();
        serviceSubCategoryLeftElements.shouldHaveSize(8);
        for (SelenideElement element : serviceSubCategoryLeftElements) {
            $(element).isDisplayed();
        }
        for (String category : getLeftSectionCategoriesList()) {
            assertTrue($$(serviceSubCategoryLeftElements).texts().contains(category));
        }
    }
}
