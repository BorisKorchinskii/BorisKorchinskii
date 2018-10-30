package hw4;

import org.testng.annotations.Test;
import pageObjects.ServicePageSelenide;

import static enums.Checkboxes.WATER;
import static enums.Checkboxes.WIND;
import static enums.Dropdowns.YELLOW;
import static enums.Radiobuttons.SELEN;
import static enums.Users.PITER_CHAILOVSKII;
import static enums.WebLinks.INDEX_PAGE;

public class ServicePageInterfaceTest extends ServicePageSelenide {

    @Test
    public void checkServicePageInterface() {

        //1 Open test site by URL
        servicePageInterface.navigateToPage(INDEX_PAGE.navigateTo);

        //2 Assert Browser title
        servicePageInterface.checkIfTitleIsVisible();

        //3 Perform login
        servicePageInterface.login(PITER_CHAILOVSKII.login, PITER_CHAILOVSKII.password);

        //4 Assert User name in the left-top side of screen that user is loggined
        servicePageInterface.userIsLogged(PITER_CHAILOVSKII);

        //5 Click on "Service" subcategory in the header and check that drop down contains options
        servicePageInterface.checkServiceHeaderContainsOptions();

        //6 Click on Service subcategory in the left section and check that drop down contains options
        servicePageInterface.checkServiceSubCategoryLeftSectionContainsOptions();

        //7 Open through the header menu Service -> Different Elements Page
        servicePageInterface.openViaHeaderServiceMenu();

        //8 Check interface on Different elements page, it contains all needed elements
        servicePageInterface.checkIfNeededElementsVisible();

        //9 Assert that there is Right Section
        servicePageInterface.checkIfRightSectionVisible();

        //10 Assert that there is Left Section
        servicePageInterface.checkIfLeftSectionVisible();

        //11 Select checkboxes (Water, Wind)
        servicePageInterface.selectWaterWindCheckboxes(WATER, WIND);

        //12 Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox. 
        servicePageInterface.checkIfDifferentElementsPageLogPannelContainsCheckboxStatusText(WATER, WIND);

        //13 Select radio (Selen)
        servicePageInterface.selectSelenRadioButton(SELEN);

        //14 Assert that for radiobutton there is a log row and value is corresponded to the status of radiobutton. 
        servicePageInterface.checkIfLogPanelContainsRadioButtonStatusText(SELEN);

        //15 Select in dropdown (Yellow)
        servicePageInterface.selectYellowFromDropdown(YELLOW);

        //16 Assert that for dropdown there is a log row and value is corresponded to the selected value. 
        servicePageInterface.checkIfLogPanelContainsDropdownStatusText(YELLOW);

        //17 Unselect and assert checkboxes (Water, Wind)
        servicePageInterface.unselectWaterWindCheckboxes(WATER, WIND);

        //18 Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox. 
        servicePageInterface.checkIfPanelContainsUnselectedCheckboxStatusText(WATER, WIND);
    }
}
