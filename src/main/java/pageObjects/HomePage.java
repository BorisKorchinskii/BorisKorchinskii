package pageObjects;

import base.TestBaseForObjectTestHW3;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HomePage extends TestBaseForObjectTestHW3 {

    @FindBy(css = ".profile-photo")
    private WebElement loginProfileButton;

    @FindBy(css = "[id = 'Name']")
    private WebElement loginField;

    @FindBy(css = "[id = 'Password']")
    private WebElement passwordField;

    @FindBy(css = ".login [type = 'submit']")
    private WebElement enterButton;

    @FindBy(css = ".profile-photo [ui = 'label']")
    private WebElement loggedinUserName;

    @FindBy(css = ".nav > li")
    private List<WebElement> navBarElements;

    @FindBy(css = ".benefit-icon")
    private List<WebElement> benefitIconsImages;

    //@FindBy(css = ".benefit-text']")
    @FindBy(css = "div.benefit-icon+span")
    private List<WebElement> benefitIconsText;

    @FindBy(css = "h3.main-title.text-center")
    private WebElement textOnMainTitle;

    @FindBy(css = "p.main-txt")
    private WebElement titleContainingText;

    @FindBy(css = "[id = 'iframe']")
    private WebElement iFrame;

    @FindBy(xpath = "//*[@id='epam_logo']")
    private WebElement epamLogoIniFrame;

    @FindBy(css = "[class='text-center'] a")
    private WebElement jdiSubheader;

    @FindBy(css = ".mCustomScrollBox")
    private WebElement leftSection;

    @FindBy(css = "footer")
    private WebElement footer;

    //=============================== Variables ===========================================

    private List<String> benefitIconsContainsText = Arrays
            .asList("To include good practices\nand ideas from successful\nEPAM project",
                    "To be flexible and\ncustomizable",
                    "To be multiplatform",
                    "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…");

    //=============================== Actions methods ========================================

    public void navigateToPage(){
        driver.navigate().to("https://epam.github.io/JDI/index.html");
    }

    public void login(String name, String pass) {
        loginProfileButton.click();
        loginField.sendKeys(name);
        passwordField.sendKeys(pass);
        enterButton.click();
    }

    public void userIsLogged() {
        loggedinUserName.isDisplayed();
        assertEquals(loggedinUserName
                .getText(), "PITER CHAILOVSKII");
    }

    public void switchToOriginalWindow() {
        driver.switchTo().defaultContent();
    }

    //=============================== Elements checks ==========================================

    public void checkIfTitleIsVisible() {
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
        for (WebElement text : benefitIconsText) {
            assertTrue(text.isDisplayed());
            assertTrue(benefitIconsContainsText.contains(text.getText()));
        }
    }

    public void checkMainHeaderHasText() {
        String textOnMainTitleis = "EPAM FRAMEWORK WISHES…";
        assertEquals(textOnMainTitle.getText(), textOnMainTitleis);
        String mainTitleTextIs = "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, " +
                "SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, " +
                "QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS " +
                "AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.";
        assertEquals(titleContainingText.getText(), mainTitleTextIs);
    }

    public void checkIframeIsVisible() {
        assertTrue(iFrame.isDisplayed());
    }

    public void checkEpamLogoIsVisible() {
        driver.switchTo().frame(iFrame);
        assertTrue(epamLogoIniFrame.isDisplayed());
    }

    public void checkSubheaderTextt() {
        assertTrue(jdiSubheader.isDisplayed());
        assertEquals(jdiSubheader.getText(), "JDI GITHUB");
    }

    public void checkSubheaderHasLink() {
        assertEquals(jdiSubheader.getAttribute("href"), "https://github.com/epam/JDI");
    }

    public void checkIfLeftSectionVisible() {
        assertTrue(leftSection.isDisplayed());
    }

    public void checkIfFooterIsVisible() {
        assertTrue(footer.isDisplayed());
    }
}
