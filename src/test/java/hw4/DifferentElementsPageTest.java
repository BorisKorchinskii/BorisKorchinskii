package hw4;

import base.TestBaseForObjectTestHW4;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.hw4.DifferentElementsPageSelenide;
import pageObjects.hw4.HomePageSelenide;

import static com.codeborne.selenide.Selenide.page;
import static enums.Checkboxes.WATER;
import static enums.Checkboxes.WIND;
import static enums.Dropdowns.YELLOW;
import static enums.Radiobuttons.SELEN;
import static enums.Users.PITER_CHAILOVSKII;

public class DifferentElementsPageTest extends TestBaseForObjectTestHW4 {

    private DifferentElementsPageSelenide differentElementsPageSelenide;
    private HomePageSelenide homePageSelenide;

    @BeforeClass
    public void beforeClass() {
        differentElementsPageSelenide = page(DifferentElementsPageSelenide.class);
        homePageSelenide = page(HomePageSelenide.class);
    }

    @Test
    public void checkDifferentElementsPageInterface() {

        //1 Open test site by URL
        homePageSelenide.navigateToPage();

        //2 Assert Browser title
        homePageSelenide.checkIfTitleIsVisible();

        //3 Perform login
        homePageSelenide.login();

        //4 Assert User name in the left-top side of screen that user is logged
        homePageSelenide.userIsLogged(PITER_CHAILOVSKII);

        //5 Click on "Service" subcategory in the header and check that drop down contains options
        homePageSelenide.checkServiceHeaderContainsOptions();

        //6 Click on Service subcategory in the left section and check that drop down contains options
        homePageSelenide.checkServiceSubCategoryLeftSectionContainsOptions();

        //7 Open through the header menu Service -> Different Elements Page
        homePageSelenide.openElementsViaHeaderServiceMenu();

        //8 Check interface on Different elements page, it contains all needed elements
        differentElementsPageSelenide.checkIfNeededElementsVisible();

        //9 Assert that there is Right Section
        differentElementsPageSelenide.checkIfRightSectionVisible();

        //10 Assert that there is Left Section
        differentElementsPageSelenide.checkIfLeftSectionVisible();

        //11 Select checkboxes (Water, Wind)
        differentElementsPageSelenide.selectWaterWindCheckboxes(WATER, WIND);

        //12 Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox. 
        differentElementsPageSelenide.checkIfDifferentElementsPageLogPannelContainsCheckboxStatusText(WATER, WIND);

        //13 Select radio (Selen)
        differentElementsPageSelenide.selectSelenRadioButton(SELEN);

        //14 Assert that for radiobutton there is a log row and value is corresponded to the status of radiobutton. 
        differentElementsPageSelenide.checkIfLogPanelContainsRadioButtonStatusText(SELEN);

        //15 Select in dropdown (Yellow)
        differentElementsPageSelenide.selectYellowFromDropdown(YELLOW);

        //16 Assert that for dropdown there is a log row and value is corresponded to the selected value. 
        differentElementsPageSelenide.checkIfLogPanelContainsDropdownStatusText(YELLOW);

        //17 Unselect and assert checkboxes (Water, Wind)
        differentElementsPageSelenide.unselectWaterWindCheckboxes(WATER, WIND);

        //18 Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox. 
        differentElementsPageSelenide.checkIfPanelContainsUnselectedCheckboxStatusText(WATER, WIND);
    }
}
