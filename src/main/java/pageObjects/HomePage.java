package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HomePage {

    @FindBy(css = ".profile-photo")
    private WebElement loginProfileButton;

    @FindBy(css = "[id = 'Name']")
    private WebElement loginField;

    @FindBy(css = "[id = 'Password']")
    private WebElement passwordField;

    @FindBy(css = ".login [type = 'submit']")
    private WebElement enterButton;

    @FindBy(css = ".profile-photo [ui = 'label']")
    private WebElement loggedInUserName;

    @FindBy(css = ".nav > li")
    private List<WebElement> navBarElements;

    @FindBy(css = ".benefit-icon")
    private List<WebElement> benefitIconsImages;

    @FindBy(css = "div.benefit-icon + span")
    private List<WebElement> benefitIconsText;

    @FindBy(css = "h3.main-title.text-center")
    private WebElement textOnMainTitle;

    @FindBy(css = "p.main-txt")
    private WebElement titleContainingText;

    @FindBy(css = "[id = 'iframe']")
    private WebElement iFrame;

    @FindBy(css = "#epam_logo")
    private WebElement epamLogoIniFrame;

    @FindBy(css = "[class='text-center'] a")
    private WebElement jdiSubheader;

    @FindBy(css = ".mCustomScrollBox")
    private WebElement leftSection;

    @FindBy(css = "footer")
    private WebElement footer;

    //=============================== Actions methods ========================================

    public void navigateToPage(WebDriver driver) {
        driver.navigate().to("https://epam.github.io/JDI/index.html");
    }

    public void login(String name, String pass) {
        loginProfileButton.click();
        loginField.sendKeys(name);
        passwordField.sendKeys(pass);
        enterButton.click();
    }

    public void userIsLogged() {
        loggedInUserName.isDisplayed();
        assertEquals(loggedInUserName.getText(), "PITER CHAILOVSKII");
    }

    public void switchToOriginalWindow(WebDriver driver) {
        driver.switchTo().defaultContent();
    }

    //=============================== Elements checks ==========================================

    public void checkIfTitleIsVisible(WebDriver driver) {
        assertEquals(driver.getTitle(), "Home Page");
    }

    public void checkIfHeaderItemsContainText() {
        assertEquals(navBarElements.size(), 4);
        for (WebElement element : navBarElements) {
            assertTrue(element.isDisplayed());
        }
        assertEquals(navBarElements.get(0).getText(), "HOME");
        assertEquals(navBarElements.get(1).getText(), "CONTACT FORM");
        assertEquals(navBarElements.get(2).getText(), "SERVICE");
        assertEquals(navBarElements.get(3).getText(), "METALS & COLORS");
    }

    public void checkIfImagesDisplays() {
        assertEquals(benefitIconsImages.size(), 4);
        for (WebElement images : benefitIconsImages) {
            assertTrue(images.isDisplayed());
        }
    }

    public void checkIfIconsContainText() {
        assertEquals(benefitIconsText.size(), 4);
        assertEquals(benefitIconsText.get(0)
                .getText(), "To include good practices\n" +
                "and ideas from successful\n" +
                "EPAM project");
        assertEquals(benefitIconsText.get(1)
                .getText(), "To be flexible and\n" +
                "customizable");
        assertEquals(benefitIconsText.get(2)
                .getText(), "To be multiplatform");
        assertEquals(benefitIconsText.get(3)
                .getText(), "Already have good base\n" +
                "(about 20 internal and\n" +
                "some external projects),\n" +
                "wish to get more…");
    }

    public void checkMainHeaderHasText() {
        String textOnMainTitleIs = "EPAM FRAMEWORK WISHES…";
        assertEquals(textOnMainTitle.getText(), textOnMainTitleIs);
        String mainTitleTextIs = "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, " +
                "SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, " +
                "QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS " +
                "AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.";
        assertEquals(titleContainingText.getText(), mainTitleTextIs);
    }

    public void checkIfFrameIsVisible() {
        assertTrue(iFrame.isDisplayed());
    }

    public void checkEpamLogoIsVisible(WebDriver driver) {
        driver.switchTo().frame(iFrame);
        assertTrue(epamLogoIniFrame.isDisplayed());
    }

    public void checkSubHeaderText() {
        assertTrue(jdiSubheader.isDisplayed());
        assertEquals(jdiSubheader.getText(), "JDI GITHUB");
    }

    public void checkSubHeaderHasLink() {
        assertEquals(jdiSubheader.getAttribute("href"), "https://github.com/epam/JDI");
    }

    public void checkIfLeftSectionVisible() {
        assertTrue(leftSection.isDisplayed());
    }

    public void checkIfFooterIsVisible() {
        assertTrue(footer.isDisplayed());
    }
}
