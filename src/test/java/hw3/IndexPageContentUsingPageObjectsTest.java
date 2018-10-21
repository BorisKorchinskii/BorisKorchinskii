package hw3;

import base.TestBase;
import base.TestBaseForObjectTestHW3;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.HomePage;


import java.util.concurrent.TimeUnit;

import static enums.Users.PITER_CHAILOVSKII;

public class IndexPageContentUsingPageObjectsTest extends TestBaseForObjectTestHW3 {

    @Test
    public void checkIfElementsPresence() {

        //1 Open test site by URL
        homePage.navigateToPage();

        //2 Assert Browser title
        homePage.checkIfTitleIsVisible();

        //3 Perform login
        homePage.login(PITER_CHAILOVSKII.login, PITER_CHAILOVSKII.password);

        //4 Assert User name in the left-top side of screen that user is loggined
        homePage.userIsLogged();

        //5 Assert Browser title
        homePage.checkIfTitleIsVisible();

        //6 Assert that there are 4 items on the header section are displayed and they have proper texts
        homePage.checkIfHeaderItemsContainText();

        //7 Assert that there are 4 images on the Index Page and they are displayed
        homePage.checkIfImagesDisplays();

        //8 Assert that there are 4 texts on the Index Page under icons and they have proper text
        homePage.checkIfIconsContainText();

        //9 Assert a text of the main header
        homePage.checkMainHeaderHasText();

        //10 Assert that there is the iframe in the center of page
        homePage.checkIframeIsVisible();

        //11 Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        homePage.checkEpamLogoIsVisible();

        //12 Switch to original window back
        homePage.switchToOriginalWindow();

        //13 Assert a text of the sub header
        homePage.checkSubheaderTextt();

        //14 Assert that JDI GITHUB is a link and has a proper URL
        homePage.checkSubheaderHasLink();

        //15 Assert that there is Left Section
        homePage.checkIfLeftSectionVisible();

        //16 Assert that there is Footer
        homePage.checkIfFooterIsVisible();
    }
}
