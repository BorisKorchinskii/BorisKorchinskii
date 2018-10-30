package hw4;

import org.testng.annotations.Test;
import pageObjects.DataPageSelenide;

import static enums.Sliders.*;
import static enums.Users.PITER_CHAILOVSKII;
import static enums.WebLinks.INDEX_PAGE;

public class DataPageSelenideTest extends DataPageSelenide {

    @Test
    public void checkDataPageSelenide() {

        //1 Open test site by URL
        dataPageSelenide.navigateToPage(INDEX_PAGE.navigateTo);

        //2 Assert Browser title
        servicePageInterface.checkIfTitleIsVisible();

        //3 Perform login
        dataPageSelenide.login(PITER_CHAILOVSKII.login, PITER_CHAILOVSKII.password);

        //4 Assert User name in the left-top side of screen that user is loggined
        dataPageSelenide.userIsLogged(PITER_CHAILOVSKII);

        //5 Open through the header menu Service -> Dates Page
        dataPageSelenide.openViaHeaderServiceMenu();

        //6 Using drag-and-drop set Range sliders. left sliders - the most left position, right slider - the most right position (From = 0, To = 100)
        dataPageSelenide.dragAndDropHandles0to100(ZERO, HUNDRED);

        //7 Assert that for "From" and "To" sliders there are logs rows with corresponding values
        dataPageSelenide.checkIfHandlesSet0to100();

        //8 Using drag-and-drop set Range sliders. left sliders - the most left position, right slider - the most left position.
        dataPageSelenide.dragAndDropHandles0to0(ZERO, ZERO);

        //9 Assert that for "From" and "To" sliders there are logs rows with corresponding values
        dataPageSelenide.checkIfHandlesSet0to0();

        //10 Using drag-and-drop set Range sliders. left sliders - the most right position, right slider - the most right position.
        dataPageSelenide.dragAndDropHandles100to100(HUNDRED, HUNDRED);

        //11 Assert that for "From" and "To" sliders there are logs rows with corresponding values
        dataPageSelenide.checkIfHandlesSet100to100();

        //12 Using drag-and-drop set Range sliders. (From = 30, To = 70)
        dataPageSelenide.dragAndDropHandles30to70(THIRTY, SEVENTY);

        //13 Assert that for "From" and "To" sliders there are logs rows with corresponding values
        dataPageSelenide.checkIfHandlesSet30to70();
    }
}
