package hw1;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class IndexPageContentTestSoftAssertions extends TestBase {

    SoftAssert softAssert = new SoftAssert();

    @Test
    public void checkIfElementsPresenceUseSoftAssertions() {

        //1 Open test site by URL
        driver.navigate().to("https://epam.github.io/JDI/index.html");

        //2 Assert Browser title
        softAssert.assertEquals(driver.getTitle(), "Home Page");

        //3 Perform login
        driver.findElement(By.cssSelector(".profile-photo")).click();
        driver.findElement(By.cssSelector("[id = 'Name']")).sendKeys("epam");
        driver.findElement(By.cssSelector("[id = 'Password']")).sendKeys("1234");
        driver.findElement(By.cssSelector(".login [type = 'submit']")).click();

        //4 Assert User name in the left-top side of screen that user is loggined
        WebElement userName = driver.findElement(By.cssSelector(".profile-photo [ui = 'label']"));
        softAssert.assertEquals(userName.getText(), "PITER CHAILOVSKII");

        //5 Assert Browser title
        softAssert.assertEquals(driver.getTitle(), "Home Page");

        //6 Assert that there are 4 items on the header section are displayed and they have proper texts
        List<WebElement> navBarElements = driver.findElements(By.cssSelector(".nav > li"));
        softAssert.assertEquals(navBarElements.size(), 4);
        for (WebElement element : navBarElements) {
            assertTrue(element.isDisplayed());
        }
        softAssert.assertEquals(navBarElements.get(0).getText(), "HOME");
        softAssert.assertEquals(navBarElements.get(1).getText(), "CONTACT FORM");
        softAssert.assertEquals(navBarElements.get(2).getText(), "SERVICE");
        softAssert.assertEquals(navBarElements.get(3).getText(), "METALS & COLORS");


        //7 Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> benefitIconsImages = driver.findElements(By.cssSelector(".benefit-icon"));
        softAssert.assertEquals(benefitIconsImages.size(), 4);
        for (WebElement images : benefitIconsImages) {
            assertTrue(images.isDisplayed());
        }

        //8 Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<WebElement> benefitIconsText = driver.findElements(By.cssSelector(".benefit-txt"));
        softAssert.assertEquals(benefitIconsText.size(), 4);
        softAssert.assertEquals(benefitIconsText.get(0)
                .getText(), "To include good practices\n" +
                "and ideas from successful\n" +
                "EPAM project");
        softAssert.assertEquals(benefitIconsText.get(1)
                .getText(), "To be flexible and\n" +
                "customizable");
        softAssert.assertEquals(benefitIconsText.get(2)
                .getText(), "To be multiplatform");
        softAssert.assertEquals(benefitIconsText.get(3)
                .getText(), "Already have good base\n" +
                "(about 20 internal and\n" +
                "some external projects),\n" +
                "wish to get more…");

        //9 Assert a text of the main header
        WebElement textOnMainTitle = driver.findElement(By.cssSelector("h3.main-title"));
        softAssert.assertTrue(textOnMainTitle.isDisplayed());
        softAssert.assertEquals(textOnMainTitle.getText(), "EPAM FRAMEWORK WISHES…");
        WebElement titleContainingText = driver.findElement(By.cssSelector(".main-txt"));
        softAssert.assertTrue(titleContainingText.isDisplayed());
        softAssert.assertEquals(titleContainingText.getText(), "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, " +
                "SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, " +
                "QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE " +
                "IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.");

        //10 Assertthat there is the iframe in the center of page
        WebElement iFrame = driver.findElement(By.cssSelector("[id = 'iframe']"));
        softAssert.assertTrue(iFrame.isDisplayed());

        //11 Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        driver.switchTo().frame(iFrame);
        WebElement epamLogoIniFrame = driver.findElement(By.xpath("//*[@id='epam_logo']"));
        softAssert.assertTrue(epamLogoIniFrame.isDisplayed());

        //12 Switch to original window back
        driver.switchTo().defaultContent();

        //13 Assert a text of the sub header
        WebElement jdiSubheader = driver.findElement(By.linkText("JDI GITHUB"));
        softAssert.assertTrue(jdiSubheader.isDisplayed());
        softAssert.assertEquals(jdiSubheader.getText(), "JDI GITHUB");

        //14 Assert that JDI GITHUB is a link and has a proper URL
        softAssert.assertEquals(jdiSubheader.getAttribute("href"), "https://github.com/epam/JDI");

        //15 Assert that there is Left Section
        WebElement leftSection = driver.findElement(By.cssSelector(".mCustomScrollBox"));
        softAssert.assertTrue(leftSection.isDisplayed());

        //16 Assert that there is Footer
        WebElement footer = driver.findElement(By.cssSelector("footer"));
        softAssert.assertTrue(footer.isDisplayed());
    }
}
