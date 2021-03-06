package hw2.ex2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HomePageSmokeTests {


    @Test(groups = "Smoke", priority = 1)
    public void checkIfElementsPresenceTest1() {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //1 Open test site by URL
        driver.navigate().to("https://epam.github.io/JDI/index.html");

        //2 Assert Browser title
        assertEquals(driver.getTitle(), "Home Page");

        //3 Perform login
        driver.findElement(By.cssSelector(".profile-photo")).click();
        driver.findElement(By.cssSelector("[id = 'Name']")).sendKeys("epam");
        driver.findElement(By.cssSelector("[id = 'Password']")).sendKeys("1234");
        driver.findElement(By.cssSelector(".login [type = 'submit']")).click();

        //4 Assert User name in the left-top side of screen that user is loggined
        WebElement userName = driver.findElement(By.cssSelector(".profile-photo [ui = 'label']"));
        assertEquals(userName.getText(), "PITER CHAILOVSKII");

        //5 Assert Browser title
        assertEquals(driver.getTitle(), "Home Page");

        //6 Assert that there are 4 items on the header section are displayed and they have proper texts
        List<WebElement> navBarElements = driver.findElements(By.cssSelector(".nav > li"));
        assertEquals(navBarElements.size(), 4);
        for (WebElement element : navBarElements) {
            assertTrue(element.isDisplayed());
        }
        assertEquals(navBarElements.get(0).getText(), "HOME");
        assertEquals(navBarElements.get(1).getText(), "CONTACT FORM");
        assertEquals(navBarElements.get(2).getText(), "SERVICE");
        assertEquals(navBarElements.get(3).getText(), "METALS & COLORS");


        //7 Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> benefitIconsImages = driver.findElements(By.cssSelector(".benefit-icon"));
        assertEquals(benefitIconsImages.size(), 4);
        for (WebElement images : benefitIconsImages) {
            assertTrue(images.isDisplayed());
        }

        //8 Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<WebElement> benefitIconsText = driver.findElements(By.cssSelector(".benefit-txt"));
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

        //9 Assert a text of the main header
        WebElement textOnMainTitle = driver.findElement(By.cssSelector("h3.main-title"));
        assertTrue(textOnMainTitle.isDisplayed());
        assertEquals(textOnMainTitle.getText(), "EPAM FRAMEWORK WISHES…");
        WebElement titleContainingText = driver.findElement(By.cssSelector(".main-txt"));
        assertTrue(titleContainingText.isDisplayed());
        assertEquals(titleContainingText.getText(), "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, " +
                "SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, " +
                "QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE " +
                "IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.");

        //10 Assertthat there is the iframe in the center of page
        WebElement iFrame = driver.findElement(By.cssSelector("[id = 'iframe']"));
        assertTrue(iFrame.isDisplayed());

        //11 Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        driver.switchTo().frame(iFrame);
        WebElement epamLogoIniFrame = driver.findElement(By.xpath("//*[@id='epam_logo']"));
        assertTrue(epamLogoIniFrame.isDisplayed());

        //12 Switch to original window back
        driver.switchTo().defaultContent();

        //13 Assert a text of the sub header
        WebElement jdiSubheader = driver.findElement(By.linkText("JDI GITHUB"));
        assertTrue(jdiSubheader.isDisplayed());
        assertEquals(jdiSubheader.getText(), "JDI GITHUB");

        //14 Assert that JDI GITHUB is a link and has a proper URL
        assertEquals(jdiSubheader.getAttribute("href"), "https://github.com/epam/JDI");

        //15 Assert that there is Left Section
        WebElement leftSection = driver.findElement(By.cssSelector(".mCustomScrollBox"));
        assertTrue(leftSection.isDisplayed());

        //16 Assert that there is Footer
        WebElement footer = driver.findElement(By.cssSelector("footer"));
        assertTrue(footer.isDisplayed());

        //17 Close Browser
        driver.close();
    }

    @Test(groups = "Smoke", priority = 2)
    public void checkIfElementsPresenceTest2() {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //1 Open test site by URL
        driver.navigate().to("https://epam.github.io/JDI/index.html");

        //2 Assert Browser title
        assertEquals(driver.getTitle(), "Home Page");

        //3 Perform login
        driver.findElement(By.cssSelector(".profile-photo")).click();
        driver.findElement(By.cssSelector("[id = 'Name']")).sendKeys("epam");
        driver.findElement(By.cssSelector("[id = 'Password']")).sendKeys("1234");
        driver.findElement(By.cssSelector(".login [type = 'submit']")).click();

        //4 Assert User name in the left-top side of screen that user is loggined
        WebElement userName = driver.findElement(By.cssSelector(".profile-photo [ui = 'label']"));
        assertEquals(userName.getText(), "PITER CHAILOVSKII");

        //5 Assert Browser title
        assertEquals(driver.getTitle(), "Home Page");

        //6 Assert that there are 4 items on the header section are displayed and they have proper texts
        List<WebElement> navBarElements = driver.findElements(By.cssSelector(".nav > li"));
        assertEquals(navBarElements.size(), 4);
        for (WebElement element : navBarElements) {
            assertTrue(element.isDisplayed());
        }
        assertEquals(navBarElements.get(0).getText(), "HOME");
        assertEquals(navBarElements.get(1).getText(), "CONTACT FORM");
        assertEquals(navBarElements.get(2).getText(), "SERVICE");
        assertEquals(navBarElements.get(3).getText(), "METALS & COLORS");


        //7 Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> benefitIconsImages = driver.findElements(By.cssSelector(".benefit-icon"));
        assertEquals(benefitIconsImages.size(), 4);
        for (WebElement images : benefitIconsImages) {
            assertTrue(images.isDisplayed());
        }

        //8 Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<WebElement> benefitIconsText = driver.findElements(By.cssSelector(".benefit-txt"));
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

        //9 Assert a text of the main header
        WebElement textOnMainTitle = driver.findElement(By.cssSelector("h3.main-title"));
        assertTrue(textOnMainTitle.isDisplayed());
        assertEquals(textOnMainTitle.getText(), "EPAM FRAMEWORK WISHES…");
        WebElement titleContainingText = driver.findElement(By.cssSelector(".main-txt"));
        assertTrue(titleContainingText.isDisplayed());
        assertEquals(titleContainingText.getText(), "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, " +
                "SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, " +
                "QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE " +
                "IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.");

        //10 Assertthat there is the iframe in the center of page
        WebElement iFrame = driver.findElement(By.cssSelector("[id = 'iframe']"));
        assertTrue(iFrame.isDisplayed());

        //11 Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        driver.switchTo().frame(iFrame);
        WebElement epamLogoIniFrame = driver.findElement(By.xpath("//*[@id='epam_logo']"));
        assertTrue(epamLogoIniFrame.isDisplayed());

        //12 Switch to original window back
        driver.switchTo().defaultContent();

        //13 Assert a text of the sub header
        WebElement jdiSubheader = driver.findElement(By.linkText("JDI GITHUB"));
        assertTrue(jdiSubheader.isDisplayed());
        assertEquals(jdiSubheader.getText(), "JDI GITHUB");

        //14 Assert that JDI GITHUB is a link and has a proper URL
        assertEquals(jdiSubheader.getAttribute("href"), "https://github.com/epam/JDI");

        //15 Assert that there is Left Section
        WebElement leftSection = driver.findElement(By.cssSelector(".mCustomScrollBox"));
        assertTrue(leftSection.isDisplayed());

        //16 Assert that there is Footer
        WebElement footer = driver.findElement(By.cssSelector("footer"));
        assertTrue(footer.isDisplayed());

        //17 Close Browser
        driver.close();
    }

    @Test(groups = "Smoke", priority = 3)
    public void checkIfElementsPresenceTest3() {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //1 Open test site by URL
        driver.navigate().to("https://epam.github.io/JDI/index.html");

        //2 Assert Browser title
        assertEquals(driver.getTitle(), "Home Page");

        //3 Perform login
        driver.findElement(By.cssSelector(".profile-photo")).click();
        driver.findElement(By.cssSelector("[id = 'Name']")).sendKeys("epam");
        driver.findElement(By.cssSelector("[id = 'Password']")).sendKeys("1234");
        driver.findElement(By.cssSelector(".login [type = 'submit']")).click();

        //4 Assert User name in the left-top side of screen that user is loggined
        WebElement userName = driver.findElement(By.cssSelector(".profile-photo [ui = 'label']"));
        assertEquals(userName.getText(), "PITER CHAILOVSKII");

        //5 Assert Browser title
        assertEquals(driver.getTitle(), "Home Page");

        //6 Assert that there are 4 items on the header section are displayed and they have proper texts
        List<WebElement> navBarElements = driver.findElements(By.cssSelector(".nav > li"));
        assertEquals(navBarElements.size(), 4);
        for (WebElement element : navBarElements) {
            assertTrue(element.isDisplayed());
        }
        assertEquals(navBarElements.get(0).getText(), "HOME");
        assertEquals(navBarElements.get(1).getText(), "CONTACT FORM");
        assertEquals(navBarElements.get(2).getText(), "SERVICE");
        assertEquals(navBarElements.get(3).getText(), "METALS & COLORS");


        //7 Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> benefitIconsImages = driver.findElements(By.cssSelector(".benefit-icon"));
        assertEquals(benefitIconsImages.size(), 4);
        for (WebElement images : benefitIconsImages) {
            assertTrue(images.isDisplayed());
        }

        //8 Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<WebElement> benefitIconsText = driver.findElements(By.cssSelector(".benefit-txt"));
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

        //9 Assert a text of the main header
        WebElement textOnMainTitle = driver.findElement(By.cssSelector("h3.main-title"));
        assertTrue(textOnMainTitle.isDisplayed());
        assertEquals(textOnMainTitle.getText(), "EPAM FRAMEWORK WISHES…");
        WebElement titleContainingText = driver.findElement(By.cssSelector(".main-txt"));
        assertTrue(titleContainingText.isDisplayed());
        assertEquals(titleContainingText.getText(), "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, " +
                "SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, " +
                "QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE " +
                "IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.");

        //10 Assertthat there is the iframe in the center of page
        WebElement iFrame = driver.findElement(By.cssSelector("[id = 'iframe']"));
        assertTrue(iFrame.isDisplayed());

        //11 Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        driver.switchTo().frame(iFrame);
        WebElement epamLogoIniFrame = driver.findElement(By.xpath("//*[@id='epam_logo']"));
        assertTrue(epamLogoIniFrame.isDisplayed());

        //12 Switch to original window back
        driver.switchTo().defaultContent();

        //13 Assert a text of the sub header
        WebElement jdiSubheader = driver.findElement(By.linkText("JDI GITHUB"));
        assertTrue(jdiSubheader.isDisplayed());
        assertEquals(jdiSubheader.getText(), "JDI GITHUB");

        //14 Assert that JDI GITHUB is a link and has a proper URL
        assertEquals(jdiSubheader.getAttribute("href"), "https://github.com/epam/JDI");

        //15 Assert that there is Left Section
        WebElement leftSection = driver.findElement(By.cssSelector(".mCustomScrollBox"));
        assertTrue(leftSection.isDisplayed());

        //16 Assert that there is Footer
        WebElement footer = driver.findElement(By.cssSelector("footer"));
        assertTrue(footer.isDisplayed());

        //17 Close Browser
        driver.close();
    }
}
