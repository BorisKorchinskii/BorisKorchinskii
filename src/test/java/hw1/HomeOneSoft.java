package hw1;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;


public class HomeOneSoft extends TestBase {

    @Test
    public void homeOneSoft(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        SoftAssert softAssert = new SoftAssert();

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
        softAssert.assertEquals(userName.getText(), "PITER CHAILOVSKI");

        //5 Assert Browser title
        softAssert.assertEquals(driver.getTitle(), "Home Page1");

        //6 Assert that there are 4 items on the header section are displayed and they have proper texts
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement home = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='index.html']")));
        softAssert.assertEquals(home.getText(), "HOME");
        WebElement contactForm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='contacts.html']")));
        softAssert.assertEquals(contactForm.getText(), "CONTACT FORM");
        WebElement service = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".dropdown-toggle")));
        softAssert.assertEquals(service.getText(), "SERVICE");
        WebElement metalsAndColors = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='metals-colors.html']")));
        softAssert.assertEquals(metalsAndColors.getText(), "METALS & COLORS");

        //7 Assert that there are 4 images on the Index Page and they are displayed
        WebElement microscopeImg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".icon-practise")));
        softAssert.assertTrue(microscopeImg.isDisplayed());
        WebElement headphonesImg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".icon-custom")));
        softAssert.assertTrue(headphonesImg.isDisplayed());
        WebElement multiplatformImg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".icon-multi")));
        softAssert.assertTrue(multiplatformImg.isDisplayed());
        WebElement rocketImg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".icon-base")));
        softAssert.assertTrue(rocketImg.isDisplayed());

        //8 Assert that there are 4 texts on the Index Page under icons and they have proper text
        WebElement microscopeText = driver.findElement(By.xpath("//div[@class ='row clerafix benefits']/div[1]"));
        softAssert.assertEquals(microscopeText.getText(), "To include good practices"
                + "\n" + "and ideas from successful"
                + "\n" + "EPAM project");
        WebElement headphonesText = driver.findElement(By.xpath("//div[@class ='row clerafix benefits']/div[2]"));
        softAssert.assertEquals(headphonesText.getText(), "To be flexible and"
                + "\n" + "customizable");
        WebElement multiplatformText = driver.findElement(By.xpath("//div[@class ='row clerafix benefits']/div[3]"));
        softAssert.assertEquals(multiplatformText.getText(), "To be multiplatform");
        WebElement rocketText = driver.findElement(By.xpath("//div[@class ='row clerafix benefits']/div[4]"));
        softAssert.assertEquals(rocketText.getText(), "Already have good base"
                + "\n" + "(about 20 internal and"
                + "\n" + "some external projects),"
                + "\n" + "wish to get more…");

        //9 Assert a text of the main header
        WebElement mainTitle = driver.findElement(By.cssSelector("h3.main-title"));
        softAssert.assertTrue(mainTitle.isDisplayed());
        softAssert.assertEquals(mainTitle.getText(), "EPAM FRAMEWORK WISHES…");
        WebElement titleText = driver.findElement(By.cssSelector("[name = 'jdi-text']"));
        softAssert.assertTrue(titleText.isDisplayed());
        softAssert.assertEquals(titleText.getText(), "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, " +
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
        softAssert.assertNotNull(jdiSubheader);

        //15 Assert that there is Left Section
        WebElement leftSection = driver.findElement(By.cssSelector(".mCustomScrollBox"));
        softAssert.assertTrue(leftSection.isDisplayed());

        //16 Assert that there is Footer
        WebElement footer = driver.findElement(By.xpath("//footer/div/div"));
        softAssert.assertTrue(footer.isDisplayed());

        //17 Close Browser
        driver.close();
    }
}
