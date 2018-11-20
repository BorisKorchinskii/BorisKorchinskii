package hw5;

import base.SelenideTestBase;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Story;
import listeners.AllureAttachmentListener;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.hw5.DatesPageSelenide;
import pageObjects.hw5.HomePageSelenide;

import static com.codeborne.selenide.Selenide.page;
import static enums.Users.PITER_CHAILOVSKII;

@Feature("Smoke tests")
@Story("Dates page test")
@Listeners(AllureAttachmentListener.class)
public class DatesPageSelenideTest extends SelenideTestBase {

    private DatesPageSelenide datesPageSelenide;
    private HomePageSelenide homePageSelenide;

    @BeforeClass
    public void beforeClass() {
        datesPageSelenide = page(DatesPageSelenide.class);
        homePageSelenide = page(HomePageSelenide.class);
    }

    @Issue("Setting to (30,70) at step 13 cause a bug")
    @Test
    public void checkDatesPageSliders() {

        //1 Open test site by URL
        homePageSelenide.navigateToPage();

        //2 Assert Browser title
        homePageSelenide.checkIfTitleIsVisible();

        //3 Perform login
        homePageSelenide.login();

        //4 Assert User name in the left-top side of screen that user is logged
        homePageSelenide.userIsLogged(PITER_CHAILOVSKII);

        //5 Open through the header menu Service -> Dates Page
        homePageSelenide.openDatesViaHeaderServiceMenu();

        //6 Using drag-and-drop set Range sliders. left sliders - the most left position, right slider - the most right position (From = 0, To = 100)
        datesPageSelenide.setSlidersPositions(0, 100);

        //7 Assert that for "From" and "To" sliders there are logs rows with corresponding values
       datesPageSelenide.checkIfHandlesSetTo(0, 100);

        //8 Using drag-and-drop set Range sliders. left sliders - the most left position, right slider - the most left position.
        datesPageSelenide.setSlidersPositions(0, 0);

        //9 Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPageSelenide.checkIfHandlesSetTo(0, 0);

        //10 Using drag-and-drop set Range sliders. left sliders - the most right position, right slider - the most right position.
        datesPageSelenide.setSlidersPositions(100, 100);

        //11 Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPageSelenide.checkIfHandlesSetTo(100, 100);

        //12 Using drag-and-drop set Range sliders. (From = 30, To = 70)
        datesPageSelenide.setSlidersPositions(30, 70);

        //13 Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPageSelenide.checkIfHandlesSetTo(30, 70);
    }
}
