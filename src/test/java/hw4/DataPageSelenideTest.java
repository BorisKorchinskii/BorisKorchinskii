package hw4;

import org.testng.annotations.Test;
import pageObjects.DataPageSelenide;

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

        //6 Using drag-and-drop set Range sliders. left sliders - the most left position, right slider - the most rigth position (From = 0, To = 100)
        dataPageSelenide.dargAndDropSliders();

        //7

        //8

        //9

        //10

        //12

        //13
    }
}
